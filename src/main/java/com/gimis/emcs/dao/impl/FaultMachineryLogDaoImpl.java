package com.gimis.emcs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gimis.emcs.dao.FaultMachineryLogDao;
import com.gimis.emcs.domain.FaultDefinition;
import com.gimis.emcs.domain.FaultMachinery;
import com.gimis.emcs.domain.MachineryEquipment;
import com.gimis.emcs.util.C3P0DBUtil;
import com.gimis.emcs.util.LogUtil;

/**
 * 车辆故障信息Dao [一句话功能简述]
 * <p>
 * [功能详细描述]
 * <p>
 * 
 * @author yanshuai
 * @version 1.0, 2016年11月28日
 * @see
 * @since V1.0
 */
public class FaultMachineryLogDaoImpl implements FaultMachineryLogDao {

	public static final String BATCH_INSERT = "insert into bs_fault_machinery_log(MACHINERY_ID, FAULT_CODE, BEGIN_TIME, BEGIN_LONGITUDE,BEGIN_LATITUDE)"
			+ "	values (?,?,?,?,?)";
	public static final String BATCH_INSERT_NEW = "insert into bs_fault_machinery_current_log(MACHINERY_ID, FAULT_CODE, BEGIN_TIME, BEGIN_LONGITUDE,BEGIN_LATITUDE)"
			+ "	values (?,?,?,?,?)";

	public static final String BATCH_UPDATE = "update bs_fault_machinery_log log set log.END_TIME = ?, log.END_LONGITUDE=?, log.END_LATITUDE=? "
			+ " WHERE log.MACHINERY_ID=? AND log.FAULT_CODE=? AND log.End_Time is null limit 1";
	
	public static final String BATCH_UPDATE_NEW = "update bs_fault_machinery_current_log log set log.END_TIME = ?, log.END_LONGITUDE=?, log.END_LATITUDE=? "
			+ " WHERE log.MACHINERY_ID=? AND log.FAULT_CODE=? AND log.End_Time is null limit 1";

	public static final String QUERY_LIST = "select * from bs_fault_machinery_log order by ID desc limit 1000";

