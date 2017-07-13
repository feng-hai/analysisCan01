package com.gimis.emcs.domain.util;

public class ModuleCodeConstants {

	  /**
     * GPS设备状态：初始化
     */
    public static final short GPS_STATE_INITIALIZATION = 5;

    /**
     * GPS设备状态：待装机
     */
    public static final short GPS_STATE_NOT_INSTALLED = 10;

    /**
     * GPS设备状态：装机检测完成
     */
    public static final short GPS_STATE_TEST_COMPLETED = 15;

    /**
     * GPS设备状态：售后
     */
    public static final short GPS_STATE_AFTER_SALES = 20;

    /**
     * GPS设备状态：维修
     */
    public static final short GPS_STATE_MAINTENANCE = 25;

    /**
     * GPS设备状态：注销
     */
    public static final short GPS_STATE_LOGOUT = 30;

    /**
     * GPS设备状态：报废
     */
    public static final short GPS_STATE_SCRAPPED = 35;

    /**
     * 机械设备状态：初始
     */
    public static final short MACHINERY_EQUIPMENT_STATE_INITIAL = 5;

    /**
     * 机械设备状态：待装机
     */
    public static final short MACHINERY_EQUIPMENT_STATE_NOT_INSTALLED = 10;

    /**
     * 机械设备状态：装机检测完成
     */
    public static final short MACHINERY_EQUIPMENT_STATE_TEST_COMPLETED = 15;

    /**
     * 机械设备状态：在库
     */
    public static final short MACHINERY_EQUIPMENT_STATE_REPOSITORY = 20;

    /**
     * 机械设备状态：样机
     */
    public static final short MACHINERY_EQUIPMENT_STATE_PROTOTYPE = 25;

    /**
     * 机械设备状态：售后
     */
    public static final short MACHINERY_EQUIPMENT_STATE_SALED = 30;

    /**
     * 机械设备状态：注销
     */
    public static final short MACHINERY_EQUIPMENT_STATE_LOGOUT = 35;

    /**
     * 机械设备状态：删除
     */
    public static final short MACHINERY_EQUIPMENT_STATE_DELETED = 40;

    /**
     * 机械设备销售属性：普通销售
     */
    public static final byte MACHINERY_GENERAL_SALE = 2;

    /**
     * 机械设备销售属性：样机销售
     */
    public static final byte MACHINERY_PROTOTYPE_SALE = 1;

    /**
     * SIM卡类型：吉美思统付
     */
    public static final short SIM_TYPE_GIMIS_UNIFY_PAY = 1;

    /**
     * SIM卡类型：吉美思非统付
     */
    public static final short SIM_TYPE_GIMIS_NONUNIFY_PAY = 2;

    /**
     * SIM卡类型：厂家自购
     */
    public static final short SIM_TYPE_GIMIS_SELF_BUY = 3;

    /**
     * SIM卡状态：正常
     */
    public static final short SIM_STATE_NORMAL = 5;

    /**
     * SIM卡状态：欠费
     */
    public static final short SIM_STATE_ARREARS = 10;

    /**
     * SIM卡状态：停机保号
     */
    public static final short SIM_STATE_STOP = 20;

    /**
     * SIM卡状态：注销
     */
    public static final short SIM_STATE_CANCEL = 25;

    /**
     * GPS定位状态：成功
     */
    public static final short LOCATE_STATE_SUCCESS = 1;

    /**
     * GPS定位状态：失败
     */
    public static final short LOCATE_STATE_FAIL = 2;

    /**
    * GPS工作模式：正常
    */
    public static final short WORKING_MODE_NORMAL = 1;

    /**
     * GPS工作模式：休眠
     */
    public static final short WORKING_MODE_SLEEP = 2;

    /**
     * GPS工作模式：运输
     */
    public static final short WORKING_MODE_TRANSPORT = 3;

    /**
     * 机械设备状态：关机
     */
    public static final short MACHINERY_STATE_CLOSE = 0;

    /**
     * 机械设备状态：开机
     */
    public static final short MACHINERY_STATE_POWER = 1;

    /**
     * MCU状态：关机
     */
    public static final short MCU_STATE_CLOSE = 0;

    /**
     * MCU状态：开机
     */
    public static final short MCU_STATE_POWER = 1;

    /**
     * GPS信息来源：GPRS
     */
    public static final short GATEWAY_SOURCE_GRPS = 1;

