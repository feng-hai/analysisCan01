
package com.gimis.emcs.ps.msg.header;

public interface Header
{
    public short getGpsCommandId();

    public short getGpsLength();

    public short getAttachmentId();

    public short getAttachmentLength();

    public short getSequenceId();

    public String getGpsId();

    public byte getSubDeviceId();

    public byte getGpsManufacturers();

    public byte getHostCompanies();

    public String getVin();

    public short getMsgLength();

    public byte getCarValue();

    public void setGpsCommandId(short gpsCommandId);

    public void setGpsLength(short gpsLength);

    public void setAttachmentId(short attachmentId);

    public void setAttachmentLength(short attachmentLength);

    public void setSequenceId(short sequenceId);

    public void setGpsId(String gpsId);

    public void setSubDeviceId(byte subDeviceId);

    public void setGpsManufacturers(byte gpsManufacturers);

    public void setHostCompanies(byte hostCompanies);

    public void setVin(String vin);

    public void setMsgLength(short msgLength);

    public void setCarValue(byte carValue);

    /**********************************五系列协议信息************************************/

    /**
     * 心跳数据命令上报
     */
    public static final short FIVESERIES_NETPOSITIONDATA_REQUEST = (short) 0x0181;

    /**
     * 心跳数据命令响应
     */
    public static final short FIVESERIES_NETPOSITIONDATA_RESPONSE = (short) 0x0101;

    /**
     * 基本信息命令上报
     */
    public static final short FIVESERIES_BASICINFODATA_REQUEST = (short) 0x0182;

    /**
     * 基本信息命令响应
     */
    public static final short FIVESERIES_BASICINFODATA_RESPONSE = (short) 0x0102;

    /**
     * GPS运行状况命令上报
     */
    public static final short FIVESERIES_GPSRUNSTATE_REQUEST = (short) 0x0188;

    /**
     * GPS运行状况命令响应
     */
    public static final short FIVESERIES_GPSRUNSTATE_RESPONSE = (short) 0x0108;

    /**
     * GPS所有参数设置命令请求
     */
    public static final short FIVESERIES_SETALLPARA_REQUEST = (short) 0x0104;

    /**
     * GPS所有参数设置命令响应
     */
    public static final short FIVESERIES_SETALLPARA_RESPONSE = (short) 0x0184;

    /**
     * 继电器1锁车命令请求
     */
    public static final short FIVESERIES_RELAYCTRL_1_REQUEST = (short) 0x010D;

    /**
     * 继电器1锁车命令响应
     */
    public static final short FIVESERIES_RELAYCTRL_1_RESPONSE = (short) 0x018D;

    /**
     * 继电器1解锁命令请求
     */
    public static final short FIVESERIES_RELAYCTRL_2_REQUEST = (short) 0x0119;

    /**
     * 继电器1解锁命令响应
     */
    public static final short FIVESERIES_RELAYCTRL_2_RESPONSE = (short) 0x0199;

    /**
     * 继电器2锁车命令请求
     */
    public static final short FIVESERIES_RELAYCTRL_3_REQUEST = (short) 0x011A;

    /**
     * 继电器2锁车命令响应
     */
    public static final short FIVESERIES_RELAYCTRL_3_RESPONSE = (short) 0x019A;

    /**
     * 继电器2解锁命令请求
     */
    public static final short FIVESERIES_RELAYCTRL_4_REQUEST = (short) 0x011B;

    /**
     * 继电器2解锁命令响应
     */
    public static final short FIVESERIES_RELAYCTRL_4_RESPONSE = (short) 0x019B;

    /**
     * 继电器12锁车命令请求
     */
    public static final short FIVESERIES_RELAYCTRL_5_REQUEST = (short) 0x011C;

    /**
     * 继电器12锁车命令响应
     */
    public static final short FIVESERIES_RELAYCTRL_5_RESPONSE = (short) 0x019C;

    /**
     * 继电器12解锁命令请求
     */
    public static final short FIVESERIES_RELAYCTRL_6_REQUEST = (short) 0x011D;

    /**
     * 继电器12解锁命令响应
     */
    public static final short FIVESERIES_RELAYCTRL_6_RESPONSE = (short) 0x019D;

    /**
     * 继电器3锁车命令请求
     */
    public static final short FIVESERIES_RELAYCTRL_7_REQUEST = (short) 0x012C;

    /**
     * 继电器3锁车命令响应
     */
    public static final short FIVESERIES_RELAYCTRL_7_RESPONSE = (short) 0x01AC;

    /**
     * 继电器3解锁命令请求
     */
    public static final short FIVESERIES_RELAYCTRL_8_REQUEST = (short) 0x012D;

    /**
     * 继电器3解锁命令响应
     */
    public static final short FIVESERIES_RELAYCTRL_8_RESPONSE = (short) 0x01AD;

    /**
     * 继电器4锁车命令请求
     */
    public static final short FIVESERIES_RELAYCTRL_9_REQUEST = (short) 0x012E;

    /**
     * 继电器4锁车命令响应
     */
    public static final short FIVESERIES_RELAYCTRL_9_RESPONSE = (short) 0x01AE;

    /**
     * 继电器4解锁命令请求
     */
    public static final short FIVESERIES_RELAYCTRL_10_REQUEST = (short) 0x012F;

    /**
     * 继电器4解锁命令响应
     */
    public static final short FIVESERIES_RELAYCTRL_10_RESPONSE = (short) 0x01AF;

    /**
     * 呼叫GPS终端心跳数据命令请求
     */
    public static final short FIVESERIES_CALL_REQUEST = (short) 0x010C;

    /**
     * 呼叫GPS终端心跳数据命令响应
     */
    public static final short FIVESERIES_CALL_RESPONSE = (short) 0x018C;

    /**
     * GPS复位重启命令请求
     */
    public static final short FIVESERIES_RESETRESTART_REQUEST = (short) 0x0311;

    /**
     * GPS复位重启命令响应 
     */
    public static final short FIVESERIES_RESETRESTART_RESPONSE = (short) 0x0391;
    
    /**
     * Gps附加信息命令请求
     */
    public static final short FIVESERIES_ADDITIONALINFO_REQUEST = (short) 0x0390;

    /**
     * Gps附加信息命令响应 
     */
    public static final short FIVESERIES_ADDITIONALINFO_RESPONSE = (short) 0x0310;

    /**
     * GPS运行状况统计清零命令请求
     */
    public static final short FIVESERIES_CLEANRUNSTATE_REQUEST = (short) 0x0116;

    /**
     * GPS运行状况统计清零命令响应
     */
    public static final short FIVESERIES_CLEANRUNSTATE_RESPONSE = (short) 0x0196;

    /**
     * ping命令上报
     */
    public static final short FIVESERIES_PING_REQUEST = (short) 0x0198;

    /**
     * GPS工作时间设置命令请求
     */
    public static final short FIVESERIES_SETWORKINGTIME_REQUEST = (short) 0x010F;

    /**
     * GPS工作时间设置命令响应
     */
    public static final short FIVESERIES_SETWORKINGTIME_RESPONSE = (short) 0x018F;

    /**
     * GPS单条参数设置命令请求
     */
    public static final short FIVESERIES_SETONEPARA_REQUEST = (short) 0x0106;

    /**
     * GPS单条参数设置命令响应
     */
    public static final short FIVESERIES_SETONEPARA_RESPONSE = (short) 0x0186;

    /**
     * GPS所有参数查询命令请求
     */
    public static final short FIVESERIES_QUERYALLPARA_REQUEST = (short) 0x0105;

    /**
     * GPS所有参数查询命令响应
     */
    public static final short FIVESERIES_QUERYALLPARA_RESPONSE = (short) 0x0185;

    /**
     * GPS固件远程升级下包命令请求
     */
    public static final short FIVESERIES_UPGRADE_0_REQUEST = (short) 0x0117;

    /**
     * GPS固件远程升级下包命令响应
     */
    public static final short FIVESERIES_UPGRADE_0_RESPONSE = (short) 0x0197;

    /**
     * GPS固件远程升级确认命令请求
     */
    public static final short FIVESERIES_UPGRADE_1_REQUEST = (short) 0x0120;

    /**
     * GPS固件远程升级确认命令响应
     */
    public static final short FIVESERIES_UPGRADE_1_RESPONSE = (short) 0x01A0;

    /**
     * GPS固件远程升级取消命令请求
     */
    public static final short FIVESERIES_UPGRADE_2_REQUEST = (short) 0x0121;

