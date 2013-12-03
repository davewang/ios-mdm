package com.sinonet.mdm.payloads.macf;

import com.dd.plist.NSArray;
import com.dd.plist.NSDictionary;
import com.dd.plist.NSString;

public class RetrievesManagedAppConfigurationsCommand extends AppsCommand {

	@Override
	public void executeBefore() {
        getCommand().put("RequestType","ManagedApplicationConfiguration");
	}

	@Override
	public void doExecute() {
		NSDictionary command = this.getCommand();
		NSArray array = new NSArray( identifies.size() );
		int curr = 0;
		for ( String iden : identifies ) {
			NSString value = new NSString( iden );
			array.setValue( curr++, value );
		}
		command.put( "Identifies", array );
	}

}
