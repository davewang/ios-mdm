package com.sinonet.mdm.payloads.response;

import com.dd.plist.NSDictionary;
import com.dd.plist.PropertyListParser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-11-5
 * Time: 上午10:29
 * To change this template use File | Settings | File Templates.
 */
public abstract class Response{
    protected final Log log = LogFactory.getLog(getClass());
    protected NSDictionary response;

    public void setResponse(NSDictionary response) {
        this.response = response;
    }
    public void setResponse(String response) {
        setResponse(response.getBytes());
    }
    public void setResponse(byte[] response) {
        try {
            this.response = (NSDictionary)PropertyListParser.parse(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void executeBefore()
    {

    }
    public Response execute()
    {
        executeBefore();
        doHandler();
        executeAfter();
        return this;
    }
    public void executeAfter()
    {
         log.debug(this);
    }
    public abstract void doHandler();


    public String getUdid() {
        return response.objectForKey("UDID").toString();
    }

    public String getStatus() {
        return response.objectForKey("Status").toString();
    }

    public String getCommandUUID() {
        return response.objectForKey("CommandUUID").toString();
    }


    public static <T extends Response> T getResponse(Class<T> tClass,String response) throws IllegalAccessException, InstantiationException {
       T obj = tClass.newInstance();
       obj.setResponse(response);
       obj.execute();
       return obj;
    }
}
