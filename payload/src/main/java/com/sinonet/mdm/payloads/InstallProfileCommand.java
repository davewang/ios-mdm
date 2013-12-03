package com.sinonet.mdm.payloads;

import com.dd.plist.NSData;

import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-10-31
 * Time: 上午11:10
 * To change this template use File | Settings | File Templates.
 */
public class InstallProfileCommand extends Command {

    public NSData payload;
    public void executeBefore()
    {
        getCommand().put("RequestType",Command.COMMAND_INSTALL_PROFILE);

    }
    @Override
    public void doExecute() {
        if(payload==null)
            log.error("payload is null,command not be execute");

        getCommand().put("Payload", payload);
    }

    public void setPayload(NSData payload) {
        this.payload = payload;
    }
    public void setPayload(File payload) throws IOException {
        this.payload = new NSData(payload);
    }
    public void setPayload(byte[] bytes){
        this.payload = new NSData(bytes);
    }
}
