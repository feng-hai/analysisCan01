package com.gimis.emcs.domain;

public class BusCompany
{

    private Integer id;

    /**
     * 公交公司名称
     */
    private String name;

    /**
     * 公交公司简称
     */
    private String shortName;
    
    /**
     * 公交公司编号
     */
    private String companyNo;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 联系人姓名
     */
    private String contactName;

    /**
     * 联系人手机
     */
    private String mobilePhone;

    /**
     * 联系电话
     */
    private String telephone;

    /**
     * 邮编
     */
    private String zip;

    /**
     * 邮件
     */
    private String email;

    /**
     * 传真
     */
    private String fax;

    /**
     * 省份
     */
    private String workProvince;

    /**
     * 工作区域
     */
    private String districtCode;

    /**
     * 备注
     */
    private String description;

    /**
     * 记录状态
     */
    private Short state;

    /**
     * 平台ID
     */
    private Integer systemId;

    public BusCompany()
    {
        super();
    }

    /**
     * @param id
     */
    public BusCompany(Integer id)
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

    
    public String getCompanyNo()
    {
        return companyNo;
    }

    public void setCompanyNo(String companyNo)
    {
        this.companyNo = companyNo;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
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

    public String getWorkProvince()
    {
        return workProvince;
    }

    public void setWorkProvince(String workProvince)
    {
        this.workProvince = workProvince;
    }

    public String getDistrictCode()
    {
        return districtCode;
    }

    public void setDistrictCode(String districtCode)
    {
        this.districtCode = districtCode;
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
        return "BusCompany [id=" + id + ", name=" + name + ", shortName=" + shortName + ", companyNo=" + companyNo
                + ", address=" + address + ", contactName=" + contactName + ", mobilePhone=" + mobilePhone
                + ", telephone=" + telephone + ", zip=" + zip + ", email=" + email + ", fax=" + fax + ", workProvince="
                + workProvince + ", districtCode=" + districtCode + ", description=" + description + ", state=" + state
                + ", systemId=" + systemId + "]";
    }

  

}
