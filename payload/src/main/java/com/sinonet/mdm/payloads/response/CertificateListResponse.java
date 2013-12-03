package com.sinonet.mdm.payloads.response;

import com.dd.plist.NSArray;
import com.dd.plist.NSData;
import com.dd.plist.NSDictionary;
import com.dd.plist.NSNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-11-5
 * Time: 下午3:22
 * To change this template use File | Settings | File Templates.
 */
public class CertificateListResponse extends Response  {
    private NSArray certificateList;
    private List<CertificateItem> certificateItems = new ArrayList<CertificateItem>();
    @Override
    public void doHandler() {
        if (getStatus().equals("Acknowledged"))
            this.certificateList = (NSArray)response.objectForKey("CertificateList");

        if (this.certificateList.count()>0)
        {
            for (int i=0;i<certificateList.count();i++)
            {
                NSDictionary dic =  (NSDictionary) this.certificateList.objectAtIndex(i);
                this.certificateItems.add(CertificateItem.getCertificateItemByNSDictionary(dic));
            }
        }

    }

    public List<CertificateItem> getCertificateItems() {
        return certificateItems;
    }
}

