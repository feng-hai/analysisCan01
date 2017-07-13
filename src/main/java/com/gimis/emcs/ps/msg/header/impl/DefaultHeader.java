
package com.gimis.emcs.ps.msg.header.impl;

import java.io.Serializable;

import com.gimis.emcs.ps.msg.header.Header;

/**
 * 
 * [4系列终端的协议头定义]<p>
 * [功能详细描述]<p>
 * @author ZhangBo
 * @version 1.0, 2011-7-8

 * @since gframe-v100
 */
public class DefaultHeader implements Header,Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = -322248194570137910L;

    private short gpsCommandId;

    private short gpsLength;

    private short attachmentId;

    private short attachmentLength;

    private short sequenceId;

    private String gpsId;

    private byte subDeviceId;

    private byte gpsManufacturers;

    private byte hostCompanies;
    
    private String vin;
    
    private short msgLength;
    
    /**
     * 车标值
     */
    private byte carValue;
    
    public short getGpsCommandId()
    {
        return gpsCommandId;
    }

    public void setGpsCommandId(short gpsCommandId)
    {
        this.gpsCommandId = gpsCommandId;
    }

    public short getGpsLength()
    {
        return gpsLength;
    }

    public void setGpsLength(short gpsLength)
    {
        this.gpsLength = gpsLength;
    }

    public short getAttachmentId()
    {
        return attachmentId;
    }

    public void setAttachmentId(short attachmentId)
    {
        this.attachmentId = attachmentId;
    }

    public short getAttachmentLength()
    {
        return attachmentLength;
    }

    public void setAttachmentLength(short attachmentLength)
    {
        this.attachmentLength = attachmentLength;
    }

    public short getSequenceId()
    {
        return sequenceId;
    }

    public void setSequenceId(short sequenceId)
    {
        this.sequenceId = sequenceId;
    }


    public byte getSubDeviceId()
    {
        return subDeviceId;
    }

    public void setSubDeviceId(byte subDeviceId)
    {
        this.subDeviceId = subDeviceId;
    }

    public byte getGpsManufacturers()
    {
        return gpsManufacturers;
    }

    public void setGpsManufacturers(byte gpsManufacturers)
    {
        this.gpsManufacturers = gpsManufacturers;
    }

    public byte getHostCompanies()
    {
        return hostCompanies;
        }

    public void setHostCompanies(byte hostCompanies)
    {
        this.hostCompanies = hostCompanies;
    }
    
    
    public String getGpsId()
    {
        return gpsId;
    }

    public void setGpsId(String gpsId)
    {
        this.gpsId = gpsId;
    }

    
    public String getVin()
    {
        return vin;
    }

    
    public void setVin(String vin)
    {
        this.vin = vin;
    }

    
    public short getMsgLength()
    {
        return msgLength;
    }

    
    public void setMsgLength(short msgLength)
    {
        this.msgLength = msgLength;
    }

    
    public byte getCarValue()
    {
        return carValue;
    }

    
    public void setCarValue(byte carValue)
    {
        this.carValue = carValue;
    }
    
    
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("[命令响应ID : ").append(attachmentId).append(",").append("响应消息长度 : ").append(attachmentLength)
                .append(",").append("车标值 : ").append(carValue).append(",").append("命令ID : ").append(gpsCommandId)
                .append(",").append("终端ID : ").append(gpsId).append(",").append("Gps消息长度 : ").append(gpsLength)
                .append(",").append("消息长度 : ").append(msgLength).append(",").append("Gps供应商代码 : ")
                .append(gpsManufacturers).append(",").append("消息流水号 : ").append(sequenceId).append(",")
                .append("子设备代码 : ").append(subDeviceId).append(",").append("车架号 : ").append(vin).append("]");
        return builder.toString();
    }

}
