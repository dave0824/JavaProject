package hx;
import java.io.*;

public class TestDataOutStream
{
	public static void main(String[] args)
	{
		new DataOutStreamTest().testData();
	}
}


class DataOutStreamTest
{
	void testData()
	{
		//1---建立联系
	   File file =new File("E:/char.txt");
		//2---选择流
		OutputStream dou=null;
		DataOutputStream dos=null;
		//FileOutputStream fo=null;
		int num=6;
		float[] f=new float[num];
		int i=0;
		f[0]=33.3f;f[1]= 22.3f;f[2]=11.3f;
		f[3]=44.3f;f[4]=55.3f;f[5]=66.3f;
/*		if(file==null)
		{
			try 
			{
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("文件创建失败！");
				e.printStackTrace();
			}
		}else {
			System.out.println("文件已经存在");;
		}*/
		
		try {
			/*
			 * 这是一种方法
			 * dou =new FileOutputStream(file);
			dos=new DataOutputStream(dou);*/
			dos=new DataOutputStream(new FileOutputStream(file,true));
			try {
					for(int j=0;j<f.length;j++) {
					dos.writeFloat(f[j]);
					System.out.println(f[j]);
				}
					dos.flush();
			} catch (IOException e) {
				System.out.println("写入文件失败！");
				e.printStackTrace();
			}
			try {
				dos.flush();
			} catch (IOException e) {
				System.out.println("文件刷新失败");
				e.printStackTrace();
			}//刷新
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				dos.close();
			} catch (IOException e) {
				System.out.println("文件关闭失败！");
				e.printStackTrace();
			}
		}
		
		
	}
}