    /**
     * GPS固件远程升级取消命令响应
     */
    public static final short FIVESERIES_UPGRADE_2_RESPONSE = (short) 0x01A1;

    /**
     * GPS终端越界查询命令请求
     */
    public static final short FIVESERIES_OUTLINE_0_REQUEST = (short) 0x0111;

    /**
     * GPS终端越界查询命令响应
     */
    public static final short FIVESERIES_OUTLINE_0_RESPONSE = (short) 0x0191;

    /**
     * GPS终端越界设置命令请求
     */
    public static final short FIVESERIES_OUTLINE_1_REQUEST = (short) 0x011E;

    /**
     * GPS终端越界设置命令响应
     */
    public static final short FIVESERIES_OUTLINE_1_RESPONSE = (short) 0x019E;

    /**
     * GPS终端里程查询命令请求
     */
    public static final short FIVESERIES_NETDISTANCE_0_REQUEST = (short) 0x0115;

    /**
     * GPS终端里程查询命令响应
     */
    public static final short FIVESERIES_NETDISTANCE_0_RESPONSE = (short) 0x0195;

    /**
     * GPS终端里程设置命令请求
     */
    public static final short FIVESERIES_NETDISTANCE_1_REQUEST = (short) 0x011F;

    /**
     * GPS终端里程设置命令响应
     */
    public static final short FIVESERIES_NETDISTANCE_1_RESPONSE = (short) 0x019F;

    /**
     * GPS终端不可识别的下行指令命令响应
     */
    public static final short FIVESERIES_UNKNOW_REQUEST = (short) 0x01D1;

    /**
     * GPSSIM卡检测命令请求
     */
    public static final short FIVESERIES_SIMDETECT_REQUEST = (short) 0x0152;

    /**
     * GPSSIM卡检测命令响应
     */
    public static final short FIVESERIES_SIMDETECT_RESPONSE = (short) 0x01D2;
    
    /**
     * 整车控制器请求远程标定命令
     */
    public static final short FIVESERIES_REMOTE_CALIBRATION_REQUEST = (short) 0x0306;
    
    /**
     * 整车控制器请求远程标定命令响应
     */
    public static final short FIVESERIES_REMOTE_CALIBRATION_RESPONSE = (short) 0x0386;
    
    /**
     * 整车控制器请求远程标文件信息请求
     */
    public static final short FIVESERIES_REMOTE_CALIBRATION_FILE_REQUEST = (short) 0x0307;
    
    /**
     * 整车控制器请求远程标文件信息响应
     */
    public static final short FIVESERIES_REMOTE_CALIBRATION_FILE_RESPONSE = (short) 0x0387;
    
    /**
     * 终端发送文件包请求
     */
    public static final short FIVESERIES_REMOTE_CALIBRATION_PACKET_REQUEST = (short) 0x0388;
    
    /**
     * 终端发送文件包响应 
     */
    public static final short FIVESERIES_REMOTE_CALIBRATION_PACKET_RESPONSE = (short) 0x0308;
    
    /**
     * 升级状态结果发送
     */
    public static final short FIVESERIES_REMOTE_CALIBRATION_RESULT_REQUEST = (short) 0x0389;
    
    /**
     * 升级状态结果发送应答
     */
    public static final short FIVESERIES_REMOTE_CALIBRATION_RESULT_RESPONSE = (short) 0x0309;

    /**
     * MCU基本信息命令请求
     */
    public static final short FIVESERIES_WORD_MCU_BASICINFO_REQUEST = (short) 0x01D5;

    /**
     * MCU基本信息命令响应
     */
    public static final short FIVESERIES_WORD_MCU_BASICINFO_RESPONSE = (short) 0x0155;

    /**********************************mcu协议信息************************************/

    /**
     * MCU基本信息命令请求
     */
    public static final short FIVESERIES_MCU_BASICINFO_REQUEST = (short) 0x01C1;

    /**
     * MCU基本信息命令响应
     */
    public static final short FIVESERIES_MCU_BASICINFO_RESPONSE = (short) 0x0141;

    /**
     * MCU故障诊断代码命令请求
     */
    public static final short FIVESERIES_MCU_FAULTCODE_REQUEST = (short) 0x01C2;

    /**
     * MCU故障诊断代码命令响应    
     */
    public static final short FIVESERIES_MCU_FAULTCODE_RESPONSE = (short) 0x0142;

    /**
     * MCU终端命令响应
     */
    public static final short FIVESERIES_MCU_CONTROL_RESPONSE = (short) 0x0145;

    /**
     * MCU解锁命令请求
     */
    public static final short FIVESERIES_MCU_RELAYCONTROL_0_REQUEST = (short) 0x0143;

    /**
     * MCU解锁命令响应
     */
    public static final short FIVESERIES_MCU_RELAYCONTROL_0_RESPONSE = (short) 0x01C3;

    /**
     * MCU1级锁车命令请求
     */
    public static final short FIVESERIES_MCU_RELAYCONTROL_1_REQUEST = (short) 0x0149;

    /**
     * MCU1级锁车命令响应
     */
    public static final short FIVESERIES_MCU_RELAYCONTROL_1_RESPONSE = (short) 0x01C9;

    /**
     * MCU2级锁车命令请求
     */
    public static final short FIVESERIES_MCU_RELAYCONTROL_2_REQUEST = (short) 0x014A;

    /**
     * MCU2级锁车命令响应
     */
    public static final short FIVESERIES_MCU_RELAYCONTROL_2_RESPONSE = (short) 0x01CA;

    /**
     * MCU3级锁车命令请求
     */
    public static final short FIVESERIES_MCU_RELAYCONTROL_3_REQUEST = (short) 0x014B;

    /**
     * MCU3级锁车命令响应
     */
    public static final short FIVESERIES_MCU_RELAYCONTROL_3_RESPONSE = (short) 0x01CB;

    /**
     * MCU4级锁车命令请求
     */
    public static final short FIVESERIES_MCU_RELAYCONTROL_4_REQUEST = (short) 0x014C;

    /**
     * MCU4级锁车命令响应
     */
    public static final short FIVESERIES_MCU_RELAYCONTROL_4_RESPONSE = (short) 0x01CC;

    /**
     * MCU心跳设置命令请求
     */
    public static final short FIVESERIES_MCU_HEARTBET_1_REQUEST = (short) 0x0144;

    /**
     * MCU心跳设置命令响应
     */
    public static final short FIVESERIES_MCU_HEARTBET_1_RESPONSE = (short) 0x01C4;

    /**
     * MCU心跳关闭命令请求
     */
    public static final short FIVESERIES_MCU_HEARTBET_0_REQUEST = (short) 0x014D;

    /**
     * MCU心跳关闭命令响应
     */
    public static final short FIVESERIES_MCU_HEARTBET_0_RESPONSE = (short) 0x01CD;

    /**
     * MCU关闭自动锁车命令响应
     */
    public static final short FIVESERIES_MCU_AUTOCONTROL_0_RESPONSE = (short) 0x01C6;

    /**
     * MCU自动一级锁车命令请求
     */
    public static final short FIVESERIES_MCU_AUTOCONTROL_1_REQUEST = (short) 0x014E;

    /**
     * MCU自动一级锁车命令响应
     */
    public static final short FIVESERIES_MCU_AUTOCONTROL_1_RESPONSE = (short) 0x01CE;

    /**
     * MCU自动二级锁车命令请求
     */
    public static final short FIVESERIES_MCU_AUTOCONTROL_2_REQUEST = (short) 0x014F;

    /**
     * MCU自动二级锁车命令响应
     */
    public static final short FIVESERIES_MCU_AUTOCONTROL_2_RESPONSE = (short) 0x01CF;

    /**
     * MCU取消提示语命令请求
     */
    public static final short FIVESERIES_MCU_PROMPTS_0_REQUEST = (short) 0x0147;

    /**
     * MCU取消提示语命令响应
     */
    public static final short FIVESERIES_MCU_PROMPTS_0_RESPONSE = (short) 0x01C7;

    /**
     * MCU提示语1命令请求
     */
    public static final short FIVESERIES_MCU_PROMPTS_1_REQUEST = (short) 0x0150;

    /**
     * MCU提示语1命令响应
     */
    public static final short FIVESERIES_MCU_PROMPTS_1_RESPONSE = (short) 0x01D0;

