package defaultLocation;

import java.sql.*;

/**
 * ����һ������access���ݿ��һ���ʽ
 * @author Superhero
 * @version 2018��12��22������11:18:30
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

