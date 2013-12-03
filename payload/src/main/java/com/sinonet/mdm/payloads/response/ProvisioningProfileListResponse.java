package com.sinonet.mdm.payloads.response;

import com.dd.plist.NSArray;
import com.dd.plist.NSDate;
import com.dd.plist.NSDictionary;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-11-5
 * Time: 下午3:00
 * To change this template use File | Settings | File Templates.
 */
public class ProvisioningProfileListResponse extends Response {
    private NSArray provisioningProfileList;
    private List<ProvisioningProfileItem> provisioningProfileItems = new ArrayList<ProvisioningProfileItem>();

    @Override
    public void doHandler() {
        if (getStatus().equals("Acknowledged"))
            this.provisioningProfileList = (NSArray)response.objectForKey("ProvisioningProfileList");

        if (this.provisioningProfileList.count()>0)
        {
            for (int i=0;i<provisioningProfileList.count();i++)
            {
                NSDictionary dic =  (NSDictionary) this.provisioningProfileList.objectAtIndex(i);
                provisioningProfileItems.add(ProvisioningProfileItem.getProvisioningProfileItemWithNSDictionary(dic));
            }
        }

    }

    public List<ProvisioningProfileItem> getProvisioningProfileItems() {
        return provisioningProfileItems;
    }
}

