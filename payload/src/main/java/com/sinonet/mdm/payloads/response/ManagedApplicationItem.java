package com.sinonet.mdm.payloads.response;

import com.dd.plist.NSDictionary;
import com.dd.plist.NSNumber;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-11-18
 * Time: 下午3:07
 * To change this template use File | Settings | File Templates.
 */
public class ManagedApplicationItem
{
    String identifier;
    String status;
    Integer managementFlags;
    String unusedRedemptionCode;
    Boolean hasConfiguration;
    Boolean hasFeedback;


    public static ManagedApplicationItem getManagedApplicationItemByNSDictionary(NSDictionary dictionary)
    {
        ManagedApplicationItem item = new ManagedApplicationItem();
        item.setStatus(dictionary.objectForKey("Status").toString());
        item.setManagementFlags(((NSNumber) dictionary.objectForKey("ManagementFlags")).intValue());



        item.setUnusedRedemptionCode(dictionary.objectForKey("UnusedRedemptionCode")==null?null:dictionary.objectForKey("UnusedRedemptionCode").toString());

     //   item.setHasConfiguration(((NSNumber)dictionary.objectForKey("HasConfiguration")).boolValue());
     //   item.setHasFeedback(((NSNumber) dictionary.objectForKey("HasFeedback")).boolValue());
        return item;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    /**
     * The status of the managed app. One of the following: NeedsRedemption—The app is scheduled for installation, but needs a redemption code to complete the transaction.
     * Redeeming—The device is redeeming the redemption code.
     * Prompting—The user is being prompted for app installation.
     * PromptingForLogin—The user is being prompted for App Store credentials.
     * Installing—The app is being installed. ValidatingPurchase—An app purchase is being
     * validated.
     * Managed—The app is installed and managed.
     * ManagedButUninstalled—The app is managed, but has been removed by the user. When the app is installed again (even by the user), it will be managed once again.
     * PromptingForUpdate—The user is being prompted for an update
     * PromptingForUpdateLogin - the user is being prompted for App Store credentials for an update
     * Updating—The app is being updated ValidatingUpdate—An app update is being
     * validated.
     * Unknown—The app state is unknown.
     * The following statuses are transient, and are reported only once:
     * UserInstalledApp—The user has installed the app before managed app installation could take place.
     * UserRejected—The user rejected the offer to install the app.
     * UpdateRejected—The user rejected the offer to update the app.
     * Failed—The app installation has failed.
     * @return
     */
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getManagementFlags() {
        return managementFlags;
    }

    public void setManagementFlags(Integer managementFlags) {
        this.managementFlags = managementFlags;
    }

    public String getUnusedRedemptionCode() {
        return unusedRedemptionCode;
    }

    public void setUnusedRedemptionCode(String unusedRedemptionCode) {
        this.unusedRedemptionCode = unusedRedemptionCode;
    }

    public Boolean getHasConfiguration() {
        return hasConfiguration;
    }

    public void setHasConfiguration(Boolean hasConfiguration) {
        this.hasConfiguration = hasConfiguration;
    }

    public Boolean getHasFeedback() {
        return hasFeedback;
    }

    public void setHasFeedback(Boolean hasFeedback) {
        this.hasFeedback = hasFeedback;
    }
}