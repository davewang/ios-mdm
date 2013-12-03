package com.sinonet.mdm.payloads;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-10-31
 * Time: 下午12:49
 * To change this template use File | Settings | File Templates.
 */
public class RequestMirroringCommand extends Command {

    private String  destinationName; //Optional. The name of the AirPlay mirroring destination. For Apple TV, this is the name of the Apple TV.
    private String  destinationDeviceID; //Optional. The device ID (hardware address) of the AirPlay mirroring destination, in the format "xx:xx:xx:xx:xx:xx". This field is not case sensitive.
    private String  scanTime; //Optional. Number of seconds to spend searching for the destination. The default is 30 seconds. This value must be in the range 10–300.
    private String  password; //Optional. The screen sharing password that the device should use when connecting to the destination.

    public void executeBefore()
    {
        getCommand().put("RequestType",Command.COMMAND_REQUEST_MIRRORING );
    }
    @Override
    public void doExecute() {
        if (destinationName!=null)
            getCommand().put("DestinationName",destinationName);
        if (destinationDeviceID!=null)
            getCommand().put("DestinationDeviceID",destinationDeviceID );
        if (scanTime!=null)
            getCommand().put("ScanTime",scanTime );
        if (password!=null)
            getCommand().put("Password",password );

    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public void setDestinationDeviceID(String destinationDeviceID) {
        this.destinationDeviceID = destinationDeviceID;
    }

    public void setScanTime(String scanTime) {
        this.scanTime = scanTime;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
