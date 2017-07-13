package com.gimis.emcs.domain;

import java.util.Date;

public class GpsDevice {

	/**
     * GPS编号
     * 
     */
    private String id;

    /**
     * GPS型号
     */
    private String model;

    /**
     * GPS制造商
     */
    private GpsManufacturer gpsManufacturer;

    /**
     * 所属主机厂
     */
    private MachineryManufacturer machineryManufacturer;

    /**
     * GPS固件号
     */
    private String firmware;

    /**
     * GPS软件版本号
     */
    private String version;

    /**
     * sim卡信息
     */
    private Sim sim;

    /**
     * GPS状态，由字典表定义
     */
    private Short gpsState;

    /**
     * 操作人
     */
    private User operateUser;

    /**
     * 发货日期
     */
    private Date deliverDate;

    /**
     * 操作时间
     */
    private Date operateTime;

    /**
     * 系统ID，用于SAAS模式
     */
    private Integer systemId;

    public GpsDevice()
    {
        super();
    }

    /**
     * @param id
     * @param machineryManufacturer
     * @param gpsState
     */
    public GpsDevice(String id, Integer machineryManufacturerId, Short gpsState)
    {
        super();
        this.id = id;
        this.machineryManufacturer = new MachineryManufacturer(machineryManufacturerId);
        this.gpsState = gpsState;
    }

    /**
     * @param id
     * @param gpsManufacturer
     * @param machineryManufacturer
     * @param sim
     * @param gpsState
     */
    public GpsDevice(String id, GpsManufacturer gpsManufacturer, MachineryManufacturer machineryManufacturer, Sim sim,
            Short gpsState)
    {
        super();
        this.id = id;
        this.gpsManufacturer = gpsManufacturer;
        this.machineryManufacturer = machineryManufacturer;
        this.sim = sim;
        this.gpsState = gpsState;
    }

    /**
     * @param id
     * @param model
     * @param firmware
     * @param version
     * @param sim
     * @param gpsState
     */
    public GpsDevice(String id, String model, String firmware, String version, Sim sim, Short gpsState)
    {
        super();
        this.id = id;
        this.model = model;
        this.firmware = firmware;
        this.version = version;
        this.sim = sim;
        this.gpsState = gpsState;
    }

    /**
     * 终端信息
     * @param id
     * @param model
     * @param gpsManufacturerId
     * @param simNo
     * @param gpsState
     * @param systemId
     */
    public GpsDevice(String id, String model, Integer gpsManufacturerId, String simNo, Short gpsState, Integer systemId)
    {
        super();
        this.id = id;
        this.model = model;
        this.gpsManufacturer = new GpsManufacturer(gpsManufacturerId);
        this.sim = new Sim(simNo);
        this.gpsState = gpsState;
        this.systemId = systemId;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public GpsManufacturer getGpsManufacturer()
    {
        return gpsManufacturer;
    }

    public Integer getGpsManufacturerId()
    {
        if (null == this.gpsManufacturer)
        {
            return null;
        }
        return this.gpsManufacturer.getId();
    }

    public void setGpsManufacturer(GpsManufacturer gpsManufacturer)
    {
        this.gpsManufacturer = gpsManufacturer;
    }

    public void setGpsManufacturerId(Integer gpsManufacturerId)
    {
        if (null == this.gpsManufacturer)
        {
            this.gpsManufacturer = new GpsManufacturer();
        }
        this.gpsManufacturer.setId(gpsManufacturerId);
    }

    public MachineryManufacturer getMachineryManufacturer()
    {
        return machineryManufacturer;
    }

    public Integer getMachineryManufacturerId()
    {
        if (null == this.machineryManufacturer)
        {
            return null;
        }
        return this.machineryManufacturer.getId();
    }

    public void setMachineryManufacturer(MachineryManufacturer machineryManufacturer)
    {
        this.machineryManufacturer = machineryManufacturer;
    }

    public void setMachineryManufacturerId(Integer machineryManufacturerId)
    {
        if (null == this.machineryManufacturer)
        {
            this.machineryManufacturer = new MachineryManufacturer();
        }
        this.machineryManufacturer.setId(machineryManufacturerId);
    }

    public String getFirmware()
    {
        return firmware;
    }

    public void setFirmware(String firmware)
    {
        this.firmware = firmware;
    }

    public String getVersion()
    {
        return version;
    }

    public void setVersion(String version)
    {
        this.version = version;
    }

    public Sim getSim()
    {
        return sim;
    }

    public String getSimNo()
    {
        if (null == this.sim)
        {
            return null;
        }
        return this.sim.getSimNo();
    }

    public void setSim(Sim sim)
    {
        this.sim = sim;
    }

    public void setSimNo(String simNo)
    {
        if (null == this.sim)
        {
            this.sim = new Sim();
        }
        this.sim.setSimNo(simNo);
    }

    public Short getGpsState()
    {
        return gpsState;
    }

    public void setGpsState(Short gpsState)
    {
        this.gpsState = gpsState;
    }

    public User getOperateUser()
    {
        return operateUser;
    }

    public void setOperateUser(User operateUser)
    {
        this.operateUser = operateUser;
    }

    public Date getOperateTime()
    {
        return operateTime;
    }

    public void setOperateTime(Date operateTime)
    {
        this.operateTime = operateTime;
    }

    public Integer getSystemId()
    {
        return systemId;
    }

    public void setSystemId(Integer systemId)
    {
        this.systemId = systemId;
    }

    public Date getDeliverDate()
    {
        return deliverDate;
    }

    public void setDeliverDate(Date deliverDate)
    {
        this.deliverDate = deliverDate;
    }

    @Override
    public String toString()
    {
        return "GpsDevice [id=" + id + ", model=" + model + ", gpsManufacturer=" + gpsManufacturer
                + ", machineryManufacturer=" + machineryManufacturer + ", firmware=" + firmware + ", version="
                + version + ", sim=" + sim + ", gpsState=" + gpsState + ", operateUser=" + operateUser
                + ", deliverDate=" + deliverDate + ", operateTime=" + operateTime + ", systemId=" + systemId + "]";
    }
}
