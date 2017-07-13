
package com.gimis.emcs.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.DataSources;
import com.mchange.v2.c3p0.PooledDataSource;

/**
 * c3p0连接池管理类
 */
public class C3P0DBUtil
{

    private static final String JDBC_DRIVER = "driverClass";

    private static final String JDBC_URL = "jdbcUrl";

    private static DataSource ds;

    static
    {
        initDBSource();
    }

    /**
     * 初始化c3p0连接池
     */
    private static final void initDBSource()
    {
        Properties c3p0Pro = new Properties();
        try
        {
            // 加载配置文件
            c3p0Pro.load(C3P0DBUtil.class.getClassLoader().getResourceAsStream("c3p0.properties"));
        }
        catch (Exception e)
        {
            LogUtil.getLogger(C3P0DBUtil.class).error("加载数据库配置文件异常", e);
        }

        String drverClass = c3p0Pro.getProperty(JDBC_DRIVER);
        if (drverClass != null)
        {
            try
            {
                // 加载驱动类
                Class.forName(drverClass);
            }
            catch (ClassNotFoundException e)
            {
                LogUtil.getLogger(C3P0DBUtil.class).error("加载数据库驱动异常", e);
                return;
            }

        }

        Properties jdbcpropes = new Properties();
        Properties c3propes = new Properties();
        for (Object key : c3p0Pro.keySet())
        {
            String skey = (String) key;
            if (skey.startsWith("c3p0."))
            {
                c3propes.put(skey, c3p0Pro.getProperty(skey));
            }
            else
            {
                jdbcpropes.put(skey, c3p0Pro.getProperty(skey));
            }
        }

        try
        {
            // 建立连接池
            DataSource unPooled = DataSources.unpooledDataSource(c3p0Pro.getProperty(JDBC_URL), jdbcpropes);
            ds = DataSources.pooledDataSource(unPooled, c3propes);
        }
        catch (SQLException e)
        {
            LogUtil.getLogger(C3P0DBUtil.class).error("加载数据库连接池异常", e);
        }
    }

    /**
     * 获取池化的dataSource对象
     * 
     * @return
     */
    public static DataSource getDataSource()
    {
        return ds;
    }

    public static void closeDataSource(DataSource ds)
    {
        try
        {
            ((PooledDataSource) ds).close();
            LogUtil.getLogger(C3P0DBUtil.class).debug("释放连接池");
        }
        catch (SQLException e)
        {
            LogUtil.getLogger(C3P0DBUtil.class).error("释放连接池异常");
        }
    }

    /**
     * 获取数据库连接对象
     * 
     * @return 数据连接对象
     * @throws SQLException
     */
    public static synchronized Connection getConnection() throws SQLException
    {
        final Connection conn = ds.getConnection();
        conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        return conn;
    }

    public static void attemptClose(ResultSet o)
    {
        try
        {
            if (o != null)
                o.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void attemptClose(Statement o)
    {
        try
        {
            if (o != null)
                o.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void attemptClose(Connection o)
    {
        try
        {
            if (o != null)
                o.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
