/*
	2018年8月15日10:24:22
	本程序说明了：
		1、用super()可以直接对父类的属性进行赋值，从而不用一个一个的列出了写。
		
		2、super()只能用在子类的构造函数中！！！
		
		3、在子类的构造函数中，如果不写super(void，void)，系统会默认一个super()，
		   而如果在父类没有无参数的构造方法就会出错。
		   
		4、super()只能写在子类的构造函数的第一条语句，否则就出错，硬性规定。
		
		5、可以再子类中用super.属性或super.方法的方式调用父类的属性或方法
	       在方法的重写中会经常用到。
		   
		6、super实质就是一个指向父类的指针。
		
		7、this实质就是一个指向对象的指针。
*/
class A
{
	public int i;
	protected int j;
	public void f()
	{
		System.out.printf("haha!");
	}
 	public A()
	{
		
	} 
	public A(int i,int j)
	{
		this.i=i;
		this.j=j;
	}
}
class B extends A
{
	public int k;
	public B()
	{
		//super(); //这里如果没有写super的话，会有一个默认super()。如果父类没有无参的构造函数就会出错
	}
/* 	public B(int i,int j,int k)//ok
	{
		this.i=i;
		this.j=j;
		this.k=k;
	} */
	public B(int i,int j,int k)
	{
		//A(i,j);//error:找不到符号A，也就是java不支持直接在构造语句中这样写。
		super(i,j);
		this.k=k;
		//super(i,j);//对super的调用必须是构造器中的第一个语句
	}
	public void g()
	{
		super.f();//只是调用父类的方法，可以把super看做是指向父类的指针，而this就是指向对象的指针。
	}
	public void k()
	{
		//super;// 错误: 对super的调用必须是构造器中的第一个语句
	}
}
public class Textsuper
{
	public static void main(String[] args)
	{
		B aa=new B(1,2,3);
		aa.g();//运行输出：haha!
	}
}