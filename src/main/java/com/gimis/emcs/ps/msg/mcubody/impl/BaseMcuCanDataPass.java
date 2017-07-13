package com.gimis.emcs.ps.msg.mcubody.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.gimis.emcs.ps.msg.mcubody.McuCanDataPass;
import com.gimis.emcs.ps.msg.util.MessageTools;
import com.gimis.emcs.ps.msg.vo.CanDataVo;

public class BaseMcuCanDataPass implements McuCanDataPass, Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = -1333364474117203011L;

    private Byte dataReportReason;

    /*
     * 上报数据包序列号
     */
    private Integer sequenceNumber;

    /*
     * 起始帧时间
     */
    private Date utcTime;

    /*
     * CAN数据格式
     */
    private Byte dataFormat;

    /*
     * CAN数据包个数
     */
    private Byte dataPackets;

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
    private Short gpsSpeed;

    /*
     * 高度
     */
    private Short height;

    /*
     * 方向角
     */
    private Short forDirect;

    private List<CanDataVo> canDataFrame;

    public Byte getDataReportReason()
    {
        return dataReportReason;
    }

    public void setDataReportReason(Byte dataReportReason)
    {
        this.dataReportReason = dataReportReason;
    }

    public Long getSequenceNumber()
    {
        if (null != sequenceNumber)
        {
            return MessageTools.getIntValue(sequenceNumber);
        }
        return null;
    }

    public void setSequenceNumber(Integer sequenceNumber)
    {
        this.sequenceNumber = sequenceNumber;
    }

    public Date getUtcTime()
    {
        return utcTime;
    }

    public void setUtcTime(long utcTime)
    {
        this.utcTime = new Date(utcTime);
    }

    public Byte getDataFormat()
    {
        return dataFormat;
    }

    public void setDataFormat(Byte dataFormat)
    {
        this.dataFormat = dataFormat;
    }

    public Byte getDataPackets()
    {
        return dataPackets;
    }

    public void setDataPackets(Byte dataPackets)
    {
        this.dataPackets = dataPackets;
    }

    public List<CanDataVo> getCanDataFrame()
    {
        return canDataFrame;
    }

    public void setCanDataFrame(List<CanDataVo> canDataFrame)
    {
        this.canDataFrame = canDataFrame;
    }

    public Double getLongitude()
    {
        if (null != longitude)
        {
            return MessageTools.getSixDoubleValue((double)longitude / 1000000);
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
            return MessageTools.getSixDoubleValue((double)latitude / 1000000);
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

    public Double getGpsSpeed()
    {
        if (null != gpsSpeed)
        {
            return (double) gpsSpeed * 0.5;
        }
        else
        {
            return null;
        }
    }

    public void setGpsSpeed(Short gpsSpeed)
    {
        this.gpsSpeed = gpsSpeed;
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

    public void setUtcTime(Date utcTime)
    {
        this.utcTime = utcTime;
    }

    @Override
    public String toString()
    {
        return "BaseMcuCanDataPass [dataReportReason=" + dataReportReason + ", sequenceNumber=" + sequenceNumber
                + ", utcTime=" + utcTime + ", dataFormat=" + dataFormat + ", dataPackets=" + dataPackets
                + ", longitude=" + longitude + ", latitude=" + latitude + ", gpsSpeed=" + gpsSpeed + ", height="
                + height + ", forDirect=" + forDirect + ", canDataFrame=" + canDataFrame + "]";
    }

}