    /**
     * GPS信息来源：短信
     */
    public static final short GATEWAY_SOURCE_SMS = 2;

    /**
     * GPS信息来源：补存
     */
    public static final short GATEWAY_SOURCE_SUPPLY = 3;

    /**
     * 机械设备入库类型：检测入库
     */
    public static final short MACHINERY_STORAGE_TYPE_CHECK = 1;

    /**
     * 机械设备入库类型：直接入库
     */
    public static final short MACHINERY_STORAGE_TYPE_DIRECT = 2;

    /**
     * 故障信息来源：网上申报
     */
    public static final short BREAKDOWN_SOURCE_WEB = 1;

    /**
     * 故障信息来源：电话申报
     */
    public static final short BREAKDOWN_SOURCE_TEL = 2;

    /**
     * 故障信息来源：短信申报
     */
    public static final short BREAKDOWN_SOURCE_SMS = 3;

    /**
     * 故障信息来源：传真申报
     */
    public static final short BREAKDOWN_SOURCE_FAX = 4;

    /**
     * 故障信息来源：Email申报
     */
    public static final short BREAKDOWN_SOURCE_EMAIL = 5;

    /**
     * 故障信息来源：外部系统同步
     */
    public static final short BREAKDOWN_SOURCE_SYNC = 6;

    /**
     * 故障信息来源：状态采集
     */
    public static final short BREAKDOWN_SOURCE_GATHER = 7;

    /**
     * 故障处理状态：未处理
     */
    public static final short BREAKDOWN_PROCESS_STATE_NO = 1;

    /**
     * 故障处理状态：处理成功
     */
    public static final short BREAKDOWN_PROCESS_STATE_SUCCESS = 2;

    /**
     * 故障处理状态：继续处理
     */
    public static final short BREAKDOWN_PROCESS_STATE_CONTINUE = 3;

    /**
     * 故障处理状态：处理失败
     */
    public static final short BREAKDOWN_PROCESS_STATE_FAIL = 4;

    /**
     * 机械设备销售方式：不详
     */
    /*
    public static final short MACHINERY_SALE_TYPE_UNKNOW = 1;*/

    /**
     * 机械设备销售方式：全款
     */
    public static final short MACHINERY_SALE_TYPE_FULL = 1;

    /**
     * 机械设备销售方式：按揭
     */
    public static final short MACHINERY_SALE_TYPE_MORTGAGE = 2;

    /**
     * 机械设备销售方式：分期
     */
    public static final short MACHINERY_SALE_TYPE_INSTALMENTS = 3;

    /**
     * 机械设备销售方式：融资租赁
     */
    public static final short MACHINERY_SALE_TYPE_FINALINGlEASE = 4;

    /**
     * 机械设备销售方式：其它
     */
    public static final short MACHINERY_SALE_TYPE_OTHER = 5;

    /**
     * 还贷状态：未贷
     */
    public static final short REPAYMENT_STATE_NOLOAN = 1;

    /**
     * 还贷状态：未还
     */
    public static final short REPAYMENT_STATE_NONE = 2;

    /**
     * 还贷状态：部分
     */
    public static final short REPAYMENT_STATE_PART = 3;

    /**
     * 还贷状态：全还
     */
    public static final short REPAYMENT_STATE_FULL = 4;

    /******************************************************GPS报警定义 start********************************************************/

    /**
     * Gps报警：GPS天线报警
     */
    public static final int ALARM_GPS_TYPE_1 = 1;

    /**
     * Gps报警：GSM天线报警
     */
    public static final int ALARM_GPS_TYPE_2 = 2;

    /**
     * Gps报警：GPS开盒
     */
    public static final int ALARM_GPS_TYPE_3 = 3;

    /**
     * Gps报警：外电切断
     */
    public static final int ALARM_GPS_TYPE_4 = 4;

    /**
     * Gps报警：拆除安装螺丝报警
     */
    public static final int ALARM_GPS_TYPE_5 = 5;

    /**
     * Gps报警：MCU通信异常
     */
    public static final int ALARM_GPS_TYPE_6 = 6;

    /**
     * Gps报警：越界报警
     */
    public static final int ALARM_GPS_TYPE_7 = 7;

    /**
     * GPS报警：离线报警
     */
    public static final int ALARM_GPS_TYPE_OFF_LINE = 8;

