/*
	2018年8月20日18:09:04
	创建线程的第二种方式来买票，建议使用这种。
*/
class A  implements Runnable
{
	private  int tickets=100;//static可写可不写。
	String str=new String("还有谁");//static可写可不写。
	public void run()
	{
		while(true)
		{
			synchronized (str)//这个关键字的作用是对象锁，即当有一个线程访问时，这个关键字所
			{                 //包涵的代码就会被锁定，再第一个线程没有运行完毕时，其它线程无法访问，
				if(tickets>0)//但是也可以跳到其它线程去运行。直到第一个线程将所包涵的代码执行完毕时，
				{             //所有线程再来竞争。
					System.out.printf("%s：线程正在出售第%d张票\n",Thread.currentThread().getName(),tickets);
					tickets--;
				}
				else if(tickets==0)
				{
					System.out.printf("票已出售完毕!\n");
					break;
				}
			}
		}
	}
}
public class Tickets_2
{
	public static void main(String[] args)
	{
		A aa=new A();
        Thread tt1=new Thread(aa);
		Thread tt2=new Thread(aa);
		tt1.start();
		tt2.start();
	}
}