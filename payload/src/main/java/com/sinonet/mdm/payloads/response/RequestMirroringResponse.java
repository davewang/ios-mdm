package com.sinonet.mdm.payloads.response;

import com.dd.plist.NSDictionary;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-11-5
 * Time: 下午4:48
 * To change this template use File | Settings | File Templates.
 */
public class RequestMirroringResponse extends Response  {
    /**
     * The result of this request. The returned value is one of: Prompting—The user is being prompted to share his or her screen.
     * DestinationNotFound—The destination cannot be reached by the device.
     * Cancelled—The request was cancelled. Unknown—An unknown error occurred.
     */
    private  String mirroringResult;
    @Override
    public void doHandler() {
        if (getStatus().equals("Acknowledged"))
            this.mirroringResult = response.objectForKey("MirroringResult").toString();

    }

    public String getMirroringResult() {
        return mirroringResult;
    }
}
