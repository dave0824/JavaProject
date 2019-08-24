/*
	2018年8月15日17:21:57
	本程序证明了：
		1、重写实际上不是重写，重写的方法的原方法在物理上还是有保留的，
		   也就是说在物理上还是继承过来的，但是在逻辑上会运行重写的那个方法。
		2、重写方法只能改变形参与内容，不能改变返回值的数据类型。
		3、对于访问控制符的重写，只能是从权限小的重写为权限大的。比如protected重写为
			public，而不能从权限大的重写为权限小的，即不能倒过来。
*/
class A
{
	public int i;
	public void f()
	{
		System.out.printf("hahaha\n");
	}
	protected void g()
	{
		System.out.printf("aaaaa\n");
	}
}
class B extends A
{
	public int k;
	public void f()
	{
		super.f();//(2)
		System.out.printf("yayaya\n");//(1)
	}
/* 	protected int g()// 错误: B中的g()无法覆盖A中的g(),因为函数的数据类型不同了，这也说明了其实重写不叫重写，重写的方法的原方法在物理上还是有保留的，但是在逻辑上会运行重写的那个方法。
	{
		System.out.printf("bbbbbb\n");
	} */
/*     protected void g(int k)//ok.可以改变方法的参数。
	{
		System.out.printf("aaaaa\n");
		this.k=k;
	} */
/*     public  void g()//ok,可以将访问控制从权限小的改为权限更大的。
	{
		System.out.printf("aaaaa\n");
	} */
/* 	private void g()//error:无法将权限大的改为权限小的。
	{
		System.out.printf("aaaaa\n");
	} */
}
public class Textchongxie
{
	public static void main(String[] args)
	{
		B aa=new B();
		aa.f();//由(1)输出yayaya. 由(1)(2)输出hahaha  yayaya
	}
}