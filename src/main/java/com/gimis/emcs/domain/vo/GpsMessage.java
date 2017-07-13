
package com.gimis.emcs.domain.vo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.gimis.emcs.domain.GpsDevice;
import com.gimis.emcs.domain.GpsManufacturer;
import com.gimis.emcs.domain.MachineryManufacturer;
import com.gimis.emcs.domain.RedisModel;
import com.gimis.emcs.domain.Sim;
import com.gimis.emcs.domain.util.DateFormatUtil;
import com.gimis.emcs.ps.net.type.GpsProtocol;

/**
 * [gps内存对象]<p>
 * [功能详细描述]<p>
 * @version 1.0, 2014年5月8日

 * @since V1.0
 */
public class GpsMessage extends GpsDevice implements RedisModel<String>
{

    public String gpsId;

    /**
     * GPS协议
     */
    private GpsProtocol protocolType;

    /**
     * GPS报警
     */
    private String gpsAlarm;

    /**
     * 上报原因
     */
    private Byte uploadType;

    /**
     * 经度
     */
    public Double longitude;

    /**
     * 纬度
     */
    public Double latitude;

    /**
     * 速度
     */
    private Double speed;

    /**
     * 高度
     */
    private Short height;

    /**
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

    /**
     * 最新数据GPS时间
     */
    private Date gpsTime;

    /**
     * 钥匙开关状态(ACC)，0：关闭，1：打开
     */
    private Byte switch1Key;

    /**
     * GPS定位状态
     */
    private Byte gpsStateLocate;

    /**
     * 星数
     */
    private Byte gpsStateSignal;

    /**
     * GPS模块状态
     */
    private Byte gpsStateModule;

    /**
     * 是否电池供电 0=外电工作，1=电池工作
     */
    private Byte powerBatteryState;

    /**
     * 服务器时间
     */
    public Date serverTime;

    /**
     * 0：代表正常，1：代表盲区补偿数据
     */
    private Byte msgType;

    /**
     * GPS信息来源
     */
    private Byte gatewaySource;

    /**
     * SD卡写保护状态
     * 0：正常1：异常2：初始化
     */
    private Byte a1;

    /**
     * 读写状态
     * 0：正常1：异常2：初始化
     */
    private Byte a2;

    /**
     * 单条数据写入状态
     * 0：正常1：异常2：初始化
     */
    private Byte a3;

    /**
     * SD卡检查状态
     * 0：正常1：异常2：初始化
     */
    private Byte a4;

    /**
     * 电源电压
     */
    private Double a5;

    /**
     * 电池电压
     */
    private Double a6;

    /**
     * CAN通讯状态
     * 0:正常  1：异常
     */
    private Byte a7;

    /**
     * 需要更新到内存的属性集合
     */
    protected Map<String, String> updateMap = new HashMap<String, String>();

    public GpsMessage()
    {

    }

    public GpsMessage(GpsDevice gpsDevice)
    {
        if (null != gpsDevice)
        {
            this.setGpsId(gpsDevice.getId());
            this.setSim(gpsDevice.getSim());
            this.setGpsManufacturer(gpsDevice.getGpsManufacturer());
            this.setMachineryManufacturer(gpsDevice.getMachineryManufacturer());
        }
    }

