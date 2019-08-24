package dava.Thread.WRFile;


 

//import java.io.FileNotFoundException;

import java.io.IOException;

import java.io.RandomAccessFile;

 

public class WRFile {

	//String str;

	boolean flag;

	public WRFile()

	{

		

	}

	public synchronized void read1()

	{

		if(this.flag)

		{

			try {

				this.wait();

			} catch (InterruptedException e) {

				

				e.printStackTrace();

			}

		}

		RandomAccessFile ra = null;

		try {

			ra = new RandomAccessFile("number.txt", "rw");

			ra.seek(ra.length());

		
             int i=0;
             i++;
			//ra.writeBytes("I love you");
			ra.writeInt(i);

			ra.writeBytes("\r\n");

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

		//修改标记 唤醒线程

		this.flag = true;

		this.notify();

	}

	public synchronized void read2()

	{

		if(!this.flag)

		{

			try {

				this.wait();

			} catch (InterruptedException e) {

				

				e.printStackTrace();

			}

		}

		RandomAccessFile ra = null;

		try {

			ra = new RandomAccessFile("number.txt", "rw");

			ra.seek(ra.length());

		
			int i=1024;
			i--;
			//ra.writeBytes("so do I");
			ra.writeInt(i);
			ra.writeBytes("\r\n");

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

		//修改标记 唤醒线程

		this.flag = false;

		this.notify();

	}

 

}
