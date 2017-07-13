package com.gimis.emcs.domain.vo;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.gimis.emcs.domain.BusCompany;
import com.gimis.emcs.domain.BusLine;
import com.gimis.emcs.domain.GpsDevice;
import com.gimis.emcs.domain.MachineryEquipment;
import com.gimis.emcs.domain.MachineryManufacturer;
import com.gimis.emcs.domain.MachineryModel;
import com.gimis.emcs.domain.MachineryType;
import com.gimis.emcs.domain.RedisModel;
import com.gimis.emcs.domain.util.DateFormatUtil;
import com.gimis.emcs.domain.util.DateUtil;
import com.gimis.emcs.domain.util.ModuleCodeConstants;

public class MachCache extends MachineryEquipment implements RedisModel<Integer> {

	/**
     * 在线状态
     */
    private Byte onLine;

    /**
     * 经度
     */
    public Double longitude;

    /**
     * 纬度
     */
    public Double latitude;

    /**
     * 是否需要加密计算
     */
    private boolean needEncryp = true;

    /**
     * 加密的经度
     */
    private String encrypLongitude;

    /**
     * 加密的纬度
     */
    private String encrypLatitude;

    /**
     * 纠偏后的经度
     */
    private Double calEncrypLongitude;

    /**
     * 纠偏后的纬度
     */
    private Double calEncrypLatitude;

    /**
     * 当前详细位置
     */
    private String location;

    /**
     * 地区信息
     */
    private String districtCode;

    /**
     * 最后一次定位服务器时间
     */
    private Date lastLocateTime;

    /**
     * CAN报警
     */
    private String machineryAlarm;

    /**
     * 最后一次通信服务器时间（包含所有类型消息）
     */
    private Date lastCommunicateTime;

    /**
     * 上次开机时间
     */
    private Date lastOnTime;

    /**
     * 最后一次can数据时间
     */
    private Date lastCanTime;

    /**
     * 矫正里程
     */
    private Double correctDistance;

    /**
     * GPS数据
     */
    private GpsMessage gps;

    /**
     * 故障报警
     * key:故障码
     */
    private Map<String, CanAlarm> canAlarms = new HashMap<String, CanAlarm>();

    /**
     * can数据 key:canId
     */
    private Map<String, CanData> cans = new HashMap<String, CanData>();

    /**
     * 需要更新到内存的属性集合
     */
    protected Map<String, String> updateMap = new HashMap<String, String>();

    public MachCache()
    {

    }

    public void loadMachineryEquipment(MachineryEquipment machineryEquipment)
    {
        this.setId(machineryEquipment.getId());
        this.setLicense(machineryEquipment.getLicense());
        this.setVin(machineryEquipment.getVin());
        this.setSerialNumber(machineryEquipment.getSerialNumber());
        this.setProductionCode(machineryEquipment.getProductionCode());
        this.setGpsDevice(machineryEquipment.getGpsDevice());
        this.setMachineryType(machineryEquipment.getMachineryType());
        this.setMachineryModel(machineryEquipment.getMachineryModel());
        this.setMachineryManufacturer(machineryEquipment.getMachineryManufacturer());
        this.setBusCompany(machineryEquipment.getBusCompany());
        this.setBusLine(machineryEquipment.getBusLine());
        this.setEquipmentState(machineryEquipment.getEquipmentState());
        this.setWorkProvince(machineryEquipment.getWorkProvince());
        this.setWorkDistrict(machineryEquipment.getWorkDistrict());

        this.setGpsManufacturerId(machineryEquipment.getGpsManufacturerId());
        this.setEngineNo(machineryEquipment.getEngineNo());
        this.setDistributor(machineryEquipment.getDistributor());
        this.setAfterSaleDistributor(machineryEquipment.getAfterSaleDistributor());
        this.setMachineryClient(machineryEquipment.getMachineryClient());
        this.setDescription(machineryEquipment.getDescription());
        this.setSystemId(machineryEquipment.getSystemId());
        this.setSaleType(machineryEquipment.getSaleType());
        this.setSaleProperty(machineryEquipment.getSaleProperty());
        this.setDeliverDate(machineryEquipment.getDeliverDate());
        this.setInStorageDate(machineryEquipment.getInStorageDate());
        this.setOutStorageDate(machineryEquipment.getOutStorageDate());
        this.setSaleDate(machineryEquipment.getSaleDate());
        this.setPrototypePlace(machineryEquipment.getPrototypePlace());
        this.setMonitor(machineryEquipment.getMonitor());
        this.setAnalyzeType(machineryEquipment.getAnalyzeType());
        this.setIsStatus(machineryEquipment.getIsStatus());
    }

