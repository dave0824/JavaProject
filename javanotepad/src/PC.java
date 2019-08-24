
import java.io.IOException;
import java.io.RandomAccessFile;

/*
	2009年6月24日15:24:35
	生产和消费
*/

class SynStack 
{
	//private char[] data = new char[20];
	private static int ch=-1;
	private  int i=0;
	
	public synchronized void readfile()
	{
		while (ch != -1)
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
			ch=ra.read();

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
		
		System.out.printf("正在读取文件1个字符，该字符是: %c\n", ch);
		this.notify(); 
	}
	
	public synchronized void writerfile()
	{
		
		while (ch == -1)
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
			ra.write(ch);

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
		System.out.printf("正在写入1个字符，该字符是: %c\n", ch);
		ch=-1;
				
	}	
}

class Producer implements Runnable
{
	private SynStack ss = null;
	
	public Producer(SynStack ss)
	{
		this.ss = ss;
	}
	
	public void run() // throws Exception
	{
		//push('a');  //error
		//char ch;
		
		for (int i=0; i<20; ++i)
		{
			try{
			Thread.sleep(100);		
			}
		catch (Exception e){			
		}
				//while(true)
			ss.readfile();
		}
	}
}

class Consumer implements Runnable
{
	private SynStack ss = null;
	
	public Consumer(SynStack ss)
	{
		this.ss = ss;
	}
	
	public void run()
	{
		for (int i=0; i<20; ++i)
		{
			try{
			Thread.sleep(100);
			}
			catch (Exception e){			
			}
			
			//System.out.printf("%c\n", ss.pop());
			ss.writerfile();
		}
	}
}


public class PC
{
	public static void main(String[] args)
	{
		SynStack ss = new SynStack();
		Producer p = new Producer(ss);
		Consumer c = new Consumer(ss);
		Thread t1 = new Thread(p);
		t1.start();
				
		Thread t2 = new Thread(c);
		t2.start();
	}
}


