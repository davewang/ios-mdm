/**
 * 
 */
package com.sinonet.mdm.payloads.macf;

import com.dd.plist.NSArray;
import com.dd.plist.NSDictionary;
import com.dd.plist.NSString;

/**
 * @author xietianlu
 *
 */
public class RetrievesManagedAppFeedbackCommand extends AppsCommand {
	
	private boolean deleteFeedback;
	
	/* (non-Javadoc)
	 * @see com.sinonet.mdm.payloads.Command#doExecute()
	 */
	public RetrievesManagedAppFeedbackCommand() {
		super();
	}

	@Override
	public void executeBefore() {
        getCommand().put("RequestType","ManagedApplicationFeedback");
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
		command.put( "DeleteFeedback", deleteFeedback );
	}
	
	public boolean isDeleteFeedback() {
		return deleteFeedback;
	}

	public void setDeleteFeedback(boolean deleteFeedback) {
		this.deleteFeedback = deleteFeedback;
	}

}
