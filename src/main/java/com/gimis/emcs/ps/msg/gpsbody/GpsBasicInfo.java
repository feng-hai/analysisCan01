package com.gimis.emcs.ps.msg.gpsbody;

import java.util.Date;

public interface GpsBasicInfo extends GpsBody
{
    public Byte getUploadType();

    public void setUploadType(Byte uploadType);

    public Double getLongitude();

    public void setLongitude(Integer longitude);

    public Double getLatitude();

    public void setLatitude(Integer latitude);

    public Double getSpeed();

    public void setSpeed(Short speed);

    public Short getHeight();

    public void setHeight(Short height);

    public Short getForDirect();

    public void setForDirect(Short forDirect);

    public Date getGpsTime();

    public void setGpsTime(Date gpsTime);

    public Byte getSwitch1Key();

    public void setSwitch1Key(Byte switch1Key);

    public Byte getGpsStateLocate();

    public void setGpsStateLocate(Byte gpsStateLocate);

    public Byte getGpsStateSignal();

    public void setGpsStateSignal(Byte gpsStateSignal);

    public Byte getGpsStateModule();

    public void setGpsStateModule(Byte gpsStateModule);

    public Byte getPowerBatteryState();

    public void setPowerBatteryState(Byte powerBatteryState);
    
    public Integer getDistance();

    public void setDistance(Integer distance);

    public Short getHardwareVersion();

    public void setHardwareVersion(Short hardwareVersion);

    public String getSoftVersion();

    public void setSoftVersion(String softVersion);
}
