package dava.os.sceond;


class A  implements Runnable
{
	private  int count=0;//static��д�ɲ�д��
	String str=new String("����˭");//static��д�ɲ�д��
	public void run()
	{
		while(true)
		{
			synchronized (str)//����ؼ��ֵ������Ƕ�������������һ���̷߳���ʱ������ؼ�����
			{                 //�����Ĵ���ͻᱻ�������ٵ�һ���߳�û���������ʱ�������߳��޷����ʣ�
				if(count>=0&&count<=1000)//����Ҳ�������������߳�ȥ���С�ֱ����һ���߳̽��������Ĵ���ִ�����ʱ��
				{             //�����߳�����������
					System.out.printf("%s���߳��Ѽ�һ��count��ֵΪ��%d\n",Thread.currentThread().getName(),count);
					count++;
				}
				else 
				{
					System.out.printf("�Ѿ��ۼӵ�1000!\n");
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


