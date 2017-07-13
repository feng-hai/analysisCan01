
package com.gimis.emcs.domain;

import java.util.List;

import com.gimis.emcs.domain.emums.DistributorType;
import com.gimis.emcs.domain.emums.InfoSource;

/**
 * 
* 经销商管理实体类<p> 
* [功能详细描述]<p> 
* @version 1.0, 2014-3-25 
* @see 
* @since V1.0
 */
public class Distributor
{
    /**
     * 经销商ID
     */
    private Integer id;

    /**
     * 外键ID
     */
    private String fid;

    /**
     * 经销商名称
     */
    private String name;

    /**
     * 经销商简称
     */
    private String shortName;

    /**
     * 经销商类型
     */
    private DistributorType type;

    /**
     * 经销商所在省份
     */
    private String province;

    /**
     * 地址
     */
    private String address;

    /**
     * 营业执照号码
     */
    private String licenseNo;

    /**
     * 联系人
     */
    private String contactName;

    /**
     * 手机号码
     */
    private String mobilePhone;

    /**
     * 电话号码
     */
    private String telephone;

    /**
     * 邮编
     */
    private String Zip;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 传真
     */
    private String fax;

    /**
     * 负责地区
     */
    private String region;

    /**
     * 描述
     */
    private String description;

    /**
     * 来源
     */
    private InfoSource infoSource;

    /**
     * 状态，0正常，1删除
     */
    private Short state;

    /**
     * 平台编号
     */
    private Integer systemId;

    /**
     * 排序
     */
    private short sort;

    /**
     * 经销商与设备类型关系
     */
    private List<DistributorTypeRelation> typeRelationList;

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

    public String getShortName()
    {
        return shortName;
    }

    public void setShortName(String shortName)
    {
        this.shortName = shortName;
    }

    public DistributorType getType()
    {
        return type;
    }

    public void setType(DistributorType type)
    {
        this.type = type;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getLicenseNo()
    {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo)
    {
        this.licenseNo = licenseNo;
    }

    public String getContactName()
    {
        return contactName;
    }

    public void setContactName(String contactName)
    {
        this.contactName = contactName;
    }

    public String getMobilePhone()
    {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone)
    {
        this.mobilePhone = mobilePhone;
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
        return Zip;
    }

    public void setZip(String zip)
    {
        Zip = zip;
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

    public String getRegion()
    {
        return region;
    }

    public void setRegion(String region)
    {
        this.region = region;
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

    public String getProvince()
    {
        return province;
    }

    public void setProvince(String province)
    {
        this.province = province;
    }

    public List<DistributorTypeRelation> getTypeRelationList()
    {
        return typeRelationList;
    }

    public void setTypeRelationList(List<DistributorTypeRelation> typeRelationList)
    {
        this.typeRelationList = typeRelationList;
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

    @Override
    public String toString()
    {
        return "Distributor [Zip=" + Zip + ", address=" + address + ", contactName=" + contactName + ", description="
                + description + ", email=" + email + ", fax=" + fax + ", fid=" + fid + ", id=" + id + ", infoSource="
                + infoSource + ", licenseNo=" + licenseNo + ", mobilePhone=" + mobilePhone + ", name=" + name
                + ", province=" + province + ", region=" + region + ", shortName=" + shortName + ", sort=" + sort
                + ", state=" + state + ", systemId=" + systemId + ", telephone=" + telephone + ", type=" + type
                + ", typeRelationList=" + typeRelationList + "]";
    }
}
