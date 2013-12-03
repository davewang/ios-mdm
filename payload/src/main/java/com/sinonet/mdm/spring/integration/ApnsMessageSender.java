package com.sinonet.mdm.spring.integration;

import com.notnoop.apns.ApnsService;
import com.notnoop.apns.ApnsServiceBuilder;
import com.notnoop.apns.PayloadBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;
import org.springframework.integration.Message;
import org.springframework.integration.MessagingException;
import org.springframework.integration.core.MessageHandler;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.util.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-10-30
 * Time: 上午11:39
 * To change this template use File | Settings | File Templates.
 */

public class ApnsMessageSender implements InitializingBean  {
    private Resource keystore;
    private String password;
    private Log log = LogFactory.getLog(getClass());
    static public final String APNS_DEVICE_TOKEN = "APNS_DEVICE_TOKEN" ;
    static public final String APNS_MDM_PUSHMAGIC = "APNS_MDM_PUSHMAGIC" ;

    public void sendMessage(Message<?> message)  throws MessagingException{
        try {
            InputStream certificate = this.keystore.getInputStream();
            ApnsServiceBuilder serviceBuilder = new ApnsServiceBuilder();
            ApnsService service = serviceBuilder
                    .withProductionDestination()
                    .withCert(certificate, this.password)
                    .build();
            String deviceToken = header(message, ApnsMessageSender.APNS_DEVICE_TOKEN);
            String pushMagic = header(message, ApnsMessageSender.APNS_MDM_PUSHMAGIC);
            PayloadBuilder payloadBuilder = PayloadBuilder.newPayload().mdm(pushMagic);
            String payload = payloadBuilder.build();
            if (log.isDebugEnabled())
                log.debug(String.format("about to send message %s", payload));

            service.push(deviceToken, payload);


        } catch (IOException e) {
            throw new RuntimeException(String.format("couldn't read the key store, '%s'", keystore.toString()), e);
        }
    }


    public void afterPropertiesSet() throws Exception {
        Assert.notNull(this.password, "the 'password' must not be null");
        Assert.notNull(this.keystore, "the 'key store' must not be null");
    }

    @SuppressWarnings("unchecked")
    protected <T> T header(Message<?> msg, String k) {
        return (T) msg.getHeaders().get(k);
    }

    public Resource getKeystore() {
        return keystore;
    }

    public void setKeystore(Resource keystore) {
        this.keystore = keystore;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
