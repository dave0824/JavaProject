package sql.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 这是一个远程连MySql接数据库程序
 * @author Superhero
 * @version 2018年12月22日上午11:16:43
 */
public class InternetConnetMySql {
 
    public static void main(String[] args) {
        //声明Connection对象
        Connection con;
        //驱动程序名
        String driver = "com.mysql.jdbc.Driver";
        //URL指向要访问的数据库名mydata        String url = "jdbc:mysql://localhost:3306/sqltestdb";
        //MySQL配置时的用户名         String user = "root";
         //MySQL配置时的密码
         //String password = "763081703";
        String password = "wass1234@";
       // String url="jdbc:mysql://localhost:3306/mydatabase?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
         //String url = "jdbc:mysql://127.0.0.1:3306/mydatabase";
         String url = "jdbc:mysql://192.168.43.195:3306/sys?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
     
         try
         {
             //加载驱动程序
             Class.forName(driver);
              //1.getConnection()方法，连接MySQL数据库！！
             con = DriverManager.getConnection(url,"sun",password);
             //con = DriverManager.getConnection(url,"root",password);
              if(!con.isClosed())
                  System.out.println("Succeeded connecting to the Database!");
              //2.创建statement类对象，用来执行SQL语句！！
              Statement statement = con.createStatement();
              //要执行的SQL语句
             String sql = "select * from Student";
            //3.ResultSet类，用来存放获取的结果集！！
             ResultSet rs = statement.executeQuery(sql);
 			while (rs.next())
 			{
 				System.out.println(rs.getString(2));
 			}
         }
         catch(SQLException e)
         {
        	 e.printStackTrace();
         }
         catch(ClassNotFoundException e)
         {
        	 e.printStackTrace();
         }
   }
 }