    /**
     * MCU设置控制器工作小时请求
     */
    public static final short FIVESERIES_MCU_WORKINGTIME_REQUEST = (short) 0x0148;

    /**
     * MCU设置控制器工作小时响应
     */
    public static final short FIVESERIES_MCU_WORKINGTIME_RESPONSE = (short) 0x01C8;

    /**
     * MCU查询/设置电流参数请求
     */
    public static final short FIVESERIES_MCU_SETELECTRIC_REQUEST = (short) 0x0203;

    /**
     * MCU查询/设置电流参数响应
     */
    public static final short FIVESERIES_MCU_SETELECTRIC_RESPONSE = (short) 0x0283;

    /**
     * MCU寄存器 6 号命令请求
     */
    public static final short FIVESERIES_MCU_SETSIXREGISTER_REQUEST = (short) 0x0177;

    /**
     * MCU寄存器 6 号命令响应
     */
    public static final short FIVESERIES_MCU_SETSIXREGISTER_RESPONSE = (short) 0x01F7;

    /**
     * 启用gps安装设置命令请求
     */
    public static final short FIVESERIES_MCU_SETGPS_REQUEST = (short) 0x0211;

    /**
     * 启用gps安装设置命令响应
     */
    public static final short FIVESERIES_MCU_SETGPS_RESPONSE = (short) 0x0291;

    /**
     * 取消gps安装设置命令请求
     */
    public static final short FIVESERIES_MCU_CANCELGPS_REQUEST = (short) 0x0212;

    /**
     * 取消gps安装设置命令响应
     */
    public static final short FIVESERIES_MCU_CANCELGPS_RESPONSE = (short) 0x0292;

    /**
     * 路谱标定请求
     */
    public static final short FIVESERIES_MCU_SETROADS_REQUEST = (short)0x0302;

    /**
     * 路谱标定响应
     */
    public static final short FIVESERIES_MCU_SETROADS_RESPONSE = (short)0x0382;
    
    /**
     * 路谱删除请求
     */
    public static final short FIVERSERIES_MCU_DELROADS_REQUEST = (short)0x0304;
    
    /**
     * 路谱删除响应
     */
    public static final short FIVERSERIES_MCU_DELROADS_RESPONSE = (short)0x0384;
    
    /**
     * 线路ID查询
     */
    public static final short FIVERSERIES_MCU_QUERYROADS_REQUEST = (short)0x0301;
    
    /**
     * 线路ID查询响应
     */
    public static final short FIVERSERIES_MCU_QUERYROADS_RESPONSE = (short)0x0381;
    
    public static final short FIVESERIES_RESPONSE_CMD = (short) 0xFF7F;

    public static final byte oneParam_1 = 0x01;

    public static final byte oneParam_2 = 0x02;

    public static final byte oneParam_3 = 0x03;

    public static final byte oneParam_4 = 0x04;

    public static final byte oneParam_5 = 0x05;

    public static final byte oneParam_6 = 0x06;

    public static final byte oneParam_7 = 0x07;

    public static final byte oneParam_8 = 0x08;

    public static final byte oneParam_9 = 0x09;

    public static final byte oneParam_10 = 0x0A;

    public static final byte oneParam_11 = 0x0B;

    public static final byte oneParam_12 = 0x0C;

    public static final byte oneParam_13 = 0x0D;

    public static final byte oneParam_14 = 0x0E;

    public static final byte oneParam_15 = 0x0F;

    public static final byte oneParam_16 = 0x10;

    public static final byte oneParam_17 = 0x11;

    public static final byte oneParam_18 = 0x12;

    public static final byte oneParam_19 = 0x13;

    public static final byte oneParam_20 = 0x14;

    public static final byte oneParam_21 = 0x15;

    /**
     * 新能源Can
     */
    public static final short CAN_DATA = (short) 0x02E8;

    /**
     * 远程升级IP地址命令下发
     */
    public static final short SET_UPDATE_REMOTE = (short) 0x0270;

    /**
     * 远程升级IP地址命令下发响应
     */
    public static final short SET_UPDATE_REMOTE_RESPONSE = (short) 0x02f0;

    /*************新能源协议***************/
    /**
     * 设置CAN帧ID请求
     */
    public static final short EMCSSERIES_SETCOLLECTID_REQUEST = (short) 0x0260;

    /**
     * 设置CAN帧ID响应
     */
    public static final short EMCSSERIES_SETCOLLECTID_RESPONSE = (short) 0x02E0;

    /**
     * 设置CAN帧上传频率请求
     */
    public static final short EMCSSERIES_SETUPLOADFREQUENCY_REQUEST = (short) 0x0264;

    /**
     * 设置CAN帧上传频率响应
     */
    public static final short EMCSSERIES_SETUPLOADFREQUENCY_RESPONSE = (short) 0x02E4;

    /**
     * 查询CAN发动机数据请求
     */
    public static final short EMCSSERIES_QUERYCANDATA_REQUEST = (short) 0x0266;

    /**
     * 查询CAN发动机数据响应
     */
    public static final short EMCSSERIES_QUERYCANDATA_RESPONSE = (short) 0x02E6;

    /**
     * GPS登陆命令请求
     */
    public static final short EMCSSERIES_GPSLOGIN_REQUEST = (short) 0x02F4;

    /**
     * GPS登陆命令响应
     */
    public static final short EMCSSERIES_GPSLOGIN_RESPONSE = (short) 0x0274;

    /**
     * GPS连接服务器请求
     */
    public static final short EMCSSERIES_GPSCONNECTSERVER_REQUEST = (short) 0x02F5;

    /**
     * GPS连接服务器响应
     */
    public static final short EMCSSERIES_GPSCONNECTSERVER_RESPONSE = (short) 0x0275;

    /**
     * 终端允许平台呼叫CAN请求
     */
    public static final short EMCSSERIES_CANALLOWSUPPLEMENT_REQUEST = (short) 0x02DD;

    /**
     * 终端允许平台呼叫CAN响应
     */
    public static final short EMCSSERIES_CANALLOWSUPPLEMENT_RESPONSE = (short) 0x025D;

    /**
     * 报警命令上报请求
     */
    public static final short EMCSSERIES_CANALARM_REQUEST = (short) 0x02E7;

    /**
     * 报警命令上报响应
     */
    public static final short EMCSSERIES_CANALARM_RESPONSE = (short) 0x0267;

    /**
     * 申沃报警命令上报请求
     */
    public static final short EMCSSERIES_SUNWIN_CANALARM_REQUEST = (short) 0x038B;

    /**
     * 申沃报警命令上报响应
     */
    public static final short EMCSSERIES_SUNWIN_CANALARM_RESPONSE = (short) 0x030B;

    /**
     * 开关机运营状态上报请求
     */
    public static final short EMCSSERIES_CANACCRUNSTATE_REQUEST = (short) 0x02E9;

    /**
     * 开关机运营状态上报响应
     */
    public static final short EMCSSERIES_CANACCRUNSTATE_RESPONSE = (short) 0x0269;

    /**
     * 日报信息上报请求
     */
    public static final short EMCSSERIES_DAILYINFO_REQUEST = (short) 0x02EB;

    /**
     * 日报信息上报响应
     */
    public static final short EMCSSERIES_DAILYINFO_RESPONSE = (short) 0x026B;

    /**
     * 申沃日报信息上报请求
     */
    public static final short EMCSSERIES_SUNWIN_DAILYINFO_REQUEST = (short) 0x038A;

    /**
     * 申沃日报信息上报响应
     */
    public static final short EMCSSERIES_SUNWIN_DAILYINFO_RESPONSE = (short) 0x030A;

    /**
     * 电池均衡信息上报请求
     */
    public static final short EMCSSERIES_CANBATTERYBALANCEDATA_REQUEST = (short) 0x02EC;

    /**
     * 电池均衡信息上报响应
     */
    public static final short EMCSSERIES_CANBATTERYBALANCEDATA_RESPONSE = (short) 0x026C;

    /**
     * 查询昆明整机数据请求
     */
    public static final short EMCSSERIES_CANQUERYMACHINEDATA_REQUEST = (short) 0x026A;

    /**
     * 查询昆明整机数据响应
     */
    public static final short EMCSSERIES_CANQUERYMACHINEDATA_RESPONSE = (short) 0x02EA;

    /**
     * 合肥can数据透传下发请求
     */
    //public static final short EMCSSERIES_HFSENDCANDATA_REQUEST = (short)0x026D;

