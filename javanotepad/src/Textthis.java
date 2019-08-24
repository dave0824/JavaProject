/*
	2018年8月15日16:53:25
	本程序证明了：
		1、this本质是一个指向对象的指针
		2、当函数的形参与类的属性一样，就要用this.属性的方法改变对象中属性的值。
*/
class A
{
	public int i;
	protected int j;
	private int k;
	public A()
	{
		
	}
	public A(int i,int j,int k)
	{
		this.i=i;//OK
		this.j=j;//OK
		this.k=k;//OK  this是指向对象的指针，当函数的形参与类的属性一样，就要用this.属性的
	}             //    方法改变对象中属性的值。    
	public void f(/* A* this */)//注释的部分是系统自动写的。实质就是这样运行的，但是自己不能手动添加。
	{
		System.out.printf("i=%d j=%d k=%d",this.i,this.j,this.k);//这里的this可写可不写。
	}
	protected void g()
	{
		
	}
	private void k()
	{
		System.out.printf("i=%d j=%d k=%d",this.i,this.j,this.k);//ok
	}
}
public class Textthis
{
	public static void main(String[] args)
	{
		A aa=new A(6,8,10);
		aa.f(/* aa */);//注释的部分是系统自动写的。实质就是这样运行的，但是自己不能手动添加。
	}
} 