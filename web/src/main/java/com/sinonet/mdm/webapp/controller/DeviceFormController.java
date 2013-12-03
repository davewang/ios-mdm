package com.sinonet.mdm.webapp.controller;

import com.notnoop.apns.APNS;
import com.notnoop.apns.ApnsService;
import com.sinonet.mdm.model.Task;
import com.sinonet.mdm.payloads.Command;
import com.sinonet.mdm.payloads.CommandFactory;
import com.sinonet.mdm.payloads.ManagedApplicationListCommand;
import com.sinonet.mdm.payloads.TaskFactory;
import com.sinonet.mdm.webapp.spring.integration.ApnsMessageSender;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang.StringUtils;
import com.sinonet.mdm.service.GenericManager;
import com.sinonet.mdm.model.Device;
import com.sinonet.mdm.webapp.controller.BaseFormController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.Message;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.security.KeyStore;
import java.util.Locale;
import java.util.UUID;

@Controller
//@RequestMapping("/deviceform")
public class DeviceFormController extends BaseFormController {
    private GenericManager<Device, Long> deviceManager = null;
    @Autowired
    private ApnsMessageSender apnsMessageSender;

    @Autowired
    public void setDeviceManager(@Qualifier("deviceManager") GenericManager<Device, Long> deviceManager) {
        this.deviceManager = deviceManager;
    }


    private GenericManager<Task, Long> taskManager;

    @Autowired
    public void setTaskManager(@Qualifier("taskManager") GenericManager<Task, Long> taskManager) {
        this.taskManager = taskManager;
    }