    public GpsMessage(Map<String, String> beanMap)
    {
        if (null == beanMap || beanMap.size() == 0)
        {
            return;
        }
        if (null != beanMap.get("gpsId") && false == "".equals(beanMap.get("gpsId")))
        {
            this.gpsId = beanMap.get("gpsId");
        }
        if (null != beanMap.get("sim.simNo") && false == "".equals(beanMap.get("sim.simNo")))
        {
            super.setSimNo(beanMap.get("sim.simNo"));
        }
        if (null != beanMap.get("gpsManufacturer.id") && false == "".equals(beanMap.get("gpsManufacturer.id")))
        {
            super.setGpsManufacturerId(Integer.parseInt(beanMap.get("gpsManufacturer.id")));
        }
        if (null != beanMap.get("gpsAlarm") && false == "".equals(beanMap.get("gpsAlarm")))
        {
            this.gpsAlarm = beanMap.get("gpsAlarm");
        }
        if (null != beanMap.get("protocolType") && false == "".equals(beanMap.get("protocolType")))
        {
            this.protocolType = GpsProtocol.valueOf(beanMap.get("protocolType"));
        }
        if (null != beanMap.get("machineryManufacturer.id")
                && false == "".equals(beanMap.get("machineryManufacturer.id")))
        {
            super.setMachineryManufacturerId(Integer.parseInt(beanMap.get("machineryManufacturer.id")));
        }
        if (null != beanMap.get("longitude") && false == "".equals(beanMap.get("longitude")))
        {
            this.longitude = Double.parseDouble(beanMap.get("longitude"));
        }
        if (null != beanMap.get("latitude") && false == "".equals(beanMap.get("latitude")))
        {
            this.latitude = Double.parseDouble(beanMap.get("latitude"));
        }
        if (null != beanMap.get("serverTime") && false == "".equals(beanMap.get("serverTime")))
        {
            this.serverTime = DateFormatUtil.parseWithoutThrowException(beanMap.get("serverTime"),
                    DateFormatUtil.DEFAULT_DATETIME_PATTERN);
        }
        if (null != beanMap.get("uploadType") && false == "".equals(beanMap.get("uploadType")))
        {
            this.uploadType = Byte.parseByte(beanMap.get("uploadType"));
        }
        if (null != beanMap.get("speed") && false == "".equals(beanMap.get("speed")))
        {
            this.speed = Double.parseDouble(beanMap.get("speed"));
        }
        if (null != beanMap.get("height") && false == "".equals(beanMap.get("height")))
        {
            this.height = Short.parseShort(beanMap.get("height"));
        }
        if (null != beanMap.get("forDirect") && false == "".equals(beanMap.get("forDirect")))
        {
            this.forDirect = Short.parseShort(beanMap.get("forDirect"));
        }
        if (null != beanMap.get("gpsTime") && false == "".equals(beanMap.get("gpsTime")))
        {
            this.gpsTime = DateFormatUtil.parseWithoutThrowException(beanMap.get("gpsTime"),
                    DateFormatUtil.DEFAULT_DATETIME_PATTERN);
        }
        if (null != beanMap.get("gpsStateLocate") && false == "".equals(beanMap.get("gpsStateLocate")))
        {
            this.gpsStateLocate = Byte.parseByte(beanMap.get("gpsStateLocate"));
        }
        if (null != beanMap.get("gpsStateSignal") && false == "".equals(beanMap.get("gpsStateSignal")))
        {
            this.gpsStateSignal = Byte.parseByte(beanMap.get("gpsStateSignal"));
        }
        if (null != beanMap.get("gpsStateModule") && false == "".equals(beanMap.get("gpsStateModule")))
        {
            this.gpsStateModule = Byte.parseByte(beanMap.get("gpsStateModule"));
        }
        if (null != beanMap.get("distance") && false == "".equals(beanMap.get("distance")))
        {
            this.distance = Integer.parseInt(beanMap.get("distance"));
        }
        if (null != beanMap.get("switch1Key") && false == "".equals(beanMap.get("switch1Key")))
        {
            this.switch1Key = Byte.parseByte(beanMap.get("switch1Key"));
        }
        if (null != beanMap.get("gatewaySource") && false == "".equals(beanMap.get("gatewaySource")))
        {
            this.gatewaySource = Byte.parseByte(beanMap.get("gatewaySource"));
        }
        if (null != beanMap.get("msgType") && false == "".equals(beanMap.get("msgType")))
        {
            this.msgType = Byte.parseByte(beanMap.get("msgType"));
        }

        if (null != beanMap.get("powerBatteryState") && false == "".equals(beanMap.get("powerBatteryState")))
        {
            this.powerBatteryState = Byte.parseByte(beanMap.get("powerBatteryState"));
        }
        if (null != beanMap.get("hardwareVersion") && false == "".equals(beanMap.get("hardwareVersion")))
        {
            this.hardwareVersion = Short.parseShort(beanMap.get("hardwareVersion"));
        }
        if (null != beanMap.get("softVersion") && false == "".equals(beanMap.get("softVersion")))
        {
            this.softVersion = String.valueOf(beanMap.get("softVersion"));
        }

        if (null != beanMap.get("a1") && false == "".equals(beanMap.get("a1")))
        {
            this.a1 = Byte.parseByte(beanMap.get("a1"));
        }
        if (null != beanMap.get("a2") && false == "".equals(beanMap.get("a2")))
        {
            this.a2 = Byte.parseByte(beanMap.get("a2"));
        }
        if (null != beanMap.get("a3") && false == "".equals(beanMap.get("a3")))
        {
            this.a3 = Byte.parseByte(beanMap.get("a3"));
        }
        if (null != beanMap.get("a4") && false == "".equals(beanMap.get("a4")))
        {
            this.a4 = Byte.parseByte(beanMap.get("a4"));
        }
        if (null != beanMap.get("a5") && false == "".equals(beanMap.get("a5")))
        {
            this.a5 = Double.parseDouble(beanMap.get("a5"));
        }
        if (null != beanMap.get("a6") && false == "".equals(beanMap.get("a6")))
        {
            this.a6 = Double.parseDouble(beanMap.get("a6"));
        }
        if (null != beanMap.get("a7") && false == "".equals(beanMap.get("a7")))
        {
            this.a7 = Byte.parseByte(beanMap.get("a7"));
        }
    }

