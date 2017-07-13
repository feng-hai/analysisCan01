
package com.gimis.emcs.domain;

import java.util.Date;

/**
 * 机械设备报警
 * [一句话功能简述]<p>
 * [功能详细描述]<p>
 * @version 2.0, 2015年7月10日
 * @see
 * @since gframe-v100
 */
public class AlarmMachinery
{

    /**
     * 报警ID
     */
    private Long id;

    /**
     * 报警定义信息
     */
    private AlarmDefinition alarmDefinition;

    /**
     * 报警开始时间
     */
    private Date beginTime;

    /**
     * 报警结束时间
     */
    private Date endTime;

    /**
     * 报警开始时的经度
     */
    private Double beginLongitude;

    /**
     * 报警开始时的纬度
     */
    private Double beginLatitude;

    /**
     * 报警结束时的经度
     */
    private Double endLongitude;

    /**
     * 报警结束时的纬度
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
     * 机械设备ID
     */
    private MachineryEquipment machineryEquipment;

    public AlarmMachinery()
    {
        super();
    }

    /**
     * 
     * 报警
     * @param machineryId
     * @param alarmType
     * @param time
     * @param longitude
     * @param latitude
     * @param isBegin
     */
    public AlarmMachinery(Integer machineryId, Integer alarmType, Date time, Double longitude, Double latitude,
            boolean isBegin)
    {
        super();
        this.machineryEquipment = new MachineryEquipment(machineryId);
        this.alarmDefinition = new AlarmDefinition(alarmType);
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

    /**
     * @return the processer
     */
    public User getProcesser()
    {
        return processer;
    }

    /**
     * @param processer the processer to set
     */
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

    public AlarmDefinition getAlarmDefinition()
    {
        return alarmDefinition;
    }

    public void setAlarmDefinition(AlarmDefinition alarmDefinition)
    {
        this.alarmDefinition = alarmDefinition;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "AlarmMachinery [id=" + id + ", alarmDefinition=" + alarmDefinition + ", beginTime=" + beginTime
                + ", endTime=" + endTime + ", beginLongitude=" + beginLongitude + ", beginLatitude=" + beginLatitude
                + ", endLongitude=" + endLongitude + ", endLatitude=" + endLatitude + ", processState=" + processState
                + ", processer=" + processer + ", processTime=" + processTime + ", description=" + description
                + ", machineryEquipment=" + machineryEquipment + "]";
    }
}