	public void add(List<FaultMachinery> list) {
		addNewFault(list);
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
			for (FaultMachinery fm : list) {
				try {
					pstm.setInt(1, fm.getMachineryEquipment().getId());
					pstm.setString(2, fm.getFaultDefinition().getFaultCode());
					pstm.setTimestamp(3, new Timestamp(fm.getBeginTime().getTime()));
					pstm.setDouble(4, fm.getBeginLongitude());
					pstm.setDouble(5, fm.getBeginLatitude());
					pstm.addBatch();
				} catch (SQLException e) {
					// ignore it
				}
			}
			pstm.executeBatch();
			con.commit();
			long end = new Date().getTime();
			LogUtil.getLogger(this).debug("插入故障 " + list.size() + " 条记录 " + (end - start) + " ms！");
		} catch (SQLException e) {
			LogUtil.getLogger(this).error("SQL执行异常", e);
		} finally {
			C3P0DBUtil.attemptClose(pstm);
			C3P0DBUtil.attemptClose(con);
		}
	}

	public void updateAlarmEnd(List<FaultMachinery> list) {
		updateNewFault(list);
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
			for (FaultMachinery fm : list) {
				try {
					pstm.setTimestamp(1, new Timestamp(fm.getEndTime().getTime()));
					pstm.setDouble(2, fm.getEndLongitude());
					pstm.setDouble(3, fm.getEndLatitude());
					pstm.setInt(4, fm.getMachineryEquipment().getId());
					pstm.setString(5, fm.getFaultDefinition().getFaultCode());
					pstm.addBatch();
				} catch (SQLException e) {
					// ignore it
				}
			}
			pstm.executeBatch();
			long end = new Date().getTime();
			LogUtil.getLogger(this).debug("更新故障 " + list.size() + " 条记录 " + (end - start) + " ms！");
		} catch (SQLException e) {
			LogUtil.getLogger(this).error("SQL执行异常", e);
		} finally {
			C3P0DBUtil.attemptClose(pstm);
			C3P0DBUtil.attemptClose(con);
		}
	}

	public List<FaultMachinery> queryList() {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<FaultMachinery> fmList = new ArrayList<FaultMachinery>();
		try {
			con = C3P0DBUtil.getConnection();
			pstm = con.prepareStatement(QUERY_LIST);
			rs = pstm.executeQuery();
			while (rs.next()) {
				FaultMachinery fm = new FaultMachinery();
				fm.setId(rs.getLong(1));
				fm.setMachineryEquipment(new MachineryEquipment(rs.getInt(2)));
				fm.setFaultDefinition(new FaultDefinition(rs.getString(3)));
				fmList.add(fm);
			}
		} catch (SQLException e) {
			LogUtil.getLogger(this).error("SQL执行异常", e);
		} finally {
			C3P0DBUtil.attemptClose(rs);
			C3P0DBUtil.attemptClose(pstm);
			C3P0DBUtil.attemptClose(con);
		}
		return fmList;
	}

	public void add(FaultMachinery fm) {
		// TODO Auto-generated method stub
		if (null == fm) {
			return;
		}
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = C3P0DBUtil.getConnection();
			pstm = con.prepareStatement(BATCH_INSERT);
			try {
				pstm.setInt(1, fm.getMachineryEquipment().getId());
				pstm.setString(2, fm.getFaultDefinition().getFaultCode());
				pstm.setTimestamp(3, new Timestamp(fm.getBeginTime().getTime()));
				pstm.setDouble(4, fm.getBeginLongitude());
				pstm.setDouble(5, fm.getBeginLatitude());
			} catch (SQLException e) {
				// ignore it
				e.printStackTrace();
			}
			pstm.executeUpdate();
			LogUtil.getLogger(this).debug("插入故障表 " + fm.getMachineryId());
		} catch (SQLException e) {
			LogUtil.getLogger(this).error("SQL执行异常", e);
		} finally {
			C3P0DBUtil.attemptClose(pstm);
			C3P0DBUtil.attemptClose(con);
		}
	}

	/**
	 * 
	 * 添加报警数据
	 * @param list
	 */
	public void addNewFault(List<FaultMachinery> list) {

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
			for (FaultMachinery fm : list) {
				try {
					pstm.setInt(1, fm.getMachineryEquipment().getId());
					pstm.setString(2, fm.getFaultDefinition().getFaultCode());
					pstm.setTimestamp(3, new Timestamp(fm.getBeginTime().getTime()));
					pstm.setDouble(4, fm.getBeginLongitude());
					pstm.setDouble(5, fm.getBeginLatitude());
					pstm.addBatch();
				} catch (SQLException e) {
					// ignore it
				}
			}
			pstm.executeBatch();
			con.commit();
			long end = new Date().getTime();
			LogUtil.getLogger(this).debug("插入故障 " + list.size() + " 条记录 " + (end - start) + " ms！");
		} catch (SQLException e) {
			LogUtil.getLogger(this).error("SQL执行异常", e);
		} finally {
			C3P0DBUtil.attemptClose(pstm);
			C3P0DBUtil.attemptClose(con);
		}

	}

	/**
	 * 
	 * 更新报警结束条件
	 * @param list
	 */
	public void updateNewFault(List<FaultMachinery> list) {
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
			for (FaultMachinery fm : list) {
				try {
					pstm.setTimestamp(1, new Timestamp(fm.getEndTime().getTime()));
					pstm.setDouble(2, fm.getEndLongitude());
					pstm.setDouble(3, fm.getEndLatitude());
					pstm.setInt(4, fm.getMachineryEquipment().getId());
					pstm.setString(5, fm.getFaultDefinition().getFaultCode());
					pstm.addBatch();
				} catch (SQLException e) {
					// ignore it
				}
			}
			pstm.executeBatch();
			long end = new Date().getTime();
			LogUtil.getLogger(this).debug("更新故障 " + list.size() + " 条记录 " + (end - start) + " ms！");
		} catch (SQLException e) {
			LogUtil.getLogger(this).error("SQL执行异常", e);
		} finally {
			C3P0DBUtil.attemptClose(pstm);
			C3P0DBUtil.attemptClose(con);
		}

	}

}
