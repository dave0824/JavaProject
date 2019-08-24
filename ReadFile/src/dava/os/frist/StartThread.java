package dava.os.frist;

public class StartThread
{
	public static void main(String[] args)
	{
		ThreadCopyFile ss = new ThreadCopyFile();
		ReaderFileThread p = new ReaderFileThread(ss);
		WriteFileThread c = new WriteFileThread(ss);
		Thread t1 = new Thread(p);
		t1.start();
				
		Thread t2 = new Thread(c);
		t2.start();
	}
}