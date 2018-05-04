package com.wlwltech.redis.update.model;

public class VehicleIndex {
	
	public VehicleIndex()
	{
		
	}
	
	public VehicleIndex(String invhicleUnid,long time)
	{
		this.vehicleUnid=invhicleUnid;
		this.time=time;
	}
	
	private String vehicleUnid;
	private long time;
	private int onLine;
	private  double[] location ;
	/**
	 * @return the onLine
	 */
	public int getOnLine() {
		return onLine;
	}
	/**
	 * @param onLine the onLine to set
	 */
	public void setOnLine(int onLine) {
		this.onLine = onLine;
	}
	/**
	 * @return the location
	 */
	public double[] getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(double[] location) {
		this.location = location;
	}
	public String getVehicleUnid() {
		return vehicleUnid;
	}
	public void setVehicleUnid(String vehicleUnid) {
		this.vehicleUnid = vehicleUnid;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	

}
