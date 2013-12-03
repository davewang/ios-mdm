package com.sinonet.mdm.webapp.util;

import com.dd.plist.Base64;
import com.dd.plist.NSDictionary;
import com.notnoop.apns.APNS;
import com.notnoop.apns.ApnsService;
import com.notnoop.apns.internal.Utilities;
import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.validator.Field;
import org.apache.commons.validator.GenericValidator;
import org.apache.commons.validator.ValidatorAction;
import org.apache.commons.validator.util.ValidatorUtils;
import org.springframework.validation.Errors;
import org.springmodules.validation.commons.FieldChecks;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;


/**
 * ValidationUtil Helper class for performing custom validations that
 * aren't already included in the core Commons Validator.
 *
 * <p>
 * <a href="ValidationUtil.java.html"><i>View Source</i></a>
 * </p>
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public class ValidationUtil {
    //~ Methods ================================================================

    /**
     * Validates that two fields match.
     * @param bean
     * @param va
     * @param field
     * @param errors
     */
    public static boolean validateTwoFields(Object bean, ValidatorAction va,
                                            Field field, Errors errors) {
        String value =
            ValidatorUtils.getValueAsString(bean, field.getProperty());
        String sProperty2 = field.getVarValue("secondProperty");
        String value2 = ValidatorUtils.getValueAsString(bean, sProperty2);

        if (!GenericValidator.isBlankOrNull(value)) {
            try {
                if (!value.equals(value2)) {
                    FieldChecks.rejectValue(errors, field, va);
                    return false;
                }
            } catch (Exception e) {
                FieldChecks.rejectValue(errors, field, va);
                return false;
            }
        }

        return true;
    }
    public static void main(String []args)  throws Exception
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

//                          try {
//
//
//        int port = 2195;
//        String hostname = "gateway.push.apple.com";
//        char[] passwKey = "wangjava".toCharArray();
//
//        KeyStore ts = KeyStore.getInstance("PKCS12");
//        ts.load(ClassLoader.getSystemResourceAsStream("mdm_push.p12"), passwKey);
//        KeyManagerFactory tmf = KeyManagerFactory.getInstance("SunX509");
//        tmf.init(ts, passwKey);
//
//        SSLContext sslContext = SSLContext.getInstance("TLS");
//        sslContext.init(tmf.getKeyManagers(), null, null);
//        SSLSocketFactory factory = sslContext.getSocketFactory();
//
//        SSLSocket socket = (SSLSocket) factory.createSocket(hostname,port);
//        String[] suites = socket.getSupportedCipherSuites();
//        socket.setEnabledCipherSuites(suites);
////start handshake
//        socket.startHandshake();
//
//
//                          }catch (Exception e){
//                           e.printStackTrace();
//                          }
//        ApnsService service = APNS.newService().withCert( ClassLoader.getSystemResourceAsStream("mdm_push.p12"),"wangjava").withProductionDestination().build();
//        String pushMagic = "3DB39E52-D778-444E-B7BC-89FE16505332";
//        String mdmPayload = APNS.newPayload().mdm(pushMagic).build();
//        service.push("0766b87b4e38", mdmPayload);

//        NSDictionary dice =  new NSDictionary();
//        System.out.println(dice.toXMLPropertyList());
//       try {
//           ApnsService service = APNS.newService().withCert( ClassLoader.getSystemResourceAsStream("mdm_push.p12"),"wangjava").withProductionDestination().build();
//           String pushMagic = "536D295C-D914-4E32-8AED-11A09B4487D5";
//           String mdmPayload = APNS.newPayload().mdm(pushMagic).build();
//           service.push(pushMagic, mdmPayload);
//             }catch(Exception e){
//               e.printStackTrace();
//           }
//
//       Thread thread2 = new Thread(){
//           public void run(){
//               while (true)
//               {
//                   System.out.println("run.....");
//                   try {
//                       sleep(2000l);
//                   } catch (InterruptedException e) {
//                       e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//                   }
//               }
//           }
//       };
//
//        thread2.start();

    }
}
