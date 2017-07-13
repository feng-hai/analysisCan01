
package com.gimis.emcs.ps.msg.append;

import java.util.Date;

public interface Append
{
    public Date getServerTime();

    public void setServerTime(Date serverTime);

    public Integer getWorkingTime();

    public void setWorkingTime(Integer workingTime);

    public Double getMiles();

    public void setMiles(Integer miles);

    public String getSimTel();

    public void setSimTel(String simTel);

    public void setCmdType(Integer cmdType);

    public Integer getCmdType();
    
    public Boolean getIsCopySend();

    public void setIsCopySend(Boolean isCopySend);
    
    public String getAppendFlag();

    public void setAppendFlag(String appendFlag);

    public Short getAppendLength();

    public void setAppendLength(Short appendLength);
    
    public Integer getMachineryId();

    public void setMachineryId(Integer machineryId);
}