    public DeviceFormController() {
        setCancelView("redirect:devices");
        setSuccessView("redirect:devices");
    }
    @ModelAttribute
    @RequestMapping("/deviceinfo")
    public void deviceinfocommand(HttpServletRequest request)
    {

        String id = request.getParameter("id");
        Device device = deviceManager.get(new Long(id));
        Message<String> message = MessageBuilder.withPayload("push")
                .setHeader(ApnsMessageSender.APNS_DEVICE_TOKEN,Hex.encodeHexString(device.getToken().getToken())).setHeader(ApnsMessageSender.APNS_MDM_PUSHMAGIC, device.getToken().getPushMagic()).build();
        log.warn(apnsMessageSender);
        apnsMessageSender.sendMessage(message);
        Task task = TaskFactory.createDeviceInformationTask();
        task.setDevice(device);
        log.debug(task);


        taskManager.save(task);
    }
    @ModelAttribute
    @RequestMapping("/devicelock")
    public void devicelockCommand(HttpServletRequest request)
    {

        String id = request.getParameter("id");
        Device device = deviceManager.get(new Long(id));
        Message<String> message = MessageBuilder.withPayload("push")
                .setHeader(ApnsMessageSender.APNS_DEVICE_TOKEN,Hex.encodeHexString(device.getToken().getToken())).setHeader(ApnsMessageSender.APNS_MDM_PUSHMAGIC, device.getToken().getPushMagic()).build();
        log.warn(apnsMessageSender);
        apnsMessageSender.sendMessage(message);
        Task task = TaskFactory.createDeviceLockCommandTask("123456","is mdm lock!",null);
        task.setDevice(device);
        log.debug(task);


        taskManager.save(task);
    }
    @ModelAttribute
    @RequestMapping("/installForiTunesStore")
    public void installCommand(HttpServletRequest request)
    {

        String id = request.getParameter("id");
        Device device = deviceManager.get(new Long(id));
        Message<String> message = MessageBuilder.withPayload("push")
                .setHeader(ApnsMessageSender.APNS_DEVICE_TOKEN,Hex.encodeHexString(device.getToken().getToken())).setHeader(ApnsMessageSender.APNS_MDM_PUSHMAGIC, device.getToken().getPushMagic()).build();
        log.warn(apnsMessageSender);
        apnsMessageSender.sendMessage(message);
        Task task = TaskFactory.createInstallApplicationByiTunesStoreIDTask("695439229");
        task.setDevice(device);
        log.debug(task);


        taskManager.save(task);
    }
    @ModelAttribute
    @RequestMapping("/removeinstall")
    public void removeCommand(HttpServletRequest request)
    {

        String id = request.getParameter("id");
        Device device = deviceManager.get(new Long(id));
        Message<String> message = MessageBuilder.withPayload("push")
                .setHeader(ApnsMessageSender.APNS_DEVICE_TOKEN,Hex.encodeHexString(device.getToken().getToken())).setHeader(ApnsMessageSender.APNS_MDM_PUSHMAGIC, device.getToken().getPushMagic()).build();
        log.warn(apnsMessageSender);
        apnsMessageSender.sendMessage(message);
        Task task = TaskFactory.createRemoveApplicationCommandTask("com.iapploft.ios.weixiang");
        task.setDevice(device);
        log.debug(task);
        taskManager.save(task);
    }
    @ModelAttribute
    @RequestMapping("/listprofile")
    public void listProfileCommand(HttpServletRequest request)
    {

        String id = request.getParameter("id");
        Device device = deviceManager.get(new Long(id));
        Message<String> message = MessageBuilder.withPayload("push")
                .setHeader(ApnsMessageSender.APNS_DEVICE_TOKEN,Hex.encodeHexString(device.getToken().getToken())).setHeader(ApnsMessageSender.APNS_MDM_PUSHMAGIC, device.getToken().getPushMagic()).build();
        log.warn(apnsMessageSender);
        apnsMessageSender.sendMessage(message);
        Task task = TaskFactory.createProfileListCommandTask();
        task.setDevice(device);
        log.debug(task);
        taskManager.save(task);
    }
    @ModelAttribute
    @RequestMapping("/installprofile")
    public void installProfileCommand(HttpServletRequest request)
    {

        String id = request.getParameter("id");
        Device device = deviceManager.get(new Long(id));
        Message<String> message = MessageBuilder.withPayload("push")
                .setHeader(ApnsMessageSender.APNS_DEVICE_TOKEN,Hex.encodeHexString(device.getToken().getToken())).setHeader(ApnsMessageSender.APNS_MDM_PUSHMAGIC, device.getToken().getPushMagic()).build();
        log.warn(apnsMessageSender);
        String path = getClass().getClassLoader().getResource("Restrictions.mobileconfig").getPath();
        log.warn(path);
        apnsMessageSender.sendMessage(message);
        Task task = TaskFactory.createInstallProfileCommandTask(new File(path));
        task.setDevice(device);
        log.debug(task);
        taskManager.save(task);
    }

    @ModelAttribute
    @RequestMapping("/removeprofile")
    public void removeProfileCommand(HttpServletRequest request)
    {

        String id = request.getParameter("id");
        Device device = deviceManager.get(new Long(id));
        Message<String> message = MessageBuilder.withPayload("push")
                .setHeader(ApnsMessageSender.APNS_DEVICE_TOKEN,Hex.encodeHexString(device.getToken().getToken())).setHeader(ApnsMessageSender.APNS_MDM_PUSHMAGIC, device.getToken().getPushMagic()).build();
        log.warn(apnsMessageSender);

        apnsMessageSender.sendMessage(message);
        Task task = TaskFactory.createRemoveProfileCommandTask("aca701de.ipt.aol.com.2E23D763-E22E-426C-B6DD-F96917C69727");
        task.setDevice(device);
        log.debug(task);
        taskManager.save(task);
    }
    @ModelAttribute
    @RequestMapping("/restrictions")
    public void restrictionsCommand(HttpServletRequest request)
    {

        String id = request.getParameter("id");
        Device device = deviceManager.get(new Long(id));
        Message<String> message = MessageBuilder.withPayload("push")
                .setHeader(ApnsMessageSender.APNS_DEVICE_TOKEN,Hex.encodeHexString(device.getToken().getToken())).setHeader(ApnsMessageSender.APNS_MDM_PUSHMAGIC, device.getToken().getPushMagic()).build();
        log.warn(apnsMessageSender);

        apnsMessageSender.sendMessage(message);
        Task task = TaskFactory.createRestrictionsCommandTask();
        task.setDevice(device);
        log.debug(task);
        taskManager.save(task);
    }
    @ModelAttribute
    @RequestMapping("/managedApplicationList")
    public void managedApplicationListCommand(HttpServletRequest request)
    {

        String id = request.getParameter("id");
        Device device = deviceManager.get(new Long(id));
        Message<String> message = MessageBuilder.withPayload("push")
                .setHeader(ApnsMessageSender.APNS_DEVICE_TOKEN,Hex.encodeHexString(device.getToken().getToken())).setHeader(ApnsMessageSender.APNS_MDM_PUSHMAGIC, device.getToken().getPushMagic()).build();
        log.warn(apnsMessageSender);
        apnsMessageSender.sendMessage(message);
        Task task = new Task();
        String commandUUID = UUID.randomUUID().toString();
        task.setStatus("no");
        task.setCommandUUID(commandUUID);
        task.setName("removeProfile");
        Command command = new ManagedApplicationListCommand();
        command.setCommandUUID(commandUUID);
        command.execute();
        task.setCommand(command.bytes());
        task.setDevice(device);
        log.debug(task);
        taskManager.save(task);
    }



