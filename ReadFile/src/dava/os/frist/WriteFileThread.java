package dava.os.frist;

public class WriteFileThread implements Runnable
{
	private ThreadCopyFile ss = null;
	
	public WriteFileThread(ThreadCopyFile ss)
	{
		this.ss = ss;
	}
	
	public void run()
	{

		while(true) {

			ss.writerfile();
		}
	}
}
