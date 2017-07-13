
package com.gimis.emcs.domain;

public class BusLine
{

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 公交路线名称
     */
    private String name;

    /**
     * 所属公交公司
     */
    private BusCompany busCompany;

    /**
     * 公交路线信息
     */
    private String busLineInfo;

    /**
     * 排序
     */
    private Short sort;

    /**
     * 状态
     */
    private Short state;

    public BusLine()
    {
        super();
    }

    /**
     * @param id
     */
    public BusLine(Integer id)
    {
        super();
        this.id = id;
    }

    /**
     * @param id
     * @param name
     */
    public BusLine(Integer id, String name)
    {
        super();
        this.id = id;
        this.name = name;
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

    public BusCompany getBusCompany()
    {
        return busCompany;
    }

    public void setBusCompany(BusCompany busCompany)
    {
        this.busCompany = busCompany;
    }

    public Integer getBusCompanyId()
    {
        return (this.busCompany == null ? null : this.busCompany.getId());
    }

    public Short getSort()
    {
        return sort;
    }

    public void setSort(Short sort)
    {
        this.sort = sort;
    }

    public String getBusLineInfo()
    {
        return busLineInfo;
    }

    public void setBusLineInfo(String busLineInfo)
    {
        this.busLineInfo = busLineInfo;
    }

    public Short getState()
    {
        return state;
    }

    public void setState(Short state)
    {
        this.state = state;
    }

    @Override
    public String toString()
    {
        return "BusLine [id=" + id + ", name=" + name + ", busCompany=" + busCompany + ", busLineInfo=" + busLineInfo
                + ", sort=" + sort + ", state=" + state + "]";
    }

}
