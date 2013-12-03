package com.sinonet.mdm.payloads.response;

import com.dd.plist.NSArray;
import com.dd.plist.NSDictionary;
import com.dd.plist.NSNumber;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-11-5
 * Time: 下午4:34
 * To change this template use File | Settings | File Templates.
 */
public class SecurityInfoResponse extends Response  {
    private NSDictionary securityInfoDictionary;
    private SecurityInfo securityInfo;
    @Override
    public void doHandler() {
        if (getStatus().equals("Acknowledged"))
            securityInfoDictionary = (NSDictionary)response.objectForKey("SecurityInfo");

        securityInfo = SecurityInfo.getSecurityInfoByNSDictionary(securityInfoDictionary);
    }

    public SecurityInfo getSecurityInfo() {
        return securityInfo;
    }
}


