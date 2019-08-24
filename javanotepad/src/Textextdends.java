/*
	2018年8月15日09:44:25
	本程序证明：
		1、继承只能继承非私有权限的属性或方法，不能继承私有权限的属性或方法。
		
		2、注意：只是逻辑上不能继承私有权限的属性或方法，程序员没有权限更写
		         而已，但是在物理上还是继承过去的，所以在继承的时候要慎重，
				 避免造成内存的浪费。
		3、证明是否继承的方法有三种：
					1、在子类中直接访问。
					2、在启动类中访问。
					3、静态属性或方法直接用子类类名.属性或子类类名.方法进行访问。
		4、一个父类可以有多个子类，但是一个子类只能有一个父类。形如数据结构中的树。
*/
class A//父类，也叫超类。
{
	public int i;
	protected int j;
	private int k;
	public static int i2;
	protected static int j2;
	private static int k2;
	public void f()
	{
		
	}
	protected void g()
	{
		
	}
	private void k()
	{
		
	}
}
class B extends A//子类
{
	public int m;
	public void q()
	{
		i=66;//ok
		j=88;//ok
		//k=666;// 错误: k 在 A 中是 private 访问控制
		f();//ok
		g();//ok
		//k();//错误: k() 在 A 中是 private 访问控制
	}
}
class C extends B//子类的子类可以继承子类。
{
	public int h;
}
class D extends A//一个父类可以被多个子类继承。
{
	
}
class Textextdends
{
	public static void main(String[] args)
	{
		B aa=new B();
		aa.i=8888;//ok
		aa.j=6666;//ok
		//aa.k=2222;// 错误: k 在 A 中是 private 访问控制
		aa.f();//ok
		aa.g();//ok
		//aa.k();//错误: k() 在 A 中是 private 访问控制
		B.i2=666;
		B.j2=888;
		//B.k=222;//错误: k 在 A 中是 private 访问控制
	}
}