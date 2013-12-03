package com.sinonet.mdm.payloads.response;

import com.dd.plist.NSDate;
import com.dd.plist.NSDictionary;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-11-18
 * Time: 下午3:10
 * To change this template use File | Settings | File Templates.
 */
public class ProvisioningProfileItem
        {
private String name;
private String uuid;
private Date expiryDate;
static ProvisioningProfileItem getProvisioningProfileItemWithNSDictionary(NSDictionary dictionary)
        {
                ProvisioningProfileItem item = new ProvisioningProfileItem();
        item.setName(dictionary.objectForKey("Name").toString());
        item.setUuid(dictionary.objectForKey("UUID").toString());
        NSDate date = (NSDate)dictionary.objectForKey("ExpiryDate");
        item.setExpiryDate(date.getDate());
        return item;
       }

            public void setName(String name) {
        this.name = name;
}

            public void setUuid(String uuid) {
        this.uuid = uuid;
}

            public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
}

            public String getName() {
        return name;
}

            public String getUuid() {
        return uuid;
}

            public  Date getExpiryDate() {
        return expiryDate;
}
        }