/*
	2018年8月15日17:38:57
	本程序证明了：
		1、父类的引用既可以指向父类对象也可以指向子类对象，它可以根据当前指向的不同
			自动调用不同对象里面的成员，这就是多肽。
		
		2、多肽可以将子类赋给父类引用，但永远都不能将父类赋给子类引用。只有一种特例，看另外一个程序。
		。
		3、将子类赋给父类，父类虽然指向了子类，但是父类只能调用
		   子类中从父类继承或重写过来的方法，不能调用子类特有的方法或属性
		   这也是起到了一种保护作用，体现了java都是先从数据的安全去考虑。
		   为sun公司点赞！哈哈哈。皮一下，皮一下。
		   为sun公司点赞！哈哈哈。皮一下，皮一下。
*/
class A
{
	public int i;
	public void f()
	{
		System.out.printf("hahhahahah\n");
	}
}
class B extends A
{
	public void f()
	{
		System.out.printf("lalalalala\n");
	}
	public void g()
	{
		System.out.printf("yayayaa\n");
	}
}
public class Textduotai
{
	public static void main(String[] args)
	{
		A aa=new A();
		B bb=new B();
		bb.f();// lalalalala
		aa.f();// hahhahahah  (1)
		aa=bb;//ok,可以将子类赋给父类。
		//bb=aa;//错误: 不兼容的类型: A无法转换为B 即不能将父类赋给子类。
		aa.f();// lalalalala   (2)   //(1)和(2)两个相同的语句输出的结果却不相同，这就是多肽。
		aa.g();//错误，虽说A类的aa对象指向了B类的bb对象，但是却不能调用B类的bb对象特有的属性。
		       //即不能调用不是从父类继承或重写过来的方法。
	}
}