class DivisorIsZeorException extends Exception
{
	public DivisorIsZeorException(String Exceptionasseage)
	{
		super(Exceptionasseage);
	}
}
/* class A
{
	public int divide(int a,int b)
	{
		if(b==0)
			throw new DivisorIsZeorException("除数不能为零!");// 错误: 未报告的异常错误DivisorIsZeorException; 必须对其进行捕获或声明以便抛出
		int m=a/b;
		return m;
	}
} */
/* class A
{
	public int divide(int a,int b)
	{
		try//ok,将抛出的错误自行处理。
		{
			if(b==0)
				throw new DivisorIsZeorException("除数不能为零!");
		}
		catch(DivisorIsZeorException e)
		{
			e.printStackTrace();
		}
		int m=a/b;
		return m;
	}
} */
class A
{
	public int divide(int a,int b)throws DivisorIsZeorException//(1)  //将错误抛给上一级处理，只需写类名就可以了。
	{

		if(b==0)
		   throw new DivisorIsZeorException("除数不能为零!");//抛出错误必须是new出来一个对象。
		int m=a/b;
		return m;
	}
}
public class Textthow
{
	public static void main(String[] args)
	{
		A aa=new A();
		//aa.divide(5,0);//如果是(1)则 错误: 未报告的异常错误DivisorIsZeorException; 必须对其进行捕获或声明以便抛出，
		                //因为自己定义的异常DivisorIsZeorException不是RuntimeErrorException异常，必须得处理。
		try
		{
			aa.divide(5,0);
		}
		catch(DivisorIsZeorException e)
		{
			e.printStackTrace();
		}
	}
}