package com.sinonet.mdm.webapp;

import com.dd.plist.Base64;
import com.notnoop.apns.APNS;
import com.notnoop.apns.ApnsService;
import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-10-28
 * Time: 下午2:14
 * To change this template use File | Settings | File Templates.
 */
public class ApnsTest {
    @Test
    public void push()
    {
        ApnsService service = APNS.newService().withCert( ClassLoader.getSystemResourceAsStream("mdm_push.p12"),"wangjava").withProductionDestination().build();
        String pushMagic = "5875CE80-DA3E-4A1E-A4A6-630DDFB32AA9";
        String mdmPayload = APNS.newPayload().mdm(pushMagic).build();

        try {
            String token = Hex.encodeHexString(Base64.decode("6zB7IRHVUv4psJiqKQzNRJhkmy0vBCcEKtZaMi52fqI="));
            service.push(token, mdmPayload);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("newServiceGetNewInstances....");
    }
}
