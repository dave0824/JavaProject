package sql.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * ����һ����Щ���ҵ����ݿ����Ӳ��Գ���
 * @author Superhero
 * @version 2018��12��22������11:17:44
 */
public class ConnetSql {
 
    public static void main(String[] args) {
        //����Connection����
        Connection con;
        //����������
        String driver = "com.mysql.jdbc.Driver";
        //URLָ��Ҫ���ʵ����ݿ���mydata        String url = "jdbc:mysql://localhost:3306/sqltestdb";
        //MySQL����ʱ���û���         String user = "root";
         //MySQL����ʱ������
         //String password = "763081703";
        String password = "wass1234@";
       // String url="jdbc:mysql://localhost:3306/mydatabase?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
         //String url = "jdbc:mysql://127.0.0.1:3306/mydatabase";
         String url = "jdbc:mysql://192.168.43.195:3306/sys";
         //������ѯ�����
       /* try {
            //������������
            Class.forName(driver);
             //1.getConnection()����������MySQL���ݿ⣡��
            con = DriverManager.getConnection("url","root",password);
             if(!con.isClosed())
                 System.out.println("Succeeded connecting to the Database!");
             //2.����statement���������ִ��SQL��䣡��
             Statement statement = con.createStatement();
             //Ҫִ�е�SQL���
            String sql = "select * from Student";
           //3.ResultSet�࣬������Ż�ȡ�Ľ��������
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("-----------------");
             System.out.println("ִ�н��������ʾ:");  
             System.out.println("-----------------");  
             //System.out.println("����" + "\t" + "ְ��");  
             System.out.println("-----------------");  
              
             String job = null;
           String id = null;
            while(rs.next()){
                 //��ȡstuname��������
                job = rs.getString("job");
                 //��ȡstuid��������
                id = rs.getString("ename");
 
                //������
            System.out.println(id + "\t" + job);
             }
             rs.close();
             con.close();
         } catch(ClassNotFoundException e) {   
            //���ݿ��������쳣����
            System.out.println("Sorry,can`t find the Driver!");   
            e.printStackTrace();   
            } catch(SQLException e) {
            //���ݿ�����ʧ���쳣����
             e.printStackTrace();  
            }catch (Exception e) {
            // TODO: handle exception
             e.printStackTrace();
         }finally{
             System.out.println("���ݿ����ݳɹ���ȡ����");
         }*/
     
         try
         {
             //������������
             Class.forName(driver);
              //1.getConnection()����������MySQL���ݿ⣡��
             con = DriverManager.getConnection(url,"root",password);
             //con = DriverManager.getConnection(url,"root",password);
              if(!con.isClosed())
                  System.out.println("Succeeded connecting to the Database!");
              //2.����statement���������ִ��SQL��䣡��
              Statement statement = con.createStatement();
              //Ҫִ�е�SQL���
             String sql = "select * from Student";
            //3.ResultSet�࣬������Ż�ȡ�Ľ��������
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