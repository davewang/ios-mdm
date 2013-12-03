package com.sinonet.mdm.payloads;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-10-31
 * Time: 下午12:49
 * To change this template use File | Settings | File Templates.
 */
public class StopMirroringCommand extends Command {
    public void executeBefore()
    {
        getCommand().put("RequestType",Command.COMMAND_STOP_MIRRORING );
    }
    @Override
    public void doExecute() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
