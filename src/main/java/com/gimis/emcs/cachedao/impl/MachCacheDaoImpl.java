package com.gimis.emcs.cachedao.impl;

import java.util.Map;

import com.gimis.emcs.cachedao.MachCacheDao;
import com.gimis.emcs.domain.vo.MachCache;

/**
 * Mach Cache Dao实现类
 * @author lion
 *
 */
public class MachCacheDaoImpl extends AbstractCommonCacheDao implements MachCacheDao {

	private static final String NAMESPACE_MACH = "mach";

	public MachCache queryMach(Integer machineryId) {
		// TODO Auto-generated method stub

		if (null == machineryId) {
			return null;
		}

		String key = this.getNameSpace(NAMESPACE_MACH) + KEY_SPLIT
				+ machineryId;
		MachCache obj = null;
		Map<String, String> result = jedisClusterFactory.getResource().hgetAll(
				key);

		if (null != result && result.keySet().size() > 0) {
			obj = new MachCache(result);
		}
		return obj;
	}

	public void updateMach(MachCache mach) {
		// TODO Auto-generated method stub
		updateMach(mach.getId(), mach.getUpdateMap());
	}

	public void updateMach(Integer machineryId, Map<String, String> param) {
		// TODO Auto-generated method stub
		if (null == machineryId || null == param || param.size() == 0)
        {
            return;
        }
        String key = this.getNameSpace(NAMESPACE_MACH) + KEY_SPLIT + machineryId;
        jedisClusterFactory.getResource().hmset(key, param);
        //更新车辆ID集合
        jedisClusterFactory.getResource().sadd(this.getNameSpace(NAMESPACE_MACH), machineryId.toString());
	}

}