    public MachCache(Map<String, String> beanMap)
    {
        if (null == beanMap || beanMap.size() == 0)
            return;

        if (null != beanMap.get("id") && false == "".equals(beanMap.get("id")))
        {
            super.setId(Integer.parseInt(beanMap.get("id")));
        }
        if (null != beanMap.get("license") && false == "".equals(beanMap.get("license")))
        {
            super.setLicense(beanMap.get("license"));
        }
        if (null != beanMap.get("vin") && false == "".equals(beanMap.get("vin")))
        {
            super.setVin(beanMap.get("vin"));
        }
        if (null != beanMap.get("serialNumber") && false == "".equals(beanMap.get("serialNumber")))
        {
            super.setSerialNumber(beanMap.get("serialNumber"));
        }
        if (null != beanMap.get("productionCode") && false == "".equals(beanMap.get("productionCode")))
        {
            super.setProductionCode(beanMap.get("productionCode"));
        }
        if (null != beanMap.get("gpsDevice.id") && false == "".equals(beanMap.get("gpsDevice.id")))
        {
            super.setGpsDeviceId(beanMap.get("gpsDevice.id"));
        }
        if (null != beanMap.get("machineryType.id") && false == "".equals(beanMap.get("machineryType.id")))
        {
            super.setMachineryTypeId(Integer.parseInt(beanMap.get("machineryType.id")));
        }
        if (null != beanMap.get("machineryModel.id") && false == "".equals(beanMap.get("machineryModel.id")))
        {
            super.setMachineryModeId(Integer.parseInt(beanMap.get("machineryModel.id")));
        }
        if (null != beanMap.get("machineryManufacturer.id")
                && false == "".equals(beanMap.get("machineryManufacturer.id")))
        {
            super.setMachineryManufacturerId(Integer.parseInt(beanMap.get("machineryManufacturer.id")));
        }
        if (null != beanMap.get("busCompany.id") && false == "".equals(beanMap.get("busCompany.id")))
        {
            super.setBusCompanyId(Integer.parseInt(beanMap.get("busCompany.id")));
        }
        if (null != beanMap.get("busLine.id") && false == "".equals(beanMap.get("busLine.id")))
        {
            super.setBusLineId(Integer.parseInt(beanMap.get("busLine.id")));
        }
        if (null != beanMap.get("equipmentState") && false == "".equals(beanMap.get("equipmentState")))
        {
            super.setEquipmentState(Short.parseShort(beanMap.get("equipmentState")));
        }
        if (null != beanMap.get("workProvince") && false == "".equals(beanMap.get("workProvince")))
        {
            super.setWorkProvince(beanMap.get("workProvince"));
        }
        if (null != beanMap.get("workDistrict") && false == "".equals(beanMap.get("workDistrict")))
        {
            super.setWorkDistrict(beanMap.get("workDistrict"));
        }
        if (null != beanMap.get("onLine") && false == "".equals(beanMap.get("onLine")))
        {
            this.onLine = Byte.parseByte(beanMap.get("onLine"));
        }
        if (null != beanMap.get("longitude") && false == "".equals(beanMap.get("longitude")))
        {
            this.longitude = Double.parseDouble(beanMap.get("longitude"));
        }
        if (null != beanMap.get("latitude") && false == "".equals(beanMap.get("latitude")))
        {
            this.latitude = Double.parseDouble(beanMap.get("latitude"));
        }
        if (null != beanMap.get("encrypLongitude") && false == "".equals(beanMap.get("encrypLongitude")))
        {
            this.encrypLongitude = beanMap.get("encrypLongitude");
        }
        if (null != beanMap.get("encrypLatitude") && false == "".equals(beanMap.get("encrypLatitude")))
        {
            this.encrypLatitude = beanMap.get("encrypLatitude");
        }
        if (null != beanMap.get("needEncryp") && false == "".equals(beanMap.get("needEncryp")))
        {
            this.needEncryp = Boolean.parseBoolean(beanMap.get("needEncryp"));
        }
        if (null != beanMap.get("calEncrypLongitude") && false == "".equals(beanMap.get("calEncrypLongitude")))
        {
            this.calEncrypLongitude = Double.parseDouble(beanMap.get("calEncrypLongitude"));
        }
        if (null != beanMap.get("calEncrypLatitude") && false == "".equals(beanMap.get("calEncrypLatitude")))
        {
            this.calEncrypLatitude = Double.parseDouble(beanMap.get("calEncrypLatitude"));
        }
        if (null != beanMap.get("location") && false == "".equals(beanMap.get("location")))
        {
            this.location = beanMap.get("location");
        }
        if (null != beanMap.get("districtCode") && false == "".equals(beanMap.get("districtCode")))
        {
            this.districtCode = beanMap.get("districtCode");
        }
        if (null != beanMap.get("lastLocateTime") && false == "".equals(beanMap.get("lastLocateTime")))
        {
            this.lastLocateTime = DateFormatUtil.parseWithoutThrowException(beanMap.get("lastLocateTime"),
                    DateFormatUtil.DEFAULT_DATETIME_PATTERN);
        }
        if (null != beanMap.get("machineryAlarm") && false == "".equals(beanMap.get("machineryAlarm")))
        {
            this.machineryAlarm = beanMap.get("machineryAlarm");
        }
        if (null != beanMap.get("lastOnTime") && false == "".equals(beanMap.get("lastOnTime")))
        {
            this.lastOnTime = DateFormatUtil.parseWithoutThrowException(beanMap.get("lastOnTime"),
                    DateFormatUtil.DEFAULT_DATETIME_PATTERN);
        }
        if (null != beanMap.get("lastCanTime") && false == "".equals(beanMap.get("lastCanTime")))
        {
            this.lastCanTime = DateFormatUtil.parseWithoutThrowException(beanMap.get("lastCanTime"),
                    DateFormatUtil.DEFAULT_DATETIME_PATTERN);
        }
        if (null != beanMap.get("lastCommunicateTime") && false == "".equals(beanMap.get("lastCommunicateTime")))
        {
            this.lastCommunicateTime = DateFormatUtil.parseWithoutThrowException(beanMap.get("lastCommunicateTime"),
                    DateFormatUtil.DEFAULT_DATETIME_PATTERN);
            //如果最新通信时间在10分钟之前，则设置设备处于离线状态
            if (null == this.lastCommunicateTime
                    || this.lastCommunicateTime.before(DateUtil.getOffsetMinute(new Date(), -10)))
            {
                this.onLine = ModuleCodeConstants.MACH_ONLINE_STATE_OFFLINE;
            }
        }
        if (null != beanMap.get("correctDistance") && false == "".equals(beanMap.get("correctDistance")))
        {
            this.correctDistance = Double.parseDouble(beanMap.get("correctDistance"));
        }
        if (null != beanMap.get("analyzeType") && false == "".equals(beanMap.get("analyzeType")))
        {
            super.setAnalyzeType(Integer.parseInt(beanMap.get("analyzeType")));
        }
    }

