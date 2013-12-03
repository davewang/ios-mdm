package com.sinonet.mdm.payloads;

import com.sinonet.mdm.model.Task;

import java.io.File;
import java.util.Collection;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-10-29
 * Time: 下午9:21
 * To change this template use File | Settings | File Templates.
 */
public class TaskFactory {
    public static Task createDeviceInformationTask()
    {
        String commandUUID = UUID.randomUUID().toString();
        Task task = new Task();
        task.setStatus("no");
        task.setCommandUUID(commandUUID);
        task.setName("DeviceInformation");
        Command command = CommandFactory.createDeviceInformationCommand();
        command.setCommandUUID(commandUUID);
        command.execute();
        task.setCommand(command.bytes());
        return task;
    }
    public static Task createDeviceLockCommandTask(String pin,String message,String phoneNumber)
    {
        String commandUUID = UUID.randomUUID().toString();
        Task task = new Task();
        task.setStatus("no");
        task.setCommandUUID(commandUUID);
        task.setName("DeviceLock");
        Command command = CommandFactory.createDeviceLockCommand(pin,message,phoneNumber);
        command.setCommandUUID(commandUUID);
        command.execute();
        task.setCommand(command.bytes());
        return task;
    }
    public static Task createInstallApplicationByiTunesStoreIDTask(String iTunesStoreID)
    {
        String commandUUID = UUID.randomUUID().toString();
        Task task = new Task();
        task.setStatus("no");
        task.setCommandUUID(commandUUID);
        task.setName("InstallApplicationForiTunesStore");
        Command command = CommandFactory.createInstallApplicationByiTunesStoreID(iTunesStoreID);
        command.setCommandUUID(commandUUID);
        command.execute();
        task.setCommand(command.bytes());
        return task;
    }
    public static Task createRemoveApplicationCommandTask(String identifier)
    {
        String commandUUID = UUID.randomUUID().toString();
        Task task = new Task();
        task.setStatus("no");
        task.setCommandUUID(commandUUID);
        task.setName("RemoveApplication");
        Command command = CommandFactory.createRemoveApplicationCommandByIdentifier(identifier);
        command.setCommandUUID(commandUUID);
        command.execute();
        task.setCommand(command.bytes());
        return task;
    }
    public static Task createProfileListCommandTask()
    {
        String commandUUID = UUID.randomUUID().toString();
        Task task = new Task();
        task.setStatus("no");
        task.setCommandUUID(commandUUID);
        task.setName("ProfileList");
        Command command = CommandFactory.createProfileListCommand();
        command.setCommandUUID(commandUUID);
        command.execute();
        task.setCommand(command.bytes());
        return task;
    }

    public static Task createInstallProfileCommandTask(byte[] bytes)
    {
        String commandUUID = UUID.randomUUID().toString();
        Task task = new Task();
        task.setStatus("no");
        task.setCommandUUID(commandUUID);
        task.setName("ProfileList");
        Command command = CommandFactory.createInstallProfileCommand(bytes);
        command.setCommandUUID(commandUUID);
        command.execute();
        task.setCommand(command.bytes());
        return task;
    }
    public static Task  createInstallProfileCommandTask(File file)
    {
        String commandUUID = UUID.randomUUID().toString();
        Task task = new Task();
        task.setStatus("no");
        task.setCommandUUID(commandUUID);
        task.setName("InstallProfile");
        Command command = CommandFactory.createInstallProfileCommand(file);
        command.setCommandUUID(commandUUID);
        command.execute();
        task.setCommand(command.bytes());
        return task;
    }
    public static Task createRemoveProfileCommandTask(String identifier)
    {

        String commandUUID = UUID.randomUUID().toString();
        Task task = new Task();
        task.setStatus("no");
        task.setCommandUUID(commandUUID);
        task.setName("removeProfile");
        Command command = CommandFactory.createRemoveProfileCommand(identifier);
        command.setCommandUUID(commandUUID);
        command.execute();
        task.setCommand(command.bytes());
        return task;
    }
    public static Task createRestrictionsCommandTask()
    {

        String commandUUID = UUID.randomUUID().toString();
        Task task = new Task();
        task.setStatus("no");
        task.setCommandUUID(commandUUID);
        task.setName("Restrictions");
        Command command = CommandFactory.createRestrictionsCommand();
        command.setCommandUUID(commandUUID);
        command.execute();
        task.setCommand(command.bytes());
        return task;
    }
    
    public static Task createInstalledApplicationListTask( Collection<String> identifies ) {
    	Task task = createTask();
    	Command command = CommandFactory.createInstalledApplicationListCommand( identifies );
    	return taskExecuteCommandWithName( task, command, "InstalledApplicationList" );
    }

    public static Task createManagedApplicationListTask( Collection<String> identifies ) {
    	Task task = createTask();
    	Command command = CommandFactory.createManagedApplicationListCommand( identifies );
    	return taskExecuteCommandWithName( task, command, "ManagedApplicationList" );
    }

    protected static Task createTask() {
    	Task task = new Task();
    	task.setStatus( "no" );
        task.setCommandUUID(UUID.randomUUID().toString());
    	return task;
    }
    
    protected static Task taskExecuteCommandWithName( Task task, Command command, String name ) {
    	task.setName( name );
    	command.setCommandUUID( task.getCommandUUID() );
    	command.execute();
    	task.setCommand( command.bytes());
    	return task;
    }
}
