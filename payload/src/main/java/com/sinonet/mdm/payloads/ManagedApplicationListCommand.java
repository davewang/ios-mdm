package com.sinonet.mdm.payloads;

import com.dd.plist.NSArray;
import com.dd.plist.NSString;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-10-31
 * Time: 下午1:01
 * To change this template use File | Settings | File Templates.
 */
public class ManagedApplicationListCommand extends Command {
    private List<String> identifiers = new ArrayList<String>(); //Optional. An array of app identifiers as strings. If provided, the response contains only the status of apps whose identifiers appear in this array. Available in iOS 7 and later.
    public void executeBefore()
    {
        getCommand().put("RequestType",Command.COMMAND_LIST_MANAGED_APPLICATION);

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
