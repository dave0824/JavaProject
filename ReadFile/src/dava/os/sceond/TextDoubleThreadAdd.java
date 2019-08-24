package dava.os.sceond;


class A  implements Runnable
{
	private  int count=0;//static可写可不写。
	String str=new String("还有谁");//static可写可不写。
	public void run()
	{
		while(true)
		{
			synchronized (str)//这个关键字的作用是对象锁，即当有一个线程访问时，这个关键字所
			{                 //包涵的代码就会被锁定，再第一个线程没有运行完毕时，其它线程无法访问，
				if(count>=0&&count<=1000)//但是也可以跳到其它线程去运行。直到第一个线程将所包涵的代码执行完毕时，
				{             //所有线程再来竞争。
					System.out.printf("%s：线程已加一，count数值为：%d\n",Thread.currentThread().getName(),count);
					count++;
				}
				else 
				{
					System.out.printf("已经累加到1000!\n");
					System.exit(-1);
					break;
				}
			}
		}
	}
}

public class TextDoubleThreadAdd{
	public static void main(String[] args){
	A aa=new A();
    Thread tt1=new Thread(aa);
	Thread tt2=new Thread(aa);
	tt1.start();
	tt2.start();
	}
}


