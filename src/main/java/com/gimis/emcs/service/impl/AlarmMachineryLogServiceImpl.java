
package com.gimis.emcs.service.impl;

import java.util.List;

import com.gimis.emcs.dao.AlarmMachineryLogDao;
import com.gimis.emcs.dao.impl.AlarmMachineryLogDaoImpl;
import com.gimis.emcs.domain.AlarmMachinery;
import com.gimis.emcs.service.AlarmMachineryLogService;

public class AlarmMachineryLogServiceImpl implements AlarmMachineryLogService
{

    private AlarmMachineryLogDao alarmMachineryLogDao;

    public AlarmMachineryLogServiceImpl()
    {
        alarmMachineryLogDao = new AlarmMachineryLogDaoImpl();
    }

    public void add(List<AlarmMachinery> list)
    {
        alarmMachineryLogDao.add(list);
    }

    public void updateAlarmEnd(List<AlarmMachinery> list)
    {
        alarmMachineryLogDao.updateAlarmEnd(list);
    }

    public void add(AlarmMachinery am)
    {
        alarmMachineryLogDao.add(am);
    }

}
