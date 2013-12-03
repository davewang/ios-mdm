package com.sinonet.mdm.payloads;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-10-31
 * Time: 上午11:21
 * To change this template use File | Settings | File Templates.
 */
public class ProvisioningProfileListCommand extends Command{
    public void executeBefore()
    {
        getCommand().put("RequestType",Command.COMMAND_LIST_PROVISIONINGPROFILE);
    }

    @Override
    public void doExecute() {

    }
}
