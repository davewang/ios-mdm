package com.sinonet.mdm.payloads;

import com.dd.plist.NSArray;
import com.dd.plist.NSString;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-10-29
 * Time: 下午6:08
 * To change this template use File | Settings | File Templates.
 */
public class DeviceInformationCommand extends Command {
    private List<String> queries = new ArrayList<String>();
    public void executeBefore()
    {
        getCommand().put("RequestType",Command.COMMAND_DEVICE_INFORMATION);
    }
    @Override
    public void doExecute() {
        if (queries.size()>0)
        {
            NSArray array = new NSArray(queries.size());
            for (int i=0; i<queries.size(); i++)
            {
                array.setValue(i, new NSString(queries.get(i)));
            }
            getCommand().put("Queries",array);
        } else {
            NSArray queries = new NSArray(36);
            queries.setValue(0,new NSString("AvailableDeviceCapacity"));
            queries.setValue(1,new NSString("BluetoothMAC"));
            queries.setValue(2,new NSString("BuildVersion"));
            queries.setValue(3,new NSString("CarrierSettingsVersion"));
            queries.setValue(4,new NSString("CurrentCarrierNetwork"));
            queries.setValue(5,new NSString("CurrentMCC"));
            queries.setValue(6,new NSString("CurrentMNC"));
            queries.setValue(7,new NSString("DataRoamingEnabled"));
            queries.setValue(8,new NSString("DeviceCapacity"));
            queries.setValue(9,new NSString("DeviceName"));
            queries.setValue(10,new NSString("ICCID"));
            queries.setValue(11,new NSString("IMEI"));
            queries.setValue(12,new NSString("IsRoaming"));
            queries.setValue(13,new NSString("Model"));
            queries.setValue(14,new NSString("ModelName"));
            queries.setValue(15,new NSString("ModemFirmwareVersion"));
            queries.setValue(16,new NSString("PhoneNumber"));
            queries.setValue(17,new NSString("Product"));
            queries.setValue(18,new NSString("ProductName"));
            queries.setValue(19,new NSString("SIMCarrierNetwork"));
            queries.setValue(20,new NSString("SIMMCC"));
            queries.setValue(21,new NSString("SIMMNC"));
            queries.setValue(22,new NSString("SerialNumber"));
            queries.setValue(23,new NSString("UDID"));
            queries.setValue(24,new NSString("WiFiMAC"));
            queries.setValue(25,new NSString("UnlockToken"));
            queries.setValue(26,new NSString("MEID"));
            queries.setValue(27,new NSString("CellularTechnology"));
            queries.setValue(28,new NSString("BatteryLevel"));
            queries.setValue(29,new NSString("SubscriberCarrierNetwork"));
            queries.setValue(30,new NSString("VoiceRoamingEnabled"));
            queries.setValue(31,new NSString("SubscriberMCC"));
            queries.setValue(32,new NSString("SubscriberMNC"));
            queries.setValue(33,new NSString("DataRoaming"));
            queries.setValue(34,new NSString("VoiceRomaing"));
            queries.setValue(35,new NSString("JailbreakDetected"));
            getCommand().put("Queries",queries);
        }
    }

    public void addQuery(String query)
    {
        queries.add(query);
    }
    public void removeQuery(String query)
    {
        queries.remove(query);
    }
    public void clearQueries()
    {
        queries.clear();
    }
}
