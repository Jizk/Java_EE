package pm.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * JDBC工具类
 * @author JiZhongkai
 *
 */

public class JdbcUtil {
	private static String url = null;
	private static String user = null;
	private static String password = null;
	private static String driverClass = null;
	/**
	 * 注册驱动程序
	 */
	static{
		try {
			
			//读取properties文件
			Properties pro  = new Properties();
			/*FileInputStream inputStream = new FileInputStream("./src/db.properties");*/
			/**
			 * 使用类路径的读取方式
			 * / 表示classpath的根目录
			 * 在java项目中，从bin目录开始
			 * 在web项目中，从WEB-INF/classes目录开始
			 */
			InputStream inputStream = JdbcUtil.class.getResourceAsStream("/db.properties");
			
			pro.load(inputStream);
			
			url = pro.getProperty("url");
			user = pro.getProperty("user");
			password = pro.getProperty("password");
			driverClass = pro.getProperty("driverClass");
			
			Class.forName(driverClass);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("驱动程序出错");
		}
	}
	/**
	 * 获取连接对象
	 */
	public static Connection getConnection(){
		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	/**
	 * 释放资源
	 */
	public static void close(Connection conn,Statement stmt){
		if(stmt!=null)
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		if(conn!=null)
			try {
				conn.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
	}
	
	public static void close(Connection conn,Statement stmt,ResultSet rs){
		if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new RuntimeException(e1);
			}
		if(stmt!=null)
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		if(conn!=null)
			try {
				conn.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
	}
}