    public String getGpsId()
    {
        return gpsId;
    }

    public void setGpsId(String gpsId)
    {
        this.setBeanMapFiled("gpsId", this.gpsId, gpsId);
        this.gpsId = gpsId;
    }

    @Override
    public void setGpsManufacturer(GpsManufacturer gpsManufacturer)
    {
        if (null != gpsManufacturer)
        {
            this.setBeanMapFiled("gpsManufacturer.id", super.getGpsManufacturerId(), gpsManufacturer.getId());
        }
        super.setGpsManufacturer(gpsManufacturer);
    }

    @Override
    public void setMachineryManufacturer(MachineryManufacturer machineryManufacturer)
    {
        if (null != machineryManufacturer)
        {
            this.setBeanMapFiled("machineryManufacturer.id", super.getMachineryManufacturerId(),
                    machineryManufacturer.getId());
        }
        super.setMachineryManufacturer(machineryManufacturer);
    }

    @Override
    public void setSim(Sim sim)
    {
        if (null != sim)
        {
            this.setBeanMapFiled("sim.simNo", super.getSimNo(), sim.getSimNo());
        }
        super.setSim(sim);
    }

    public GpsProtocol getProtocolType()
    {
        return protocolType;
    }

    public void setProtocolType(GpsProtocol protocolType)
    {
        this.setBeanMapFiled("protocolType", this.protocolType, protocolType);
        this.protocolType = protocolType;
    }

    public String getGpsAlarm()
    {
        return gpsAlarm;
    }

    public void setGpsAlarm(String gpsAlarm)
    {
        this.setBeanMapFiled("gpsAlarm", this.gpsAlarm, gpsAlarm);
        this.gpsAlarm = gpsAlarm;
    }

    public Double getLongitude()
    {
        return longitude;
    }

    public void setLongitude(Double longitude)
    {
        this.setBeanMapFiled("longitude", this.longitude, longitude);
        this.longitude = longitude;
    }

    public Double getLatitude()
    {
        return latitude;
    }

    public void setLatitude(Double latitude)
    {
        this.setBeanMapFiled("latitude", this.latitude, latitude);
        this.latitude = latitude;
    }

    public Date getServerTime()
    {
        return serverTime;
    }

    public void setServerTime(Date serverTime)
    {
        this.setBeanMapFiled("serverTime", this.serverTime, serverTime);
        this.serverTime = serverTime;
    }

