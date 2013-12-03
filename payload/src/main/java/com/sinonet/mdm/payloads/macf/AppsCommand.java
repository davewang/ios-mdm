package com.sinonet.mdm.payloads.macf;

import java.util.Vector;

import com.sinonet.mdm.payloads.Command;

public abstract class AppsCommand extends Command {
	
	protected Vector<String> identifies = new Vector<String>();
	
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