    /**
     * 合肥can数据透传下发响应
     */
    //public static final short EMCSSERIES_HFSENDCANDATA_RESPONSE = (short)0x02ED;

    /**
     * 申沃故障码命令请求
     */
    public static final short EMCSSERIES_SUNWINALARM_REQUEST = (short) 0x0383;

    /**
     * 申沃故障码命令响应
     */
    public static final short EMCSSERIES_SUNWINALARM_RESPONSE = (short) 0x0303;

    /**
     * 阈值报警命令设置请求
     */
    public static final short EMCSSERIES_THRESHOLDALARM_REQUEST = (short) 0x026D;

    /**
     * 阈值报警命令设置响应
     */
    public static final short EMCSSERIES_THRESHOLDALARM_RESPONSE = (short) 0x02ED;

    /**
     * 阈值报警命令查询请求
     */
    public static final short EMCSSERIES_QUERY_THRESHOLDALARM_REQUEST = (short) 0x026E;

    /**
     * 阈值报警命令查询响应
     */
    public static final short EMCSSERIES_QUERY_THRESHOLDALARM_RESPONSE = (short) 0x02EE;

    /**
     * 阈值报警命令删除请求
     */
    public static final short EMCSSERIES_DELETE_THRESHOLDALARM_REQUEST = (short) 0x026F;

    /**
     * 阈值报警命令删除响应
     */
    public static final short EMCSSERIES_DELETE_THRESHOLDALARM_RESPONSE = (short) 0x02EF;

    /**
     * 充电状态上报请求
     */
    public static final short EMCSSERIES_CHARGERSTATE_REQUEST = (short) 0x038C;

    /**
     * 充电状态上报响应
     */
    public static final short EMCSSERIES_CHARGERSTATE_RESPONSE = (short) 0x030C;

    /**
     * 设置动力总成地址参数请求
     */
    public static final short EMCSSERIES_SET_ADDRESSPARA_REQUEST = (short) 0x030D;

    /**
     * 设置动力总成地址参数响应
     */
    public static final short EMCSSERIES_SET_ADDRESSPARA_RESPONSE = (short) 0x038D;

    /**
     * 动力总成地址参数上传请求
     */
    public static final short EMCSSERIES_UPLOAD_ADDRESSPARA_REQUEST = (short) 0x038E;

    /**
     * 动力总成地址参数上传响应
     */
    public static final short EMCSSERIES_UPLOAD_ADDRESSPARA_RESPONSE = (short) 0x030E;

    /**
     * GPS时间校准上传请求
     */
    public static final short EMCSSERIES_TIME_CALIBRATION_REQUEST = (short) 0x038F;

    /**
     * GPS时间校准上传响应
     */
    public static final short EMCSSERIES_TIME_CALIBRATION_RESPONSE = (short) 0x030F;
    
    /**
     * 越博远程参数标定下发请求
     */
    public static final short EMCSSERIES_CAN_PARACALIBRATION_REQUEST = (short) 0x0312;

    /**
     * 越博远程参数标定上传响应
     */
    public static final short EMCSSERIES_CAN_PARACALIBRATION_RESPONSE = (short) 0x0392;
    
    /**
     * 越博故障地址下发请求
     */
    public static final short EMCSSERIES_CAN_SETFUALYADDR_REQUEST = (short) 0x0315;

    /**
     * 越博故障地址下发响应
     */
    public static final short EMCSSERIES_CAN_SETFUALYADDR_RESPONSE = (short) 0x0395;
    
    /**
     * 越博数据回溯下发请求
     */
    public static final short EMCSSERIES_CAN_DATATRACE_REQUEST = (short) 0x0314;

    /**
     * 越博数据回溯下发响应
     */
    public static final short EMCSSERIES_CAN_DATATRACE_RESPONSE = (short) 0x0394;
    
    /**
     * 越博查询参数标定下发请求
     */
    public static final short EMCSSERIES_CAN_QUERY_PARACALIBRATION_REQUEST = (short) 0x0316;

    /**
     * 越博查询参数标定上传响应
     */
    public static final short EMCSSERIES_CAN_QUERY_PARACALIBRATION_RESPONSE = (short) 0x0396;
    
    /**
     * 设置车架号下发请求
     */
    public static final short EMCSSERIES_CAN_SET_VIN_REQUEST = (short) 0x0317;

    /**
     * 设置车架号上传响应
     */
    public static final short EMCSSERIES_CAN_SET_VIN_RESPONSE = (short) 0x0397;
    
    /**
     * 设置车型下发请求
     */
    public static final short EMCSSERIES_CAN_SET_ANALYZE_REQUEST = (short)0x0318;
    
    /**
     * 设置车型下发响应
     */
    public static final short EMCSSERIES_CAN_SET_ANALYZE_RESPONSE = (short)0x0398;
    
    /**
     * 能耗下发命令
     */
    public static final short EMCSSERIES_CAN_SET_ENERGY_REQUEST = (short)0x0319;
    
    /**
     * 能耗下发响应
     */
    public static final short EMCSSERIES_CAN_SET_ENERGY_RESPONSE = (short)0x0399;
    
    /**
     * Can帧透传命令
     */
    public static final short EMCSSERIES_CAN_SENDCANDATA_REQUEST = (short)0x0305;
    
    /**
     * Can帧透传响应
     */
    public static final short EMCSSERIES_CAN_SENDCANDATA_RESPONSE = (short)0x0385;
    
    
    /*************************************** 南车对应的CAN帧 *********************************************/
    public static final String EMCSSERIES_CSRZIC_CANID_0C03A1A7 = "0C03A1A7";

    public static final String EMCSSERIES_CSRZIC_CANID_0C04A1A7 = "0C04A1A7";

    public static final String EMCSSERIES_CSRZIC_CANID_0C05A1A7 = "0C05A1A7";

    public static final String EMCSSERIES_CSRZIC_CANID_0C06A1A7 = "0C06A1A7";

    public static final String EMCSSERIES_CSRZIC_CANID_0C079AA7 = "0C079AA7";

    public static final String EMCSSERIES_CSRZIC_CANID_0C07A1A7 = "0C07A1A7";

    public static final String EMCSSERIES_CSRZIC_CANID_0C07F2A7 = "0C07F2A7";

    public static final String EMCSSERIES_CSRZIC_CANID_0C08A1A7 = "0C08A1A7";

    public static final String EMCSSERIES_CSRZIC_CANID_0C08A79A = "0C08A79A";

    public static final String EMCSSERIES_CSRZIC_CANID_0C08A7F0 = "0C08A7F0";

    public static final String EMCSSERIES_CSRZIC_CANID_0C09A79B = "0C09A79B";

    public static final String EMCSSERIES_CSRZIC_CANID_0C09A7F0 = "0C09A7F0";

    public static final String EMCSSERIES_CSRZIC_CANID_0C0AA79D = "0C0AA79D";

    public static final String EMCSSERIES_CSRZIC_CANID_0C0AA7F2 = "0C0AA7F2";

    public static final String EMCSSERIES_CSRZIC_CANID_0C0BA7F2 = "0C0BA7F2";

    public static final String EMCSSERIES_CSRZIC_CANID_0C19A7A1 = "0C19A7A1";

    public static final String EMCSSERIES_CSRZIC_CANID_0C19F0A7 = "0C19F0A7";

    public static final String EMCSSERIES_CSRZIC_CANID_18XX28F3 = "18XX28F3";

    public static final String EMCSSERIES_CSRZIC_CANID_180028F4 = "180028F4";

    //public static final String EMCSSERIES_CSRZIC_CANID_180128F3 = "180128F3";

    public static final String EMCSSERIES_CSRZIC_CANID_1801A4A7 = "1801A4A7";

    //public static final String EMCSSERIES_CSRZIC_CANID_180228F3 = "180228F3";

    public static final String EMCSSERIES_CSRZIC_CANID_1802A7A4 = "1802A7A4";

    //public static final String EMCSSERIES_CSRZIC_CANID_180328F3 = "180328F3";

    public static final String EMCSSERIES_CSRZIC_CANID_1818A1A4 = "1818A1A4";

    public static final String EMCSSERIES_CSRZIC_CANID_1818D0F3 = "1818D0F3";

    public static final String EMCSSERIES_CSRZIC_CANID_1819A1A4 = "1819A1A4";

    public static final String EMCSSERIES_CSRZIC_CANID_1819D0F3 = "1819D0F3";

    public static final String EMCSSERIES_CSRZIC_CANID_181AD0F3 = "181AD0F3";