    @Override
    public void setId(Integer id)
    {
        this.setBeanMapFiled("id", super.getId(), id);
        super.setId(id);
    }

    @Override
    public Integer getId()
    {
        return super.getId();
    }

    @Override
    public void setLicense(String license)
    {
        if (null != license)
        {
            license = license.toUpperCase();
        }
        this.setBeanMapFiled("license", super.getLicense(), license);
        super.setLicense(license);
    }

    @Override
    public void setVin(String vin)
    {
        if (null != vin)
        {
            vin = vin.toUpperCase();
        }
        this.setBeanMapFiled("vin", super.getVin(), vin);
        super.setVin(vin);
    }

    @Override
    public void setSerialNumber(String serialNumber)
    {
        if (null != serialNumber)
        {
            serialNumber = serialNumber.toUpperCase();
        }
        this.setBeanMapFiled("serialNumber", super.getSerialNumber(), serialNumber);
        super.setSerialNumber(serialNumber);
    }

    @Override
    public void setProductionCode(String productionCode)
    {
        this.setBeanMapFiled("productionCode", super.getProductionCode(), productionCode);
        super.setProductionCode(productionCode);
    }

    @Override
    public void setEngineNo(String engineNo)
    {
        this.setBeanMapFiled("engineNo", super.getEngineNo(), engineNo);
        super.setEngineNo(engineNo);
    }

