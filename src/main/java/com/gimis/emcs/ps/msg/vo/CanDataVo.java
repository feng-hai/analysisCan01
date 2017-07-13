package com.gimis.emcs.ps.msg.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

public class CanDataVo implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = -8368612452119798597L;

    /*
     * 当前帧的时间
     */
    private Date time;
       
    /*
     * ID
     */
    private String canId;
    
    /*
     * CAN数据所属通道
     */
    private byte channel;
    
    
    /*
     * 内容
     */
    private String canContent;
    
 
    /*
     * Map集合用于存储解析的内容
     */
    private Map<String,Object> canContentMap;
    
    public Date getTime()
    {
        return time;
    }
    
    public void setTime(long time)
    {
        this.time = new Date(time);
    }
    
    public String getCanId()
    {
        return canId;
    }

    public void setCanId(String canId)
    {
        this.canId = canId;
    }

    public byte getChannel()
    {
        return channel;
    }
    
    public void setChannel(byte channel)
    {
        this.channel = channel;
    }
    
    public String getCanContent()
    {
        return canContent;
    }

    public void setCanContent(String canContent)
    {
        this.canContent = canContent;
    }

  
    public Map<String, Object> getCanContentMap()
    {
        return canContentMap;
    }

    public void setCanContentMap(Map<String, Object> canContentMap)
    {
        this.canContentMap = canContentMap;
    }

    @Override
    public String toString()
    {
        return "CanDataVo [time=" + time + ", canId=" + canId + ", channel=" + channel + ", canContent=" + canContent
                + ", canContentMap=" + canContentMap + "]";
    }
}
