package com.wlwltech.pages;

import java.util.List;

import com.wlwltech.redis.update.model.VehicleIndex;


public class SubmitIndex implements Runnable {
	
	private String tableName;
	private String type;
	private List<VehicleIndex> vehicles;
	
	public SubmitIndex(String intabeleName,String intype,List<VehicleIndex> invehicles)
	{
		this.tableName=intabeleName;
		this.type=intype;
		this.vehicles=invehicles;
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Esutil.addIndex(tableName,type,vehicles);	
	}

}
