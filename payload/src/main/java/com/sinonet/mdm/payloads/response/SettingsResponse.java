package com.sinonet.mdm.payloads.response;

import com.dd.plist.NSArray;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-11-6
 * Time: 下午4:29
 * To change this template use File | Settings | File Templates.
 */
public class SettingsResponse  extends Response  {
    //Optional. An array representing the chain of errors that occurred.
    private NSArray errorChain;
    //Optional. The app identifier to which this error applies. Availability: Available in iOS 7 and later.
    private String identifier;
    @Override
    public void doHandler() {
        if (!getStatus().equals("Acknowledged"))
        {
            this.errorChain = (NSArray)response.objectForKey("ErrorChain");
            this.identifier = response.objectForKey("Identifier").toString();
        }

    }

    public NSArray getErrorChain() {
        return errorChain;
    }

    public String getIdentifier() {
        return identifier;
    }
}
