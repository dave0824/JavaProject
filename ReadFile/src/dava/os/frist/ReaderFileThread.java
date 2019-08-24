package dava.os.frist;

public class ReaderFileThread implements Runnable
{
	private ThreadCopyFile ss = null;
	
	public ReaderFileThread(ThreadCopyFile ss)
	{
		this.ss = ss;
	}
	
	public void run() 
	{

		while(true) {

			ss.readfile();
		}
	}
}