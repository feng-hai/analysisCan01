
package com.gimis.emcs.ps.msg;
import com.gimis.emcs.ps.msg.append.Append;
import com.gimis.emcs.ps.msg.end.End;
import com.gimis.emcs.ps.msg.gpsbody.GpsBody;
import com.gimis.emcs.ps.msg.header.Header;
import com.gimis.emcs.ps.msg.mcubody.McuBody;
import com.gimis.emcs.ps.net.type.GpsProtocol;

public interface Message
{
    public Header getHeader();

    public GpsBody getGpsBody();

    public McuBody getMcuBody();

    public End getEnd();

    public Append getAppend();

    public GpsProtocol getProtocolType();

    public void setHeader(Header header);

    public void setGpsBody(GpsBody gpsBody);

    public void setMcuBody(McuBody mcuBody);

    public void setEnd(End end);

    public void setAppend(Append append);

    public void setProtocolType(GpsProtocol type);

    public String getMessageCode();

    public void setMessageCode(String messageCode);

    public Integer getAttachmentCode();

    public void setAttachmentCode(Short attachmentCode);

    public Byte getGateWaySource();

    public void setGateWaySource(Byte gateWaySource);

    public Byte getMessageType();

    public void setMessageType(Byte messageType);

    public byte[] getDataByteBuffer();

    public void setDataByteBuffer(byte[] dataByteBuffer);
    
    public byte getDetectionMode();

    public void setDetectionMode(byte detectionMode);
    
    public long getCommandId();

    public void setCommandId(long commandId);

}
