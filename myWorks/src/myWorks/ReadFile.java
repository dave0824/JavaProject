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
		//1-建立联系
		File src=new File("E:/char.txt");
		//2-选择流
		InputStream is=null;
		try {
			//3-读取  
			is=new FileInputStream(src);
			byte[] c=new byte[10];
			int len=0;
			while(-1!=(len=is.read(c))) {
				/*flag=false;
				return ;*/
				//输出字节数组，转字符串
				String str=new String(c,0,len);
				Thread.sleep(10);
				System.out.println(str);
				System.out.println("正在读取文件");
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("文件读取失败");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("文件不存在");
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//4-释放资源
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
