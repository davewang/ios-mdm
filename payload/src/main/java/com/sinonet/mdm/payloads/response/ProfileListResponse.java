package com.sinonet.mdm.payloads.response;

import com.dd.plist.NSArray;
import com.dd.plist.NSDate;
import com.dd.plist.NSDictionary;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-11-5
 * Time: 下午1:28
 * To change this template use File | Settings | File Templates.
 */
public class ProfileListResponse extends Response {
    private NSArray profileList;
    private List<ProfileItem> profileItems = new ArrayList<ProfileItem>();
    @Override
    public void doHandler() {
        if (getStatus().equals("Acknowledged"))
            profileList = (NSArray)response.objectForKey("ProfileList");


        if (this.profileList.count()>0)
        {
            for (int i=0;i<profileList.count();i++)
            {
                NSDictionary dic =  (NSDictionary) this.profileList.objectAtIndex(i);
                profileItems.add(ProfileItem.getProfileItemWithNSDictionary(dic));
            }
        }
    }

    public List<ProfileItem> getProfileItems() {
        return profileItems;
    }
}

