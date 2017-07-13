package com.wlwltech.redis.update.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



 

public class ObjectModelOfKafka implements Serializable {
	private static final long serialVersionUID = 477223109817573790L;
	private Double calEncrypLongitude;
	private Double calEncrypLatitude;
	private String machineryId;
	private String analyzeType;
	private Date TIMESTAMP = new Date();
	private List<Pair> pairs = new ArrayList<Pair>();
	private String DATIME_RX = "";
	
	//故障报警
	private List<Pair> faults = new ArrayList<Pair>();
	
	public Double getCalEncrypLongitude() {
		return calEncrypLongitude;
	}

	public void setCalEncrypLongitude(Double calEncrypLongitude) {
		this.calEncrypLongitude = calEncrypLongitude;
	}

	public Double getCalEncrypLatitude() {
		return calEncrypLatitude;
	}

	public void setCalEncrypLatitude(Double calEncrypLatitude) {
		this.calEncrypLatitude = calEncrypLatitude;
	}

	public String getMachineryId() {
		return machineryId;
	}

	public void setMachineryId(String machineryId) {
		this.machineryId = machineryId;
	}

	public String getAnalyzeType() {
		return analyzeType;
	}
	
//	public Pair getAnalyzeType() {
//		for ( Pair p : pairs )
//		{
//			if (p.getAlias().equals( "ANALYZE_TYPE" ))
//			{
//				return p;
//			}
//		}
//		return new Pair();
//}
	

	public void setAnalyzeType(String analyzeType) {
		this.analyzeType = analyzeType;
	}

	/**
	 * @return tIMESTAMP
	 */
	public Date getTIMESTAMP() {
		return TIMESTAMP;
	}

	/**
	 * @param tIMESTAMP
	 *            要设置的 tIMESTAMP
	 */
	public void setTIMESTAMP(Date tIMESTAMP) {
		TIMESTAMP = tIMESTAMP;
	}

	/**
	 * @return pairs
	 */
	public List<Pair> getPairs() {
		return pairs;
	}

	/**
	 * @param pairs
	 *            要设置的 pairs
	 */
	public void setPairs(List<Pair> pairs) {
		this.pairs = pairs;
	}

	/**
	 * @return dATIME_RX
	 */
	public String getDATIME_RX() {
		return DATIME_RX;
	}

	/**
	 * @param dATIME_RX
	 *            要设置的 dATIME_RX
	 */
	public void setDATIME_RX(String dATIME_RX) {
		DATIME_RX = dATIME_RX;
	}

	@Override
	public String toString() {
		return JsonUtils.serialize(this);
	}


}

