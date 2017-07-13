package com.gimis.emcs.cachedao.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.gimis.emcs.cachedao.AlarmCacheDao;
import com.gimis.emcs.domain.vo.CanAlarm;

public class AlarmCacheDaoImpl extends AbstractCommonCacheDao implements
		AlarmCacheDao {

	private static final String NAMESPACE_ALARM = "alarm";

	public Map<String, CanAlarm> queryAlarmMap(Integer machineryId,
			Integer alarmMark) {
		// TODO Auto-generated method stub
		Map<String, CanAlarm> result = null;
		if (null != machineryId && null != alarmMark) {
			Set<String> ckeys = this.queryAlarmNo(machineryId, alarmMark);
			if (null != ckeys && ckeys.size() > 0) {
				result = new HashMap<String, CanAlarm>();
				Map<String, String> tmap = null;
				CanAlarm alarm = null;
				for (String c : ckeys) {
					// alarm#systemId:machineryId:alarmNo-alarmMark
					c = this.getNameSpace(NAMESPACE_ALARM) + KEY_SPLIT
							+ machineryId + KEY_SPLIT + c + KEY_SEPREATE
							+ alarmMark;
					tmap = jedisClusterFactory.getResource().hgetAll(c);
					if (null == tmap)
						continue;
					alarm = new CanAlarm(tmap);
					result.put(alarm.getAlarmNo(), alarm);
				}
			}
		}
		return result;
	}

	public Set<String> queryAlarmNo(Integer machineryId, Integer alarmMark) {
		if (null == machineryId || null == alarmMark) {
			return null;
		}
		// alarm#systemId:machineryId-alarmMark
		String key = this.getNameSpace(NAMESPACE_ALARM) + KEY_SPLIT
				+ machineryId + KEY_SEPREATE + alarmMark;
		Set<String> ckeys = jedisClusterFactory.getResource().smembers(key);
		return ckeys;
	}

	public void addAlarm(Integer machineryId, Map<String, CanAlarm> alarmMap) {
		if (null != machineryId && null != alarmMap && alarmMap.size() > 0) {
			for (Entry<String, CanAlarm> tmp : alarmMap.entrySet()) {
				this.addAlarm(machineryId, tmp.getValue(), null);
			}
		}
	}

	public void addAlarm(Integer machineryId, CanAlarm alarm, Integer alarmMark) {
		// TODO Auto-generated method stub
		if (null == machineryId || null == alarm
				|| null == alarm.getUpdateMap()
				|| alarm.getUpdateMap().size() == 0
				|| (null == alarmMark && null == alarm.getAlarmMark())) {
			return;
		}
		if (null == alarmMark) {
			alarmMark = alarm.getAlarmMark().intValue();
		}
		// 增加报警车辆集合 alarm#systemId-alarmMark
		String key = this.getNameSpace(NAMESPACE_ALARM) + KEY_SEPREATE
				+ alarmMark;
		jedisClusterFactory.getResource().sadd(key, machineryId.toString());
		// 增加单车报警类型集合 alarm#systemId:machineryId-alarmMark
		key = this.getNameSpace(NAMESPACE_ALARM) + KEY_SPLIT + machineryId
				+ KEY_SEPREATE + alarmMark;
		jedisClusterFactory.getResource().sadd(key, alarm.getAlarmNo());
		// 更新报警信息 alarm#systemId:machineryId:alarmNo-alarmMark
		key = this.getNameSpace(NAMESPACE_ALARM) + KEY_SPLIT + machineryId
				+ KEY_SPLIT + alarm.getAlarmNo() + KEY_SEPREATE + alarmMark;
		jedisClusterFactory.getResource().hmset(key, alarm.getUpdateMap());
	}

	public void deleteAlarm(Integer machineryId, String alarmNo,
			Integer alarmMark) {
		// TODO Auto-generated method stub
		if (null == machineryId || null == alarmNo || null == alarmMark) {
			return;
		}
		// 删除报警信息 alarm#systemId:machineryId:alarmNo-alarmMark
		String key = this.getNameSpace(NAMESPACE_ALARM) + KEY_SPLIT
				+ machineryId + KEY_SPLIT + alarmNo + KEY_SEPREATE + alarmMark;
		jedisClusterFactory.getResource().del(key);
		// 更新单车报码警集合 alarm#systemId:machineryId-alarmMark
		key = this.getNameSpace(NAMESPACE_ALARM) + KEY_SPLIT + machineryId
				+ KEY_SEPREATE + alarmMark;
		jedisClusterFactory.getResource().srem(key, alarmNo.toString());
		// 判断车辆是否有报警，若没有报警则删除故障车辆集合 alarm#systemId-alarmMark
		Set<String> set = jedisClusterFactory.getResource().smembers(key);
		if (null == set || set.size() <= 0) {
			key = this.getNameSpace(NAMESPACE_ALARM) + KEY_SEPREATE + alarmMark;
			jedisClusterFactory.getResource().srem(key, machineryId.toString());
		}
	}

}
