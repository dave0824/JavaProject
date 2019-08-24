package defaultLocation;

import java.sql.*;

/**
 * 这是一个连接access数据库的一般格式
 * @author Superhero
 * @version 2018年12月22日上午11:18:30
 */
class  JdbcTest
{
	public static void main(String[] args) 
	{
		String url = "jdbc:odbc:Student";

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url);
			Statement stat = conn.createStatement();
			String sql = "select * from Student";
			ResultSet rs = stat.executeQuery(sql);
			while (rs.next())
			{
				System.out.println(rs.getString(2));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

