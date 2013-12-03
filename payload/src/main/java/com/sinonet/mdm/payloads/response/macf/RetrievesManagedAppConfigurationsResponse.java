package com.sinonet.mdm.payloads.response.macf;

import com.dd.plist.NSArray;
import com.dd.plist.NSDictionary;
import com.dd.plist.NSString;
import com.sinonet.mdm.payloads.response.Response;

public class RetrievesManagedAppConfigurationsResponse extends Response {

	@Override
	public void doHandler() {
		NSArray array = (NSArray)response.get( "ApplicationConfigurations" );
		for ( int i = 0; i < array.count(); i++ ) {
			NSDictionary elem = (NSDictionary)array.objectAtIndex(i);
			NSString iden = (NSString)elem.get( "Identifier" );
			NSDictionary configuration = (NSDictionary)elem.get( "Configuration" );
			this.handleConfiguration( iden, configuration );
		}
	}

	protected void handleConfiguration( NSString iden, NSDictionary configuration ) {
		System.out.println( iden.toString() + configuration.toXMLPropertyList() );
	}
}
