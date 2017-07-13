package com.gimis.emcs.ps.msg.util;

import java.text.DecimalFormat;

public class MessageTools {

	/**
     * 返回6位小数double
     * @param value
     * @return
     */
    public static double getSixDoubleValue(double value)
    {
        DecimalFormat  df = new DecimalFormat("#.000000");
        return Double.parseDouble(df.format(value));
    }
    
    /**
     * 将short负值改为正值
     * @param value
     * @return
     */
    public static int getShortValue(short value) {
        // TODO Auto-generated method stub
        int relayValue = value;
        if(value < 0)
        {
            relayValue = 65536-Math.abs(value);
        }
        return relayValue;
    }
    
    public static Long getIntValue(int value)
    {
        long relayValue = value;
        if (value < 0)
        {
            relayValue = 4294967296L - Math.abs(value);
        }
        return relayValue;
    }
}
