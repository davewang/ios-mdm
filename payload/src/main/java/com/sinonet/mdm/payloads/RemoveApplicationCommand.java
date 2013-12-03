package com.sinonet.mdm.payloads;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-10-30
 * Time: 下午1:53
 * To change this template use File | Settings | File Templates.
 */
public class RemoveApplicationCommand extends Command {
    private String identifier;
    public void executeBefore()
    {
        getCommand().put("RequestType",Command.COMMAND_REMOVE_APPLICATION);
    }
    @Override
    public void doExecute() {
        getCommand().put("Identifier",identifier);
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
