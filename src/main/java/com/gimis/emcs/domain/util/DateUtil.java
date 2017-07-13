package com.gimis.emcs.domain.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public final class DateUtil {
    
    /**
     * 获取当前时间偏移若干毫秒之后的时间
     * @param date 待偏移的时间
     * @param offset 偏移的毫秒，整数表示时间向后偏移，负数表示时间向前偏移
     * @return 偏移之后的时间
     */
    public static Date getOffsetMillisecond(Date date , int offset)
    {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(GregorianCalendar.MILLISECOND, offset);
        return calendar.getTime();
    }

    /**
     * 获取当前时间偏移若干秒之后的时间
     * @param offset 偏移的秒，正数表示时间向后偏移，负数表示时间向前偏移
     * @return 偏移之后的时间
     */
    public static Date getOffsetSecond(Date date , int offset)
    {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(GregorianCalendar.SECOND, offset);
        return calendar.getTime();
    }

    /**
     * 获取当前时间偏移若干分钟之后的时间
     * @param date 需要偏移的时间
     * @param offset 偏移的分钟，正数表示时间向后偏移，负数表示时间向前偏移
     * @return 偏移之后的时间
     */
    public static Date getOffsetMinute(Date date , int offset)
    {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(GregorianCalendar.MINUTE, offset);
        return calendar.getTime();
    }

    /**
     * 获取当前时间偏移若干小时之后的时间
     * @param date 需要偏移的时间
     * @param offset 偏移的分钟，正数表示时间向后偏移，负数表示时间向前偏移
     * @return 偏移之后的时间
     */
    public static Date getOffsetHour(Date date , int offset)
    {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(GregorianCalendar.HOUR_OF_DAY, offset);
        return calendar.getTime();
    }

    /**
     * 根据指定是日期，获取偏移的日期
     * @param date
     * @param offset
     * @return
     */
    public static Date getOffsetDate(Date date , int offset)
    {
        if (null != date)
        {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_MONTH, offset);
            return calendar.getTime();
        }
        else
        {
            return null;
        }
    }

    /**
     * 根据指定是日期，获取偏移月份后的日期
     * @param date
     * @param offset 偏移月数
     * @return
     */
    public static Date getOffsetMonth(Date date , int offset)
    {
        if (null != date)
        {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.MONTH, offset);
            return calendar.getTime();
        }
        else
        {
            return null;
        }
    }

    /**
     * 根据指定是日期，获取偏移年份后的日期
     * @param date
     * @param offset 偏移年数
     * @return
     */
    public static Date getOffsetYear(Date date , int offset)
    {
        if (null != date)
        {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.YEAR, offset);
            return calendar.getTime();
        }
        else
        {
            return null;
        }
    }
	
}
