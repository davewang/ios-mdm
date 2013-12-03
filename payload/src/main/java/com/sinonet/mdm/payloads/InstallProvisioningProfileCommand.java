package com.sinonet.mdm.payloads;

import com.dd.plist.NSData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-10-31
 * Time: 上午11:25
 * To change this template use File | Settings | File Templates.
 */
public class InstallProvisioningProfileCommand extends Command {

    private NSData provisioningProfile;
    public void executeBefore()
    {
        getCommand().put("RequestType",Command.COMMAND_INSTALL_PROVISIONINGPROFILE);

    }
    @Override
    public void doExecute() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setProvisioningProfile(NSData provisioningProfile) {
        this.provisioningProfile = provisioningProfile;
    }
    public void setProvisioningProfile(File provisioningProfile) throws IOException {
        this.provisioningProfile = new NSData(provisioningProfile);
    }
    public void setProvisioningProfile(byte[] bytes){
        this.provisioningProfile = new NSData(bytes);
    }

}