    public static final String EMCSSERIES_CSRZIC_CANID_180028F3 = "180028F3";

    public static final String EMCSSERIES_CSRZIC_CANID_18XX28F4 = "180028F4";

    public static final String EMCSSERIES_CSRZIC_CANID_180F8D80 = "180F8D80";
    
    public static final String EMCSSERIES_CSRZIC_CANID_180B808D = "180B808D";
    
    public static final String EMCSSERIES_CSRZIC_CANID_0C01A203 = "0C01A203";
    
    public static final String EMCSSERIES_CSRZIC_CANID_0C1AA7A1 = "0C1AA7A1";
    
    public static final String EMCSSERIES_CSRZIC_CANID_0C01F4A7 = "0C01F4A7";
    
    public static final String EMCSSERIES_CSRZIC_CANID_0C08A7F4 = "0C08A7F4";
    
    public static final String EMCSSERIES_CSRZIC_CANID_18019888 = "18019888";
    
    public static final String EMCSSERIES_CSRZIC_CANID_180A8898 = "180A8898";
    
    public static final String EMCSSERIES_CSRZIC_CANID_1805A89C = "1805A89C";
    
    public static final String EMCSSERIES_CSRZIC_CANID_18149CA8 = "18149CA8";
    
    public static final String EMCSSERIES_CSRZIC_CANID_18FF12F7 = "18FF12F7";
    
    public static final String EMCSSERIES_CSRZIC_CANID_10262B27 = "10262B27";
    
    public static final String EMCSSERIES_CSRZIC_CANID_0C00A709 = "0C00A709";
    
    public static final String EMCSSERIES_CSRZIC_CANID_0C01A709 = "0C01A709";
    
    public static final String EMCSSERIES_CSRZIC_CANID_0C02A709 = "0C02A709";
    
    public static final String EMCSSERIES_CSRZIC_CANID_0C03A709 = "0C03A709";
    
    public static final String EMCSSERIES_CSRZIC_CANID_0C04A709 = "0C04A709";
    
    public static final String EMCSSERIES_CSRZIC_CANID_0C05A709 = "0C05A709";
    
    public static final String EMCSSERIES_CSRZIC_CANID_0C06A709 = "0C06A709";
    
    public static final String EMCSSERIES_CSRZIC_CANID_0C07A709 = "0C07A709";
    
    public static final String EMCSSERIES_CSRZIC_CANID_0C08A709 = "0C08A709";
    
    public static final String EMCSSERIES_CSRZIC_CANID_0C09A709 = "0C09A709";
    
    public static final String EMCSSERIES_CSRZIC_CANID_0C0AA709 = "0C0AA709";
    
    public static final String EMCSSERIES_CSRZIC_CANID_0C0BA709 = "0C0BA709";
    
    public static final String EMCSSERIES_CSRZIC_CANID_0C0CA709 = "0C0CA709";
    
    public static final String EMCSSERIES_CSRZIC_CANID_0C0DA709 = "0C0DA709";
    
    public static final String EMCSSERIES_CSRZIC_CANID_0C0FA709 = "0C0FA709";
    
    public static final String EMCSSERIES_CSRZIC_CANID_0C10A709 = "0C10A709";
    
    public static final String EMCSSERIES_CSRZIC_CANID_0C11A709 = "0C11A709";
    
    public static final String EMCSSERIES_CSRZIC_CANID_0C0AA7F0 = "0C0AA7F0";
    
    public static final String EMCSSERIES_CSRZIC_CANID_181FD0F3 = "181FD0F3";
    
    public static final String EMCSSERIES_CSRZIC_CANID_0C01A2A7 = "0C01A2A7";

    public static final String EMCSSERIES_CSRZIC_CANID_0C02A2A7 = "0C02A2A7";

    public static final String EMCSSERIES_CSRZIC_CANID_18019EA7 = "18019EA7";

    public static final String EMCSSERIES_CSRZIC_CANID_18FFC09E = "18FFC09E";
    
    public static final String EMCSSERIES_CSRZIC_CANID_0CFFF3A7 = "0CFFF3A7";
	
	public static final String EMCSSERIES_CSRZIC_CANID_0CFEA719 = "0CFEA719";
    
    public static final String EMCSSERIES_CSRZIC_CANID_0CFF13F4 = "0CFF13F4";
    
    public static final String EMCSSERIES_CSRZIC_CANID_0C0CA7F2 = "0C0CA7F2";
    
    public static final String EMCSSERIES_CSRZIC_CANID_0C01A7B7 = "0C01A7B7";
    
    public static final String EMCSSERIES_CSRZIC_CANID_1808E5F4 = "1808E5F4";
    
    public static final String EMCSSERIES_CSRZIC_CANID_0C17A709 = "0C17A709";
    
    /*************************************** 奇瑞万达CAN帧 ***************************************************/
    public static final String EMCSSERIES_CHERY_CANID_18019888 = "18019888";
    
    public static final String EMCSSERIES_CHERY_CANID_180A8898 = "180A8898";
    
    public static final String EMCSSERIES_CHERY_CANID_1805A89C = "1805A89C";
    
    public static final String EMCSSERIES_CHERY_CANID_18149CA8 = "18149CA8";
    
    public static final String EMCSSERIES_CHERY_CANID_18FF12F7 = "18FF12F7";
    
    public static final String EMCSSERIES_CHERY_CANID_10262B27 = "10262B27";
    
    public static final String EMCSSERIES_CHERY_CANID_000001EF = "000001EF";
    
    public static final String EMCSSERIES_CHERY_CANID_000002EF = "000002EF";
    
    public static final String EMCSSERIES_CHERY_CANID_000003EF = "000003EF";
    
    public static final String EMCSSERIES_CHERY_CANID_000004EF = "000004EF";
    
    public static final String EMCSSERIES_CHERY_CANID_000005EF = "000005EF";
    
    public static final String EMCSSERIES_CHERY_CANID_000006EF = "000006EF";
    
    public static final String EMCSSERIES_CHERY_CANID_18FECA03 = "18FECA03";
    
    public static final String EMCSSERIES_CHERY_CANID_18FEF117 = "18FEF117";
    
    public static final String EMCSSERIES_CHERY_CANID_18FFA0F3 = "18FFA0F3";
    
    public static final String EMCSSERIES_CHERY_CANID_18FFA1F3 = "18FFA1F3";
    
    public static final String EMCSSERIES_CHERY_CANID_18FFA2F3 = "18FFA2F3";
    
    public static final String EMCSSERIES_CHERY_CANID_18FFA4F3 = "18FFA4F3";
    
    public static final String EMCSSERIES_CHERY_CANID_18FFA5F3 = "18FFA5F3";
    
    public static final String EMCSSERIES_CHERY_CANID_18FFA6F3 = "18FFA6F3";
    
    public static final String EMCSSERIES_CHERY_CANID_18FFA7F3 = "18FFA7F3";
    
    public static final String EMCSSERIES_CHERY_CANID_18FFAFF3 = "18FFAFF3";
    
    public static final String EMCSSERIES_CHERY_CANID_18FF31F0 = "18FF31F0";
    
    public static final String EMCSSERIES_CHERY_CANID_18FF41F0 = "18FF41F0";
    
    public static final String EMCSSERIES_CHERY_CANID_18FF51F0 = "18FF51F0";
    
    public static final String EMCSSERIES_CHERY_CANID_18FF81F0 = "18FF81F0";
    /*************************************** 陆地方舟对应的CAN帧 ***************************************************/
    public static final String EMCSSERIES_GREENWHEEL_CANID_0CF814F3 = "0CF814F3";

    public static final String EMCSSERIES_GREENWHEEL_CANID_0CF80AF0 = "0CF80AF0";

    public static final String EMCSSERIES_GREENWHEEL_CANID_0CF80BF0 = "0CF80BF0";
    
	public static final String EMCSSERIES_GREENWHEEL_CANID_0C08A7F0 = "0C08A7F0";

    public static final String EMCSSERIES_GREENWHEEL_CANID_18F815F3 = "18F815F3";

    public static final String EMCSSERIES_GREENWHEEL_CANID_18F816F3 = "18F816F3";
    
    public static final String EMCSSERIES_GREENWHEEL_CANID_0C19F0A7 = "0C19F0A7";
    
    public static final String EMCSSERIES_GREENWHEEL_CANID_0C1AF3A7 = "0C1AF3A7";
    
