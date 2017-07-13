package com.gimis.emcs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.gimis.emcs.dao.AlarmMachineryLogDao;
import com.gimis.emcs.domain.AlarmMachinery;
import com.gimis.emcs.util.C3P0DBUtil;
import com.gimis.emcs.util.LogUtil;

/**
 * 车辆报警信息Dao
* [一句话功能简述]<p>
* [功能详细描述]<p>
* @author yanshuai
* @version 1.0, 2016年11月28日
* @see
* @since V1.0
 */
/**
 * @author FH
 *
 */
public class AlarmMachineryLogDaoImpl implements AlarmMachineryLogDao {

	private static final String BATCH_INSERT = "insert into bs_alarm_machinery_log(MACHINERY_ID, ALARM_TYPE_ID, BEGIN_TIME, BEGIN_LONGITUDE,BEGIN_LATITUDE) "
			+ " values(?,?,?,?,?)";

	private static final String BATCH_INSERT_NEW = "insert into bs_fault_machinery_current_log(MACHINERY_ID, ALARM_TYPE_ID, BEGIN_TIME, BEGIN_LONGITUDE,BEGIN_LATITUDE) "
			+ " values(?,?,?,?,?)";

	private static final String BATCH_UPDATE = "update bs_alarm_machinery_log log "
			+ " left join bs_alarm_definition def on def.id = log.ALARM_TYPE_ID "
			+ " set log.END_TIME = ?, log.END_LONGITUDE=?, log.END_LATITUDE=? "
			+ " WHERE log.MACHINERY_ID=? AND log.ALARM_TYPE_ID=? " + " AND log.End_Time is null ";

	private static final String BATCH_UPDATE_NEW = "update bs_fault_machinery_current_log log "
			+ " left join bs_alarm_definition def on def.id = log.ALARM_TYPE_ID "
			+ " set log.END_TIME = ?, log.END_LONGITUDE=?, log.END_LATITUDE=? "
			+ " WHERE log.MACHINERY_ID=? AND log.ALARM_TYPE_ID=? " + " AND log.End_Time is null ";

