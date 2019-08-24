class A
{
	private int a;//private是私有形的访问控制符
	public int b;//public是公共形的访问控制符
	protected int c;//protected是保护形的访问控制符
	private void f()
	{
		a=1;//ok，对类的内部而言，不管共有还是私有的都是可以进行访问的。也就是说访问控制符是透明的。
		b=2;
		c=3;
	}
	public void g()
	{
		a=1;
		b=2;
		c=3;
	}
	protected void k()
	{
		a=1;
		b=2;
		c=3;
	}
}
class textaccess
{
	public static void main(String[] args)
	{
		A aa=new A();
		//aa.a=10;
		//System.out.printf("%d\n",aa.a);//错误: a 在 A 中是 private 访问控制
		aa.b=20;
		System.out.printf("%d\n",aa.b);//ok,因为b在 A 中是 public 访问控制
		aa.c=30;
		System.out.printf("%d\n",aa.c);//ok,因为c 在 A 中是 protected 访问控制
	}
}