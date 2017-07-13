package com.gimis.emcs.ps.msg.mcubody;

import java.util.Date;
import java.util.List;

import com.gimis.emcs.ps.msg.vo.CanDataVo;

public interface McuCanDataPass extends McuBody
{
    public Byte getDataReportReason();

    public void setDataReportReason(Byte dataReportReason);

    public Long getSequenceNumber();

    public void setSequenceNumber(Integer sequenceNumber);

    public Date getUtcTime();

    public void setUtcTime(long utcTime);

    public Byte getDataFormat();

    public void setDataFormat(Byte dataFormat);

    public Byte getDataPackets();

    public void setDataPackets(Byte dataPackets);

    public List<CanDataVo> getCanDataFrame();

    public void setCanDataFrame(List<CanDataVo> canDataFrame);
}
