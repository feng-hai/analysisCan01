/**
 * 
 */

package com.gimis.emcs.domain;

import java.util.Date;
import java.util.Map;

import com.gimis.emcs.domain.util.DateFormatUtil;

/**
 * 报警规则定义
 * [一句话功能简述]<p>
 * [功能详细描述]<p>
 * @version 1.0, 2015年3月11日
 * @see
 * @since gframe-v100
 */
public class AlarmDefinition
{


    private Integer id;

    /**
     * 规则名称
     */
    private String name;

    /**
     * 报警等级
     */
    private Short alarmLevel;

    /**
     * 规则表达式
     */
    private String expression;

    /**
     * 支持的类型
     * 字典表定义，如车型、GPS类型等
     */
    private Short fitType;

    /**
     * 支持的类型值
     * 当类型为车辆类型时，该值表示车型ID
     */
    private Integer fitValue;

    /**
     * 备注信息
     */
    private String description;

    /**
     * 创建人
     */
    private User creator;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 记录状态
     */
    private Short state;
    
    /**
     * 车型(协议)
     */
    private Integer analyzeType;

    public AlarmDefinition()
    {
        super();
    }

    public AlarmDefinition(Integer id)
    {
        super();
        this.id = id;
    }

    /**
     * @param id
     * @param alarmLevel
     */
    public AlarmDefinition(Integer id, Short alarmLevel)
    {
        super();
        this.id = id;
        this.alarmLevel = alarmLevel;
    }

    public AlarmDefinition(Map<String, String> beanMap)
    {
        if (null == beanMap || beanMap.size() == 0)
            return;

        if (null != beanMap.get("id") && false == "".equals(beanMap.get("id")))
        {
            this.setId(Integer.parseInt(beanMap.get("id")));
        }
        if (null != beanMap.get("name") && false == "".equals(beanMap.get("name")))
        {
            this.setName(beanMap.get("name"));
        }

        if (null != beanMap.get("alarmLevel") && false == "".equals(beanMap.get("alarmLevel")))
        {
            this.setAlarmLevel(Short.parseShort(beanMap.get("alarmLevel")));
        }
        if (null != beanMap.get("expression") && false == "".equals(beanMap.get("expression")))
        {
            this.setExpression(beanMap.get("expression"));
        }
        if (null != beanMap.get("fitType") && false == "".equals(beanMap.get("fitType")))
        {
            this.setFitType(Short.parseShort(beanMap.get("fitType")));
        }
        if (null != beanMap.get("fitValue") && false == "".equals(beanMap.get("fitValue")))
        {
            this.setFitValue(Integer.parseInt(beanMap.get("fitValue")));
        }
        if (null != beanMap.get("description") && false == "".equals(beanMap.get("description")))
        {
            this.setDescription(beanMap.get("description"));
        }
        if (null != beanMap.get("creator.id") && !"".equals(beanMap.get("creator.id")))
        {
            this.setCreator(new User(Integer.valueOf(beanMap.get("creator.id"))));
        }
        if (null != beanMap.get("createTime") && false == "".equals(beanMap.get("createTime")))
        {
            this.setCreateTime(DateFormatUtil.parseWithoutThrowException(beanMap.get("createTime"),
                    DateFormatUtil.DEFAULT_DATE_PATTERN));
        }
        if (null != beanMap.get("state") && false == "".equals(beanMap.get("state")))
        {
            this.setState(Short.parseShort(beanMap.get("state")));
        }
        if (null != beanMap.get("analyzeType") && false == "".equals(beanMap.get("analyzeType")))
        {
            this.setAnalyzeType(Integer.parseInt(beanMap.get("analyzeType")));
        }
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

    public String getExpression()
    {
        return expression;
    }

    public void setExpression(String expression)
    {
        this.expression = expression;
    }

    public Short getFitType()
    {
        return fitType;
    }

    public void setFitType(Short fitType)
    {
        this.fitType = fitType;
    }

    public Integer getFitValue()
    {
        return fitValue;
    }

    public void setFitValue(Integer fitValue)
    {
        this.fitValue = fitValue;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public User getCreator()
    {
        return creator;
    }

    public void setCreator(User creator)
    {
        this.creator = creator;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Short getState()
    {
        return state;
    }

    public void setState(Short state)
    {
        this.state = state;
    }

    /**
     * @return the alarmLevel
     */
    public Short getAlarmLevel()
    {
        return alarmLevel;
    }

    /**
     * @param alarmLevel the alarmLevel to set
     */
    public void setAlarmLevel(Short alarmLevel)
    {
        this.alarmLevel = alarmLevel;
    }
    
    

    public Integer getAnalyzeType()
    {
        return analyzeType;
    }

    public void setAnalyzeType(Integer analyzeType)
    {
        this.analyzeType = analyzeType;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "AlarmDefinition [id=" + id + ", name=" + name + ", alarmLevel=" + alarmLevel + ", expression="
                + expression + ", fitType=" + fitType + ", fitValue=" + fitValue + ", description=" + description
                + ", creator=" + creator + ", createTime=" + createTime + ", state=" + state + ", analyzeType="
                + analyzeType + "]";
    }


}
