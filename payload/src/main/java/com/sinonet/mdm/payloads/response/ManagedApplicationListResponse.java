package com.sinonet.mdm.payloads.response;

import com.dd.plist.NSArray;
import com.dd.plist.NSDictionary;
import com.dd.plist.NSNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-11-6
 * Time: 上午11:18
 * To change this template use File | Settings | File Templates.
 */
public class ManagedApplicationListResponse extends Response {
    private NSDictionary managedApplicationList;
    private List<ManagedApplicationItem> managedApplicationItems = new ArrayList<ManagedApplicationItem>();
    @Override
    public void doHandler() {
        if (getStatus().equals("Acknowledged"))
        {
            this.managedApplicationList = (NSDictionary) response.objectForKey("ManagedApplicationList");
        }
        if (getCount()>0)
        {
            String[] apps = getIdentifiers();
            for (int i=0;i<apps.length;i++)
            {
                NSDictionary dictionary = (NSDictionary) this.managedApplicationList.objectForKey(apps[i]);
                ManagedApplicationItem item = ManagedApplicationItem.getManagedApplicationItemByNSDictionary(dictionary);
                item.setIdentifier(apps[i]);
                managedApplicationItems.add(item);
            }
        }

    }
    public int getCount()
    {
        return this.managedApplicationList.count();
    }
    public String[] getIdentifiers()
    {
        return this.managedApplicationList.allKeys();
    }
    public NSDictionary getNSDictionaryWithIdentify(String identify)
    {
        return (NSDictionary)this.managedApplicationList.get(identify);
    }

    public NSDictionary getManagedApplicationList() {
        return managedApplicationList;
    }

    public List<ManagedApplicationItem> getManagedApplicationItems() {
        return managedApplicationItems;
    }
}
