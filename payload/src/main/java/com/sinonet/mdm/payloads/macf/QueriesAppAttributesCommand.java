package com.sinonet.mdm.payloads.macf;

import java.util.Vector;

import com.dd.plist.NSArray;
import com.dd.plist.NSDictionary;
import com.dd.plist.NSString;
import com.sinonet.mdm.payloads.Command;

public class QueriesAppAttributesCommand extends Command {

	private Vector<String> identifies = new Vector<String>();
	
	@Override
	public void executeBefore() {
        getCommand().put("RequestType","ManagedApplicationAttributes");
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

	public void addIdentify( String iden ) {
		for ( String old : identifies ) {
			if ( old.equals( iden ) )
				return;
		}
		identifies.add( iden );
	}
	
	public void removeIdentify( String iden ) {
		for ( String old : identifies ) {
			if ( old.equals( iden ) ) {
				identifies.remove( old );
				return;
			}
		}
	}
}
