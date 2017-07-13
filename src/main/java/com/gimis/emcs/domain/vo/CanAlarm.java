/**
 * 
 */

package com.gimis.emcs.domain.vo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.gimis.emcs.domain.RedisModel;
import com.gimis.emcs.domain.util.DateFormatUtil;

/**
 * [一句话功能简述]<p>
 * [功能详细描述]<p>
 * @author LiuHouJun
 * @version 2.0, 2015年5月25日

 * @since gframe-v100
 */
public class CanAlarm implements RedisModel<Integer>
{

    /**
     * 车辆ID
     */
    private Integer machineryId;

    /**
     * 报警故障码
     */
    private String alarmNo;

    /**
     * 报警时间
     */
    private Date alarmTime;

    /**
     * 经度
     */
    private Double longitude;

    /**
     * 纬度
     */
    private Double latitude;

    /**
     * 0:系统故障码  1:阈值故障码
     */
    private Byte alarmMark;

    /**
     * 需要更新到内存的属性集合
     */
    protected Map<String, String> updateMap = new HashMap<String, String>();

    /**
     * jersey在实现时绑定的类需要提供一个默认的无参构造函数
     */
    public CanAlarm()
    {

    }

    /**
     * @param machineryId
     * @param alarmNo
     * @param alarmTime
     * @param alarmMark
     * @param longitude
     * @param latitude
     */
    public CanAlarm(Integer machineryId, String alarmNo, Date alarmTime, Byte alarmMark, Double longitude,
            Double latitude)
    {
        super();
        this.setMachineryId(machineryId);
        this.setAlarmNo(alarmNo);
        this.setAlarmTime(alarmTime);
        this.setAlarmMark(alarmMark);
        this.setLongitude(longitude);
        this.setLatitude(latitude);
    }

    public CanAlarm(Map<String, String> beanMap)
    {
        if (null == beanMap || beanMap.size() == 0)
        {
            return;
        }
        if (null != beanMap.get("machineryId") && false == "".equals(beanMap.get("machineryId")))
        {
            this.machineryId = Integer.parseInt(beanMap.get("machineryId"));
        }
        if (null != beanMap.get("alarmNo") && false == "".equals(beanMap.get("alarmNo")))
        {
            this.alarmNo = beanMap.get("alarmNo");
        }
        if (null != beanMap.get("alarmTime") && false == "".equals(beanMap.get("alarmTime")))
        {
            this.alarmTime = DateFormatUtil.parseWithoutThrowException(beanMap.get("alarmTime"),
                    DateFormatUtil.DEFAULT_DATETIME_PATTERN);
        }
        if (null != beanMap.get("longitude") && false == "".equals(beanMap.get("longitude")))
        {
            this.longitude = Double.parseDouble(beanMap.get("longitude"));
        }
        if (null != beanMap.get("latitude") && false == "".equals(beanMap.get("latitude")))
        {
            this.latitude = Double.parseDouble(beanMap.get("latitude"));
        }
        if (null != beanMap.get("alarmMark") && false == "".equals(beanMap.get("alarmMark")))
        {
            this.alarmMark = Byte.parseByte(beanMap.get("alarmMark"));
        }
    }

    /**
     * @param machineryId the machineryId to set
     */
    public void setMachineryId(Integer machineryId)
    {
        this.setBeanMapFiled("machineryId", this.machineryId, machineryId);
        this.machineryId = machineryId;
    }

    /**
     * @param alarmNo the alarmNo to set
     */
    public void setAlarmNo(String alarmNo)
    {
        this.setBeanMapFiled("alarmNo", this.alarmNo, alarmNo);
        this.alarmNo = alarmNo;
    }

    /**
     * @param alarmTime the alarmTime to set
     */
    public void setAlarmTime(Date alarmTime)
    {
        this.setBeanMapFiled("alarmTime", this.alarmTime, alarmTime);
        this.alarmTime = alarmTime;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(Double longitude)
    {
        this.setBeanMapFiled("longitude", this.longitude, longitude);
        this.longitude = longitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(Double latitude)
    {
        this.setBeanMapFiled("latitude", this.latitude, latitude);
        this.latitude = latitude;
    }

    /**
     * @param alarmMark the alarmMark to set
     */
    public void setAlarmMark(Byte alarmMark)
    {
        this.setBeanMapFiled("alarmMark", this.alarmMark, alarmMark);
        this.alarmMark = alarmMark;
    }

    /**
     * @return the alarmMark
     */
    public Byte getAlarmMark()
    {
        return alarmMark;
    }

    /**
     * @return the machineryId
     */
    public Integer getMachineryId()
    {
        return machineryId;
    }

    /**
     * @return the alarmNo
     */
    public String getAlarmNo()
    {
        return alarmNo;
    }

    /**
     * @return the alarmTime
     */
    public Date getAlarmTime()
    {
        return alarmTime;
    }

    /**
     * @return the longitude
     */
    public Double getLongitude()
    {
        return longitude;
    }

    /**
     * @return the latitude
     */
    public Double getLatitude()
    {
        return latitude;
    }

    
    public Integer getId()
    {
        return this.machineryId;
    }

    
    public Map<String, String> getUpdateMap()
    {
        return this.updateMap;
    }

    /**
     * 所有的子类的set方法必须调用该方法
     * @param filed
     * @param value
     */
    private void setBeanMapFiled(String filed , Object oldObj , Object newObj)
    {
        if (null == filed || "".equals(filed) || null == newObj)
            return;
        boolean isChange = false;
        if (!newObj.equals(oldObj))
            isChange = true;
        if (newObj instanceof Number)
        {
            if (isChange)
                this.updateMap.put(filed, newObj + "");
        }
        else if (newObj instanceof Date)
        {
            String date = DateFormatUtil.formatDateTime((Date) newObj);
            if (isChange)
                this.updateMap.put(filed, date);
        }
        else if (newObj instanceof String)
        {
            if (isChange)
                this.updateMap.put(filed, (String) newObj);
        }
        else
        {
            if (isChange)
                this.updateMap.put(filed, newObj.toString());
        }
    }
    
    public String toString()
    {
        return "CanAlarm [machineryId=" + machineryId + ", alarmNo=" + alarmNo + ", alarmTime=" + alarmTime
                + ", longitude=" + longitude + ", latitude=" + latitude + ", alarmMark=" + alarmMark + ", updateMap="
                + updateMap + "]";
    }
}
