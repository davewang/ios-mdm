package com.sinonet.mdm.payloads.response;

import com.dd.plist.NSDictionary;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-11-6
 * Time: 上午11:14
 * To change this template use File | Settings | File Templates.
 */
public class InstallApplicationResponse extends Response  {
    private String identifier;//The app's identifier (Bundle ID)
    private String state;//The app's installation state. If the state is NeedsRedemption, the server needs to send a redemption code to complete the app installation.
    @Override
    public void doHandler() {
        if (getStatus().equals("Acknowledged"))
        {
           this.identifier = response.objectForKey("Identifier").toString();
           this.state = response.objectForKey("State").toString();
        }
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getState() {
        return state;
    }
}