    public Byte getUploadType()
    {
        return uploadType;
    }

    public void setUploadType(Byte uploadType)
    {
        this.setBeanMapFiled("uploadType", this.uploadType, uploadType);
        this.uploadType = uploadType;
    }

    public Double getSpeed()
    {
        return speed;
    }

    public void setSpeed(Double speed)
    {
        this.setBeanMapFiled("speed", this.speed, speed);
        this.speed = speed;
    }

    public Short getHeight()
    {
        return height;
    }

    public void setHeight(Short height)
    {
        this.setBeanMapFiled("height", this.height, height);
        this.height = height;
    }

    public Short getForDirect()
    {
        return forDirect;
    }

    public void setForDirect(Short forDirect)
    {
        this.setBeanMapFiled("forDirect", this.forDirect, forDirect);
        this.forDirect = forDirect;
    }

    public Date getGpsTime()
    {
        return gpsTime;
    }

    public void setGpsTime(Date gpsTime)
    {
        this.setBeanMapFiled("gpsTime", this.gpsTime, gpsTime);
        this.gpsTime = gpsTime;
    }

    public Byte getGpsStateLocate()
    {
        return gpsStateLocate;
    }

    public void setGpsStateLocate(Byte gpsStateLocate)
    {
        this.setBeanMapFiled("gpsStateLocate", this.gpsStateLocate, gpsStateLocate);
        this.gpsStateLocate = gpsStateLocate;
    }

    public Byte getGpsStateSignal()
    {
        return gpsStateSignal;
    }

    public void setGpsStateSignal(Byte gpsStateSignal)
    {
        this.setBeanMapFiled("gpsStateSignal", this.gpsStateSignal, gpsStateSignal);
        this.gpsStateSignal = gpsStateSignal;

    }

    public Byte getGpsStateModule()
    {
        return gpsStateModule;
    }

    public void setGpsStateModule(Byte gpsStateModule)
    {
        this.setBeanMapFiled("gpsStateModule", this.gpsStateModule, gpsStateModule);
        this.gpsStateModule = gpsStateModule;
    }

    public Integer getDistance()
    {
        return distance;
    }

    public void setDistance(Integer distance)
    {
        this.setBeanMapFiled("distance", this.distance, distance);
        this.distance = distance;
    }

    public Byte getSwitch1Key()
    {
        return switch1Key;
    }

    public void setSwitch1Key(Byte switch1Key)
    {
        this.setBeanMapFiled("switch1Key", this.switch1Key, switch1Key);
        this.switch1Key = switch1Key;
    }

    public Byte getGatewaySource()
    {
        return gatewaySource;
    }

    public void setGatewaySource(Byte gatewaySource)
    {
        this.setBeanMapFiled("gatewaySource", this.gatewaySource, gatewaySource);
        this.gatewaySource = gatewaySource;
    }

    public Byte getMsgType()
    {
        return msgType;
    }

    public void setMsgType(Byte msgType)
    {
        this.setBeanMapFiled("msgType", this.msgType, msgType);
        this.msgType = msgType;
    }

    public Short getHardwareVersion()
    {
        return hardwareVersion;
    }

    public void setHardwareVersion(Short hardwareVersion)
    {
        this.setBeanMapFiled("hardwareVersion", this.hardwareVersion, hardwareVersion);
        this.hardwareVersion = hardwareVersion;
    }

    public String getSoftVersion()
    {
        return softVersion;
    }

    public void setSoftVersion(String softVersion)
    {
        this.setBeanMapFiled("softVersion", this.softVersion, softVersion);
        this.softVersion = softVersion;
    }

    public Byte getPowerBatteryState()
    {
        return powerBatteryState;
    }

    public void setPowerBatteryState(Byte powerBatteryState)
    {
        this.setBeanMapFiled("powerBatteryState", this.powerBatteryState, powerBatteryState);
        this.powerBatteryState = powerBatteryState;
    }

