
package com.gimis.emcs.domain;

public class MachineryManufacturer 
{

    private Integer id;

    private String name;

    private String telephone;

    private String districtCode;

    private String address;

    private Boolean outFactoryNotify;

    private Double factoryNeLongitude;

    private Double factoryNeLatitude;

    private Double factorySwLongitude;

    private Double factorySwLatitude;

    private Float cityNeLongitude;

    private Float cityNeLatitude;

    private Float citySwLongitude;

    private Float citySwLatitude;

    private String description;

    private Short state;

    /**
     * 排序
     */
    private short sort;

    /**
     * 平台编号
     */
    private Integer systemId;

    public MachineryManufacturer()
    {
        super();
    }

    /**
     * @param id
     */
    public MachineryManufacturer(Integer id)
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

    public short getSort()
    {
        return sort;
    }

    public void setSort(short sort)
    {
        this.sort = sort;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    public String getDistrictCode()
    {
        return districtCode;
    }

    public void setDistrictCode(String districtCode)
    {
        this.districtCode = districtCode;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public Boolean getOutFactoryNotify()
    {
        return outFactoryNotify;
    }

    public void setOutFactoryNotify(Boolean outFactoryNotify)
    {
        this.outFactoryNotify = outFactoryNotify;
    }

    public Double getFactoryNeLongitude()
    {
        return factoryNeLongitude;
    }

    public void setFactoryNeLongitude(Double factoryNeLongitude)
    {
        this.factoryNeLongitude = factoryNeLongitude;
    }

    public Double getFactoryNeLatitude()
    {
        return factoryNeLatitude;
    }

    public void setFactoryNeLatitude(Double factoryNeLatitude)
    {
        this.factoryNeLatitude = factoryNeLatitude;
    }

    public Double getFactorySwLongitude()
    {
        return factorySwLongitude;
    }

    public void setFactorySwLongitude(Double factorySwLongitude)
    {
        this.factorySwLongitude = factorySwLongitude;
    }

    public Double getFactorySwLatitude()
    {
        return factorySwLatitude;
    }

    public void setFactorySwLatitude(Double factorySwLatitude)
    {
        this.factorySwLatitude = factorySwLatitude;
    }

    public Float getCityNeLongitude()
    {
        return cityNeLongitude;
    }

    public void setCityNeLongitude(Float cityNeLongitude)
    {
        this.cityNeLongitude = cityNeLongitude;
    }

    public Float getCityNeLatitude()
    {
        return cityNeLatitude;
    }

    public void setCityNeLatitude(Float cityNeLatitude)
    {
        this.cityNeLatitude = cityNeLatitude;
    }

    public Float getCitySwLongitude()
    {
        return citySwLongitude;
    }

    public void setCitySwLongitude(Float citySwLongitude)
    {
        this.citySwLongitude = citySwLongitude;
    }

    public Float getCitySwLatitude()
    {
        return citySwLatitude;
    }

    public void setCitySwLatitude(Float citySwLatitude)
    {
        this.citySwLatitude = citySwLatitude;
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
        return "MachineryManufacturer [address=" + address + ", cityNeLatitude=" + cityNeLatitude
                + ", cityNeLongitude=" + cityNeLongitude + ", citySwLatitude=" + citySwLatitude + ", citySwLongitude="
                + citySwLongitude + ", description=" + description + ", districtCode=" + districtCode
                + ", factoryNeLatitude=" + factoryNeLatitude + ", factoryNeLongitude=" + factoryNeLongitude
                + ", factorySwLatitude=" + factorySwLatitude + ", factorySwLongitude=" + factorySwLongitude + ", id="
                + id + ", name=" + name + ", outFactoryNotify=" + outFactoryNotify + ", state=" + state
                + ", telephone=" + telephone + "，systemId=" + systemId + "]";
    }
}
