package com.sinonet.mdm.payloads;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-10-29
 * Time: 下午2:04
 * To change this template use File | Settings | File Templates.
 */
public class ClearPasscodeCommand extends Command {
    private byte[] unlockToken;
    @Override
    public void doExecute() {
        getCommand().put("UnlockToken",unlockToken);
    }
    public void executeBefore()
    {
        getCommand().put("RequestType",Command.COMMAND_CLEAR_PASSCODE);
    }

    public void setUnlockToken(byte[] unlockToken) {
        this.unlockToken = unlockToken;
    }
}
