package com.sinonet.mdm.payloads.response;

import com.dd.plist.NSDictionary;
import com.dd.plist.NSNumber;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-11-18
 * Time: 下午3:12
 * To change this template use File | Settings | File Templates.
 */
public class SecurityInfo {
        Integer hardwareEncryptionCaps; //Bitfield. Describes the underlying hardware encryption capabilities of the device. Values are described in Table 9 (page 38).
        Boolean passcodePresent;   //Set to true if the device is protected by a passcode.
        Boolean passcodeCompliant;  //Set to true if the user's passcode is compliant with all requirements on the device, including Exchange and other accounts.
        Boolean passcodeCompliantWithProfiles; //Set to true if the user's passcode is compliant with requirements from profiles.

    public static  SecurityInfo getSecurityInfoByNSDictionary(NSDictionary dictionary)
        {
            SecurityInfo securityInfo = new SecurityInfo();
            securityInfo.setHardwareEncryptionCaps(((NSNumber)dictionary.objectForKey("HardwareEncryptionCaps")).intValue());
            securityInfo.setPasscodePresent(((NSNumber) dictionary.objectForKey("PasscodePresent")).boolValue());
            securityInfo.setPasscodeCompliant(((NSNumber) dictionary.objectForKey("PasscodeCompliant")).boolValue());
            securityInfo.setPasscodeCompliantWithProfiles(((NSNumber) dictionary.objectForKey("PasscodeCompliant-WithProfiles")).boolValue());

            return securityInfo;
        }

        /**
         * 1  Block-level encryption.
         * 2  File-level encryption.
         * @return
         */
        public Integer getHardwareEncryptionCaps() {
            return hardwareEncryptionCaps;
        }

    public void setHardwareEncryptionCaps(Integer hardwareEncryptionCaps) {
            this.hardwareEncryptionCaps = hardwareEncryptionCaps;
        }

    public  Boolean getPasscodePresent() {
            return passcodePresent;
        }

    public  void setPasscodePresent(Boolean passcodePresent) {
            this.passcodePresent = passcodePresent;
        }

    public Boolean getPasscodeCompliant() {
            return passcodeCompliant;
        }

    public void setPasscodeCompliant(Boolean passcodeCompliant) {
            this.passcodeCompliant = passcodeCompliant;
        }

    public Boolean getPasscodeCompliantWithProfiles() {
            return passcodeCompliantWithProfiles;
        }

    public void setPasscodeCompliantWithProfiles(Boolean passcodeCompliantWithProfiles) {
            this.passcodeCompliantWithProfiles = passcodeCompliantWithProfiles;
        }
    }