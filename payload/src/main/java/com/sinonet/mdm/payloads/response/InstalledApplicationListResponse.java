package com.sinonet.mdm.payloads.response;

import com.dd.plist.NSArray;
import com.dd.plist.NSDictionary;
import com.dd.plist.NSNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-11-5
 * Time: 下午4:13
 * To change this template use File | Settings | File Templates.
 */
public class InstalledApplicationListResponse extends Response  {
    private NSArray installedApplicationList;
    private List<InstalledApplicationItem> installedApplicationItems = new ArrayList<InstalledApplicationItem>();
    @Override
    public void doHandler() {
        if (getStatus().equals("Acknowledged"))
            installedApplicationList = (NSArray)response.objectForKey("InstalledApplicationList");


        if (this.installedApplicationList.count()>0)
        {
            for (int i=0;i<installedApplicationList.count();i++)
            {
                NSDictionary dic =  (NSDictionary) this.installedApplicationList.objectAtIndex(i);
                installedApplicationItems.add(InstalledApplicationItem.getInstalledApplicationItemByNSDictionary(dic));
            }
        }
    }

    public List<InstalledApplicationItem> getInstalledApplicationItems() {
        return installedApplicationItems;
    }
}