    /******************************************************GPS报警定义 end********************************************************/
    /**
     * 统计标记，正常出入库时为1
     */
    public static final short STORAGE_STAT_FLAG_IN = 1;

    /**
     * 统计标记，退库时为-1
     */
    public static final short STORAGE_STAT_FLAG_OUT = -1;

    /**
     * 操作类型， 1：表示入库； 
     */
    public static final short STORAGE_OPERATE_TYPE_IN = 1;

    /**
     * 操作类型， 2：表示出库； 
     */
    public static final short STORAGE_OPERATE_TYPE_OUT = 2;

    /**
     * 操作类型， 3：表示退库
     */
    public static final short STORAGE_OPERATE_TYPE_REFUND = 3;

    /**
     * LBS定位方式 ：自动
     */
    public static final short LBS_LOCATION_TYPE_AUTO = 1;

    /**
     * LBS定位方式 ：手动
     */
    public static final short LBS_LOCATION_TYPE_MANUAL = 0;

    /**
     * LBS每台设备 每日最多定位次数
     */
    public static final Short LBS_LOCATION_COUNT_DAY = 5;

    /**
     * LBS可定位   开始时间
     * 格式: HH:mm:ss
     */
    public static final String LBS_LOCATION_VALID_TIME_START = "06:00:00";

    /**
     * LBS可定位   结束时间
     * 格式: HH:mm:ss
     */
    public static final String LBS_LOCATION_VALID_TIME_END = "23:59:59";

    /**
     * LBS设备状态：初始化
     */
    public static final short LBS_STATE_INITIALIZATION = 5;

    /**
     * LBS设备状态：待装机
     */
    public static final short LBS_STATE_NOT_INSTALLED = 10;

    /**
     * LBS设备状态：装机检测完成
     */
    public static final short LBS_STATE_TEST_COMPLETED = 15;

    /**
     * LBS设备状态：售后
     */
    public static final short LBS_STATE_AFTER_SALES = 20;

    /**
     * LBS设备状态：维修
     */
    public static final short LBS_STATE_MAINTENANCE = 25;

    /**
     * LBS设备状态：注销
     */
    public static final short LBS_STATE_LOGOUT = 30;

    /**
     * LBS设备状态：删除
     */
    public static final short LBS_STATE_SCRAPPED = 35;

    /**
     * SIM卡用途，0表示GPS使用。
     */
    public static final short SIM_GPS_USE = 0;

    /**
     * SIM卡用途，1表示LBS使用。
     */
    public static final short SIM_LBS_USE = 1;

    /**
     * 样机违规类型
     * 0：工作超时
     */
    public static final short PROTOTYPE_VLOLATION_TYPE_WORK_TIME_OUT = 0;

    /**
     * 样机违规类型
     * 1：越界
     */
    public static final short PROTOTYPE_VLOLATION_TYPE_OVER_STEP = 1;

    /**
     * 样机违规类型
     * 2：跨市
     */
    public static final short PROTOTYPE_VLOLATION_TYPE_OUT_OF_CITY = 2;

    /**
     * MCU工时矫正方式
     * 1：自动
     */
    public static final short MCU_TIME_CORRECT_TYPE_AUTO = 1;

    /**
     * MCU工时矫正方式
     * 2：手动
     */
    public static final short MCU_TIME_CORRECT_TYPE_MANUALLY = 2;

    /**
     * 围栏类型
     * 0：矩形
     */
    public static final short FENCE_TYPE_RECTANGULAR = 0;

    /**
     * 围栏类型
     * 1：圆形  只有半径
     */
    public static final short FENCE_TYPE_CIRCULAR = 1;

    /**
     * 围栏类型
     * 2：圆形  参数包括半径和圆心
     */
    public static final short FENCE_TYPE_CIRCULAR_RADIUS = 2;

    /**
     * 在线状态
     * 离线：0
     */
    public static final byte MACH_ONLINE_STATE_OFFLINE = 0;

    /**
     * 在线状态
     * 关机在线：5
     */
    /* public static final byte MACH_ONLINE_STATE_NORMAL = 5;*/

    /**
     * 在线状态
     * 停车在线：10
     */
    public static final byte MACH_ONLINE_STATE_PARK = 10;

    /**
     * 在线状态
     * 行驶：15
     */
    public static final byte MACH_ONLINE_STATE_RUNNING = 15;
}
