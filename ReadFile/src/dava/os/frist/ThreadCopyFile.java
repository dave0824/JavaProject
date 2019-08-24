package dava.os.frist;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ThreadCopyFile 
{
	private static boolean flag=false;
	private  int i=0;
	private  int dept=0;
	
	//读文件
	public synchronized void readfile()
	{
		while (flag)
		{
			try
			{
				this.wait();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		
		RandomAccessFile ra = null;

		try {

			ra = new RandomAccessFile("G:\\20180910\\javawork\\ReadFile\\1.txt","rw");

			ra.seek(this.i++);
			if((dept=ra.read())!=-1) {
				flag=true;
			}
			else {
				System.out.println("复制完毕！");
				System.exit(-1);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		finally {

			try {

				ra.close();

			} catch (IOException e) {

				e.printStackTrace();
			}

		}
		
		System.out.printf("正在读取文件1个字符，该字符是: %c\n", dept);
		this.notify(); 
	}
	
	
	//向文件写入数据
	public synchronized void writerfile()
	{
		
		while (!flag)
		{
			try
			{
				this.wait();
			}
			catch (Exception e)
			{
			}
		}
		
		RandomAccessFile ra = null;

		try {

			ra = new RandomAccessFile("G:\\20180910\\javawork\\ReadFile\\2.txt","rw");

			ra.seek(ra.length());
			ra.write(dept);

		} catch (Exception e) {

			
			e.printStackTrace();

		}

		finally {

			try {

				ra.close();

			} catch (IOException e) {

				e.printStackTrace();
			}

		}
		this.notify();
		flag=false;
		System.out.printf("正在写入1个字符，该字符是: %c\n", dept);			
	}	
}
