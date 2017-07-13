
package com.gimis.emcs.domain.vo;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.gimis.emcs.domain.util.DateFormatUtil;

public class CanData implements Serializable
{
    private static final long serialVersionUID = -708180498733565501L;

    private Integer machineryId;

    private String canId;

    /**
     * 存放查询所得的该canId下所有属性的值，key为属性名
     */
    private Map<String, String> data = new HashMap<String, String>();

    /**
     * 此MAP中未包含该can帧中所有的属性，仅供查询时的条件对比使用
     */
    private Map<String, Object> objectData = new HashMap<String, Object>();

    /**
     * 存放值发生变化的属性，用于更新redis
     */
    private Map<String, String> updateMap = new HashMap<String, String>();

    /**
     * jersey在实现时绑定的类需要提供一个默认的无参构造函数
     */
    public CanData()
    {

    }

    public CanData(Integer machineryId, String canId, Map<String, String> data)
    {
        this.machineryId = machineryId;
        this.canId = canId;
        this.setData(data);
    }

    public Integer getMachineryId()
    {
        return machineryId;
    }

    public String getCanId()
    {
        return canId;
    }

    public Map<String, String> getData()
    {
        return this.data;
    }

    public String getData(String key)
    {
        return this.data.get(key);
    }

    public Object getObject(String key)
    {
        return this.objectData.get(key);
    }

    public Map<String, Object> getObjectData()
    {
        return objectData;
    }

    public void setData(Map<String, String> data)
    {
        if (null != data)
        {
            Iterator<String> iter = data.keySet().iterator();
            String key = null;
            String value = null;
            while (iter.hasNext())
            {
                key = iter.next();
                value = data.get(key);
                this.data.put(key, value);
                this.objectData.put(key, value);
            }
        }
    }


    /**
     * 格式化number类型
     * @param data
     * @param pattern
     * @return
     */
    protected String formatNumber(Number data , Double ratio , String pattern)
    {
        if (null == data)
        {
            return null;
        }
        DecimalFormat df = new DecimalFormat(pattern);
        if (null != ratio)
        {
            return df.format(data.doubleValue() * ratio);
        }
        return df.format(data);
    }

    public void update(Map<String, Object> newMap)
    {
        if (null != newMap && newMap.size() > 0)
        {
            Set<Entry<String, Object>> entrys = newMap.entrySet();
            for (Entry<String, Object> entry : entrys)
            {
                this.update(entry.getKey(), this.data.get(entry.getKey()), entry.getValue());
            }
        }
    }

    private void update(String filed , String oldObj , Object newObj)
    {

        if (null == filed || "".equals(filed) || null == newObj)
            return;
        String newValue = "";
        if (newObj instanceof Number)
        {
            newValue = newObj + "";
        }
        else if (newObj instanceof Date)
        {
            newValue = DateFormatUtil.formatDateTime((Date) newObj);
        }
        else if (newObj instanceof String)
        {
            newValue = (String) newObj;
        }
        else
        {
            newValue = newObj.toString();
        }
        if (null != newValue && (!newValue.equals(oldObj)))
        {
            this.data.put(filed, newValue);
            this.updateMap.put(filed, newValue);
        }

    }

    public Map<String, String> getUpdateMap()
    {
        return this.updateMap;
    }

}