    @Override
    public void setGpsDevice(GpsDevice gpsDevice)
    {
        if (null != gpsDevice)
        {
            this.setBeanMapFiled("gpsDevice.id", super.getGpsDeviceId(), gpsDevice.getId());
        }
        super.setGpsDevice(gpsDevice);
    }

    @Override
    public void setMachineryType(MachineryType machineryType)
    {
        if (null != machineryType)
        {
            this.setBeanMapFiled("machineryType.id", super.getMachineryTypeId(), machineryType.getId());
        }
        super.setMachineryType(machineryType);
    }

    @Override
    public void setMachineryModel(MachineryModel machineryModel)
    {
        if (null != machineryModel)
        {
            this.setBeanMapFiled("machineryModel.id", super.getMachineryModelId(), machineryModel.getId());
        }
        super.setMachineryModel(machineryModel);
    }

    @Override
    public void setMachineryManufacturer(MachineryManufacturer machineryManufacturer)
    {
        if (null != machineryManufacturer && null != machineryManufacturer.getId())
        {
            this.setBeanMapFiled("machineryManufacturer.id", super.getMachineryManufacturerId(),
                    machineryManufacturer.getId());
        }
        super.setMachineryManufacturer(machineryManufacturer);
    }

    @Override
    public void setEquipmentState(Short equipmentState)
    {
        this.setBeanMapFiled("equipmentState", super.getEquipmentState(), equipmentState);
        super.setEquipmentState(equipmentState);
    }

    @Override
    public void setBusCompany(BusCompany busCompany)
    {
        if (null != busCompany && null != busCompany.getId())
        {
            this.setBeanMapFiled("buscompany.id", super.getBusCompanyId(), busCompany.getId());
        }
        super.setBusCompany(busCompany);
    }

    @Override
    public void setBusLine(BusLine busLine)
    {
        if (null != busLine && null != busLine.getId())
        {
            this.setBeanMapFiled("busLine.id", super.getBusLineId(), busLine.getId());
        }
        super.setBusLine(busLine);
    }

    @Override
    public void setWorkProvince(String workProvince)
    {
        this.setBeanMapFiled("workProvince", super.getWorkProvince(), workProvince);
        super.setWorkProvince(workProvince);
    }

    @Override
    public void setWorkDistrict(String workDistrict)
    {
        this.setBeanMapFiled("workDistrict", super.getWorkDistrict(), workDistrict);
        super.setWorkDistrict(workDistrict);
    }

    @Override
    public void setAnalyzeType(Integer analyzeType)
    {
        this.setBeanMapFiled("analyzeType", super.getAnalyzeType(), analyzeType);
        super.setAnalyzeType(analyzeType);
    }

    public String getMachineryAlarm()
    {
        return machineryAlarm;
    }

    public void setMachineryAlarm(String machineryAlarm)
    {
        this.setBeanMapFiled("machineryAlarm", this.machineryAlarm, machineryAlarm);
        this.machineryAlarm = machineryAlarm;
    }

    public Byte getOnLine()
    {
        return onLine;
    }

    public void setOnLine(Byte onLine)
    {
        this.setBeanMapFiled("onLine", this.onLine, onLine);
        this.onLine = onLine;
    }

