package com.sinonet.mdm.payloads.response;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-11-6
 * Time: 下午3:37
 * To change this template use File | Settings | File Templates.
 */
public class InviteToProgramResponse extends Response  {

    private String invitationResult;
    @Override
    public void doHandler() {
        if (getStatus().equals("Acknowledged"))
        {
            this.invitationResult = response.objectForKey("InvitationResult").toString();

        }
    }

    /**
     * One of the following:
     *    Acknowledged
     *    InvalidProgramID
     *    InvalidInvitationURL
     * @return
     */
    public String getInvitationResult() {
        return invitationResult;
    }
}
