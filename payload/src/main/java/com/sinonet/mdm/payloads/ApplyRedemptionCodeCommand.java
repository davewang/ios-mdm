package com.sinonet.mdm.payloads;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-10-31
 * Time: 下午12:56
 * To change this template use File | Settings | File Templates.
 */
public class ApplyRedemptionCodeCommand extends Command {
    private String identifier;    //The App ID returned by the InstallApplication command
    private String redemptionCode; //The redemption code that applies to the app being installed.
    public void executeBefore()
    {
        getCommand().put("RequestType",Command.COMMAND_APPLY_REDEMPTION_CODE);
    }
    @Override
    public void doExecute() {
        if (identifier!=null)
            getCommand().put("Identifier",identifier);
        if (redemptionCode!=null)
            getCommand().put("RedemptionCode",redemptionCode);
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public void setRedemptionCode(String redemptionCode) {
        this.redemptionCode = redemptionCode;
    }
}