    public Date getLastCommunicateTime()
    {
        return lastCommunicateTime;
    }

    public void setLastCommunicateTime(Date lastCommunicateTime)
    {
        this.setBeanMapFiled("lastCommunicateTime", this.lastCommunicateTime, lastCommunicateTime);
        this.lastCommunicateTime = lastCommunicateTime;
    }

    public Double getCorrectDistance()
    {
        return correctDistance;
    }

    public void setCorrectDistance(Double correctDistance)
    {
        this.setBeanMapFiled("correctDistance", this.correctDistance, correctDistance);
        this.correctDistance = correctDistance;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.setBeanMapFiled("location", this.location, location);
        this.location = location;
    }

    public Double getLongitude()
    {
        return longitude;
    }

    public void setLongitude(Double longitude)
    {
        this.setBeanMapFiled("longitude", this.longitude, longitude);
        this.longitude = longitude;
    }

    public Double getLatitude()
    {
        return latitude;
    }

    public void setLatitude(Double latitude)
    {
        this.setBeanMapFiled("latitude", this.latitude, latitude);
        this.latitude = latitude;
    }

    public boolean isNeedEncryp()
    {
        return needEncryp;
    }

    public void setNeedEncryp(boolean needEncryp)
    {
        this.setBeanMapFiled("needEncryp", this.needEncryp, needEncryp);
        this.needEncryp = needEncryp;
    }

    public Double getCalEncrypLongitude()
    {
        return calEncrypLongitude;
    }

    public void setCalEncrypLongitude(Double calEncrypLongitude)
    {
        this.setBeanMapFiled("calEncrypLongitude", this.calEncrypLongitude, calEncrypLongitude);
        this.calEncrypLongitude = calEncrypLongitude;
    }

    public Double getCalEncrypLatitude()
    {
        return calEncrypLatitude;
    }

    public void setCalEncrypLatitude(Double calEncrypLatitude)
    {
        this.setBeanMapFiled("calEncrypLatitude", this.calEncrypLatitude, calEncrypLatitude);
        this.calEncrypLatitude = calEncrypLatitude;
    }

    public String getEncrypLongitude()
    {
        return encrypLongitude;
    }

    public void setEncrypLongitude(String encrypLongitude)
    {
        this.setBeanMapFiled("encrypLongitude", this.encrypLongitude, encrypLongitude);
        this.encrypLongitude = encrypLongitude;
    }

    public String getEncrypLatitude()
    {
        return encrypLatitude;
    }

    public void setEncrypLatitude(String encrypLatitude)
    {
        this.setBeanMapFiled("encrypLatitude", this.encrypLatitude, encrypLatitude);
        this.encrypLatitude = encrypLatitude;

    }

    public Date getLastLocateTime()
    {
        return lastLocateTime;
    }

    public void setLastLocateTime(Date lastLocateTime)
    {
        if (null == lastLocateTime)
            return;
        this.setBeanMapFiled("lastLocateTime", this.lastLocateTime, lastLocateTime);
        this.lastLocateTime = lastLocateTime;
        if ((null == this.getLastCommunicateTime()) || (lastLocateTime.after(this.getLastCommunicateTime())))
        {
            //修改通讯时间
            this.setLastCommunicateTime(lastLocateTime);
        }
    }

    public Date getLastOnTime()
    {
        return lastOnTime;
    }

    public void setLastOnTime(Date lastOnTime)
    {
        this.setBeanMapFiled("lastOnTime", this.lastOnTime, lastOnTime);
        this.lastOnTime = lastOnTime;
    }

    public Date getLastCanTime()
    {
        return lastCanTime;
    }

    public void setLastCanTime(Date lastCanTime)
    {
        this.setBeanMapFiled("lastCanTime", this.lastCanTime, lastCanTime);
        this.lastCanTime = lastCanTime;
    }

    public String getDistrictCode()
    {
        return districtCode;
    }

    public void setDistrictCode(String districtCode)
    {
        this.setBeanMapFiled("districtCode", this.districtCode, districtCode);
        this.districtCode = districtCode;
    }

    public GpsMessage getGps()
    {
        return gps;
    }