    public static final String EMCSSERIES_GREENWHEEL_CANID_180165F4 = "180165F4";
    
    public static final String EMCSSERIES_GREENWHEEL_CANID_180265F4 = "180265F4";
    
    public static final String EMCSSERIES_GREENWHEEL_CANID_180365F4 = "180365F4";
    
    public static final String EMCSSERIES_GREENWHEEL_CANID_0CF81EA7 = "0CF81EA7";
    
    public static final String EMCSSERIES_GREENWHEEL_CANID_0CF81FA7 = "0CF81FA7";
    
    public static final String EMCSSERIES_GREENWHEEL_CANID_0C1BA7F2 = "0C1BA7F2";
    
    public static final String EMCSSERIES_GREENWHEEL_CANID_0C09F2A7 = "0C09F2A7";
    
    public static final String EMCSSERIES_GREENWHEEL_CANID_0CF828F2 = "0CF828F2";

    public static final String EMCSSERIES_GREENWHEEL_CANID_0CF829F2 = "0CF829F2";
    
    public static final String EMCSSERIES_GREENWHEEL_CANID_18FF0B19 = "18FF0B19";
    
    /****************************************申沃对应的CAN帧 ************************************************/
    public static final String EMCSSERIES_SUNWO_CANID_0C0A28D0 = "0C0A28D0";

    public static final String EMCSSERIES_SUNWO_CANID_0C2030EF = "0C2030EF";

    public static final String EMCSSERIES_SUNWO_CANID_0CFF3F27 = "0CFF3F27";

    public static final String EMCSSERIES_SUNWO_CANID_1810EF30 = "1810EF30";

    public static final String EMCSSERIES_SUNWO_CANID_1838D028 = "1838D028";

    public static final String EMCSSERIES_SUNWO_CANID_18FECAF3 = "18FECAF3";

    public static final String EMCSSERIES_SUNWO_CANID_18FEF433 = "18FEF433";

    public static final String EMCSSERIES_SUNWO_CANID_18FF01A7 = "18FF01A7";

    public static final String EMCSSERIES_SUNWO_CANID_18FF01B4 = "18FF01B4";

    public static final String EMCSSERIES_SUNWO_CANID_18FF01F3 = "18FF01F3";

    public static final String EMCSSERIES_SUNWO_CANID_18FF02F3 = "18FF02F3";

    public static final String EMCSSERIES_SUNWO_CANID_18FF03F3 = "18FF03F3";

    public static final String EMCSSERIES_SUNWO_CANID_18FF04F3 = "18FF04F3";

    public static final String EMCSSERIES_SUNWO_CANID_18FF8E03 = "18FF8E03";

    public static final String EMCSSERIES_SUNWO_CANID_18FF8F03 = "18FF8F03";

    public static final String EMCSSERIES_SUNWO_CANID_18FF9003 = "18FF9003";

    public static final String EMCSSERIES_SUNWO_CANID_1C1500F3 = "1C1500F3";

    public static final String EMCSSERIES_SUNWO_CANID_1C1600F3 = "1C1600F3";

    public static final String EMCSSERIES_SUNWO_CANID_1838D128 = "1838D128";

    public static final String EMCSSERIES_SUNWO_CANID_14FF00A6 = "14FF00A6";
    
    public static final String EMCSSERIES_SUNWO_CANID_14FF02A3 = "14FF02A3";
    
    public static final String EMCSSERIES_SUNWO_CANID_18FEF1A6 = "18FEF1A6";
    
    public static final String EMCSSERIES_SUNWO_CANID_18FEF2A6 = "18FEF2A6";
    
    public static final String EMCSSERIES_SUNWO_CANID_18FEF3A6 = "18FEF3A6";
    
    public static final String EMCSSERIES_SUNWO_CANID_18FEF4A6 = "18FEF4A6";
    
    public static final String EMCSSERIES_SUNWO_CANID_18FFC017 = "18FFC017";
    
    /***************************************南京金龙****************************************/
    public static final String EMCSSERIES_GDBUS_CANID_08F200A0 = "08F200A0";

    public static final String EMCSSERIES_GDBUS_CANID_0C08A7F0 = "0C08A7F0";

    public static final String EMCSSERIES_GDBUS_CANID_0C09A7F0 = "0C09A7F0";

    public static final String EMCSSERIES_GDBUS_CANID_0C20A0A6 = "0C20A0A6";

    public static final String EMCSSERIES_GDBUS_CANID_0CFF0008 = "0CFF0008";

    public static final String EMCSSERIES_GDBUS_CANID_0CFF0108 = "0CFF0108";

    public static final String EMCSSERIES_GDBUS_CANID_0CFF0208 = "0CFF0208";

    public static final String EMCSSERIES_GDBUS_CANID_10F8159E = "10F8159E";

    public static final String EMCSSERIES_GDBUS_CANID_10F89E01 = "10F89E01";

    public static final String EMCSSERIES_GDBUS_CANID_1810A6A0 = "1810A6A0";

    public static final String EMCSSERIES_GDBUS_CANID_1811A6A0 = "1811A6A0";

    public static final String EMCSSERIES_GDBUS_CANID_18F8199E = "18F8199E";

    public static final String EMCSSERIES_GDBUS_CANID_18F81B9E = "18F81B9E";

    public static final String EMCSSERIES_GDBUS_CANID_18F81F9E = "18F81F9E";

    public static final String EMCSSERIES_GDBUS_CANID_18FFA1F3 = "18FFA1F3";

    public static final String EMCSSERIES_GDBUS_CANID_18FFA2F3 = "18FFA2F3";

    public static final String EMCSSERIES_GDBUS_CANID_18FFA4F3 = "18FFA4F3";

    public static final String EMCSSERIES_GDBUS_CANID_18FFA5F3 = "18FFA5F3";

    public static final String EMCSSERIES_GDBUS_CANID_18F81E9E = "18F81E9E";

    public static final String EMCSSERIES_GDBUS_CANID_041000A0 = "041000A0";

    public static final String EMCSSERIES_GDBUS_CANID_0C0AA7F0 = "0C0AA7F0";

    public static final String EMCSSERIES_GDBUS_CANID_18FF50E5 = "18FF50E5";

    public static final String EMCSSERIES_GDBUS_CANID_10F81D9E = "10F81D9E";
    
    public static final String EMCSSERIES_GDBUS_CANID_08F10501 = "08F10501";
    
    public static final String EMCSSERIES_GDBUS_CANID_18C2FFF4 = "18C2FFF4";
    
    public static final String EMCSSERIES_GDBUS_CANID_1812F456 = "1812F456"; 
    
    public static final String EMCSSERIES_GDBUS_CANID_1806E5F4 = "1806E5F4"; 
    
    public static final String EMCSSERIES_GDBUS_CANID_1807E5F4 = "1807E5F4";
    
    public static final String EMCSSERIES_GDBUS_CANID_18C012F4 = "18C012F4";
    
    public static final String EMCSSERIES_GDBUS_CANID_18C0EFF4 = "18C0EFF4";
    
    public static final String EMCSSERIES_GDBUS_CANID_18C0F4EF = "18C0F4EF";
    
    public static final String EMCSSERIES_GDBUS_CANID_18F002F4 = "18F002F4";
    
    public static final String EMCSSERIES_GDBUS_CANID_18F010F4 = "18F010F4";
    
    public static final String EMCSSERIES_GDBUS_CANID_18F011F4 = "18F011F4";
    
    public static final String EMCSSERIES_GDBUS_CANID_18F012F4 = "18F012F4";
    
    public static final String EMCSSERIES_GDBUS_CANID_1CFF14F4 = "1CFF14F4";

    /*************************************唐骏*********************************************/
    public static final String EMCSSERIES_TJ_CANID_18XXD1F3VOL = "18XXD1F3VOL";

    public static final String EMCSSERIES_TJ_CANID_18XXD1F3TEMP = "18XXD1F3TEMP";

    public static final String EMCSSERIES_TJ_CANID_1801D0F4 = "1801D0F4";

    public static final String EMCSSERIES_TJ_CANID_1802D0F4 = "1802D0F4";

    public static final String EMCSSERIES_TJ_CANID_1803D0F4 = "1803D0F4";

    public static final String EMCSSERIES_TJ_CANID_1804D0F4 = "1804D0F4";

    public static final String EMCSSERIES_TJ_CANID_1805D0F4 = "1805D0F4";

    public static final String EMCSSERIES_TJ_CANID_1806D0F4 = "1806D0F4";

