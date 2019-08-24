package sql.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * 这是一个有些杂乱的数据库连接测试程序
 * @author Superhero
 * @version 2018年12月22日上午11:17:44
 */
public class ConnetSql {
 
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
         String url = "jdbc:mysql://192.168.43.195:3306/sys";
         //遍历查询结果集
       /* try {
            //加载驱动程序
            Class.forName(driver);
             //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection("url","root",password);
             if(!con.isClosed())
                 System.out.println("Succeeded connecting to the Database!");
             //2.创建statement类对象，用来执行SQL语句！！
             Statement statement = con.createStatement();
             //要执行的SQL语句
            String sql = "select * from Student";
           //3.ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("-----------------");
             System.out.println("执行结果如下所示:");  
             System.out.println("-----------------");  
             //System.out.println("姓名" + "\t" + "职称");  
             System.out.println("-----------------");  
              
             String job = null;
           String id = null;
            while(rs.next()){
                 //获取stuname这列数据
                job = rs.getString("job");
                 //获取stuid这列数据
                id = rs.getString("ename");
 
                //输出结果
            System.out.println(id + "\t" + job);
             }
             rs.close();
             con.close();
         } catch(ClassNotFoundException e) {   
            //数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");   
            e.printStackTrace();   
            } catch(SQLException e) {
            //数据库连接失败异常处理
             e.printStackTrace();  
            }catch (Exception e) {
            // TODO: handle exception
             e.printStackTrace();
         }finally{
             System.out.println("数据库数据成功获取！！");
         }*/
     
         try
         {
             //加载驱动程序
             Class.forName(driver);
              //1.getConnection()方法，连接MySQL数据库！！
             con = DriverManager.getConnection(url,"root",password);
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