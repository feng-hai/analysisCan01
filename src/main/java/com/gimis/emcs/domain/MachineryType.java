
package com.gimis.emcs.domain;

public class MachineryType
{
    private Integer id;

    /**
     * 设备类型名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 排序
     */
    private Short sort;

    /**
     * 状态，0：正常；1：无效（已删除）
     */
    private Short state;

    /**
     * 平台编号
     */
    private Integer systemId;

    public MachineryType()
    {
        super();
    }

    /**
     * @param id
     */
    public MachineryType(Integer id)
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

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Short getSort()
    {
        return sort;
    }

    public void setSort(Short sort)
    {
        this.sort = sort;
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
        return "MachineryType [id=" + id + ", name=" + name + ", description=" + description + ", sort=" + sort
                + ", state=" + state + ",systemId=" + systemId + "]";
    }
}