    public static final String EMCSSERIES_TJ_CANID_1807D0F4 = "1807D0F4";

    public static final String EMCSSERIES_TJ_CANID_18E4A5A6 = "18E4A5A6";

    public static final String EMCSSERIES_TJ_CANID_0C09A6A7 = "0C09A6A7";

    public static final String EMCSSERIES_TJ_CANID_18FF50E5 = "18FF50E5";

    public static final String EMCSSERIES_TJ_CANID_1808D0F4 = "1808D0F4";

    public static final String EMCSSERIES_TJ_CANID_180BD0F4 = "180BD0F4";

    public static final String EMCSSERIES_TJ_CANID_1809D0F4 = "1809D0F4";

    public static final String EMCSSERIES_TJ_CANID_180AD0F4 = "180AD0F4";
    
    public static final String EMCSSERIES_TJ_CANID_1801D017 = "1801D017";
    
    public static final String EMCSSERIES_TJ_CANID_1806E5F4 = "1806E5F4";
    
    public static final String EMCSSERIES_TJ_CANID_180CD0F4 = "180CD0F4";
    
    public static final String EMCSSERIES_TJ_CANID_0C0128D0 = "0C0128D0";
    
    public static final String EMCSSERIES_TJ_CANID_0C0228D0 = "0C0228D0";

    public static final String EMCSSERIES_TJ_CANID_0CFA02D0 = "0CFA02D0";
    /*************************************卡威*********************************************/
    public static final String EMCSSERIES_KW_CANID_0C71D0D2 = "0C71D0D2";
    
    public static final String EMCSSERIES_KW_CANID_0C72D0D2 = "0C72D0D2";
    
    public static final String EMCSSERIES_KW_CANID_1873D0D2 = "1873D0D2";
    
    public static final String EMCSSERIES_KW_CANID_1874D0D2 = "1874D0D2";
    
    public static final String EMCSSERIES_KW_CANID_1875D0D2 = "1875D0D2";
    
    public static final String EMCSSERIES_KW_CANID_1876D0D2 = "1876D0D2";
    
    public static final String EMCSSERIES_KW_CANID_0C77D2D0 = "0C77D2D0";
    
    public static final String EMCSSERIES_KW_CANID_0C68D0D1 = "0C68D0D1";
    
    public static final String EMCSSERIES_KW_CANID_0C69D0D1 = "0C69D0D1";
    
    public static final String EMCSSERIES_KW_CANID_0C6AD0D1 = "0C6AD0D1";
    
    public static final String EMCSSERIES_KW_CANID_0C6BD1D0 = "0C6BD1D0";
    
    public static final String EMCSSERIES_KW_CANID_1884D3D0 = "1884D3D0";
    
    public static final String EMCSSERIES_KW_CANID_1885D3D0 = "1885D3D0";
    
    public static final String EMCSSERIES_KW_CANID_1886D3D0 = "1886D3D0";
    
    public static final String EMCSSERIES_KW_CANID_1887D3D0 = "1887D3D0";
    
    public static final String EMCSSERIES_KW_CANID_0C88D0D3 = "0C88D0D3";
    
    public static final String EMCSSERIES_KW_CANID_18F0D0D4 = "18F0D0D4";
    public static final String EMCSSERIES_KW_CANID_0C07F0A7 = "0C07F0A7";

    public static final String EMCSSERIES_KW_CANID_0C08A7F0 = "0C08A7F0";

    public static final String EMCSSERIES_KW_CANID_0C09A7F0 = "0C09A7F0";

    public static final String EMCSSERIES_KW_CANID_0C0AA7F0 = "0C0AA7F0";

    public static final String EMCSSERIES_KW_CANID_0C109E27 = "0C109E27";

    public static final String EMCSSERIES_KW_CANID_10F8159E = "10F8159E";

    public static final String EMCSSERIES_KW_CANID_10F8169E = "10F8169E";

    public static final String EMCSSERIES_KW_CANID_10F81D9E = "10F81D9E";

    public static final String EMCSSERIES_KW_CANID_10F81E9E = "10F81E9E";

    public static final String EMCSSERIES_KW_CANID_10F81F9E = "10F81F9E";

    public static final String EMCSSERIES_KW_CANID_18F8179E = "18F8179E";

    public static final String EMCSSERIES_KW_CANID_18F8189E = "18F8189E";

    public static final String EMCSSERIES_KW_CANID_18F8199E = "18F8199E";

    public static final String EMCSSERIES_KW_CANID_18F81A9E = "18F81A9E";

    public static final String EMCSSERIES_KW_CANID_18F81B9E = "18F81B9E";

    public static final String EMCSSERIES_KW_CANID_18F81C9E = "18F81C9E";

    public static final String EMCSSERIES_KW_CANID_18F81F27 = "18F81F27";

    public static final String EMCSSERIES_KW_CANID_08F200A0 = "08F200A0";

    public static final String EMCSSERIES_KW_CANID_08F10501 = "08F10501";

    public static final String EMCSSERIES_KW_CANID_18F81F9E = "18F81F9E";

    /*************************************南京依维柯*********************************************/
    public static final String EMCSSERIES_NAVECO_CANID_0C0101F3 = "0C0101F3";

    public static final String EMCSSERIES_NAVECO_CANID_0C01EF01 = "0C01EF01";

    public static final String EMCSSERIES_NAVECO_CANID_0C0201F3 = "0C0201F3";

    public static final String EMCSSERIES_NAVECO_CANID_0C0401F3 = "0C0401F3";

    public static final String EMCSSERIES_NAVECO_CANID_0CFF82EF = "0CFF82EF";

    public static final String EMCSSERIES_NAVECO_CANID_0CFF84EF = "0CFF84EF";

    public static final String EMCSSERIES_NAVECO_CANID_10FF4117 = "10FF4117";

    public static final String EMCSSERIES_NAVECO_CANID_18011701 = "18011701";

    public static final String EMCSSERIES_NAVECO_CANID_1801F301 = "1801F301";

    public static final String EMCSSERIES_NAVECO_CANID_18021701 = "18021701";

    public static final String EMCSSERIES_NAVECO_CANID_180301F3 = "180301F3";

    public static final String EMCSSERIES_NAVECO_CANID_180501F3 = "180501F3";

    public static final String EMCSSERIES_NAVECO_CANID_180601F3 = "180601F3";

    public static final String EMCSSERIES_NAVECO_CANID_18F1B917 = "18F1B917";

    public static final String EMCSSERIES_NAVECO_CANID_18FEC1EE = "18FEC1EE";

    public static final String EMCSSERIES_NAVECO_CANID_18FF83EF = "18FF83EF";

    public static final String EMCSSERIES_NAVECO_CANID_18FF85EF = "18FF85EF";

    public static final String EMCSSERIES_NAVECO_CANID_18FFFF01 = "18FFFF01";

    public static final String EMCSSERIES_NAVECO_CANID_18FFFF02 = "18FFFF02";

    public static final String EMCSSERIES_NAVECO_CANID_18FFFF03 = "18FFFF03";

    /*************************************上汽大通*********************************************/
    public static final String EMCSSERIES_MAXUS_CANID_00000230 = "00000230";

    public static final String EMCSSERIES_MAXUS_CANID_0000008A = "0000008A";

    public static final String EMCSSERIES_MAXUS_CANID_00000380 = "00000380";

    public static final String EMCSSERIES_MAXUS_CANID_00000300 = "00000300";

    public static final String EMCSSERIES_MAXUS_CANID_00000301 = "00000301";

    public static final String EMCSSERIES_MAXUS_CANID_00000302 = "00000302";

    public static final String EMCSSERIES_MAXUS_CANID_00000303 = "00000303";

    public static final String EMCSSERIES_MAXUS_CANID_00000310 = "00000310";

    public static final String EMCSSERIES_MAXUS_CANID_00000321 = "00000321";

    public static final String EMCSSERIES_MAXUS_CANID_00000322 = "00000322";

    public static final String EMCSSERIES_MAXUS_CANID_00000323 = "00000323";

    public static final String EMCSSERIES_MAXUS_CANID_00000200 = "00000200";

    public static final String EMCSSERIES_MAXUS_CANID_00000500 = "00000500";

    public static final String EMCSSERIES_MAXUS_CANID_00000510 = "00000510";

    public static final String EMCSSERIES_MAXUS_CANID_00000520 = "00000520";

