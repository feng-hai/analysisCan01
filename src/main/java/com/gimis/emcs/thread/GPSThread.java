package com.gimis.emcs.thread;


import com.gimis.emcs.ps.msg.Message;
import com.gimis.emcs.ps.msg.append.Append;
import com.gimis.emcs.ps.msg.gpsbody.GpsBasicInfo;
import com.gimis.emcs.ps.msg.gpsbody.GpsBody;
import com.gimis.emcs.util.LogUtil;

import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.message.MessageAndMetadata;

public class GPSThread extends Thread {
	private KafkaStream<String,Message> partition;
	public GPSThread(KafkaStream<String,Message> _partition)
	{
		this.partition=_partition;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		ConsumerIterator<String, Message> it = partition.iterator();
		while(it.hasNext())
		{
			try
			{
				MessageAndMetadata<String, Message> item = it.next();
				
				Message message = item.message();
				System.out.println(message);
				
				if (null == message || null == message.getAppend() || null == message.getMcuBody())
		        {
		            return;
		        }
				Append append = message.getAppend();
				
		        Integer machineryId = append.getMachineryId();
		        
		        String gpsId = message.getHeader().getGpsId();
		        GpsBody gpsBody = message.getGpsBody();
		        
		        if (gpsBody instanceof GpsBasicInfo)
		        {
		            GpsBasicInfo gpsHeartBeat = (GpsBasicInfo) gpsBody;
//		            //上报原因
//		            gpsCache.setUploadType(gpsHeartBeat.getUploadType());
//		            //速度
//		            gpsCache.setSpeed(gpsHeartBeat.getSpeed());
//		            //高度
//		            gpsCache.setHeight(gpsHeartBeat.getHeight());
//		            //方向角
//		            gpsCache.setForDirect(gpsHeartBeat.getForDirect());
//		            //最新数据GPS时间
//		            gpsCache.setGpsTime(gpsHeartBeat.getGpsTime());
//		            //星数
//		            gpsCache.setGpsStateSignal(gpsHeartBeat.getGpsStateSignal());
//		            //GPS模块状态
//		            gpsCache.setGpsStateModule(gpsHeartBeat.getGpsStateModule());
//		            //钥匙开关状态
//		            gpsCache.setSwitch1Key(gpsHeartBeat.getSwitch1Key());
//		            gpsCache.setPowerBatteryState(gpsHeartBeat.getPowerBatteryState());
//		            gpsCache.setDistance(gpsHeartBeat.getDistance());
//		            gpsCache.setHardwareVersion(gpsHeartBeat.getHardwareVersion());
//		            gpsCache.setSoftVersion(gpsHeartBeat.getSoftVersion());
//		            //GPS定位状态
//		            if (null != gpsHeartBeat.getGpsStateLocate())
//		            {
//		                gpsCache.setGpsStateLocate(gpsHeartBeat.getGpsStateLocate());
//		                //只有当精确定位的时候才更新经纬度信息
//		                if (1 == gpsHeartBeat.getGpsStateLocate().byteValue())
//		                {
//		                    //经度
//		                    if (null != gpsHeartBeat.getLongitude())
//		                    {
//		                        gpsCache.setLongitude(gpsHeartBeat.getLongitude());
//		                    }
//		                    //纬度
//		                    if (null != gpsHeartBeat.getLatitude())
//		                    {
//		                        gpsCache.setLatitude(gpsHeartBeat.getLatitude());
//		                    }
//		                }
//		            }
		        }
				
		       
		        
			}catch(Exception e)
			{
				LogUtil.getLogger(this).warn("获取kafka消息异常!",e);
			}
		}
	}

}
