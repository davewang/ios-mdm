package com.sinonet.mdm.model;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: dave
 * Date: 13-10-21
 * Time: 下午3:37
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "app_device")
@Indexed
@XmlRootElement
public class Device extends BaseObject implements Serializable {
    private Long id;
    private String deviceName;
    private String udid;
    private String buildVersion;
    private String wifiMAC;
    private String bluetoothMAC;
    private String currentCarrierNetwork;
    private String availableDeviceCapacity;
    private String currentMNC;
    private String currentMCC;
    private String iccid;
    private String imei;
    private String osVersion;
    private String simCarrierNetwork;
    private String serialNumber;
    private String batteryLevel;
    private String subscriberMCC;
    private String subscriberMNC;
    private String voiceRoamingEnabled;
    private String cellularTechnology;
    private String meid;
    private String subscriberCarrierNetwork;
    private String voiceRomaing;
    private String dataRoaming;
    private String jailbreakDetected;
    private Token token;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @DocumentId
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "token_id")
    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    @Field
    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
    @Field
    public String getUdid() {
        return udid;
    }

    public void setUdid(String udid) {
        this.udid = udid;
    }
    @Field
    public String getBuildVersion() {
        return buildVersion;
    }

    public void setBuildVersion(String buildVersion) {
        this.buildVersion = buildVersion;
    }
    @Field
    public String getWifiMAC() {
        return wifiMAC;
    }

    public void setWifiMAC(String wifiMAC) {
        this.wifiMAC = wifiMAC;
    }
    @Field
    public String getBluetoothMAC() {
        return bluetoothMAC;
    }

    public void setBluetoothMAC(String bluetoothMAC) {
        this.bluetoothMAC = bluetoothMAC;
    }

    @Field
    public String getCurrentCarrierNetwork() {
        return currentCarrierNetwork;
    }

    public void setCurrentCarrierNetwork(String currentCarrierNetwork) {
        this.currentCarrierNetwork = currentCarrierNetwork;
    }
    @Field
    public String getAvailableDeviceCapacity() {
        return availableDeviceCapacity;
    }

    public void setAvailableDeviceCapacity(String availableDeviceCapacity) {
        this.availableDeviceCapacity = availableDeviceCapacity;
    }
    @Field
    public String getCurrentMNC() {
        return currentMNC;
    }

    public void setCurrentMNC(String currentMNC) {
        this.currentMNC = currentMNC;
    }
    @Field
    public String getCurrentMCC() {
        return currentMCC;
    }

    public void setCurrentMCC(String currentMCC) {
        this.currentMCC = currentMCC;
    }
    @Field
    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }
    @Field
    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }
    @Field
    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }
    @Field
    public String getSimCarrierNetwork() {
        return simCarrierNetwork;
    }

    public void setSimCarrierNetwork(String simCarrierNetwork) {
        this.simCarrierNetwork = simCarrierNetwork;
    }
    @Field
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
    @Field
    public String getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(String batteryLevel) {
        this.batteryLevel = batteryLevel;
    }
    @Field
    public String getSubscriberMCC() {
        return subscriberMCC;
    }

    public void setSubscriberMCC(String subscriberMCC) {
        this.subscriberMCC = subscriberMCC;
    }
    @Field
    public String getSubscriberMNC() {
        return subscriberMNC;
    }

    public void setSubscriberMNC(String subscriberMNC) {
        this.subscriberMNC = subscriberMNC;
    }
    @Field
    public String getVoiceRoamingEnabled() {
        return voiceRoamingEnabled;
    }

    public void setVoiceRoamingEnabled(String voiceRoamingEnabled) {
        this.voiceRoamingEnabled = voiceRoamingEnabled;
    }
    @Field
    public String getCellularTechnology() {
        return cellularTechnology;
    }

    public void setCellularTechnology(String cellularTechnology) {
        this.cellularTechnology = cellularTechnology;
    }
    @Field
    public String getMeid() {
        return meid;
    }

    public void setMeid(String meid) {
        this.meid = meid;
    }
    @Field
    public String getSubscriberCarrierNetwork() {
        return subscriberCarrierNetwork;
    }

    public void setSubscriberCarrierNetwork(String subscriberCarrierNetwork) {
        this.subscriberCarrierNetwork = subscriberCarrierNetwork;
    }
    @Field
    public String getVoiceRomaing() {
        return voiceRomaing;
    }

    public void setVoiceRomaing(String voiceRomaing) {
        this.voiceRomaing = voiceRomaing;
    }
    @Field
    public String getDataRoaming() {
        return dataRoaming;
    }

    public void setDataRoaming(String dataRoaming) {
        this.dataRoaming = dataRoaming;
    }
    @Field
    public String getJailbreakDetected() {
        return jailbreakDetected;
    }

    public void setJailbreakDetected(String jailbreakDetected) {
        this.jailbreakDetected = jailbreakDetected;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Device)) return false;

        Device device = (Device) o;

        if (availableDeviceCapacity != null ? !availableDeviceCapacity.equals(device.availableDeviceCapacity) : device.availableDeviceCapacity != null)
            return false;
        if (batteryLevel != null ? !batteryLevel.equals(device.batteryLevel) : device.batteryLevel != null)
            return false;
        if (bluetoothMAC != null ? !bluetoothMAC.equals(device.bluetoothMAC) : device.bluetoothMAC != null)
            return false;
        if (buildVersion != null ? !buildVersion.equals(device.buildVersion) : device.buildVersion != null)
            return false;
        if (cellularTechnology != null ? !cellularTechnology.equals(device.cellularTechnology) : device.cellularTechnology != null)
            return false;
        if (currentCarrierNetwork != null ? !currentCarrierNetwork.equals(device.currentCarrierNetwork) : device.currentCarrierNetwork != null)
            return false;
        if (currentMCC != null ? !currentMCC.equals(device.currentMCC) : device.currentMCC != null) return false;
        if (currentMNC != null ? !currentMNC.equals(device.currentMNC) : device.currentMNC != null) return false;
        if (dataRoaming != null ? !dataRoaming.equals(device.dataRoaming) : device.dataRoaming != null) return false;
        if (deviceName != null ? !deviceName.equals(device.deviceName) : device.deviceName != null) return false;
        if (iccid != null ? !iccid.equals(device.iccid) : device.iccid != null) return false;
        if (id != null ? !id.equals(device.id) : device.id != null) return false;
        if (imei != null ? !imei.equals(device.imei) : device.imei != null) return false;
        if (jailbreakDetected != null ? !jailbreakDetected.equals(device.jailbreakDetected) : device.jailbreakDetected != null)
            return false;
        if (meid != null ? !meid.equals(device.meid) : device.meid != null) return false;
        if (osVersion != null ? !osVersion.equals(device.osVersion) : device.osVersion != null) return false;
        if (serialNumber != null ? !serialNumber.equals(device.serialNumber) : device.serialNumber != null)
            return false;
        if (simCarrierNetwork != null ? !simCarrierNetwork.equals(device.simCarrierNetwork) : device.simCarrierNetwork != null)
            return false;
        if (subscriberCarrierNetwork != null ? !subscriberCarrierNetwork.equals(device.subscriberCarrierNetwork) : device.subscriberCarrierNetwork != null)
            return false;
        if (subscriberMCC != null ? !subscriberMCC.equals(device.subscriberMCC) : device.subscriberMCC != null)
            return false;
        if (subscriberMNC != null ? !subscriberMNC.equals(device.subscriberMNC) : device.subscriberMNC != null)
            return false;
        if (token != null ? !token.equals(device.token) : device.token != null) return false;
        if (udid != null ? !udid.equals(device.udid) : device.udid != null) return false;
        if (voiceRoamingEnabled != null ? !voiceRoamingEnabled.equals(device.voiceRoamingEnabled) : device.voiceRoamingEnabled != null)
            return false;
        if (voiceRomaing != null ? !voiceRomaing.equals(device.voiceRomaing) : device.voiceRomaing != null)
            return false;
        if (wifiMAC != null ? !wifiMAC.equals(device.wifiMAC) : device.wifiMAC != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (deviceName != null ? deviceName.hashCode() : 0);
        result = 31 * result + (udid != null ? udid.hashCode() : 0);
        result = 31 * result + (buildVersion != null ? buildVersion.hashCode() : 0);
        result = 31 * result + (wifiMAC != null ? wifiMAC.hashCode() : 0);
        result = 31 * result + (bluetoothMAC != null ? bluetoothMAC.hashCode() : 0);
        result = 31 * result + (currentCarrierNetwork != null ? currentCarrierNetwork.hashCode() : 0);
        result = 31 * result + (availableDeviceCapacity != null ? availableDeviceCapacity.hashCode() : 0);
        result = 31 * result + (currentMNC != null ? currentMNC.hashCode() : 0);
        result = 31 * result + (currentMCC != null ? currentMCC.hashCode() : 0);
        result = 31 * result + (iccid != null ? iccid.hashCode() : 0);
        result = 31 * result + (imei != null ? imei.hashCode() : 0);
        result = 31 * result + (osVersion != null ? osVersion.hashCode() : 0);
        result = 31 * result + (simCarrierNetwork != null ? simCarrierNetwork.hashCode() : 0);
        result = 31 * result + (serialNumber != null ? serialNumber.hashCode() : 0);
        result = 31 * result + (batteryLevel != null ? batteryLevel.hashCode() : 0);
        result = 31 * result + (subscriberMCC != null ? subscriberMCC.hashCode() : 0);
        result = 31 * result + (subscriberMNC != null ? subscriberMNC.hashCode() : 0);
        result = 31 * result + (voiceRoamingEnabled != null ? voiceRoamingEnabled.hashCode() : 0);
        result = 31 * result + (cellularTechnology != null ? cellularTechnology.hashCode() : 0);
        result = 31 * result + (meid != null ? meid.hashCode() : 0);
        result = 31 * result + (subscriberCarrierNetwork != null ? subscriberCarrierNetwork.hashCode() : 0);
        result = 31 * result + (voiceRomaing != null ? voiceRomaing.hashCode() : 0);
        result = 31 * result + (dataRoaming != null ? dataRoaming.hashCode() : 0);
        result = 31 * result + (jailbreakDetected != null ? jailbreakDetected.hashCode() : 0);
        result = 31 * result + (token != null ? token.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", deviceName='" + deviceName + '\'' +
                ", udid='" + udid + '\'' +
                ", buildVersion='" + buildVersion + '\'' +
                ", wifiMAC='" + wifiMAC + '\'' +
                ", bluetoothMAC='" + bluetoothMAC + '\'' +
                ", currentCarrierNetwork='" + currentCarrierNetwork + '\'' +
                ", availableDeviceCapacity='" + availableDeviceCapacity + '\'' +
                ", currentMNC='" + currentMNC + '\'' +
                ", currentMCC='" + currentMCC + '\'' +
                ", iccid='" + iccid + '\'' +
                ", imei='" + imei + '\'' +
                ", osVersion='" + osVersion + '\'' +
                ", simCarrierNetwork='" + simCarrierNetwork + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", batteryLevel='" + batteryLevel + '\'' +
                ", subscriberMCC='" + subscriberMCC + '\'' +
                ", subscriberMNC='" + subscriberMNC + '\'' +
                ", voiceRoamingEnabled='" + voiceRoamingEnabled + '\'' +
                ", cellularTechnology='" + cellularTechnology + '\'' +
                ", meid='" + meid + '\'' +
                ", subscriberCarrierNetwork='" + subscriberCarrierNetwork + '\'' +
                ", voiceRomaing='" + voiceRomaing + '\'' +
                ", dataRoaming='" + dataRoaming + '\'' +
                ", jailbreakDetected='" + jailbreakDetected + '\'' +
                ", token=" + token +
                '}';
    }
}
