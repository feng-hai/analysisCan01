
package com.gimis.emcs.domain;

import com.gimis.emcs.domain.emums.InfoSource;


/**
 * 
* 机械设备用户信息<p> 
* [功能详细描述]<p> 
* @author jujian 
* @version 1.0, 2014-3-31 
* @see 
* @since V1.0
 */
public class MachineryClient
{
    /**
     * 用户ID
     */
    private Integer id;

    /**
     * 外部系统主键，如果不是从外部系统同步过来的，则此处为空
     */
    private String fid;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 用户类型，1：个人用户 ；2 ：公司用户
     */
    private Short clientType;

    /**
     * 用户行业
     */
    private Short trade;

    /**
     * 身份证号码
     */
    private String idNumber;

    /**
     * 地址
     */
    private String address;

    /**
     * 手机号码
     */
    private String mobilePhone;

    /**
     * 电话
     */
    private String telephone;

    /**
     * 邮编
     */
    private String zip;

    /**
     * Email
     */
    private String email;

    /**
     * 传真
     */
    private String fax;

    /**
     * 第二联系人姓名
     */
    private String secondContactName;

    /**
     * 第二联系人电话，手机号码或固话电话
     */
    private String secondContactTel;

    /**
     * 备注
     */
    private String description;

    /**
     * 字典表定义，分为手动、同步两类
     */
    private InfoSource infoSource;

    /**
     * 状态，0：正常；1：无效（已删除）
     */
    private Short state;

    /**
     * 平台编号
     */
    private Integer systemId;

    /**
     * 与经销商关系，不同经销商ID之间用“,”隔开
     */
    private String distributorRelation;

    public Short getClientType()
    {
        return clientType;
    }

    public void setClientType(Short clientType)
    {
        this.clientType = clientType;
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

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    public String getZip()
    {
        return zip;
    }

    public void setZip(String zip)
    {
        this.zip = zip;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getFax()
    {
        return fax;
    }

    public void setFax(String fax)
    {
        this.fax = fax;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Short getState()
    {
        return state;
    }

    public void setState(Short state)
    {
        this.state = state;
    }

    public Short getTrade()
    {
        return trade;
    }

    public void setTrade(Short trade)
    {
        this.trade = trade;
    }

    /**
     * @return the idNumber
     */
    public String getIdNumber()
    {
        return idNumber;
    }

    /**
     * @param idNumber the idNumber to set
     */
    public void setIdNumber(String idNumber)
    {
        this.idNumber = idNumber;
    }

    /**
     * @return the mobilePhone
     */
    public String getMobilePhone()
    {
        return mobilePhone;
    }

    /**
     * @param mobilePhone the mobilePhone to set
     */
    public void setMobilePhone(String mobilePhone)
    {
        this.mobilePhone = mobilePhone;
    }

    /**
     * @return the secondContactName
     */
    public String getSecondContactName()
    {
        return secondContactName;
    }

    /**
     * @param secondContactName the secondContactName to set
     */
    public void setSecondContactName(String secondContactName)
    {
        this.secondContactName = secondContactName;
    }

    /**
     * @return the secondContactTel
     */
    public String getSecondContactTel()
    {
        return secondContactTel;
    }

    /**
     * @param secondContactTel the secondContactTel to set
     */
    public void setSecondContactTel(String secondContactTel)
    {
        this.secondContactTel = secondContactTel;
    }

    /**
     * @return the infoSource
     */
    public InfoSource getInfoSource()
    {
        return infoSource;
    }

    /**
     * @param infoSource the infoSource to set
     */
    public void setInfoSource(InfoSource infoSource)
    {
        this.infoSource = infoSource;
    }

    public String getDistributorRelation()
    {
        return distributorRelation;
    }

    public void setDistributorRelation(String distributorRelation)
    {
        this.distributorRelation = distributorRelation;
    }

    public Integer getSystemId()
    {
        return systemId;
    }

    public void setSystemId(Integer systemId)
    {
        this.systemId = systemId;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "MachineryClient [id=" + id + ", fid=" + fid + ", name=" + name + ", idNumber=" + idNumber
                + ", address=" + address + ", mobilePhone=" + mobilePhone + ", telephone=" + telephone + ", zip=" + zip
                + ", email=" + email + ", fax=" + fax + ", secondContactName=" + secondContactName
                + ", secondContactTel=" + secondContactTel + ", description=" + description + ", infoSource="
                + infoSource + ", state=" + state + ", systemid=" + systemId + ", distributorRelation="
                + distributorRelation + "]";
    }

}
