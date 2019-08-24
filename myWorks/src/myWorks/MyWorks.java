package myWorks;
/**
 * 实现多线程读写文件
 * @version 2018-10-9
 * @author hx
 */
public class MyWorks {

	public MyWorks() {
		
	}
	public static void main(String[] args) {
		ReadFile readFile=new ReadFile();
		WriteFile writeFile=new WriteFile();
		Thread thread1 =new Thread(readFile);
		Thread thread2 =new Thread(writeFile);
		thread2.start();
		thread1.start();
	}
}
