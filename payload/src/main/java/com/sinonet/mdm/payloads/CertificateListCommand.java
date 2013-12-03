package com.sinonet.mdm.payloads;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-10-31
 * Time: 下午12:02
 * To change this template use File | Settings | File Templates.
 */
public class CertificateListCommand extends Command{

    public void executeBefore()
    {
        getCommand().put("RequestType",Command.COMMAND_LIST_CERTIFICATE);
    }

    @Override
    public void doExecute() {

    }
}
