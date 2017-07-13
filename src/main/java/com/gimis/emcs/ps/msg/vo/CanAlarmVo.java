/**
 * 
 */

package com.gimis.emcs.ps.msg.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 报警信息
 * [一句话功能简述]<p>
 * [功能详细描述]<p>
 * @author zjm
 * @version 1.0, 2015-5-12

 * @since gms-v100
 */
public class CanAlarmVo implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1640556952606984162L;

    /**
     * 报警标示
     * 0:系统故障码  1:阈值故障码
     */
    private Byte alarmMark;

    /**
     * 报警故障码
     */
    private Integer alarmNo;

    /**
     * 报警状态
     * 0:报警结束   1：报警开始
     */
    private Byte alarmValue;

    /**
     * 报警时间
     */
    private Date alarmTime;

    /**
     * spn代码
     */
    private Integer alarmSpn;

    /**
     * fmi代码
     */
    private Short alarmFmi;

    public Byte getAlarmMark()
    {
        return alarmMark;
    }

    public void setAlarmMark(Byte alarmMark)
    {
        this.alarmMark = alarmMark;
    }

    public Long getAlarmNo()
    {
        long relayValue = alarmNo;
        if (alarmNo < 0)
        {
            relayValue = 4294967296L - Math.abs(alarmNo);
        }
        return relayValue;
    }

    public void setAlarmNo(Integer alarmNo)
    {
        this.alarmNo = alarmNo;
    }

    public Byte getAlarmValue()
    {
        return alarmValue;
    }

    public void setAlarmValue(Byte alarmValue)
    {
        this.alarmValue = alarmValue;
    }

    public Date getAlarmTime()
    {
        return alarmTime;
    }

    public void setAlarmTime(Date alarmTime)
    {
        this.alarmTime = alarmTime;
    }

    public Integer getAlarmSpn()
    {
        return alarmSpn;
    }

    public void setAlarmSpn(Integer alarmSpn)
    {
        this.alarmSpn = alarmSpn;
    }

    public Short getAlarmFmi()
    {
        return alarmFmi;
    }

    public void setAlarmFmi(Short alarmFmi)
    {
        this.alarmFmi = alarmFmi;
    }

    @Override
    public String toString()
    {
        return "CanAlarmVo [alarmMark=" + alarmMark + ", alarmNo=" + alarmNo + ", alarmValue=" + alarmValue
                + ", alarmTime=" + alarmTime + ", alarmSpn=" + alarmSpn + ", alarmFmi=" + alarmFmi + "]";
    }

}
