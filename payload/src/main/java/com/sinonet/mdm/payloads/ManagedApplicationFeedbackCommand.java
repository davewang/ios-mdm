package com.sinonet.mdm.payloads;

import com.dd.plist.NSArray;
import com.dd.plist.NSString;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-11-4
 * Time: 下午2:23
 * To change this template use File | Settings | File Templates.
 */
public class ManagedApplicationFeedbackCommand  extends Command  {

    //Array of managed application identifiers, as strings.
    public void executeBefore()
    {
        getCommand().put("RequestType",Command.COMMAND_MANAGED_APPLICATION_FEEDBACK);

    }



    private Boolean deleteFeedback;
    private List<String> identifiers = new ArrayList<String>();

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
        if(deleteFeedback)
            getCommand().put("DeleteFeedback",deleteFeedback);

    }

    /**
     * Optional. If true, the application's feedback dictionary is deleted after it is read.
     * @param deleteFeedback
     */
    public void setDeleteFeedback(Boolean deleteFeedback)
    {
        this.deleteFeedback=deleteFeedback;
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
