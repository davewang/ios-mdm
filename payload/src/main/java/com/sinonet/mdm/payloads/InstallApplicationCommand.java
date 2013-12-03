package com.sinonet.mdm.payloads;

import com.dd.plist.NSDictionary;
import com.dd.plist.NSNumber;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-10-30
 * Time: 下午1:36
 * To change this template use File | Settings | File Templates.
 */
public class InstallApplicationCommand extends Command {
    private NSNumber iTunesStoreID;
    private String identifier;//Optional. The application’s bundle identifier. Available in iOS 7 and later.
    private NSDictionary options;//Optional. App installation options. The available options are listed below. Available in iOS 7 and later.
    private String manifestURL; //he https URL where the manifest of an enterprise application can be found.  Note that in iOS 7 and later, this URL must begin with https.
    private Integer managementFlags;  //1—Remove app when MDM profile is removed. 4—Prevent backup of the app data.
    private NSDictionary configuration; //Optional
    private NSDictionary attributes;//Optional.
    private Boolean notManaged; //f true, the app is queued for installation, but is not managed. OS X app installation must set this value to true.
    private Integer purchaseMethod; //0: Volume Purchase Program 1: Volume Purchase Program App Assignment
    public void executeBefore()
    {
        getCommand().put("RequestType",Command.COMMAND_INSTALL_APPLICATION);
    }
    @Override
    public void doExecute() {


        if (iTunesStoreID!=null)
            getCommand().put("iTunesStoreID",iTunesStoreID);
        if (identifier!=null)
            getCommand().put("Identifier",identifier);
        if (options!=null)
            getCommand().put("Options",options);
        if (manifestURL!=null)
            getCommand().put("ManifestURL",manifestURL);
        if (managementFlags!=null)
            getCommand().put("ManagementFlags",managementFlags);
        if (configuration!=null)
            getCommand().put("Configuration",configuration);
        if (attributes!=null)
            getCommand().put("Attributes",attributes);
        if (notManaged!=null)
            getCommand().put("NotManaged",notManaged);
        if (purchaseMethod!=null)
            getCommand().put("PurchaseMethod",purchaseMethod);
    }

    public String getiTunesStoreID() {
        return iTunesStoreID.toString();
    }

    public void setiTunesStoreID(String iTunesStoreID) {
        this.iTunesStoreID = new NSNumber(iTunesStoreID);
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public NSDictionary getOptions() {
        return options;
    }

    public void setOptions(NSDictionary options) {
        this.options = options;
    }

    public String getManifestURL() {
        return manifestURL;
    }

    public void setManifestURL(String manifestURL) {
        this.manifestURL = manifestURL;
    }

    public Integer getManagementFlags() {
        return managementFlags;
    }

    public void setManagementFlags(Integer managementFlags) {
        this.managementFlags = managementFlags;
    }

    public NSDictionary getConfiguration() {
        return configuration;
    }

    public void setConfiguration(NSDictionary configuration) {
        this.configuration = configuration;
    }

    public NSDictionary getAttributes() {
        return attributes;
    }

    public void setAttributes(NSDictionary attributes) {
        this.attributes = attributes;
    }

    public Boolean getNotManaged() {
        return notManaged;
    }

    public void setNotManaged(Boolean notManaged) {
        this.notManaged = notManaged;
    }

    public Integer getPurchaseMethod() {
        return purchaseMethod;
    }

    public void setPurchaseMethod(Integer purchaseMethod) {
        this.purchaseMethod = purchaseMethod;
    }
}
