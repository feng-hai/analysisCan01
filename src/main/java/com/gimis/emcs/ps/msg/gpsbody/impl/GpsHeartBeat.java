package com.gimis.emcs.ps.msg.gpsbody.impl;

import java.io.Serializable;
import java.util.Date;

import com.gimis.emcs.ps.msg.gpsbody.GpsBasicInfo;
import com.gimis.emcs.ps.msg.util.MessageTools;

public class GpsHeartBeat implements GpsBasicInfo,Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = -984273454921096251L;

    /*
     * 上报原因
     */
    private Byte uploadType;

    /*
     * 经度
     */
    private Integer longitude;

    /*
     * 纬度
     */
    private Integer latitude;

    /*
     * 速度
     */
    private Short speed;

    /*
     * 高度
     */
    private Short height;

    /*
     * 方向角
     */
    private Short forDirect;

    /**
     * 里程
     */
    private Integer distance;

    /**
     * 硬件版本号
     */
    private Short hardwareVersion;

    /**
     * 软件版本号
     */
    private String softVersion;

    /*
     * GPS模块时间
     */
    private Date gpsTime;

    /*
     * 开关量采集1
     * 钥匙开关ACC
     */
    private Byte switch1Key;

    /*
     * GPS模块状态
     * 是否精确定位 
     * 1:GPS定位，0:GPS不定位
     */
    private Byte gpsStateLocate;

    /*
     * GPS模块状态
     * 收到的星数
     */
    private Byte gpsStateSignal;

    /*
     * GPS模块状态
     * 模块状态  
     * 0:GPS模块正常(有数据输出)，1:模块异常
     */
    private Byte gpsStateModule;

    /*
     * 是否电池供电 0=外电工作，1=电池工作
     */
    private Byte powerBatteryState;

    public Byte getUploadType()
    {
        return uploadType;
    }

    public void setUploadType(Byte uploadType)
    {
        this.uploadType = uploadType;
    }

    public Double getLongitude()
    {
        if (null != longitude)
        {
            return MessageTools.getSixDoubleValue((double) longitude / 1000000);
        }
        else
        {
            return null;
        }

    }

    public void setLongitude(Integer longitude)
    {
        this.longitude = longitude;
    }

    public Double getLatitude()
    {
        if (null != latitude)
        {
            return MessageTools.getSixDoubleValue((double) latitude / 1000000);
        }
        else
        {
            return null;
        }
    }

    public void setLatitude(Integer latitude)
    {
        this.latitude = latitude;
    }

    public Double getSpeed()
    {
        return MessageTools.getShortValue(speed) * 0.5;
    }

    public void setSpeed(Short speed)
    {
        this.speed = speed;
    }

    public Short getHeight()
    {
        return height;
    }

    public void setHeight(Short height)
    {
        this.height = height;
    }

    public Short getForDirect()
    {
        return forDirect;
    }

    public void setForDirect(Short forDirect)
    {
        this.forDirect = forDirect;
    }

    public Date getGpsTime()
    {
        return gpsTime;
    }

    public void setGpsTime(Date gpsTime)
    {
        this.gpsTime = gpsTime;
    }

    public Byte getSwitch1Key()
    {
        return switch1Key;
    }

    public void setSwitch1Key(Byte switch1Key)
    {
        this.switch1Key = switch1Key;
    }

    public Byte getGpsStateLocate()
    {
        return gpsStateLocate;
    }

    public void setGpsStateLocate(Byte gpsStateLocate)
    {
        this.gpsStateLocate = gpsStateLocate;
    }

    public Byte getGpsStateSignal()
    {
        return gpsStateSignal;
    }

    public void setGpsStateSignal(Byte gpsStateSignal)
    {
        this.gpsStateSignal = gpsStateSignal;
    }

    public Byte getGpsStateModule()
    {
        return gpsStateModule;
    }

    public void setGpsStateModule(Byte gpsStateModule)
    {
        this.gpsStateModule = gpsStateModule;
    }

    public Byte getPowerBatteryState()
    {
        return powerBatteryState;
    }

    public void setPowerBatteryState(Byte powerBatteryState)
    {
        this.powerBatteryState = powerBatteryState;
    }

    public Integer getDistance()
    {
        return distance;
    }

    public void setDistance(Integer distance)
    {
        this.distance = distance;
    }

    public Short getHardwareVersion()
    {
        return hardwareVersion;
    }

    public void setHardwareVersion(Short hardwareVersion)
    {
        this.hardwareVersion = hardwareVersion;
    }

    public String getSoftVersion()
    {
        return softVersion;
    }

    public void setSoftVersion(String softVersion)
    {
        this.softVersion = softVersion;
    }

    @Override
    public String toString()
    {
        return "GpsHeartBeat [uploadType=" + uploadType + ", longitude=" + longitude + ", latitude=" + latitude
                + ", speed=" + speed + ", height=" + height + ", forDirect=" + forDirect + ", distance=" + distance
                + ", hardwareVersion=" + hardwareVersion + ", softVersion=" + softVersion + ", gpsTime=" + gpsTime
                + ", switch1Key=" + switch1Key + ", gpsStateLocate=" + gpsStateLocate + ", gpsStateSignal="
                + gpsStateSignal + ", gpsStateModule=" + gpsStateModule + ", powerBatteryState=" + powerBatteryState
                + "]";
    }

}
