package com.sinonet.mdm.payloads;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-10-31
 * Time: 上午11:59
 * To change this template use File | Settings | File Templates.
 */
public class RemoveProvisioningProfileCommand extends Command {
    private String uuid;
    public void executeBefore()
    {
        getCommand().put("RequestType",Command.COMMAND_REMOVE_PROVISIONINGPROFILE);

    }
    @Override
    public void doExecute() {
        getCommand().put("UUID",uuid);
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
