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
		//1---������ϵ
	   File file =new File("E:/char.txt");
		//2---ѡ����
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
				System.out.println("�ļ�����ʧ�ܣ�");
				e.printStackTrace();
			}
		}else {
			System.out.println("�ļ��Ѿ�����");;
		}*/
		
		try {
			/*
			 * ����һ�ַ���
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
				System.out.println("д���ļ�ʧ�ܣ�");
				e.printStackTrace();
			}
			try {
				dos.flush();
			} catch (IOException e) {
				System.out.println("�ļ�ˢ��ʧ��");
				e.printStackTrace();
			}//ˢ��
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				dos.close();
			} catch (IOException e) {
				System.out.println("�ļ��ر�ʧ�ܣ�");
				e.printStackTrace();
			}
		}
		
		
	}
}
