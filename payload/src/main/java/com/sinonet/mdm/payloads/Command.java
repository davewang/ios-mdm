package com.sinonet.mdm.payloads;


import com.dd.plist.NSDictionary;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-10-29
 * Time: 下午1:05
 * To change this template use File | Settings | File Templates.
 */
public abstract class Command {
    protected final Log log = LogFactory.getLog(getClass());

    private NSDictionary root = new NSDictionary();
    private String commandUUID;
    private String requestType;
    private NSDictionary command = new NSDictionary();
    public abstract void doExecute();
    public void executeBefore()
    {
        getCommand().put("RequestType",requestType);
    }
    public void executeAfter()
    {
        root.put("CommandUUID",commandUUID);
        root.put("Command",command);
        log.debug(root.toXMLPropertyList());
    }
    public Command execute()
    {
        executeBefore();
        doExecute();
        executeAfter();
        return this;
    }

    public String getCommandUUID() {
        return commandUUID;
    }


    public void setCommandUUID(String commandUUID) {
        this.commandUUID = commandUUID;
    }

    public NSDictionary getCommand() {
        return command;
    }


    public String toXMLPropertyList()
    {
        return root.toXMLPropertyList();
    }
    public byte[] bytes()
    {
        return toXMLPropertyList().getBytes();
    }




    protected static final String  COMMAND_DEVICE_INFORMATION="DeviceInformation";
    protected static final String  COMMAND_CLEAR_PASSCODE="ClearPasscode";
    protected static final String  COMMAND_DEVICE_LOCK="DeviceLock";
    protected static final String  COMMAND_ERASE_DEVICE="EraseDevice";
    protected static final String  COMMAND_INSTALL_APPLICATION="InstallApplication";
    protected static final String  COMMAND_REMOVE_APPLICATION="RemoveApplication";
    protected static final String  COMMAND_INSTALL_PROFILE="InstallProfile";
    protected static final String  COMMAND_REMOVE_PROFILE="RemoveProfile";
    protected static final String  COMMAND_INSTALL_PROVISIONINGPROFILE="InstallProvisioningProfile";
    protected static final String  COMMAND_REMOVE_PROVISIONINGPROFILE="RemoveProvisioningProfile";
    protected static final String  COMMAND_LIST_PROVISIONINGPROFILE="ProvisioningProfileList";
    protected static final String  COMMAND_LIST_PROFILE="ProfileList";
    protected static final String  COMMAND_RESTRICTIONS="Restrictions";
    protected static final String  COMMAND_SECURITY_INFO="SecurityInfo";
    protected static final String  COMMAND_LIST_CERTIFICATE="CertificateList";
    protected static final String  COMMAND_LIST_INSTALLED_APPLICATION="InstalledApplicationList";
    protected static final String  COMMAND_REQUEST_MIRRORING="RequestMirroring";
    protected static final String  COMMAND_STOP_MIRRORING="StopMirroring";
    protected static final String  COMMAND_APPLY_REDEMPTION_CODE="ApplyRedemptionCode";
    protected static final String  COMMAND_LIST_MANAGED_APPLICATION="ManagedApplicationList";
    protected static final String  COMMAND_INVITE_TO_PROGRAM="InviteToProgram";
    protected static final String  COMMAND_SETTINGS="Settings";
    protected static final String  COMMAND_MANAGED_APPLICATION_CONFIGURATION="ManagedApplicationConfiguration";
    protected static final String  COMMAND_MANAGED_APPLICATION_FEEDBACK="ManagedApplicationFeedback";
    protected static final String  COMMAND_MANAGED_APPLICATION_ATTRIBUTES="ManagedApplicationAttributes";



//
//    public static <T extends Command> T getCommand(Class<T> tClass,...) throws IllegalAccessException, InstantiationException {
//        T obj = tClass.newInstance();
//
//        obj.execute();
//        return obj;
//    }



//    public static void main(String args[]){
//        DeviceLockCommand command1 =  new DeviceLockCommand();
//        command1.setCommandUUID("dave");
//        command1.setMessage(" Lock");
//        command1.setPin("123456");
//        command1.execute();
//    }
}
