package com.gimis.emcs.domain.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {
	/**
     * 默认日期格式yyyy-MM-dd
     */
    public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";

    /**
     * 默认时间格式HH:mm:ss
     */
    public static final String DEFAULT_TIME_PATTERN = "HH:mm:ss";

    /**
     * 中文时分格式HH:mm
     */
    public static final String CN_TIME_PATTERN = "HH时mm分";

    /**
     * 默认日期时间格式yyyy-MM-dd HH:mm:ss
     */
    public static final String DEFAULT_DATETIME_PATTERN = DEFAULT_DATE_PATTERN + " " + DEFAULT_TIME_PATTERN;

    /**
     * 默认带毫秒的日期时间格式yyyy-MM-dd HH:mm:ss.SSS
     */
    public static final String DEFAULT_DATETIME_MILLISECOND_PATTERN = DEFAULT_DATETIME_PATTERN + ".SSS";

    /**
     * 年份格式
     */
    public static final String DEFAULT_YEAR_PATTERN = "yyyy";

    /**
     * 月份格式
     */
    public static final String DEFAULT_YEAR_MONTH_PATTERN = "yyyy-MM";

    /**
     * 中文月份格式
     */
    public static final String CN_MONTH_PATTERN = "yyyy年MM月";

    /**
     * 14位（秒级）时间戳
     */
    public static final String TIMESTAMP_SECOND = "yyyyMMddHHmmss";

    /**
     * 17位（毫秒级）时间戳
     */
    public static final String TIMESTAMP_MILLISECOND = "yyyyMMddHHmmssSSS";

    /**
     * 采用默认日期格式的日期格式化类
     */
    private static final SimpleDateFormat DEFAULT_DATE_SIMPLEDATEFORMAT = new SimpleDateFormat(DEFAULT_DATE_PATTERN);

    private static final Object SYNC_KEY_DEFAULT_DATE_SIMPLEDATEFORMAT = new Object();

    private static final Object SYNC_KEY_DEFAULT_DATETIME_SIMPLEDATEFORMAT = new Object();
    
    /**
     * 采用默认日期时间格式的日期格式化类
     */
    private static final SimpleDateFormat DEFAULT_DATETIME_SIMPLEDATEFORMAT = new SimpleDateFormat(
            DEFAULT_DATETIME_PATTERN);

    /**
     * 使用默认格式（yyyy-MM-dd）将字符串转化为日期对象，如果无法格式化，则返回null
     * @param s 日期字符串
     * @return 日期对象
     */
    public static Date parseWithoutThrowException(String s)
    {
        try
        {
            return parse(s);
        }
        catch (Exception ex)
        {
        	ex.printStackTrace();
            return null;
        }
    }
    
    /**
     * 使用默认日期时间格式格式化时间
     * @param date 时间
     * @return 日期时间字符串，格式为yyyy-MM-dd HH:mm:ss
     */
    public static String formatDateTime(Date date)
    {
        synchronized (SYNC_KEY_DEFAULT_DATETIME_SIMPLEDATEFORMAT)
        {
            return DEFAULT_DATETIME_SIMPLEDATEFORMAT.format(date);
        }
    }
    
    /**
     * 使用指定的格式将字符串转化为日期对象，如果无法格式化，则返回null
     * @param s 日期字符串
     * @param pattern 格式
     * @return 日期对象
     */
    public static Date parseWithoutThrowException(String s , String pattern)
    {
        try
        {
            return parse(s, pattern);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }
    
    /**
     * 使用默认格式（yyyy-MM-dd）将字符串转化为日期对象
     * @param s 日期字符串，要求格式必须为yyyy-MM-dd
     * @return 日期对象
     * @throws ParseException 格式化异常
     */
    public static Date parse(String s) throws ParseException
    {
        synchronized (SYNC_KEY_DEFAULT_DATE_SIMPLEDATEFORMAT)
        {
            return DEFAULT_DATE_SIMPLEDATEFORMAT.parse(s);
        }
    }
    
    /**
     * 使用指定的格式将字符串转化为日期对象
     * @param s 日期字符串
     * @param pattern 格式
     * @return 日期对象
     * @throws ParseException
     */
    public static Date parse(String s , String pattern) throws ParseException
    {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        sdf.setLenient(true);
        return sdf.parse(s);
    }
}
