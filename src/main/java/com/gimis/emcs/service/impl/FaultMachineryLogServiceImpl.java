
package com.gimis.emcs.service.impl;

import java.util.List;

import com.gimis.emcs.dao.FaultMachineryLogDao;
import com.gimis.emcs.dao.impl.FaultMachineryLogDaoImpl;
import com.gimis.emcs.domain.FaultMachinery;
import com.gimis.emcs.service.FaultMachineryLogService;

public class FaultMachineryLogServiceImpl implements FaultMachineryLogService
{

    private FaultMachineryLogDao faultMachineryLogDao;

    public FaultMachineryLogServiceImpl()
    {
        faultMachineryLogDao = new FaultMachineryLogDaoImpl();
    }

    public void add(List<FaultMachinery> list)
    {
        faultMachineryLogDao.add(list);
    }

    public void updateAlarmEnd(List<FaultMachinery> list)
    {
        faultMachineryLogDao.updateAlarmEnd(list);
    }

    public List<FaultMachinery> queryList()
    {
        return faultMachineryLogDao.queryList();
    }

    public void add(FaultMachinery fm)
    {
        faultMachineryLogDao.add(fm);
    }

}
