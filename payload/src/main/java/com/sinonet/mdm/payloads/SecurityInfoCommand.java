package com.sinonet.mdm.payloads;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-10-30
 * Time: 下午2:46
 * To change this template use File | Settings | File Templates.
 */
public class SecurityInfoCommand extends Command{
    public void executeBefore()
    {
        getCommand().put("RequestType",Command.COMMAND_SECURITY_INFO );
    }
    @Override
    public void doExecute() {

    }
}
