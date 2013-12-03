package com.sinonet.mdm.payloads;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-10-29
 * Time: 下午1:36
 * To change this template use File | Settings | File Templates.
 */
public class DeviceLockCommand extends Command {
    private String pin;   //The Find My Mac PIN. Must be 4 or 6 characters long. Note that this field is provided only for OS X, not iOS.
    private String message;  //Optional. If provided, this message is displayed on the lock screen. Available in iOS 7 and later.
    private String phoneNumber; //Optional. If provided, this phone number is displayed on the lock screen. Available in iOS 7 and later.
    public void executeBefore()
    {
        getCommand().put("RequestType",Command.COMMAND_DEVICE_LOCK);
    }
    @Override
    public void doExecute() {
        getCommand().put("PIN",pin);
        if (message!=null)
           getCommand().put("Message",message);
        if (phoneNumber!=null)
           getCommand().put("PhoneNumber",phoneNumber);
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