    public static final String EMCSSERIES_MAXUS_CANID_00000530 = "00000530";

    public static final String EMCSSERIES_MAXUS_CANID_00000540 = "00000540";

    public static final String EMCSSERIES_MAXUS_CANID_00000550 = "00000550";

    public static final String EMCSSERIES_MAXUS_CANID_181156F4 = "181156F4";

    public static final String EMCSSERIES_MAXUS_CANID_181356F4 = "181356F4";

    public static final String EMCSSERIES_MAXUS_CANID_1812F456 = "1812F456";

    public static final String EMCSSERIES_MAXUS_CANID_00000260 = "00000260";

    public static final String EMCSSERIES_MAXUS_CANID_00000272 = "00000272";

    public static final String EMCSSERIES_MAXUS_CANID_00000274 = "00000274";

    public static final String EMCSSERIES_MAXUS_CANID_00000560 = "00000560";

    public static final String EMCSSERIES_MAXUS_CANID_00000570 = "00000570";

    public static final String EMCSSERIES_MAXUS_CANID_00000580 = "00000580";

    public static final String EMCSSERIES_MAXUS_CANID_00000590 = "00000590";

    public static final String EMCSSERIES_MAXUS_CANID_00000600 = "00000600";

    public static final String EMCSSERIES_MAXUS_CANID_00000601 = "00000601";

    public static final String EMCSSERIES_MAXUS_CANID_00000602 = "00000602";

    /*************************************舒驰*********************************************/
    public static final String EMCSSERIES_BESTBUS_CANID_0CF041D0 = "0CF041D0";

    public static final String EMCSSERIES_BESTBUS_CANID_0CFFC9D0 = "0CFFC9D0";

    public static final String EMCSSERIES_BESTBUS_CANID_18F501F0 = "18F501F0";

    public static final String EMCSSERIES_BESTBUS_CANID_18F502F0 = "18F502F0";

    public static final String EMCSSERIES_BESTBUS_CANID_18FB7017 = "18FB7017";

    public static final String EMCSSERIES_BESTBUS_CANID_18FB7117 = "18FB7117";

    public static final String EMCSSERIES_BESTBUS_CANID_18FF217B = "18FF217B";

    public static final String EMCSSERIES_BESTBUS_CANID_18FF247B = "18FF247B";

    public static final String EMCSSERIES_BESTBUS_CANID_18FF257B = "18FF257B";
    public static final String EMCSSERIES_BESTBUS_CANID_18FF227B = "18FF227B";
    public static final String EMCSSERIES_BESTBUS_CANID_18FF297B = "18FF297B";
    public static final String EMCSSERIES_BESTBUS_CANID_18FFA97B = "18FFA97B";
    public static final String EMCSSERIES_BESTBUS_CANID_13CC16B2 = "13CC16B2";
    
	 public static final String EMCSSERIES_BESTBUS_CANID_104C1991 = "104C1991";
    
    public static final String EMCSSERIES_BESTBUS_CANID_104C1992 = "104C1992";
    
    public static final String EMCSSERIES_BESTBUS_CANID_104C1993 = "104C1993";
    
    public static final String EMCSSERIES_BESTBUS_CANID_104C1997 = "104C1997";
    
    public static final String EMCSSERIES_BESTBUS_CANID_0CFFCAD0 = "0CFFCAD0";
    
    public static final String EMCSSERIES_BESTBUS_CANID_1801A79D = "1801A79D";
    
    public static final String EMCSSERIES_BESTBUS_CANID_1801A79B = "1801A79B";
    
    public static final String EMCSSERIES_BESTBUS_CANID_1801A79C = "1801A79C";
    
    public static final String EMCSSERIES_BESTBUS_CANID_104C19XX = "104C19XX";
    
    public static final String EMCSSERIES_BESTBUS_CANID_104C1AXXTEMPLOW = "104C1AXXTEMPLOW";
    
    public static final String EMCSSERIES_BESTBUS_CANID_104C1AXXTEMPHIGH = "104C1AXXTEMPHIGH";
    
    public static final String EMCSSERIES_BESTBUS_CANID_104CXXXX = "104CXXXX";

    
    /*************************************ATL电池*********************************************/
    public static final String EMCSSERIES_ATLBATTERY_CANID_000000C1 = "000000C1";

    public static final String EMCSSERIES_ATLBATTERY_CANID_000000C4 = "000000C4";

    public static final String EMCSSERIES_ATLBATTERY_CANID_000000C5 = "000000C5";

    public static final String EMCSSERIES_ATLBATTERY_CANID_000001A0 = "000001A0";

    /***************************************中国重汽*******************************************/
    public static final String EMCSSERIES_CNHTC_CANID_18EF4AEF = "18EF4AEF";
    
    public static final String EMCSSERIES_CNHTC_CANID_18EF4BEF = "18EF4BEF";
    
    public static final String EMCSSERIES_CNHTC_CANID_18EF4EEF = "18EF4EEF";
    
    public static final String EMCSSERIES_CNHTC_CANID_18FECAEF = "18FECAEF";
    
    public static final String EMCSSERIES_CNHTC_CANID_18FEF117 = "18FEF117";
    
    public static final String EMCSSERIES_CNHTC_CANID_18FFA4F3 = "18FFA4F3";
    
    public static final String EMCSSERIES_CNHTC_CANID_18FFA5F3 = "18FFA5F3";
    
    public static final String EMCSSERIES_CNHTC_CANID_18FFAFF3 = "18FFAFF3";
    
    /***************************************上汽万向*******************************************/
    public static final String EMCSSERIES_SAICWANXIANG_CANID_18FF01F3 = "18FF01F3";
    
    public static final String EMCSSERIES_SAICWANXIANG_CANID_18FF02F3 = "18FF02F3";
    
    public static final String EMCSSERIES_SAICWANXIANG_CANID_18FF03F3 = "18FF03F3";
    
    public static final String EMCSSERIES_SAICWANXIANG_CANID_0CFE09EF = "0CFE09EF";
    
    public static final String EMCSSERIES_SAICWANXIANG_CANID_0CFF09EF = "0CFF09EF";
    
    public static final String EMCSSERIES_SAICWANXIANG_CANID_18FF8E09 = "18FF8E09";
    
    public static final String EMCSSERIES_SAICWANXIANG_CANID_18FF8D09 = "18FF8D09";
    
    public static final String EMCSSERIES_SAICWANXIANG_CANID_18FF01A7 = "18FF01A7";
    
    public static final String EMCSSERIES_SAICWANXIANG_CANID_18FEFAA6 = "18FEFAA6";
    
    public static final String EMCSSERIES_SAICWANXIANG_CANID_18FF02A7 = "18FF02A7";
    
    public static final String EMCSSERIES_SAICWANXIANG_CANID_181028EF = "181028EF";
    
    public static final String EMCSSERIES_SAICWANXIANG_CANID_180AEF28 = "180AEF28";
    
    public static final String EMCSSERIES_SAICWANXIANG_CANID_18FDFF13 = "18FDFF13";
    
    public static final String EMCSSERIES_SAICWANXIANG_CANID_181628EF = "181628EF";
    
    public static final String EMCSSERIES_SAICWANXIANG_CANID_181428EF = "181428EF";
    
    public static final String EMCSSERIES_SAICWANXIANG_CANID_18FDFF1A = "18FDFF1A";
    
    public static final String EMCSSERIES_SAICWANXIANG_CANID_18FDFF1E = "18FDFF1E";
    
    public static final String EMCSSERIES_SAICWANXIANG_CANID_0CFDFFD0 = "0CFDFFD0";
    
    public static final String EMCSSERIES_SAICWANXIANG_CANID_18FEF100 = "18FEF100";
    
    public static final String EMCSSERIES_SAICWANXIANG_CANID_181228EF = "181228EF";
    
    public static final String EMCSSERIES_SAICWANXIANG_CANID_18F005EF = "18F005EF";
    public static final String EMCSSERIES_SAICWANXIANG_CANID_188117F3 = "188117F3";
    
    public static final String EMCSSERIES_SAICWANXIANG_CANID_188217F3 = "188217F3";
    
    public static final String EMCSSERIES_SAICWANXIANG_CANID_188317F3 = "188317F3";
    
    public static final String EMCSSERIES_SAICWANXIANG_CANID_188417F3 = "188417F3";
    
    public static final String EMCSSERIES_SAICWANXIANG_CANID_18XX17F3VOL = "18XX17F3VOL";
}
