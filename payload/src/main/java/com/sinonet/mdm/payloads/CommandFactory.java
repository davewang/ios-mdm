package com.sinonet.mdm.payloads;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-10-29
 * Time: 下午3:09
 * To change this template use File | Settings | File Templates.
 */
public class CommandFactory {
    public static Command createEraseDeviceCommand()
    {
        EraseDeviceCommand eraseDeviceCommand = new EraseDeviceCommand();
        return eraseDeviceCommand;
    }
    public static Command createDeviceLockCommand(String pin,String message,String phoneNumber)
    {
        if (pin==null || pin.isEmpty() )
            return null;

        DeviceLockCommand deviceLockCommand = new DeviceLockCommand();
        deviceLockCommand.setMessage(message);
        deviceLockCommand.setPhoneNumber(phoneNumber);
        deviceLockCommand.setPin(pin);
        return deviceLockCommand;
    }
    public static Command createClearPasscodeCommand(byte[] data)
    {
        if (data==null )
            return null;

        ClearPasscodeCommand clearPasscodeCommand = new ClearPasscodeCommand();
        clearPasscodeCommand.setUnlockToken(data);
        return clearPasscodeCommand;
    }
    public static Command createClearPasscodeCommand(String hexData)
    {
        if (hexData==null || hexData.isEmpty() )
            return null;

        ClearPasscodeCommand clearPasscodeCommand = new ClearPasscodeCommand();
        try {
            clearPasscodeCommand.setUnlockToken(Hex.decodeHex(hexData.toCharArray()));
        } catch (DecoderException e) {
            e.printStackTrace();
        }
        return clearPasscodeCommand;
    }
    public static Command createDeviceInformationCommand()
    {
        DeviceInformationCommand deviceInformationCommand = new DeviceInformationCommand();

        return deviceInformationCommand;
    }
    public static Command createInstallApplicationByiTunesStoreID(String  iTunesStoreID)
    {
        InstallApplicationCommand installApplicationCommand = new InstallApplicationCommand();
        installApplicationCommand.setiTunesStoreID(iTunesStoreID);
        installApplicationCommand.setManagementFlags(4);
       // installApplicationCommand.execute();
        return installApplicationCommand;
    }
    public static Command createRemoveApplicationCommandByIdentifier(String  identifier)
    {
        RemoveApplicationCommand removeApplicationCommand = new RemoveApplicationCommand();
        removeApplicationCommand.setIdentifier(identifier);
        return removeApplicationCommand;
    }

    public static Command createProfileListCommand()
    {
        ProfileListCommand profileListCommand = new ProfileListCommand();

        return profileListCommand;
    }

    public static Command createInstallProfileCommand(byte[] bytes)
    {
        InstallProfileCommand installProfileCommand = new InstallProfileCommand();
        installProfileCommand.setPayload(bytes);

        return installProfileCommand;
    }
    public static Command createInstallProfileCommand(File file)
    {
        InstallProfileCommand installProfileCommand = new InstallProfileCommand();
        try {
            installProfileCommand.setPayload(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return installProfileCommand;
    }

    public static Command createRemoveProfileCommand(String identifier)
    {

        RemoveProfileCommand removeProfileCommand = new RemoveProfileCommand();
        removeProfileCommand.setIdentifier(identifier);


        return removeProfileCommand;
    }


    public static Command createRestrictionsCommand()
    {

        RestrictionsCommand restrictionsCommand = new RestrictionsCommand();
         return restrictionsCommand;
    }
    
    public static Command createInstalledApplicationListCommand( Collection<String> identifies ) {
    	InstalledApplicationListCommand command = new InstalledApplicationListCommand();
    	if ( identifies != null && !identifies.isEmpty() ) {
    		for ( String iden : identifies ) {
    			command.addIdentifier( iden );
    		}
    	}
    	return command;
    }

    public static Command createManagedApplicationListCommand( Collection<String> identifies ) {
    	ManagedApplicationListCommand command = new ManagedApplicationListCommand();
    	if ( identifies != null && !identifies.isEmpty() ) {
	    	for ( String iden : identifies ) {
	    		command.addIdentifier( iden );
	    	}
    	}
    	return command;
    }
}
