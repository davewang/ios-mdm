package com.sinonet.mdm.payloads.response;

import com.dd.plist.NSDictionary;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-11-18
 * Time: 下午3:10
 * To change this template use File | Settings | File Templates.
 */
public class ProfileItem
{
    String payloadDisplayName;
    String payloadIdentifier;
    String payloadUUID;

    public static ProfileItem getProfileItemWithNSDictionary(NSDictionary dictionary)
    {
        ProfileItem item = new ProfileItem();
        item.setPayloadDisplayName(dictionary.objectForKey("PayloadDisplayName").toString());
        item.setPayloadIdentifier(dictionary.objectForKey("PayloadIdentifier").toString());
        item.setPayloadUUID(dictionary.objectForKey("PayloadUUID").toString());
        return item;
    }
    public String getPayloadDisplayName() {
        return payloadDisplayName;
    }

    public void setPayloadDisplayName(String payloadDisplayName) {
        this.payloadDisplayName = payloadDisplayName;
    }

    public String getPayloadIdentifier() {
        return payloadIdentifier;
    }

    public void setPayloadIdentifier(String payloadIdentifier) {
        this.payloadIdentifier = payloadIdentifier;
    }

    public String getPayloadUUID() {
        return payloadUUID;
    }

    public void setPayloadUUID(String payloadUUID) {
        this.payloadUUID = payloadUUID;
    }
}