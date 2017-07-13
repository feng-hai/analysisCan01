package com.gimis.emcs.domain;

import java.util.Date;

public class FaultMachinery {
	/**
     * 故障ID
     */
    private Long id;

    /**
     * 故障定义信息
     */
    private FaultDefinition faultDefinition;

    /**
     * 故障开始时间
     */
    private Date beginTime;

    /**
     * 故障结束时间
     */
    private Date endTime;

    /**
     * 故障开始时的经度
     */
    private Double beginLongitude;

    /**
     * 故障开始时的纬度
     */
    private Double beginLatitude;

    /**
     * 故障结束时的经度
     */
    private Double endLongitude;

    /**
     * 故障结束时的纬度
     */
    private Double endLatitude;

    /**
     * 处理状态，字典表定义
     */
    private Short processState;

    /**
     * 处理人
     */
    private User processer;

    /**
     * 处理时间
     */
    private Date processTime;

    private String description;
    
    /**
     * 故障信息显示状态 0:显示 1:不显示
     */
    private Short displayStatus;

    /**
     * 机械设备ID
     */
    private MachineryEquipment machineryEquipment;

    public FaultMachinery()
    {
        super();
    }

    /**
     * @param displayStatus
     */
    public FaultMachinery(Short displayStatus)
    {
        super();
        this.displayStatus = displayStatus;
    }

    /**
     * 
     * 警告信息
     * @param machineryId
     * @param faultCode
     * @param time
     * @param longitude
     * @param latitude
     * @param isBegin
     */
    public FaultMachinery(Integer machineryId, String faultCode, Date time, Double longitude, Double latitude,
            boolean isBegin)
    {
        super();
        this.machineryEquipment = new MachineryEquipment(machineryId);
        this.faultDefinition = new FaultDefinition(faultCode);
        if (isBegin)
        {
            //报警开始
            this.beginTime = time;
            this.beginLongitude = longitude;
            this.beginLatitude = latitude;
        }
        else
        {
            //报警结束
            this.endTime = time;
            this.endLongitude = longitude;
            this.endLatitude = latitude;
        }
    }

    public MachineryEquipment getMachineryEquipment()
    {
        return machineryEquipment;
    }

    public Integer getMachineryId()
    {
        if (null == this.machineryEquipment)
        {
            return null;
        }
        return this.machineryEquipment.getId();
    }

    public void setMachineryId(Integer machineryId)
    {
        if (null == this.machineryEquipment)
        {
            this.machineryEquipment = new MachineryEquipment();
        }
        this.machineryEquipment.setId(machineryId);
    }

    public void setMachineryEquipment(MachineryEquipment machineryEquipment)
    {
        this.machineryEquipment = machineryEquipment;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Date getBeginTime()
    {
        return beginTime;
    }

    public void setBeginTime(Date beginTime)
    {
        this.beginTime = beginTime;
    }

    public Date getEndTime()
    {
        return endTime;
    }

    public void setEndTime(Date endTime)
    {
        this.endTime = endTime;
    }

    public Short getProcessState()
    {
        return processState;
    }

    public void setProcessState(Short processState)
    {
        this.processState = processState;
    }

    public FaultDefinition getFaultDefinition()
    {
        return faultDefinition;
    }

    public void setFaultDefinition(FaultDefinition faultDefinition)
    {
        this.faultDefinition = faultDefinition;
    }

    public User getProcesser()
    {
        return processer;
    }

    public void setProcesser(User processer)
    {
        this.processer = processer;
    }

    public Date getProcessTime()
    {
        return processTime;
    }

    public void setProcessTime(Date processTime)
    {
        this.processTime = processTime;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Short getDisplayStatus()
    {
        return displayStatus;
    }

    public void setDisplayStatus(Short displayStatus)
    {
        this.displayStatus = displayStatus;
    }

    public Double getBeginLongitude()
    {
        return beginLongitude;
    }

    public void setBeginLongitude(Double beginLongitude)
    {
        this.beginLongitude = beginLongitude;
    }

    public Double getBeginLatitude()
    {
        return beginLatitude;
    }

    public void setBeginLatitude(Double beginLatitude)
    {
        this.beginLatitude = beginLatitude;
    }

    public Double getEndLongitude()
    {
        return endLongitude;
    }

    public void setEndLongitude(Double endLongitude)
    {
        this.endLongitude = endLongitude;
    }

    public Double getEndLatitude()
    {
        return endLatitude;
    }

    public void setEndLatitude(Double endLatitude)
    {
        this.endLatitude = endLatitude;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "FaultMachinery [id=" + id + ", faultDefinition=" + faultDefinition + ", beginTime=" + beginTime
                + ", endTime=" + endTime + ", beginLongitude=" + beginLongitude + ", beginLatitude=" + beginLatitude
                + ", endLongitude=" + endLongitude + ", endLatitude=" + endLatitude + ", processState=" + processState
                + ", processer=" + processer + ", processTime=" + processTime + ", description=" + description
                + ", displayStatus=" + displayStatus + ", machineryEquipment=" + machineryEquipment + "]";
    }
}
