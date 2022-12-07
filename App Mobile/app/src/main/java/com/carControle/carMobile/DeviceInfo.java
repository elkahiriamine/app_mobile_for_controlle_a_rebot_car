package com.carControle.carMobile;

public class DeviceInfo {

    private String deviceName, deviceHardwareAddress;

    public DeviceInfo(){}

    public DeviceInfo(String deviceName, String deviceHardwareAddress){
        this.deviceName = deviceName;
        this.deviceHardwareAddress = deviceHardwareAddress;
    }

    public String getDeviceName(){return deviceName;}

    public String getDeviceHardwareAddress(){return deviceHardwareAddress;}

}
