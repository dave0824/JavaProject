
class A{
	
	public int a=5;
	public static void f() {
		
	   A b =new A();
	   b.a=10;
	 System.out.println(b.a);
	}
	public void g() {
		System.out.println(a);
	}
}
public class Shishi {
	int a;
	public static void main (String [] args){
	
		A a=new A();
		A.f();
		a.g();
		
		
	}
}
