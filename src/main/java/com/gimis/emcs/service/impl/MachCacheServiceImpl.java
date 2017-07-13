
package com.gimis.emcs.service.impl;

import java.util.Map;
import java.util.Map.Entry;

import com.gimis.emcs.cachedao.AlarmCacheDao;
import com.gimis.emcs.cachedao.MachCacheDao;
import com.gimis.emcs.cachedao.impl.AlarmCacheDaoImpl;
import com.gimis.emcs.cachedao.impl.MachCacheDaoImpl;
import com.gimis.emcs.domain.vo.CanAlarm;
import com.gimis.emcs.domain.vo.MachCache;
import com.gimis.emcs.service.MachCacheService;

public class MachCacheServiceImpl implements MachCacheService
{

    private MachCacheDao machCacheDao;

    private AlarmCacheDao alarmCacheDao;

    public MachCacheServiceImpl()
    {
        machCacheDao = new MachCacheDaoImpl();
        alarmCacheDao = new AlarmCacheDaoImpl();
    }

    public MachCache queryMachAlarm(Integer machineryId)
    {
        MachCache cache = machCacheDao.queryMach(machineryId);
        if (null != cache)
        {
            Map<String, CanAlarm> tm = alarmCacheDao.queryAlarmMap(cache.getId(), 0);
            if (null != tm && tm.size() > 0)
            {
                for (Entry<String, CanAlarm> entry : tm.entrySet())
                {
                    cache.addCanAlarm(entry.getValue());
                }
            }
        }
        return cache;
    }

    public void updateMachAlarm(MachCache machCache)
    {
        // 更新车辆基本信息
        machCacheDao.updateMach(machCache);
        // 更新故障信息
        alarmCacheDao.addAlarm(machCache.getId(), machCache.getCanAlarms());
    }

    public void deleteMachAlarm(Integer machineryId , String alarmNo , Byte alarmMark)
    {
        if (null != machineryId && null != alarmNo && null != alarmMark)
        {
            alarmCacheDao.deleteAlarm(machineryId, alarmNo, alarmMark.intValue());
        }
    }

}
