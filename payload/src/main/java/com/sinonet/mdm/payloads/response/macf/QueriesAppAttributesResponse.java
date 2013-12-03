package com.sinonet.mdm.payloads.response.macf;

import com.dd.plist.NSArray;
import com.dd.plist.NSDictionary;
import com.dd.plist.NSString;
import com.sinonet.mdm.payloads.response.Response;

public class QueriesAppAttributesResponse extends Response {

	@Override
	public void doHandler() {
		NSArray array = (NSArray)response.get( "ApplicationAttributes" );
		for ( int i = 0; i < array.count(); i++ ) {
			NSDictionary elem = (NSDictionary)array.objectAtIndex(i);
			NSString iden = (NSString)elem.get( "Identifier" );
			NSDictionary attributes = (NSDictionary)elem.get( "Attributes" );
			this.handleAttributes( iden, attributes );
		}
	}

	protected void handleAttributes( NSString iden, NSDictionary attributes ) {
		System.out.println( iden.toString() + attributes.toXMLPropertyList() );
		NSString vpnuuid = (NSString)attributes.get( "VPNUUID" );
		System.out.println( "VPNUUID:" + vpnuuid );
	}
}