    public void setGps(Map<String, String> gpsMap)
    {
        this.gps = new GpsMessage(gpsMap);
    }

    public Map<String, CanData> getCans()
    {
        return cans;
    }

    /**
     * 系统规定不同CAN帧没有重复的属性，此处直接转为以属性名为key的map
     */
    public Map<String, String> getCanMap()
    {
        Map<String, String> result = null;
        if (null != this.cans && 0 < this.cans.keySet().size())
        {
            result = new HashMap<String, String>();
            Iterator<String> iter = this.cans.keySet().iterator();
            String key = null;
            CanData canData = null;
            while (iter.hasNext())
            {
                key = iter.next();
                canData = this.cans.get(key);
                if (null != canData && null != canData.getData())
                {
                    Map<String, String> temp = canData.getData();
                    Iterator<String> iter2 = temp.keySet().iterator();
                    String key2 = null;
                    while (iter2.hasNext())
                    {
                        key2 = iter2.next();
                        result.put(key2, temp.get(key2));
                    }
                }
            }
        }
        return result;
    }

    public void setCans(Map<String, CanData> cans)
    {
        this.cans = cans;
    }

    public CanData getCanData(String canId)
    {
        if (null == this.cans || this.cans.keySet().size() == 0)
        {
            return null;
        }
        return this.cans.get(canId);
    }

    public void addCan(String canId , CanData can)
    {
        if (null == this.cans)
            this.cans = new HashMap<String, CanData>();
        this.cans.put(canId, can);
    }

    /**
     * @return the canAlarms
     */
    public Map<String, CanAlarm> getCanAlarms()
    {
        return canAlarms;
    }

    /**
     * 查询故障信息
     * @param faultCode
     * @return
     */
    public CanAlarm getCanAlarm(String faultCode)
    {
        return this.canAlarms.get(faultCode);
    }

    /**
     * @param canAlarms the canAlarms to set
     */
    public void setCanAlarms(Map<String, CanAlarm> canAlarms)
    {
        this.canAlarms = canAlarms;
    }

    public void addCanAlarm(CanAlarm canAlarm)
    {
        if (null != canAlarm)
        {
            this.canAlarms.put(canAlarm.getAlarmNo(), canAlarm);
        }
    }

    public Map<String, String> getUpdateMap()
    {
        return this.updateMap;
    }

    /**
     * 所有的子类的set方法必须调用该方法
     * @param filed

     */
    private void setBeanMapFiled(String filed , Object oldObj , Object newObj)
    {
        if (null == filed || "".equals(filed) || null == newObj)
            return;
        boolean isChange = false;
        if (!newObj.equals(oldObj))
            isChange = true;
        if (newObj instanceof Number)
        {
            if (isChange)
                this.updateMap.put(filed, newObj + "");
        }
        else if (newObj instanceof Date)
        {
            String date = DateFormatUtil.formatDateTime((Date) newObj);
            if (isChange)
                this.updateMap.put(filed, date);
        }
        else if (newObj instanceof String)
        {
            if (isChange)
                this.updateMap.put(filed, (String) newObj);
        }
        else
        {
            if (isChange)
                this.updateMap.put(filed, newObj.toString());
        }
    }

    @Override
    public String toString()
    {
        return "MachCache [onLine=" + onLine + ", longitude=" + longitude + ", latitude=" + latitude + ", needEncryp="
                + needEncryp + ", encrypLongitude=" + encrypLongitude + ", encrypLatitude=" + encrypLatitude
                + ", calEncrypLongitude=" + calEncrypLongitude + ", calEncrypLatitude=" + calEncrypLatitude
                + ", location=" + location + ", districtCode=" + districtCode + ", lastLocateTime=" + lastLocateTime
                + ", machineryAlarm=" + machineryAlarm + ", lastCommunicateTime=" + lastCommunicateTime
                + ", lastOnTime=" + lastOnTime + ", lastCanTime=" + lastCanTime + ", correctDistance="
                + correctDistance + ", gps=" + gps + ", cans=" + cans + ", updateMap=" + updateMap + "]";
    }

}
