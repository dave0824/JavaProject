package myWorks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadFile implements Runnable{

	boolean flag=true;
	public ReadFile() {
		
	}
	@Override
	public void run() {
			read();
		
	}
	public synchronized  void read() {
		//1-������ϵ
		File src=new File("E:/char.txt");
		//2-ѡ����
		InputStream is=null;
		try {
			//3-��ȡ  
			is=new FileInputStream(src);
			byte[] c=new byte[10];
			int len=0;
			while(-1!=(len=is.read(c))) {
				/*flag=false;
				return ;*/
				//����ֽ����飬ת�ַ���
				String str=new String(c,0,len);
				Thread.sleep(10);
				System.out.println(str);
				System.out.println("���ڶ�ȡ�ļ�");
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("�ļ���ȡʧ��");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("�ļ�������");
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//4-�ͷ���Դ
			if(null!=is) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
}
