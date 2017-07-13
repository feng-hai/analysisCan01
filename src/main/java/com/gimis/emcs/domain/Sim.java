
package com.gimis.emcs.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Sim
{

    /**
     * 主键，SIM卡的手机号码
     */
    private String simNo;

    /**
     * SIM卡开通日期
     */
    private Date openDate;

    /**
     * 余额
     */
    private BigDecimal balance;

    /**
     * 余额有效期
     */
    private Date period;

    /**
     * 所属厂家ID
     */
    private Integer owner;

    /**
     * SIM卡类型，字典表定义，厂家购买，吉美思购买，通付，非统付
     */
    private Short type;

    /**
     * SIM卡用途，字典表定义，0表示GPS使用，1表示LBS使用。
     */
    private Short simUse;

    /**
     * SIM卡状态，由业务状态表定义，0-正常、1-欠费、2-有效期到期、3-停机保号、4-注销
     */
    private Short simState;

    /**
     * 卡有效期
     */
    private Date cardValidTime;

    /**
     * 保号到期时间
     */
    private Date noValidTime;

    private Integer operator;

    private Date operateTime;

    private Integer systemId;

    public Sim()
    {
        super();
    }

    /**
     * @param simNo
     */
    public Sim(String simNo)
    {
        super();
        this.simNo = simNo;
    }

    /**
     * @param simNo
     * @param owner
     */
    public Sim(String simNo, Integer owner)
    {
        super();
        this.simNo = simNo;
        this.owner = owner;
    }

    /**
     * @param simNo
     * @param type
     * @param simUse
     * @param simState
     */
    public Sim(String simNo, Short type, Short simUse, Short simState, Integer systemId)
    {
        super();
        this.simNo = simNo;
        this.type = type;
        this.simUse = simUse;
        this.simState = simState;
        this.systemId = systemId;
    }

    public String getSimNo()
    {
        return simNo;
    }

    public void setSimNo(String simNo)
    {
        this.simNo = simNo;
    }

    public Date getOpenDate()
    {
        return openDate;
    }

    public void setOpenDate(Date openDate)
    {
        this.openDate = openDate;
    }

    public BigDecimal getBalance()
    {
        return balance;
    }

    public void setBalance(BigDecimal balance)
    {
        this.balance = balance;
    }

    public Date getPeriod()
    {
        return period;
    }

    public void setPeriod(Date period)
    {
        this.period = period;
    }

    public Integer getOwner()
    {
        return owner;
    }

    public void setOwner(Integer owner)
    {
        this.owner = owner;
    }

    public Short getType()
    {
        return type;
    }

    public void setType(Short type)
    {
        this.type = type;
    }

    public Short getSimState()
    {
        return simState;
    }

    public void setSimState(Short simState)
    {
        this.simState = simState;
    }

    public Short getSimUse()
    {
        return simUse;
    }

    public void setSimUse(Short simUse)
    {
        this.simUse = simUse;
    }

    public Date getCardValidTime()
    {
        return cardValidTime;
    }

    public void setCardValidTime(Date cardValidTime)
    {
        this.cardValidTime = cardValidTime;
    }

    public Date getNoValidTime()
    {
        return noValidTime;
    }

    public void setNoValidTime(Date noValidTime)
    {
        this.noValidTime = noValidTime;
    }

    public Integer getOperator()
    {
        return operator;
    }

    public void setOperator(Integer operator)
    {
        this.operator = operator;
    }

    public Date getOperateTime()
    {
        return operateTime;
    }

    public void setOperateTime(Date operateTime)
    {
        this.operateTime = operateTime;
    }

    public Integer getSystemId()
    {
        return systemId;
    }

    public void setSystemId(Integer systemId)
    {
        this.systemId = systemId;
    }

    @Override
    public String toString()
    {
        return "Sim [simNo=" + simNo + ", openDate=" + openDate + ", balance=" + balance + ", period=" + period
                + ", owner=" + owner + ", type=" + type + ", simUse=" + simUse + ", simState=" + simState
                + ", cardValidTime=" + cardValidTime + ", noValidTime=" + noValidTime + ", operator=" + operator
                + ", operateTime=" + operateTime + ", systemId=" + systemId + "]";
    }
}
