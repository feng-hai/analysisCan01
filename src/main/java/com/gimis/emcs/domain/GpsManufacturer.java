
package com.gimis.emcs.domain;

public class GpsManufacturer
{

    private Integer id;

    /**
     * GPS生产厂家名称
     */
    private String name;

    /**
     * 地址
     */
    private String address;

    /**
     * 联系电话
     */
    private String telephone;

    /**
     * 描述
     */
    private String description;

    /**
     * 状态
     */
    private Short state;

    /**
     * 排序
     */
    private short sort;

    public GpsManufacturer()
    {
        super();
    }

    public GpsManufacturer(Integer id)
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
        return "GpsManufacturer [address=" + address + ", description=" + description + ", id=" + id + ", name=" + name
                + ", sort=" + sort + ", state=" + state + ", telephone=" + telephone + "]";
    }

}
