package myWorks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class WriteFile implements Runnable{
	boolean flag=true;
	int i=5;
	@Override
	public void run() {
		while(flag) {
			write();
		}
		
	}
	public synchronized void write() {
		//1-������ϵ
		File dest =new File("E:/char.txt");
		//2-ѡ����
		OutputStream os=null;
		try {
			os=new FileOutputStream(dest,true);
			//3-����
			//for(int i=1;i<5;i++) {
			if(i<=0) {
				flag=false;
				return ;
			}
			String str='\n'+"����д�ļ�--->"+i--;
				byte[] data=str.getBytes();
				System.out.println("����д���ļ�");
				Thread.sleep(10);
				os.write(data,0,data.length);
				os.flush();
			//}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("�ļ�ˢ��ʧ��");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("�ļ�д��ʧ��");
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				os.close();
			} catch (IOException e) {
				System.out.println("�ļ��ر�ʧ�ܣ�");
				e.printStackTrace();
			}
		}
	}
	
}
