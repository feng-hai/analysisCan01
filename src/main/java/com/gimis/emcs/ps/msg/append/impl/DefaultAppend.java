
package com.gimis.emcs.ps.msg.append.impl;

import java.io.Serializable;
import java.util.Date;

import com.gimis.emcs.ps.msg.append.Append;

public class DefaultAppend implements Append , Serializable
{

    private static final long serialVersionUID = 3232441330804999038L;

    private Date ServerTime;

    private Integer workingTime;

    private Integer miles;

    private String simTel;

    private Integer cmdType;

    /**
     * true  为抄送   
     */
    private Boolean isCopySend;
    
    /**
     * 附加数据标志位
     * 默认为append的asc码
     */
    private String appendFlag;
    
    /**
     * 附加数据长度
     */
    private Short appendLength;
    
    /**
     * 设备编号
     */
    private Integer machineryId;
    
    public Integer getCmdType()
    {
        return cmdType;
    }

    public void setCmdType(Integer cmdType)
    {
        this.cmdType = cmdType;
    }

    public Date getServerTime()
    {
        return ServerTime;
    }

    public void setServerTime(Date serverTime)
    {
        ServerTime = serverTime;
    }

    public Integer getWorkingTime()
    {
        if (null != workingTime)
        {
            return workingTime;
        }
        else
        {
            return null;
        }

    }

    public void setWorkingTime(Integer workingTime)
    {
        this.workingTime = workingTime;
    }

    public Double getMiles()
    {
        if (null != miles)
        {
            return (double) miles / 1000;
        }
        else
        {
            return null;
        }

    }

    public void setMiles(Integer miles)
    {
        this.miles = miles;
    }

    public String getSimTel()
    {
        return simTel;
    }

    public void setSimTel(String simTel)
    {
        this.simTel = simTel;
    }
    
    public Boolean getIsCopySend()
    {
        return isCopySend;
    }

    public void setIsCopySend(Boolean isCopySend)
    {
        this.isCopySend = isCopySend;
    }
    
    public String getAppendFlag()
    {
        return appendFlag;
    }

    public void setAppendFlag(String appendFlag)
    {
        this.appendFlag = appendFlag;
    }

    public Short getAppendLength()
    {
        return appendLength;
    }

    public void setAppendLength(Short appendLength)
    {
        this.appendLength = appendLength;
    }
    
    public Integer getMachineryId()
    {
        return machineryId;
    }

    public void setMachineryId(Integer machineryId)
    {
        this.machineryId = machineryId;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("[").append("服务器时间 : ").append(ServerTime).append(",")
            .append("设备编号 : ").append(machineryId).append(",")
            .append("附加数据标志位 : ").append(appendFlag).append(",")
            .append("附加数据长度 : ").append(workingTime).append("]");
        return builder.toString();
    }

    

}
