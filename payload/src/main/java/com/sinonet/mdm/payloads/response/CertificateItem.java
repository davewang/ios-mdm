package com.sinonet.mdm.payloads.response;

import com.dd.plist.NSData;
import com.dd.plist.NSDictionary;
import com.dd.plist.NSNumber;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-11-18
 * Time: 下午3:09
 * To change this template use File | Settings | File Templates.
 */
public class CertificateItem{

    String commonName;
    Boolean isIdentity;
    byte[] data;  //The certificate in DER-encoded X.509 format.

    static CertificateItem getCertificateItemByNSDictionary(NSDictionary dictionary)
    {
        CertificateItem item = new CertificateItem();
        item.setCommonName(dictionary.objectForKey("CommonName").toString());
        NSNumber number = (NSNumber)dictionary.objectForKey("IsIdentity");
        item.setIdentity(number.boolValue());
        NSData data = (NSData)dictionary.objectForKey("Data");
        item.setData(data.bytes());
        return null;
    }

    public String getCommonName() {
        return commonName;
    }

    public Boolean getIdentity() {
        return isIdentity;
    }

    public byte[] getData() {
        return data;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public void setIdentity(Boolean identity) {
        isIdentity = identity;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}