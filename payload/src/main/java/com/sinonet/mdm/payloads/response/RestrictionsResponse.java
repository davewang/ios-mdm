package com.sinonet.mdm.payloads.response;

import com.dd.plist.NSDictionary;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-11-5
 * Time: 下午5:01
 * To change this template use File | Settings | File Templates.
 */
public class RestrictionsResponse extends Response  {

    private NSDictionary globalRestrictions;
    private NSDictionary profileRestrictions;

    @Override
    public void doHandler() {
        if (getStatus().equals("Acknowledged"))
        {
            this.globalRestrictions =(NSDictionary) response.objectForKey("GlobalRestrictions");
            this.profileRestrictions =(NSDictionary) response.objectForKey("ProfileRestrictions");
        }
    }

    public NSDictionary getGlobalRestrictions() {
        return globalRestrictions;
    }

    public NSDictionary getProfileRestrictions() {
        return profileRestrictions;
    }
}