	public void add(List<AlarmMachinery> list) {
		addNewAlarm(list);
		// TODO Auto-generated method stub
		if (null == list || list.size() == 0) {
			return;
		}
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			long start = new Date().getTime();
			con = C3P0DBUtil.getConnection();
			con.setAutoCommit(false);
			pstm = con.prepareStatement(BATCH_INSERT);
			for (AlarmMachinery fm : list) {
				try {
					pstm.setInt(1, fm.getMachineryEquipment().getId());
					pstm.setInt(2, fm.getAlarmDefinition().getId());
					pstm.setTimestamp(3, new Timestamp(fm.getBeginTime().getTime()));
					pstm.setDouble(4, fm.getBeginLongitude());
					pstm.setDouble(5, fm.getBeginLatitude());
					pstm.addBatch();
				} catch (SQLException e) {
					LogUtil.getLogger(this).error("插入报警表[" + fm + "]异常!", e);
				}
			}
			pstm.executeBatch();
			con.commit();
			long end = new Date().getTime();
			LogUtil.getLogger(this).debug("插入报警 " + list.size() + " 条记录 " + (end - start) + " ms！");
		} catch (SQLException e) {
			LogUtil.getLogger(this).error("SQL执行异常", e);
		} finally {
			C3P0DBUtil.attemptClose(pstm);
			C3P0DBUtil.attemptClose(con);
		}
	}

	public void updateAlarmEnd(List<AlarmMachinery> list) {
		// TODO Auto-generated method stub
		if (null == list || list.size() == 0) {
			return;
		}
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			long start = new Date().getTime();
			con = C3P0DBUtil.getConnection();
			pstm = con.prepareStatement(BATCH_UPDATE);
			for (AlarmMachinery fm : list) {
				try {
					pstm.setTimestamp(1, new Timestamp(fm.getEndTime().getTime()));
					pstm.setDouble(2, fm.getEndLongitude());
					pstm.setDouble(3, fm.getEndLatitude());
					pstm.setInt(4, fm.getMachineryEquipment().getId());
					pstm.setInt(5, fm.getAlarmDefinition().getId());
					pstm.addBatch();
				} catch (SQLException e) {
					LogUtil.getLogger(this).error("插入报警表[" + fm + "]异常!", e);
				}
			}
			pstm.executeBatch();
			long end = new Date().getTime();
			LogUtil.getLogger(this).debug("更新报警 " + list.size() + " 条记录 " + (end - start) + " ms！");
		} catch (SQLException e) {
			LogUtil.getLogger(this).error("SQL执行异常", e);
		} finally {
			C3P0DBUtil.attemptClose(pstm);
			C3P0DBUtil.attemptClose(con);
		}
	}

	public void add(AlarmMachinery am) {
		// TODO Auto-generated method stub
		if (null == am) {
			return;
		}
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = C3P0DBUtil.getConnection();
			pstm = con.prepareStatement(BATCH_INSERT);
			try {
				pstm.setInt(1, am.getMachineryEquipment().getId());
				pstm.setInt(2, am.getAlarmDefinition().getId());
				pstm.setTimestamp(3, new Timestamp(am.getBeginTime().getTime()));
				pstm.setDouble(4, am.getBeginLongitude());
				pstm.setDouble(5, am.getBeginLatitude());
			} catch (SQLException e) {
				LogUtil.getLogger(this).error("插入报警表[" + am + "]异常!", e);
			}
			pstm.executeUpdate();
			LogUtil.getLogger(this).debug("插入报警 " + am);
		} catch (SQLException e) {
			LogUtil.getLogger(this).error("SQL执行异常", e);
		} finally {
			C3P0DBUtil.attemptClose(pstm);
			C3P0DBUtil.attemptClose(con);
		}
	}

	/**
	 * 跟新新表的列表
	 * 
	 * @param list
	 */
	public void addNewAlarm(List<AlarmMachinery> list) {

		updateNewAlarm(list);
		// TODO Auto-generated method stub
		if (null == list || list.size() == 0) {
			return;
		}
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			long start = new Date().getTime();
			con = C3P0DBUtil.getConnection();
			con.setAutoCommit(false);
			pstm = con.prepareStatement(BATCH_INSERT_NEW);
			for (AlarmMachinery fm : list) {
				try {
					pstm.setInt(1, fm.getMachineryEquipment().getId());
					pstm.setInt(2, fm.getAlarmDefinition().getId());
					pstm.setTimestamp(3, new Timestamp(fm.getBeginTime().getTime()));
					pstm.setDouble(4, fm.getBeginLongitude());
					pstm.setDouble(5, fm.getBeginLatitude());
					pstm.addBatch();
				} catch (SQLException e) {
					LogUtil.getLogger(this).error("插入报警表[" + fm + "]异常!", e);
				}
			}
			pstm.executeBatch();
			con.commit();
			long end = new Date().getTime();
			LogUtil.getLogger(this).debug("插入报警 " + list.size() + " 条记录 " + (end - start) + " ms！");
		} catch (SQLException e) {
			LogUtil.getLogger(this).error("SQL执行异常", e);
		} finally {
			C3P0DBUtil.attemptClose(pstm);
			C3P0DBUtil.attemptClose(con);
		}

	}

	public void updateNewAlarm(List<AlarmMachinery> list) {
		// TODO Auto-generated method stub
		if (null == list || list.size() == 0) {
			return;
		}
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			long start = new Date().getTime();
			con = C3P0DBUtil.getConnection();
			pstm = con.prepareStatement(BATCH_UPDATE_NEW);
			for (AlarmMachinery fm : list) {
				try {
					pstm.setTimestamp(1, new Timestamp(fm.getEndTime().getTime()));
					pstm.setDouble(2, fm.getEndLongitude());
					pstm.setDouble(3, fm.getEndLatitude());
					pstm.setInt(4, fm.getMachineryEquipment().getId());
					pstm.setInt(5, fm.getAlarmDefinition().getId());
					pstm.addBatch();
				} catch (SQLException e) {
					LogUtil.getLogger(this).error("插入报警表[" + fm + "]异常!", e);
				}
			}
			pstm.executeBatch();
			long end = new Date().getTime();
			LogUtil.getLogger(this).debug("更新报警 " + list.size() + " 条记录 " + (end - start) + " ms！");
		} catch (SQLException e) {
			LogUtil.getLogger(this).error("SQL执行异常", e);
		} finally {
			C3P0DBUtil.attemptClose(pstm);
			C3P0DBUtil.attemptClose(con);
		}

	}

}
