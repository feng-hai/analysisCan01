package com.gimis.emcs.domain;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MachineryEquipment {
	 /**
     * 机械设备ID
     */
    private Integer id;

    /**
     * 车牌号
     */
    private String license;

    /**
     * 车架号
     */
    private String vin;

    /**
     * 车辆序号
     */
    private String serialNumber;

    /**
     * 生产编号
     */
    private String productionCode;

    /**
     * 发动机编号
     */
    private String engineNo;

    /**
     * GPS设备信息
     */
    private GpsDevice gpsDevice;

    /**
     * 机械设备类型
     */
    private MachineryType machineryType;

    /**
     * 主机厂
     */
    private MachineryManufacturer machineryManufacturer;

    /**
     * 机型
     */
    private MachineryModel machineryModel;

    /**
     * 经销商信息
     */
    private Distributor distributor;

    /**
     * 服务经销商信息
     */
    private Distributor afterSaleDistributor;

    /**
     * 设备用户
     */
    private MachineryClient machineryClient;

    /**
     * 公交公司
     */
    private BusCompany busCompany;

    /**
     * 公交路线
     */
    private BusLine busLine;

    /**
     * 设备信息
     */
    private String description;

    /**
     * 设备状态，由业务状态表定义
     */
    private Short equipmentState;

    /**
     * 平台ID
     */
    private Integer systemId;

    /**
     * 记录状态，0：正常；1：无效（已删除）
     */
    private Short state;

    /**
     * 销售类型
     */
    private Short saleType;

    /**
     * 销售属性，样机销售、普通销售
     */
    private Byte saleProperty;

    /**
     * 设备发货日期，与GPS发货日期不同
     */
    private Date deliverDate;

    /**
     * 入库日期
     */
    private Date inStorageDate;

    /**
     * 出库日期
     */
    private Date outStorageDate;

    /**
     * 销售日期
     */
    private Date saleDate;

    /**
     * 样机存放地
     */
    private String prototypePlace;

    /**
     * 工作省份
     */
    private String workProvince;

    /**
     * 工作区域
     */
    private String workDistrict;

    /**
     * 监控状态，0表示不监控，1表示监控。本字段仅用来方便用户检索，无其他特殊含义。用户可以将出保或全款、已还完贷款的挖机设置为不需要监控，方便检索导
     */
    private Short monitor;

    /**
     * 解析方式
     */
    private Integer analyzeType;
    
    private Short isStatus;
    
    private Map<String,Object>map;

    public MachineryEquipment(Integer id)
    {
        super();
        this.id = id;
    }

    public MachineryEquipment(Integer id, Short equipmentState)
    {
        super();
        this.id = id;
        this.equipmentState = equipmentState;
    }

    public MachineryEquipment()
    {
        super();
    }

    /**
     * @param machineryTypeId
     * @param machineryManufacturerId
     * @param license
     * @param vin
     * @param productionCode
     * @param serialNumber
     * @param engineNo
     * @param machineryModelId
     * @param analyzeType
     */
    public MachineryEquipment(Integer machineryTypeId, Integer machineryManufacturerId, String license, String vin,
            String productionCode, String serialNumber, String engineNo, Integer machineryModelId, Integer analyzeType)
    {
        super();
        this.machineryType = new MachineryType(machineryTypeId);
        this.machineryManufacturer = new MachineryManufacturer(machineryManufacturerId);
        this.license = license;
        this.vin = vin;
        this.productionCode = productionCode;
        this.serialNumber = serialNumber;
        this.engineNo = engineNo;
        this.machineryModel = new MachineryModel(machineryModelId);
        this.analyzeType = analyzeType;
    }

    /**
     * @param gpsId
     * @param manufacturersId
     * @param equipmentState
     * @param deliverDate
     */
    public MachineryEquipment(GpsDevice gpsDevice, MachineryManufacturer machineryManufacturer, Short equipmentState,
            Date deliverDate)
    {
        super();
        this.gpsDevice = gpsDevice;
        this.machineryManufacturer = machineryManufacturer;
        this.equipmentState = equipmentState;
        this.deliverDate = deliverDate;
    }

    /**
     * @param gpsDevice
     * @param equipmentState
     * @param systemId
     */
    public MachineryEquipment(GpsDevice gpsDevice, Short equipmentState, Integer systemId)
    {
        super();
        this.gpsDevice = gpsDevice;
        this.equipmentState = equipmentState;
        this.systemId = systemId;
    }

    /**
     * @param gpsDevice
     * @param equipmentState
     * @param systemId
     * @param state
     */
    public MachineryEquipment(GpsDevice gpsDevice, Short equipmentState, Integer systemId, Short state)
    {
        super();
        this.gpsDevice = gpsDevice;
        this.equipmentState = equipmentState;
        this.systemId = systemId;
        this.state = state;
    }

    public Map<String, Object> getBaseMap()
    {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("license", this.getLicense());
        result.put("vin", this.getVin());
        result.put("serialNumber", this.getSerialNumber());
        result.put("productionCode", this.getProductionCode());
        result.put("machineryTypeId", this.getMachineryTypeId());
        result.put("machineryTypeName", this.getMachineryTypeName());
        result.put("machineryModeId", this.getMachineryModeId());
        result.put("machineryModelName", this.getMachineryModelName());
        result.put("busCompanyId", this.getBusCompanyId());
        result.put("busCompanyName", this.getBusCompanyName());
        result.put("busLineId", this.getBusLineId());
        String busLineName = (null == this.getBusLine() ? null : this.getBusLine().getName());
        result.put("busLineName", busLineName);
        String districtCode = (null == this.getBusCompany() ? null : this.getBusCompany().getDistrictCode());
        result.put("districtCode", districtCode);
        result.put("machineryManufacturerId", this.getMachineryManufacturerId());
        result.put("machineryManufacturerName", this.getMachineryManufacturerName());
        if (null != this.analyzeType)
        {
            result.put("analyzeType", this.analyzeType);
        }
        else
        {
            result.put("analyzeType", 0);
        }
        return result;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getLicense()
    {
        return license;
    }

    public void setLicense(String license)
    {
        if (null != license)
            this.license = license.toUpperCase();
        else
            this.license = license;
    }

    public String getVin()
    {
        return vin;
    }

    public void setVin(String vin)
    {
        if (null != vin)
            this.vin = vin.toUpperCase();
        else
            this.vin = vin;
    }

    public String getSerialNumber()
    {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber)
    {
        if (null != serialNumber)
            this.serialNumber = serialNumber.toUpperCase();
        else
            this.serialNumber = serialNumber;
    }

    public String getEngineNo()
    {
        return engineNo;
    }

    public void setEngineNo(String engineNo)
    {
        if (null != engineNo)
            this.engineNo = engineNo.toUpperCase();
        else
            this.engineNo = engineNo;
    }

    public Short getEquipmentState()
    {
        return equipmentState;
    }

    public void setEquipmentState(Short equipmentState)
    {
        this.equipmentState = equipmentState;
    }

    public Short getState()
    {
        return state;
    }

    public void setState(Short state)
    {
        this.state = state;
    }

    public Distributor getAfterSaleDistributor()
    {
        return afterSaleDistributor;
    }

    public void setAfterSaleDistributor(Distributor afterSaleDistributor)
    {
        this.afterSaleDistributor = afterSaleDistributor;
    }

    public Integer getSystemId()
    {
        return systemId;
    }

    public void setSystemId(Integer systemId)
    {
        this.systemId = systemId;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Date getDeliverDate()
    {
        return deliverDate;
    }

    public void setDeliverDate(Date deliverDate)
    {
        this.deliverDate = deliverDate;
    }

    public Date getInStorageDate()
    {
        return inStorageDate;
    }

    public void setInStorageDate(Date inStorageDate)
    {
        this.inStorageDate = inStorageDate;
    }

    public Date getOutStorageDate()
    {
        return outStorageDate;
    }

    public void setOutStorageDate(Date outStorageDate)
    {
        this.outStorageDate = outStorageDate;
    }

    public Date getSaleDate()
    {
        return saleDate;
    }

    public void setSaleDate(Date saleDate)
    {
        this.saleDate = saleDate;
    }

    public String getPrototypePlace()
    {
        return prototypePlace;
    }

    public void setPrototypePlace(String prototypePlace)
    {
        this.prototypePlace = prototypePlace;
    }

    public String getWorkProvince()
    {
        return workProvince;
    }

    public void setWorkProvince(String workProvince)
    {
        this.workProvince = workProvince;
    }

    public Short getSaleType()
    {
        return saleType;
    }

    public void setSaleType(Short saleType)
    {
        this.saleType = saleType;
    }

    public Byte getSaleProperty()
    {
        return saleProperty;
    }

    public void setSaleProperty(Byte saleProperty)
    {
        this.saleProperty = saleProperty;
    }

    public Short getMonitor()
    {
        return monitor;
    }

    public void setMonitor(Short monitor)
    {
        this.monitor = monitor;
    }

    public MachineryType getMachineryType()
    {
        return machineryType;
    }

    public void setMachineryType(MachineryType machineryType)
    {
        this.machineryType = machineryType;
    }

    public MachineryManufacturer getMachineryManufacturer()
    {
        return machineryManufacturer;
    }

    public void setMachineryManufacturer(MachineryManufacturer machineryManufacturer)
    {
        this.machineryManufacturer = machineryManufacturer;
    }

    public GpsDevice getGpsDevice()
    {
        return gpsDevice;
    }

    public String getGpsDeviceSimNo()
    {
        return null == this.gpsDevice ? null : this.gpsDevice.getSimNo();
    }

    public void setGpsDevice(GpsDevice gpsDevice)
    {
        this.gpsDevice = gpsDevice;
    }

    public MachineryModel getMachineryModel()
    {
        return machineryModel;
    }

    public void setMachineryModel(MachineryModel machineryModel)
    {
        this.machineryModel = machineryModel;
    }

    public Distributor getDistributor()
    {
        return distributor;
    }

    public void setDistributor(Distributor distributor)
    {
        this.distributor = distributor;
    }

    public MachineryClient getMachineryClient()
    {
        return machineryClient;
    }

    public void setMachineryClient(MachineryClient machineryClient)
    {
        this.machineryClient = machineryClient;
    }

    public BusCompany getBusCompany()
    {
        return busCompany;
    }

    public void setBusCompany(BusCompany busCompany)
    {
        this.busCompany = busCompany;
    }

    public void setBusCompanyId(Integer id)
    {
        if (null == this.busCompany)
            this.busCompany = new BusCompany();
        this.busCompany.setId(id);
    }

    public Integer getBusCompanyId()
    {
        return (null == this.busCompany ? null : this.busCompany.getId());
    }

    public String getBusCompanyName()
    {
        return (null == this.busCompany ? null : this.busCompany.getName());
    }

    /**
     * 获取生产厂家ID
     * @return
     */
    public Integer getMachineryManufacturerId()
    {
        if (null != machineryManufacturer)
        {
            return this.machineryManufacturer.getId();
        }
        else
        {
            return null;
        }
    }

    public void setMachineryManufacturerId(Integer id)
    {
        if (null == this.machineryManufacturer)
            this.machineryManufacturer = new MachineryManufacturer();
        this.machineryManufacturer.setId(id);
    }

    /**
     * 获取生产厂家NAME
     * @return
     */
    public String getMachineryManufacturerName()
    {
        if (null != machineryManufacturer)
        {
            return this.machineryManufacturer.getName();
        }
        else
        {
            return null;
        }
    }

    /**
     * 获取设备类型ID
     * @return
     */
    public Integer getMachineryTypeId()
    {
        if (null != machineryType)
        {
            return this.machineryType.getId();
        }
        else
        {
            return null;
        }
    }

    /**
     * 设置设备类型ID
     * @param machineryTypeId
     */
    public void setMachineryTypeId(Integer machineryTypeId)
    {
        if (null == this.machineryType)
            this.machineryType = new MachineryType();
        this.machineryType.setId(machineryTypeId);
    }

    /**
     * 获取设备类型NAME
     * @return
     */
    public String getMachineryTypeName()
    {
        if (null != machineryType)
        {
            return this.machineryType.getName();
        }
        else
        {
            return null;
        }
    }

    /**
     * 获取机型ID
     * @return
     */
    public Integer getMachineryModelId()
    {
        if (null != machineryModel)
        {
            return this.machineryModel.getId();
        }
        else
        {
            return null;
        }
    }

    /**
     * 设置机型ID
     * @param machineryModeId
     */
    public void setMachineryModeId(Integer machineryModeId)
    {
        if (null == this.machineryModel)
            this.machineryModel = new MachineryModel();
        this.machineryModel.setId(machineryModeId);
    }

    public Integer getMachineryModeId()
    {
        return null == this.machineryModel ? null : this.machineryModel.getId();
    }

    /**
     * 获取机型NAME
     * @return
     */
    public String getMachineryModelName()
    {
        if (null != machineryModel)
        {
            return this.machineryModel.getName();
        }
        else
        {
            return null;
        }
    }

    /**
     * 获取经销商ID
     * @return
     */
    public Integer getDistributorId()
    {
        if (null != distributor)
        {
            return this.distributor.getId();
        }
        else
        {
            return null;
        }
    }

    /**
     * 获取经销商NAME
     * @return
     */
    public String getDistributorName()
    {
        if (null != distributor)
        {
            return this.distributor.getShortName();
        }
        else
        {
            return null;
        }
    }

    /**
     * 获取售后经销商ID
     * @return
     */
    public Integer getAfterSaleDistributorId()
    {
        if (null != afterSaleDistributor)
        {
            return this.afterSaleDistributor.getId();
        }
        else
        {
            return null;
        }
    }

    /**
     * 获取售后经销商NAME
     * @return
     */
    public String getAfterSaleDistributorName()
    {
        if (null != afterSaleDistributor)
        {
            return this.afterSaleDistributor.getShortName();
        }
        else
        {
            return null;
        }
    }

    /**
     * 获取GPS设备信息ID
     * @return
     */
    public String getGpsDeviceId()
    {
        if (null != gpsDevice)
        {
            return this.gpsDevice.getId();
        }
        else
        {
            return null;
        }
    }

    public void setGpsDeviceId(String gpsDeviceId)
    {
        if (null == this.gpsDevice)
            this.gpsDevice = new GpsDevice();
        this.gpsDevice.setId(gpsDeviceId);
    }

    public void setGpsDeviceSimNo(String gpsDeviceSimNo)
    {
        if (null == this.gpsDevice)
            this.gpsDevice = new GpsDevice();
        if (null == this.gpsDevice.getSim())
        {
            Sim s = new Sim();
            s.setSimNo(gpsDeviceSimNo);
            this.gpsDevice.setSim(s);
        }
        else
        {
            this.gpsDevice.getSim().setSimNo(gpsDeviceSimNo);
        }
    }

    public Integer getGpsManufacturerId()
    {
        if (null != this.getGpsDevice())
        {
            return this.gpsDevice.getGpsManufacturerId();
        }
        return null;
    }

    public void setGpsManufacturerId(Integer id)
    {
        if (null == this.gpsDevice)
            this.gpsDevice = new GpsDevice();
        if (null == this.gpsDevice.getGpsManufacturer())
        {
            GpsManufacturer s = new GpsManufacturer();
            s.setId(id);
            this.gpsDevice.setGpsManufacturer(s);
        }
        else
        {
            this.gpsDevice.getGpsManufacturer().setId(id);
        }
    }

    /**
     * 获取设备用户ID
     * @return
     */
    public Integer getMachineryClientId()
    {
        if (null != machineryClient)
        {
            return this.machineryClient.getId();
        }
        else
        {
            return null;
        }
    }

    public BusLine getBusLine()
    {
        return busLine;
    }

    public Integer getBusLineId()
    {
        if (null != this.busLine)
        {
            return this.busLine.getId();
        }
        else
        {
            return null;
        }
    }

    public void setBusLine(BusLine busLine)
    {
        this.busLine = busLine;
    }

    public void setBusLineId(Integer busLineId)
    {
        if (null == this.busLine)
        {
            this.busLine = new BusLine(busLineId);
        }
        else
        {
            this.busLine.setId(busLineId);
        }
    }

    public String getWorkDistrict()
    {
        return workDistrict;
    }

    public void setWorkDistrict(String workDistrict)
    {
        this.workDistrict = workDistrict;
    }

    /**
     * 获取设备用户NAME
     * @return
     */
    public String getMachineryClientName()
    {
        if (null != machineryClient)
        {
            return this.machineryClient.getName();
        }
        else
        {
            return null;
        }
    }

    
    public Short getIsStatus()
    {
        return isStatus;
    }

    public void setIsStatus(Short isStatus)
    {
        this.isStatus = isStatus;
    }

    /**
     * @return the productionCode
     */
    public String getProductionCode()
    {
        return productionCode;
    }

    /**
     * @param productionCode the productionCode to set
     */
    public void setProductionCode(String productionCode)
    {
        this.productionCode = productionCode;
    }

    public Integer getAnalyzeType()
    {
        return analyzeType;
    }

    public void setAnalyzeType(Integer analyzeType)
    {
        this.analyzeType = analyzeType;
    }

    /**
     * @return the map
     */
    public Map<String, Object> getMap()
    {
        return map;
    }

    /**
     * @param map the map to set
     */
    public void setMap(Map<String, Object> map)
    {
        this.map = map;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "MachineryEquipment [id=" + id + ", license=" + license + ", vin=" + vin + ", serialNumber="
                + serialNumber + ", productionCode=" + productionCode + ", engineNo=" + engineNo + ", gpsDevice="
                + gpsDevice + ", machineryType=" + machineryType + ", machineryManufacturer=" + machineryManufacturer
                + ", machineryModel=" + machineryModel + ", distributor=" + distributor + ", afterSaleDistributor="
                + afterSaleDistributor + ", machineryClient=" + machineryClient + ", busCompany=" + busCompany
                + ", busLine=" + busLine + ", description=" + description + ", equipmentState=" + equipmentState
                + ", systemId=" + systemId + ", state=" + state + ", saleType=" + saleType + ", saleProperty="
                + saleProperty + ", deliverDate=" + deliverDate + ", inStorageDate=" + inStorageDate
                + ", outStorageDate=" + outStorageDate + ", saleDate=" + saleDate + ", prototypePlace="
                + prototypePlace + ", workProvince=" + workProvince + ", workDistrict=" + workDistrict + ", monitor="
                + monitor + ", analyzeType=" + analyzeType + ", isStatus=" + isStatus + ", map=" + map + "]";
    }
}
