package com.gimis.emcs.domain;

import java.util.Map;

public class FaultDefinition {
	private Integer id;

    /**
     * 故障码
     */
    private String faultCode;

    private String spn;

    private String fmi;

    /**
     * 故障部件
     */
    private String faultPart;

    /**
     * 故障名称
     */
    private String faultName;

    /**
     * 故障等级
     */
    private Short faultLevel;

    /**
     * 故障源
     */
    private Integer faultSource;

    /**
     * 故障描述
     */
    private String faultDescription;

    /**
     * 记录状态
     */
    private Short state;

    /**
     * 车辆类型
     */
    private Integer analyzeType;

    public FaultDefinition()
    {
        super();
    }

    public FaultDefinition(String faultCode)
    {
        super();
        this.faultCode = faultCode;
    }

    public FaultDefinition(Map<String, String> beanMap)
    {
        if (null == beanMap || beanMap.size() == 0)
            return;

        if (null != beanMap.get("id") && false == "".equals(beanMap.get("id")))
        {
            this.setId(Integer.parseInt(beanMap.get("id")));
        }
        if (null != beanMap.get("faultCode") && false == "".equals(beanMap.get("faultCode")))
        {
            this.setFaultCode(beanMap.get("faultCode"));
        }
        if (null != beanMap.get("spn") && false == "".equals(beanMap.get("spn")))
        {
            this.setFaultCode(beanMap.get("spn"));
        }
        if (null != beanMap.get("fmi") && false == "".equals(beanMap.get("fmi")))
        {
            this.setFaultCode(beanMap.get("fmi"));
        }
        if (null != beanMap.get("faultPart") && false == "".equals(beanMap.get("faultPart")))
        {
            this.setFaultPart(beanMap.get("faultPart"));
        }
        if (null != beanMap.get("faultName") && false == "".equals(beanMap.get("faultName")))
        {
            this.setFaultName(beanMap.get("faultName"));
        }
        if (null != beanMap.get("faultLevel") && false == "".equals(beanMap.get("faultLevel")))
        {
            this.setFaultLevel(Short.parseShort(beanMap.get("faultLevel")));
        }
        if (null != beanMap.get("faultSource") && false == "".equals(beanMap.get("faultSource")))
        {
            this.setFaultSource(Integer.parseInt(beanMap.get("faultSource")));
        }
        if (null != beanMap.get("faultDescription") && false == "".equals(beanMap.get("faultDescription")))
        {
            this.setFaultDescription(beanMap.get("faultDescription"));
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

    public String getFaultCode()
    {
        return faultCode;
    }

    public void setFaultCode(String faultCode)
    {
        this.faultCode = faultCode;
    }

    public String getFaultPart()
    {
        return faultPart;
    }

    public void setFaultPart(String faultPart)
    {
        this.faultPart = faultPart;
    }

    public String getFaultName()
    {
        return faultName;
    }

    public void setFaultName(String faultName)
    {
        this.faultName = faultName;
    }

    public Short getFaultLevel()
    {
        return faultLevel;
    }

    public void setFaultLevel(Short faultLevel)
    {
        this.faultLevel = faultLevel;
    }

    public Integer getFaultSource()
    {
        return faultSource;
    }

    public void setFaultSource(Integer faultSource)
    {
        this.faultSource = faultSource;
    }

    /**
     * @return the spn
     */
    public String getSpn()
    {
        return spn;
    }

    /**
     * @param spn the spn to set
     */
    public void setSpn(String spn)
    {
        this.spn = spn;
    }

    /**
     * @return the fmi
     */
    public String getFmi()
    {
        return fmi;
    }

    /**
     * @param fmi the fmi to set
     */
    public void setFmi(String fmi)
    {
        this.fmi = fmi;
    }

    public String getFaultDescription()
    {
        return faultDescription;
    }

    public void setFaultDescription(String faultDescription)
    {
        this.faultDescription = faultDescription;
    }

    public Short getState()
    {
        return state;
    }

    public void setState(Short state)
    {
        this.state = state;
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
        return "FaultDefinition [id=" + id + ", faultCode=" + faultCode + ", spn=" + spn + ", fmi=" + fmi
                + ", faultPart=" + faultPart + ", faultName=" + faultName + ", faultLevel=" + faultLevel
                + ", faultSource=" + faultSource + ", faultDescription=" + faultDescription + ", state=" + state
                + ", analyzeType=" + analyzeType + "]";
    }

}
