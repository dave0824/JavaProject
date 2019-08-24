package sql.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ����һ���������ݿ��һ������
 * @author Superhero
 * @version 2018��12��22������11:08:54
 */
public class DataBasesSample {
 
    public static void main(String[] args) {
        //����Connection����
        Connection con;
        //����������
        String driver = "com.mysql.jdbc.Driver";
        //URLָ��Ҫ���ʵ����ݿ���mydata        String url = "jdbc:mysql://localhost:3306/sqltestdb";
        //MySQL����ʱ���û���         String user = "root";
         //MySQL����ʱ������
         String password = "763081703";
         String url="jdbc:mysql://localhost:3306/mydatabase?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
         //��һ����ʽ��localhost�ȼ���127.0.0.1
         //String url = "jdbc:mysql://127.0.0.1:3306/mydatabase?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
         //������ѯ�����
        try {
            //������������
            Class.forName(driver);
             //1.getConnection()����������MySQL���ݿ⣡��
            con = DriverManager.getConnection(url,"root",password);
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
             System.out.println("id" + "\t" + "����"+ "\t" + "�ձ�"+ "\t" + "����"+ "\t\t" + "ϵ��");  
             System.out.println("-----------------");  
              
             String name = null;
             int id ;
             int sex;
             String brith = null;
             String dept = null;
            while(rs.next()){
                 //��ȡstuid��������
                id = rs.getInt("Sid");
                //��ȡstuname��������
                name = rs.getString("Sname");
                
                sex = rs.getInt("Ssex");
                
                brith = rs.getString("Sbrith");
                
                dept = rs.getString("Sdept");
                //������
            System.out.println(id + "\t" + name + "\t" + sex + "\t" + brith + "\t" + dept);
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
         }
   }
 }