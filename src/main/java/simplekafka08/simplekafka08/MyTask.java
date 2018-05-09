package simplekafka08.simplekafka08;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;

import org.dom4j.Attribute;
import org.dom4j.Element;

import com.wlwl.mysql.JdbcUtils;
import com.wlwl.mysql.SingletonJDBC;

import com.wlwltech.csrzic.redis.RedisPool;
import com.wlwltech.redis.update.model.Dom4jUtil;
import com.wlwltech.redis.update.model.JsonUtils;
import com.wlwltech.redis.update.model.Pair;

public class MyTask extends TimerTask {
	private Map<String,Map<String, Pair>> values=new HashMap<>();
	private Map<String,String >vehicles=new HashMap<>();
	public MyTask() {
	
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		loadData();
		System.out.println("缓存大小："+publicStaticMap.getMessageQueue().size());
	}
	
	  //遍历当前节点下的所有节点  
    public void listNodes(Element node,String protol,String can){  
    	String nodeName=node.getName();
      //  System.out.println("当前节点的名称：" + node.getName());  
        //首先获取当前节点的所有属性节点  
        List<Attribute> list = node.attributes();  
        //遍历属性节点  
       // Map<String,String > tempValue=new HashMap<>();
        
        Pair pair=new Pair();
        for(Attribute attribute : list){  
        	if(nodeName=="analyzeType")
        	{
        		if(attribute.getName()=="type")
        		{
        			protol= attribute.getValue();
        		}
        	}
        	if(nodeName=="can")
        	{
        		if(attribute.getName()=="name")
        		{
        			can= attribute.getValue();
        		}
        	}
        	if(nodeName=="value")
        	{
        		if(attribute.getName()=="id")
        		{
        			pair.setCode(attribute.getValue());
        		}else if(attribute.getName()=="title")
        		{
        			pair.setTitle(attribute.getValue());
        		}else if(attribute.getName()=="alias")
        		{
        			pair.setAlias(attribute.getValue());
        		}
        		
        		//tempValue.put(attribute.getName(), attribute.getValue());
        		//System.out.println("属性"+attribute.getName() +":" + attribute.getValue());  
           
        	}
        }
            
    	if(nodeName=="value")
    	{
    		Map<String, Pair> pairs=values.get(protol+"-"+can);
    		if(pairs!=null)
    		{
	    		if(!pairs.containsKey(pair.getCode()))
	    		{
	    			pairs.put(pair.getCode(), pair);
	    		}
	    		
    		}else
    		{
    			pairs=new HashMap<>();
    			pairs.put(pair.getCode(), pair);
    		}
    		values.put(protol+"-"+can, pairs);
    		return ;
    	}
        //如果当前节点内容不为空，则输出  
        if(!(node.getTextTrim().equals(""))){  
             System.out.println( node.getName() + "：" + node.getText());    
        }  
        //同时迭代当前节点下面的所有子节点  
        //使用递归  
        Iterator<Element> iterator = node.elementIterator();  
        while(iterator.hasNext()){  
            Element e = iterator.next();  
            listNodes(e,protol,can);  
        }  
    }  

	private void loadData() {

		
	String path;
	Element element=null ;
	try {
		path = new File( "." ).getCanonicalPath() + "/resource/config.xml";
		InputStream in = new BufferedInputStream( new FileInputStream( path ) );
		element= Dom4jUtil.getDocument(in);
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		
		
		
		
			
		   
		 listNodes(element,"","");
		 
		 publicStaticMap.setCans(values);
		//System.out.println( JsonUtils.serialize(values));
		
		System.out.println("定时任务开始");
		// 查询数据库
		JdbcUtils jdbcUtils = null;
		try {
			// String onll =
			// RedisPool.getInstance().getJedisCluster().hget("mach:" + "61",
			// "onLine");
			/// System.out.println("在线状态"+onll);
			JdbcUtils utils = SingletonJDBC.getJDBC();
			List<Object> params = new ArrayList<Object>();
			List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
			try {
				result = utils.findModeResult("select  vehi.id,vehi.ANALYZE_TYPE from bs_machinery_equipment vehi ",
						params);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (Map<String, Object> idO : result) {
				
				//System.out.println(JsonUtils.serialize(idO));
				String id = idO.get("ID").toString();
				String protolType = idO.get("ANALYZE_TYPE").toString();
				//System.out.println(protolType);
				
                vehicles.put(id, protolType);
                
               
              
				//System.out.println("车辆id：" + id);
				SimpleDateFormat DEFAULT_DATE_SIMPLEDATEFORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String dateTimeStr = RedisPool.getInstance().getJedisCluster().hget("mach:" + id,
						"lastCommunicateTime");
				//System.out.println("车辆id：" + id + "-" + dateTimeStr);
				if (dateTimeStr != null && !dateTimeStr.isEmpty()) {
					Date dataDate = DEFAULT_DATE_SIMPLEDATEFORMAT.parse(dateTimeStr);
					//System.out.println("间隔时间：" + (new Date().getTime() - dataDate.getTime()));
					if (new Date().getTime() - dataDate.getTime() > 1000 * 60 * 5) {
						RedisPool.getInstance().getJedisCluster().hset("mach:" + id, "onLine", "0");

						//String onllTemp = RedisPool.getInstance().getJedisCluster().hget("mach:" + id, "onLine");
						//System.out.println("更新车辆状态:" + id + "-" + onllTemp);
					}
				} else {
					RedisPool.getInstance().getJedisCluster().hset("mach:" + id, "onLine", "0");
					//String onllTemp = RedisPool.getInstance().getJedisCluster().hget("mach:" + id, "onLine");
					//System.out.println("更新车辆状态:" + id + "-" + onllTemp);
				}
			}
			
			 publicStaticMap.setVehicles(vehicles);

			System.out.println("定时任务结束");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jdbcUtils != null) {
				jdbcUtils.releaseConn();
			}
		}

	}

}
