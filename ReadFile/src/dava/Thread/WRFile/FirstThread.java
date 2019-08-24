package dava.Thread.WRFile;

 

public class FirstThread implements Runnable {

private WRFile wr = new WRFile();

 

   public FirstThread(WRFile wr) {

		this.wr = wr;

	} 

	@Override

	public void run() {

		

		while(true)

		{

			wr.read1();

		}

 

	}

 

}

