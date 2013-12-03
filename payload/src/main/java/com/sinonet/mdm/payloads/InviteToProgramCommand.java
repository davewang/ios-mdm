package com.sinonet.mdm.payloads;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-10-31
 * Time: 下午1:06
 * To change this template use File | Settings | File Templates.
 */
public class InviteToProgramCommand extends Command {
    private String programID; //he program's identifier. One of the following: com.apple.cloudvpp: Volume Purchase Program App Assignment
    private String invitationURL; //An invitation URL provided by the program.
    public void executeBefore()
    {
        getCommand().put("RequestType",Command.COMMAND_INVITE_TO_PROGRAM);

    }
    @Override
    public void doExecute() {
        getCommand().put("ProgramID",programID);
        getCommand().put("InvitationURL",invitationURL);
    }

    public void setProgramID(String programID) {
        this.programID = programID;
    }

    public void setInvitationURL(String invitationURL) {
        this.invitationURL = invitationURL;
    }
}