    @ModelAttribute
    @RequestMapping(value = "/deviceform",method = RequestMethod.GET)
    protected Device showForm(HttpServletRequest request)
    throws Exception {
        String id = request.getParameter("id");

        if (!StringUtils.isBlank(id)) {
            return deviceManager.get(new Long(id));
        }

        return new Device();
    }



    @RequestMapping(value = "/deviceform",method = RequestMethod.POST)
    public String onSubmit(Device device, BindingResult errors, HttpServletRequest request,
                           HttpServletResponse response)
    throws Exception {
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }

        if (validator != null) { // validator is null during testing
            validator.validate(device, errors);

            if (errors.hasErrors() && request.getParameter("delete") == null) { // don't validate when deleting
                return "deviceform";
            }
        }

        log.debug("entering 'onSubmit' method...");

        boolean isNew = (device.getId() == null);
        String success = getSuccessView();
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
            deviceManager.remove(device.getId());
            saveMessage(request, getText("device.deleted", locale));
        } else {
            deviceManager.save(device);
            String key = (isNew) ? "device.added" : "device.updated";
            saveMessage(request, getText(key, locale));

            if (!isNew) {
                success = "redirect:deviceform?id=" + device.getId();
            }
        }

        return success;
    }
    
    @RequestMapping(value="/installedapplicationlist",method=RequestMethod.GET)
    public void installedApplicationList(HttpServletRequest request) {
        String id = request.getParameter("id");
        Device device = deviceManager.get(new Long(id));
        pushNotifyToDevice( device );
        
        Task task = TaskFactory.createInstalledApplicationListTask( null );
        task.setDevice(device);
        log.debug(task);
        taskManager.save(task);
    }
    
    @RequestMapping(value="/managedapplicationlist",method=RequestMethod.GET)
    public void managedApplicationList(HttpServletRequest request) {
        String id = request.getParameter("id");
        Device device = deviceManager.get(new Long(id));
        pushNotifyToDevice( device );
        
        Task task = TaskFactory.createManagedApplicationListTask( null );
        task.setDevice(device);
        log.debug(task);
        taskManager.save(task);
    }
    
    protected void pushNotifyToDevice( Device device ) {
    	String token = Hex.encodeHexString(device.getToken().getToken());
    	String magic = device.getToken().getPushMagic();
		Message<String> message = MessageBuilder
				.withPayload("push")
				.setHeader(ApnsMessageSender.APNS_DEVICE_TOKEN, token)
				.setHeader(ApnsMessageSender.APNS_MDM_PUSHMAGIC, magic).build();
		log.warn(apnsMessageSender);
		apnsMessageSender.sendMessage(message);
    }
}
