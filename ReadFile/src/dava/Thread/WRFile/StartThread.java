package dava.Thread.WRFile;



public class StartThread {

 

	public static void main(String[] args) {

		//�������ݶ���

		WRFile wr = new WRFile();

		//���úͻ�ȡ��

		FirstThread ft = new FirstThread(wr);

		SecondThread st = new SecondThread(wr);

		//�߳���

		Thread th1 = new Thread(ft);

		Thread th2 = new Thread(st);

		//�����߳�

		th1.start();

		th2.start();

	}

 

}
