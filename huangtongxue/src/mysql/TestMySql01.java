package mysql;


//Class.forName("com.mysql.jdbc.Driver");
//Class.for.Name("oracle.jdbc.driver.OracleDriver");  
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class TestMySql01 {


	public TestMySql01() {
		
	}
	public static void main(String[] args) throws SQLException {
		//String url="jdbc:mysql://127.0.0.1:3306/sys";
		String url="jdbc:mysql://localhost:3306/sys?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
		//String url=	"jdbc:mysql://192.168.43.195:3306/sys";//	本机地址法
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn = (Connection) DriverManager.getConnection(url, "root", "wass1234@");/*"763081703"*/
			//java.sql.Connection conn=DriverManager.getConnection(url, "root", "wass1234@");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(conn!=null) {
			System.out.println("连接成功！");
		}else {
			System.out.println("连接失败！");
		}
		Statement stat=conn.createStatement();
		ResultSet rs=stat.executeQuery("select * from course");
		while(rs.next()) {
			System.out.println(rs.getString(1)+"---"+rs.getDouble(2)+
					"---"+rs.getDouble(3)+"----"+rs.getFloat(4)+"----"+
							rs.getInt(5)+"-----"+rs.getShort(6));
		}
		rs.close();
		stat.close();	
	}

}
