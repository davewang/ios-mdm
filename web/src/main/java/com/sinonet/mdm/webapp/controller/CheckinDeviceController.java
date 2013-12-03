package com.sinonet.mdm.webapp.controller;

import com.dd.plist.NSData;
import com.dd.plist.NSDictionary;
import com.dd.plist.PropertyListParser;
import com.sinonet.mdm.dao.SearchException;
import com.sinonet.mdm.model.Device;
import com.sinonet.mdm.model.Task;
import com.sinonet.mdm.model.Token;
import com.sinonet.mdm.service.GenericManager;
import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.configuration.plist.PropertyListConfiguration;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-10-24
 * Time: 下午4:35
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class CheckinDeviceController {
    private GenericManager<Device, Long> deviceManager;

    @Autowired
    public void setDeviceManager(@Qualifier("deviceManager") GenericManager<Device, Long> deviceManager) {
        this.deviceManager = deviceManager;
    }

    private GenericManager<Task, Long> taskManager;

    @Autowired
    public void setTaskManager(@Qualifier("taskManager") GenericManager<Task, Long> taskManager) {
        this.taskManager = taskManager;
    }
    private transient final Log log = LogFactory.getLog(ReloadController.class);
    @RequestMapping(value = "/checkin",method = RequestMethod.PUT)
    public void handleCheckinRequest(HttpServletRequest request,HttpServletResponse response)
            throws Exception {

        NSDictionary dictionary = (NSDictionary) PropertyListParser.parse(request.getInputStream());
        String messageType = dictionary.objectForKey("MessageType").toString();
        log.debug(dictionary.toXMLPropertyList());
        if (messageType.equals("Authenticate"))
        {
            Device device = deviceManager.findUniqueBy("udid",dictionary.objectForKey("UDID").toJavaObject().toString());
            if (device==null)
            {
               device = new Device();
               device.setUdid(dictionary.objectForKey("UDID").toJavaObject().toString());
               deviceManager.save(device);
            } else {
                log.warn("device udid="+dictionary.objectForKey("UDID").toJavaObject().toString()+" is exist!");
            }
        }else if (messageType.equals("TokenUpdate"))
        {
            Device device = deviceManager.findUniqueBy("udid",dictionary.objectForKey("UDID").toJavaObject().toString());
            if (device==null) {
                device = new Device();
                device.setUdid(dictionary.objectForKey("UDID").toJavaObject().toString());
                log.error("TokenUpdate but device is null!!!");
            }
            Token token = device.getToken();
            if (token==null)
                token= new Token();


            token.setUdid(dictionary.objectForKey("UDID").toString());
            token.setPushMagic(dictionary.objectForKey("PushMagic").toString());
            NSData tokenData =  ((NSData)dictionary.objectForKey("Token"));
            log.debug(tokenData.getBase64EncodedData());
            token.setToken(tokenData.bytes());
            token.setTopic(dictionary.objectForKey("Topic").toJavaObject().toString());
            NSData unlockTokenData = (NSData)dictionary.objectForKey("UnlockToken");
            log.debug(unlockTokenData.getBase64EncodedData());
            token.setUnlockToken(unlockTokenData.bytes());
            device.setToken(token);
            log.debug("PushMagic>>"+token.getPushMagic() + "<<");
            log.debug("Token>>"+token.getToken()+"<<");
            log.debug("Token>>"+token.getUnlockToken()+"<<");
            log.debug("Token>>"+token+"<<");
            deviceManager.save(device);


        }



    }
    @RequestMapping(value = "/server",method = {RequestMethod.PUT,RequestMethod.GET})
    public void handleSeverRequest(HttpServletRequest request,HttpServletResponse response)
            throws Exception {

        NSDictionary dictionary = (NSDictionary) PropertyListParser.parse(request.getInputStream());
        log.warn("server request :"+dictionary.toXMLPropertyList());
        if (dictionary.objectForKey("Status").toString().equals("Idle") && dictionary.objectForKey("CommandUUID") == null)
        {
            String udid = dictionary.objectForKey("UDID").toString();
            List allTask = taskManager.find("from Task where status='no' and device.udid = ? ",udid);
            if (allTask.size()>0){
              Task topTask = (Task)allTask.get(0);
              topTask.setStatus("run");
              taskManager.save(topTask);
              response.getWriter().write(new String(topTask.getCommand()));
              log.debug(topTask);
            }else {
                log.warn("UDID ="+udid+" device's task is not find ");

            }
        }else if (dictionary.objectForKey("CommandUUID")!=null)
        {
            String udid = dictionary.objectForKey("UDID").toString();
            String commandUUID = dictionary.objectForKey("CommandUUID").toString();
            log.debug(udid);
            log.debug(commandUUID);
            response.setStatus(200);
            List allTask = taskManager.find("from Task where status='run' and device.udid = ? and CommandUUID = ?",udid,commandUUID);
            if (allTask.size()>0)
            {
                Task topTask = (Task)(allTask.get(0));
                topTask.setStatus("ok");
                topTask.setResult(dictionary.toXMLPropertyList().getBytes());
                taskManager.save(topTask);
            }else {
                log.warn("commandUUID ="+commandUUID+" task is not find ");
            }
        }


    }

}
