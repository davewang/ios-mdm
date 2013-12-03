package com.sinonet.mdm.payloads;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-10-29
 * Time: 下午2:12
 * To change this template use File | Settings | File Templates.
 */
public class EraseDeviceCommand extends Command {
    private String pin;//The Find My Mac PIN. Must be 4 or 6 characters long. Note that this field is provided only for OS X, not iOS.
    public void executeBefore()
    {
        getCommand().put("RequestType",Command.COMMAND_ERASE_DEVICE);
    }
    @Override
    public void doExecute() {
        if (pin!=null)
            getCommand().put("PIN",pin);

    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
