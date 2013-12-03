package com.sinonet.mdm.payloads.response;

import com.dd.plist.NSDictionary;
import com.dd.plist.NSNumber;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-11-18
 * Time: 下午3:08
 * To change this template use File | Settings | File Templates.
 */
public class InstalledApplicationItem
{
    String identifier;
    String version;
    String shortVersion;
    String name;
    Integer bundleSize;
    Integer dynamicSize;

    public String getIdentifier() {
        return identifier;
    }
    static  InstalledApplicationItem getInstalledApplicationItemByNSDictionary(NSDictionary dictionary)
    {
        InstalledApplicationItem item = new InstalledApplicationItem();
        item.setIdentifier(dictionary.objectForKey("Identifier").toString());
        item.setName(dictionary.objectForKey("Name").toString());
        item.setVersion(dictionary.objectForKey("Version").toString());
        item.setShortVersion(dictionary.objectForKey("ShortVersion")==null?null:dictionary.objectForKey("ShortVersion").toString());
        item.setBundleSize(( dictionary.objectForKey("BundleSize")==null?null: ((NSNumber)dictionary.objectForKey("BundleSize")).intValue()));
        item.setDynamicSize( dictionary.objectForKey("DynamicSize")==null?null: ((NSNumber)dictionary.objectForKey("DynamicSize")).intValue());
        return item;
    }
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getShortVersion() {
        return shortVersion;
    }

    public void setShortVersion(String shortVersion) {
        this.shortVersion = shortVersion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBundleSize() {
        return bundleSize;
    }

    public void setBundleSize(Integer bundleSize) {
        this.bundleSize = bundleSize;
    }

    public Integer getDynamicSize() {
        return dynamicSize;
    }

    public void setDynamicSize(Integer dynamicSize) {
        this.dynamicSize = dynamicSize;
    }
}