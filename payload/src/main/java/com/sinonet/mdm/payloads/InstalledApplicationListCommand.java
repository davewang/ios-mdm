package com.sinonet.mdm.payloads;

import com.dd.plist.NSArray;
import com.dd.plist.NSString;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-10-31
 * Time: 下午12:19
 * To change this template use File | Settings | File Templates.
 */
public class InstalledApplicationListCommand extends Command {
    private List<String> identifiers = new ArrayList<String>(); //Optional. An array of app identifiers as strings. If provided, the response contains only the status of apps whose identifiers appear in this array. Available in iOS 7 and later.
    private boolean managedAppsOnly; //Optional. If true, only managed app identifiers are returned. Available in iOS 7 and later.
    public void executeBefore()
    {
        getCommand().put("RequestType",Command.COMMAND_LIST_INSTALLED_APPLICATION);
    }
    @Override
    public void doExecute() {
        if (identifiers.size()>0)
        {
            NSArray array = new NSArray(identifiers.size());
            for (int i=0; i<identifiers.size(); i++)
            {
                array.setValue(i, new NSString(identifiers.get(i)));
            }
            getCommand().put("Identifiers",array);
        }
        if (managedAppsOnly)
            getCommand().put("ManagedAppsOnly", new Boolean( managedAppsOnly ) );


    }
    
    public boolean isManagedAppsOnly() {
		return managedAppsOnly;
	}
    
	public void setManagedAppsOnly(boolean managedAppsOnly) {
		this.managedAppsOnly = managedAppsOnly;
	}
	
	public void addIdentifier(String identifier)
    {
        identifiers.add(identifier);
    }
    public void removeIdentifier(String identifier)
    {
        identifiers.remove(identifier);
    }
    public void clearIdentifiers()
    {
        identifiers.clear();
    }
}