    /**
     * @param a1 the a1 to set
     */
    public void setA1(Byte a1)
    {
        this.setBeanMapFiled("a1", this.a1, a1);
        this.a1 = a1;
    }

    /**
     * @param a2 the a2 to set
     */
    public void setA2(Byte a2)
    {
        this.setBeanMapFiled("a2", this.a2, a2);
        this.a2 = a2;
    }

    /**
     * @param a3 the a3 to set
     */
    public void setA3(Byte a3)
    {
        this.setBeanMapFiled("a3", this.a3, a3);
        this.a3 = a3;
    }

    /**
     * @param a4 the a4 to set
     */
    public void setA4(Byte a4)
    {
        this.setBeanMapFiled("a4", this.a4, a4);
        this.a4 = a4;
    }

    /**
     * @param a5 the a5 to set
     */
    public void setA5(Double a5)
    {
        this.setBeanMapFiled("a5", this.a5, a5);
        this.a5 = a5;
    }

    /**
     * @param a6 the a6 to set
     */
    public void setA6(Double a6)
    {
        this.setBeanMapFiled("a6", this.a6, a6);
        this.a6 = a6;
    }

    /**
     * @param a7 the a7 to set
     */
    public void setA7(Byte a7)
    {
        this.setBeanMapFiled("a7", this.a7, a7);
        this.a7 = a7;
    }

    /**
     * @return the a1
     */
    public Byte getA1()
    {
        return a1;
    }

    /**
     * @return the a2
     */
    public Byte getA2()
    {
        return a2;
    }

    /**
     * @return the a3
     */
    public Byte getA3()
    {
        return a3;
    }

    /**
     * @return the a4
     */
    public Byte getA4()
    {
        return a4;
    }

    /**
     * @return the a5
     */
    public Double getA5()
    {
        return a5;
    }

    /**
     * @return the a6
     */
    public Double getA6()
    {
        return a6;
    }

    /**
     * @return the a7
     */
    public Byte getA7()
    {
        return a7;
    }

    public void setUpdateMap(Map<String, String> updateMap)
    {
        this.updateMap = updateMap;
    }

    @Override
    public String getId()
    {
        return this.gpsId;
    }

    public Map<String, String> getUpdateMap()
    {
        return this.updateMap;
    }

    /**
     * 所有的子类的set方法必须调用该方法
     * @param filed

     */
    private void setBeanMapFiled(String filed , Object oldObj , Object newObj)
    {
        if (null == filed || "".equals(filed) || null == newObj)
            return;
        boolean isChange = false;
        if (!newObj.equals(oldObj))
            isChange = true;
        if (newObj instanceof Number)
        {
            if (isChange)
                this.updateMap.put(filed, newObj + "");
        }
        else if (newObj instanceof Date)
        {
            String date = DateFormatUtil.formatDateTime((Date) newObj);
            if (isChange)
                this.updateMap.put(filed, date);
        }
        else if (newObj instanceof String)
        {
            if (isChange)
                this.updateMap.put(filed, (String) newObj);
        }
        else
        {
            if (isChange)
                this.updateMap.put(filed, newObj.toString());
        }
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "GpsMessage [gpsId=" + gpsId + ", protocolType=" + protocolType + ", gpsAlarm=" + gpsAlarm
                + ", uploadType=" + uploadType + ", longitude=" + longitude + ", latitude=" + latitude + ", speed="
                + speed + ", height=" + height + ", forDirect=" + forDirect + ", distance=" + distance
                + ", hardwareVersion=" + hardwareVersion + ", softVersion=" + softVersion + ", gpsTime=" + gpsTime
                + ", switch1Key=" + switch1Key + ", gpsStateLocate=" + gpsStateLocate + ", gpsStateSignal="
                + gpsStateSignal + ", gpsStateModule=" + gpsStateModule + ", powerBatteryState=" + powerBatteryState
                + ", serverTime=" + serverTime + ", msgType=" + msgType + ", gatewaySource=" + gatewaySource
                + ", updateMap=" + updateMap + " " + super.toString() + "]";
    }

}
