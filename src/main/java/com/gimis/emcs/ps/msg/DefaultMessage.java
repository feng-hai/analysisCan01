
package com.gimis.emcs.ps.msg;

import java.io.Serializable;

import com.gimis.emcs.ps.msg.append.Append;
import com.gimis.emcs.ps.msg.end.End;
import com.gimis.emcs.ps.msg.gpsbody.GpsBody;
import com.gimis.emcs.ps.msg.header.Header;
import com.gimis.emcs.ps.msg.mcubody.McuBody;
import com.gimis.emcs.ps.msg.util.MessageTools;
import com.gimis.emcs.ps.net.type.GpsProtocol;

public class DefaultMessage implements Message,Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = -7417914633458198018L;

    /**
     * 头结构
     */
    private Header header;

    /**
     * GPS消息体
     */
    private GpsBody gpsBody;

    /**
     * MCU消息体
     */
    private McuBody mcuBody;

    /**
     * 尾结构，用于5系列CRC校验
     */
    private End end;

    /**
     * 附件数据，包括消息接收时间，矫正数据
     */
    private Append append;

    /**
     * 协议类型
     */
    private GpsProtocol protocolType;

    /**
     * GPS唯一标识
     */
    private String messageCode;

    /**
     * MCU唯一标识
     */
    private Short attachmentCode;

    /**
     * 网关方式 0-gprs方式，1-sms方式
     */
    private Byte gateWaySource;

    /**
     * 消息类型 0-正常消息，1-盲区补偿消息
     */
    private Byte messageType;

    /**
     * 获取的数据流,转发使用
     */
    private byte[] dataByteBuffer;

    /**
     * 获取转发到业务平台的数据流
     */
    private byte[] transDataByteBuffer;
    
    /**
     * 发送模式
     * 0:普通模式（命令控制） 1：阻力检测
     */
    private byte detectionMode;
    
    /**
     * 命令自增长Id
     */
    private long commandId;

    public Header getHeader()
    {
        return header;
    }

    public void setHeader(Header header)
    {
        this.header = header;
    }

    public GpsBody getGpsBody()
    {
        return gpsBody;
    }

    public void setGpsBody(GpsBody gpsBody)
    {
        this.gpsBody = gpsBody;
    }

    public McuBody getMcuBody()
    {
        return mcuBody;
    }

    public void setMcuBody(McuBody mcuBody)
    {
        this.mcuBody = mcuBody;
    }

    public End getEnd()
    {
        return end;
    }

    public void setEnd(End end)
    {
        this.end = end;
    }

    public Append getAppend()
    {
        return append;
    }

    public void setAppend(Append append)
    {
        this.append = append;
    }

    public GpsProtocol getProtocolType()
    {
        return protocolType;
    }

    public void setProtocolType(GpsProtocol protocolType)
    {
        this.protocolType = protocolType;
    }

    public String getMessageCode()
    {
        return messageCode;
    }

    public void setMessageCode(String messageCode)
    {
        this.messageCode = messageCode;
    }

    public Integer getAttachmentCode()
    {
        if(null != attachmentCode)
        {
            return MessageTools.getShortValue(attachmentCode);
        }
        return null;
    }

    public void setAttachmentCode(Short attachmentCode)
    {
        this.attachmentCode = attachmentCode;
    }

    public Byte getGateWaySource()
    {
        return gateWaySource;
    }

    public void setGateWaySource(Byte gateWaySource)
    {
        this.gateWaySource = gateWaySource;
    }

    public Byte getMessageType()
    {
        return messageType;
    }

    public void setMessageType(Byte messageType)
    {
        this.messageType = messageType;
    }

    public byte[] getDataByteBuffer()
    {
        return dataByteBuffer;
    }

    public void setDataByteBuffer(byte[] dataByteBuffer)
    {
        this.dataByteBuffer = dataByteBuffer;
    }

    public byte[] getTransDataByteBuffer()
    {
        return transDataByteBuffer;
    }

    public void setTransDataByteBuffer(byte[] transDataByteBuffer)
    {
        this.transDataByteBuffer = transDataByteBuffer;
    }
    
    public byte getDetectionMode()
    {
        return detectionMode;
    }

    public void setDetectionMode(byte detectionMode)
    {
        this.detectionMode = detectionMode;
    }
    
    public long getCommandId()
    {
        return commandId;
    }

    public void setCommandId(long commandId)
    {
        this.commandId = commandId;
    }

    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        if(null != header)
        {
            sb.append(header.toString());
        }
        if (null != gpsBody)
        {
            sb.append(gpsBody.toString());
        }
        if (null != mcuBody)
        {
            sb.append(mcuBody.toString());
        }
        if (null != append)
        {
            sb.append(append.toString());
        }
        return sb.toString();
    }

}
