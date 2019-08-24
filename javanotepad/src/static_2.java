/*
	2018年8月14日17:54:25
	 一: 本程序是限制类只能创建一个对象。也是对static的一种实际的应用。
	 
	 二. 对于都是private访问控制的重载函数，会按顺序进行，
		 直到进行到最后一个才会判断类型是否相同。
			
         (1) 比如private A(int i,int j)在private A()前面new 一个A()就会提示：
				错误: A() 在 A 中是 private 访问控制A aa1=new A();
				
	     (2) 比如private A(int i,int j)在private A()后面new 一个A()就会提示：
				错误: 无法将类 A中的构造器 A应用到给定类型;
                      ^
					需要: int,int
					找到: 没有参数
					原因: 实际参数列表和形式参数列表长度不同
*/
class A
{
	public int i;
	protected int j;
	private static A aa=new A();
	private A()
	{
		
	}
/* 	private A(int i,int j)
	{
		this.i=i;
		this.j=j;
	} */
	public static A getA()
	{
		return aa;
	}
	public void show()
	{
		System.out.printf("%d  %d\n",i,j);
	}
}
public class static_2
{
	public static void main(String[] args)
	{
		//A aa1=new A();//错误: A() 在 A 中是 private 访问控制
		A aa2=A.getA();//ok
		A aa3=A.getA();
		aa2.i=66;
		aa2.j=88;
		aa3.show();//运行结果是66 88 即说明了aa2和aa3是同一个对象。
		if(aa2==aa3)
			System.out.printf("aa2和aa3相等\n");
		else
			System.out.printf("aa2和aa3不相等\n");//运行结构：aa2和aa3相等
	}
}