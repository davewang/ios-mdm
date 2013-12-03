package com.sinonet.mdm.payloads.response;

import com.dd.plist.NSDictionary;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-11-5
 * Time: 上午11:16
 * To change this template use File | Settings | File Templates.
 */
public class DeviceInformationResponse extends Response {
    private NSDictionary queryResponses;
    @Override
    public void doHandler() {
        if (getStatus().equals("Acknowledged"))
              this.queryResponses = (NSDictionary)response.objectForKey("QueryResponses");
    }

    public NSDictionary getQueryResponses() {
        return queryResponses;
    }

    public static void main(String[] args)
    {


        try {
            Response.getResponse(Response.class,"");

            DeviceInformationResponse response =  Response.getResponse(DeviceInformationResponse.class,"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<!DOCTYPE plist PUBLIC \"-//Apple//DTD PLIST 1.0//EN\" \"http://www.apple.com/DTDs/PropertyList-1.0.dtd\">\n" +
                "<plist version=\"1.0\">\n" +
                "<dict>\n" +
                "\t<key>CommandUUID</key>\n" +
                "\t<string>08981c01-d9ce-4052-bd2b-c98f23d12be6</string>\n" +
                "\t<key>QueryResponses</key>\n" +
                "\t<dict>\n" +
                "\t\t<key>AvailableDeviceCapacity</key>\n" +
                "\t\t<real>3.3529701232910156</real>\n" +
                "\t\t<key>BatteryLevel</key>\n" +
                "\t\t<real>0.0</real>\n" +
                "\t\t<key>BluetoothMAC</key>\n" +
                "\t\t<string>5c:96:9d:ee:43:62</string>\n" +
                "\t\t<key>BuildVersion</key>\n" +
                "\t\t<string>10A523</string>\n" +
                "\t\t<key>CarrierSettingsVersion</key>\n" +
                "\t\t<string>13.1</string>\n" +
                "\t\t<key>CellularTechnology</key>\n" +
                "\t\t<integer>3</integer>\n" +
                "\t\t<key>CurrentMCC</key>\n" +
                "\t\t<string>460</string>\n" +
                "\t\t<key>CurrentMNC</key>\n" +
                "\t\t<string>03</string>\n" +
                "\t\t<key>DataRoamingEnabled</key>\n" +
                "\t\t<false/>\n" +
                "\t\t<key>DeviceCapacity</key>\n" +
                "\t\t<real>13.564884185791016</real>\n" +
                "\t\t<key>DeviceName</key>\n" +
                "\t\t<string>JiaPeiQi</string>\n" +
                "\t\t<key>ICCID</key>\n" +
                "\t\t<string>8986 0312 0001 0186 8473</string>\n" +
                "\t\t<key>IMEI</key>\n" +
                "\t\t<string>99 000194 382102 5</string>\n" +
                "\t\t<key>IsRoaming</key>\n" +
                "\t\t<false/>\n" +
                "\t\t<key>MEID</key>\n" +
                "\t\t<string>99000194382102</string>\n" +
                "\t\t<key>Model</key>\n" +
                "\t\t<string>MD240CH</string>\n" +
                "\t\t<key>ModelName</key>\n" +
                "\t\t<string>iPhone</string>\n" +
                "\t\t<key>ModemFirmwareVersion</key>\n" +
                "\t\t<string>3.0.04</string>\n" +
                "\t\t<key>PhoneNumber</key>\n" +
                "\t\t<string>+8618010005337</string>\n" +
                "\t\t<key>ProductName</key>\n" +
                "\t\t<string>iPhone4,1</string>\n" +
                "\t\t<key>SIMCarrierNetwork</key>\n" +
                "\t\t<string>ä¸­å\u009B½ç\u0094µä¿¡</string>\n" +
                "\t\t<key>SIMMCC</key>\n" +
                "\t\t<string>460</string>\n" +
                "\t\t<key>SIMMNC</key>\n" +
                "\t\t<string>03</string>\n" +
                "\t\t<key>SerialNumber</key>\n" +
                "\t\t<string>DX3K161ADTD3</string>\n" +
                "\t\t<key>SubscriberCarrierNetwork</key>\n" +
                "\t\t<string>ä¸­å\u009B½ç\u0094µä¿¡</string>\n" +
                "\t\t<key>SubscriberMCC</key>\n" +
                "\t\t<string>460</string>\n" +
                "\t\t<key>SubscriberMNC</key>\n" +
                "\t\t<string>03</string>\n" +
                "\t\t<key>UDID</key>\n" +
                "\t\t<string>6f9cc42c9f73fb8a7664b6cc0d777ce710f012e3</string>\n" +
                "\t\t<key>VoiceRoamingEnabled</key>\n" +
                "\t\t<false/>\n" +
                "\t\t<key>WiFiMAC</key>\n" +
                "\t\t<string>5c:96:9d:ee:43:61</string>\n" +
                "\t</dict>\n" +
                "\t<key>Status</key>\n" +
                "\t<string>Acknowledged</string>\n" +
                "\t<key>UDID</key>\n" +
                "\t<string>6f9cc42c9f73fb8a7664b6cc0d777ce710f012e3</string>\n" +
                "</dict>\n" +
                "</plist>");

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }
}
