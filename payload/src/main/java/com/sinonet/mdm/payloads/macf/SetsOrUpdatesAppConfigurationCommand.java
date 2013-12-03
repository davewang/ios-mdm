package com.sinonet.mdm.payloads.macf;

import com.dd.plist.NSDictionary;
import com.dd.plist.NSObject;
import com.dd.plist.NSString;
import com.sinonet.mdm.payloads.SettingsCommand;

public class SetsOrUpdatesAppConfigurationCommand extends SettingsCommand {

	private String identify;
	private NSDictionary configuration = new NSDictionary();
	
	@Override
	public void doExecute() {
		NSDictionary command = getCommand();
		command.put( "Item", new NSString( "ApplicationConfiguration" ) );
		command.put( "Identifier", identify );
		command.put( "Configuration", configuration );
	}

	public void setConfiguration( String key, String value ) {
		configuration.put( key, value );
	}
	
	public void setConfiguration( String key, NSObject object ) {
		configuration.put( key, object );
	}
}
