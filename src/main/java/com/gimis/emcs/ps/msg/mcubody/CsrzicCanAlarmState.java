package com.gimis.emcs.ps.msg.mcubody;

import java.util.List;

import com.gimis.emcs.ps.msg.vo.CanAlarmVo;

public interface CsrzicCanAlarmState extends CanAlarmState
{
    public Double getLongitude();

    public void setLongitude(Integer longitude);

    public Double getLatitude();

    public void setLatitude(Integer latitude);

    public Byte getAlarmNum();

    public void setAlarmNum(Byte alarmNum);

    public List<CanAlarmVo> getAlarmList();

    public void setAlarmList(List<CanAlarmVo> alarmList);
}
