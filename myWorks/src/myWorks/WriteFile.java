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
		//1-建立联系
		File dest =new File("E:/char.txt");
		//2-选择流
		OutputStream os=null;
		try {
			os=new FileOutputStream(dest,true);
			//3-操作
			//for(int i=1;i<5;i++) {
			if(i<=0) {
				flag=false;
				return ;
			}
			String str='\n'+"正在写文件--->"+i--;
				byte[] data=str.getBytes();
				System.out.println("正在写入文件");
				Thread.sleep(10);
				os.write(data,0,data.length);
				os.flush();
			//}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("文件刷新失败");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("文件写入失败");
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				os.close();
			} catch (IOException e) {
				System.out.println("文件关闭失败！");
				e.printStackTrace();
			}
		}
	}
	
}
