package dava.os.frist;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ThreadCopyFile 
{
	private static boolean flag=false;
	private  int i=0;
	private  int dept=0;
	
	//���ļ�
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
				System.out.println("������ϣ�");
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
		
		System.out.printf("���ڶ�ȡ�ļ�1���ַ������ַ���: %c\n", dept);
		this.notify(); 
	}
	
	
	//���ļ�д������
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
		System.out.printf("����д��1���ַ������ַ���: %c\n", dept);			
	}	
}
