/**
 * 
 */
package com.gimis.emcs.ps.msg.mcubody.impl;

import java.util.List;

import com.gimis.emcs.ps.msg.mcubody.CsrzicCanAlarmState;
import com.gimis.emcs.ps.msg.util.MessageTools;
import com.gimis.emcs.ps.msg.vo.CanAlarmVo;

/**
 * 报警状态上报实体
 * [一句话功能简述]<p>
 * [功能详细描述]<p>
 * @author zjm
 * @version 1.0, 2015-5-12

 * @since gms-v100
 */
public class BaseCanAlarmState implements CsrzicCanAlarmState
{

    /**
     * 
     */
    private static final long serialVersionUID = -7407176415115763244L;
    
    /**
     * 经度
     */
    private Integer longitude;

    /**
     * 纬度
     */
    private Integer latitude;
    
    /**
     * 报警个数
     */
    private Byte alarmNum;
    
    /**
     * 报警信息
     */
    private List<CanAlarmVo> alarmList;
    
    public Double getLongitude()
    {
        if(null != longitude)
        {
            return MessageTools.getSixDoubleValue((double)longitude/ 1000000);
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
        if(null != latitude)
        {
            return MessageTools.getSixDoubleValue((double)latitude/ 1000000);
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

    public Byte getAlarmNum()
    {
        return alarmNum;
    }

    public void setAlarmNum(Byte alarmNum)
    {
        this.alarmNum = alarmNum;
    }

    public List<CanAlarmVo> getAlarmList()
    {
        return alarmList;
    }

    public void setAlarmList(List<CanAlarmVo> alarmList)
    {
        this.alarmList = alarmList;
    }

    @Override
    public String toString()
    {
        return "BaseCanAlarmState [alarmList=" + alarmList + ", alarmNum=" + alarmNum + ", latitude=" + latitude
                + ", longitude=" + longitude + "]";
    }
}
