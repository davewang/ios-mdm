package com.sinonet.mdm.payloads.response.macf;

import com.dd.plist.NSArray;
import com.dd.plist.NSDictionary;
import com.dd.plist.NSString;
import com.sinonet.mdm.payloads.response.Response;

public class RetrievesManagedAppFeedbackResponse extends Response {

	@Override
	public void doHandler() {
		NSArray array = (NSArray)response.get( "ManagedApplicationFeedback" );
		for ( int i = 0; i < array.count(); i++ ) {
			NSDictionary elem = (NSDictionary)array.objectAtIndex(i);
			NSString iden = (NSString)elem.get( "Identifier" );
			NSDictionary feedback = (NSDictionary)elem.get( "Feedback" );
			this.handleFeedback( iden, feedback );
		}
	}
	
	protected void handleFeedback( NSString iden, NSDictionary feedback ) {
		System.out.println( iden.toString() + feedback.toXMLPropertyList() );
	}

}
