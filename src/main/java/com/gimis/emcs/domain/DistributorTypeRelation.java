
package com.gimis.emcs.domain;


/**
 * 
* 经销商类型关系实体类<p> 
* [功能详细描述]<p> 
* @version 1.0, 2014-3-25 
* @see 
* @since V1.0
 */
public class DistributorTypeRelation
{
    /**
     * 关系ID
     */
    private Integer id;

    /**
     * 经销商ID
     */
    private Integer distributorId;

    /**
     * 机械类型ID
     */
    private Integer machineryTypeId;

    /**
     * 状态
     */
    private Short state;

    /**
     * @return the id
     */
    public Integer getId()
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id)
    {
        this.id = id;
    }

    /**
     * @return the distributorId
     */
    public Integer getDistributorId()
    {
        return distributorId;
    }

    /**
     * @param distributorId the distributorId to set
     */
    public void setDistributorId(Integer distributorId)
    {
        this.distributorId = distributorId;
    }

    /**
     * @return the machineryTypeId
     */
    public Integer getMachineryTypeId()
    {
        return machineryTypeId;
    }

    /**
     * @param machineryTypeId the machineryTypeId to set
     */
    public void setMachineryTypeId(Integer machineryTypeId)
    {
        this.machineryTypeId = machineryTypeId;
    }

    /**
     * @return the state
     */
    public Short getState()
    {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(Short state)
    {
        this.state = state;
    }

    @Override
    public String toString()
    {
        return "DistributorTypeRelation [distributorId=" + distributorId + ", id=" + id + ", machineryTypeId="
                + machineryTypeId + ", state=" + state + "]";
    }
}
