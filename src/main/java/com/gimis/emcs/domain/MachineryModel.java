
package com.gimis.emcs.domain;

import java.util.Date;

import com.gimis.emcs.domain.emums.InfoSource;

public class MachineryModel
{
    /**
     * 主键 
     */
    private Integer id;

    /**
     * 外键
     */
    private String fid;

    /**
     * 设备类型
     */
    private Integer machineryTypeId;

    /**
     * 吨位
     */
    private Integer tonnage;

    /**
     * 车型名称
     */
    private String name;

    /**
     * 中文名称
     */
    private String cnName;

    /**
     * 油箱容积
     */
    private Integer oilboxVol;

    /**
     * 描述
     */
    private String description;

    /**
     * 信息来源，字典表定义，分为手动、同步两类
     */
    private InfoSource infoSource;

    /**
     * 状态，0：正常；1：无效（已删除）
     */
    private Short state;

    /**
     * 操作人
     */
    private User operateUser;

    /**
     * 操作时间
     */
    private Date operateTime;

    /**
     * 排序
     */
    private short sort;

    /**
     * 平台编号
     * @return
     */
    private Integer systemId;
    /**
     * 车型
     */
    private Integer analyzeType;

    public MachineryModel()
    {
        super();
    }

    /**
     * @param id
     */
    public MachineryModel(Integer id)
    {
        super();
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getFid()
    {
        return fid;
    }

    public void setFid(String fid)
    {
        this.fid = fid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getCnName()
    {
        return cnName;
    }

    public void setCnName(String cnName)
    {
        this.cnName = cnName;
    }

    public Integer getOilboxVol()
    {
        return oilboxVol;
    }

    public void setOilboxVol(Integer oilboxVol)
    {
        this.oilboxVol = oilboxVol;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public InfoSource getInfoSource()
    {
        return infoSource;
    }

    public void setInfoSource(InfoSource infoSource)
    {
        this.infoSource = infoSource;
    }

    public Short getState()
    {
        return state;
    }

    public void setState(Short state)
    {
        this.state = state;
    }

    public Integer getMachineryTypeId()
    {
        return machineryTypeId;
    }

    public void setMachineryTypeId(Integer machineryTypeId)
    {
        this.machineryTypeId = machineryTypeId;
    }

    public Integer getTonnage()
    {
        return tonnage;
    }

    public void setTonnage(Integer tonnage)
    {
        this.tonnage = tonnage;
    }

    public User getOperateUser()
    {
        return operateUser;
    }

    public void setOperateUser(User operateUser)
    {
        this.operateUser = operateUser;
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

    public short getSort()
    {
        return sort;
    }

    public void setSort(short sort)
    {
        this.sort = sort;
    }
    
    

    public Integer getAnalyzeType()
    {
        return analyzeType;
    }

    public void setAnalyzeType(Integer analyzeType)
    {
        this.analyzeType = analyzeType;
    }

    @Override
    public String toString()
    {
        return "MachineryModel [id=" + id + ", fid=" + fid + ", machineryTypeId=" + machineryTypeId + ", tonnage="
                + tonnage + ", name=" + name + ", cnName=" + cnName + ", oilboxVol=" + oilboxVol + ", description="
                + description + ", infoSource=" + infoSource + ", state=" + state + ", operateUser=" + operateUser
                + ", operateTime=" + operateTime + ", sort=" + sort + ", systemId=" + systemId + ", analyzeType="
                + analyzeType + "]";
    }

    

}
