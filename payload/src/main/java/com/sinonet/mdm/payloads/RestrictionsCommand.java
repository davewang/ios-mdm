package com.sinonet.mdm.payloads;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-10-30
 * Time: 下午5:49
 * To change this template use File | Settings | File Templates.
 */
public class RestrictionsCommand extends Command {



    private Boolean profileRestrictions;//Optional. If true, the device will report restrictions enforced by each profile.


    public void executeBefore()
    {
        getCommand().put("RequestType",Command.COMMAND_RESTRICTIONS);

    }
    @Override
    public void doExecute() {

    }

    public void setProfileRestrictions(Boolean profileRestrictions) {
        this.profileRestrictions = profileRestrictions;
    }
}
