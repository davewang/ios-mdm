package com.sinonet.mdm.payloads;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-10-31
 * Time: 上午11:18
 * To change this template use File | Settings | File Templates.
 */
public class RemoveProfileCommand  extends Command  {
    private String identifier;    //The PayloadIdentifier value for the profile to remove.
    public void executeBefore()
    {
        getCommand().put("RequestType",Command.COMMAND_REMOVE_PROFILE);

    }
    @Override
    public void doExecute() {
        getCommand().put("Identifier",identifier);
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
