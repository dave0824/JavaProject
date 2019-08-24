package thread;


public class TrainApp
{
	
	public static void main(String[] args){
		A a1=new A("A1");
		A a2=new A("A2");
		A a3=new A("A3");
		A a4=new A("A4");
		a1.start();
		a2.start();
		a3.start();
		a4.start();
	}
}
class A extends Thread
{
	static int  tickets=100;
	String name=null; 
	//static String str = new String("haha");
	public  void run(){
		while(tickets > 0 ){
			synchronized("hahah"){
				if(tickets == 0)
					break;
			System.out.println(name+"---"+tickets);
			tickets--;
			}

	  }
	}
	public A(){

	}

	public A(String name){
		this.name=name;
	}
}