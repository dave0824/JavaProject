
abstract class Animals{
	protected String kind;
	protected String food;
	protected int age;
	

//	public Animals(String kind, String food, int age) {
//		super();
//		this.kind = kind;
//		this.food = food;
//		this.age = age;
//	}
	
	public Animals() {
		
	}

	public abstract void eat();
	//Animals(){
		
	//	System.out.println("���๹����");
	//}

}

class Bird extends Animals{
	private String colors;
	public Bird(String kind,String food,int age){
		this.kind=kind;
		this.food=food;
		this.age=age;
	}
	public Bird(String colors,String kind,String food,int age){
		//super(kind,food,age);
		this(kind,food,age);
		this.colors=colors;
		
	}
	void print(){
		System.out.println("kind--->"+kind);
		System.out.println("food--->"+food);
		System.out.println("age--->"+age);
		System.out.println("colors--->"+colors);
		
	}
	public void eat(){
			System.out.println("С��ÿ��Ҫ��10kg����");

	}


}
public class AnimalsApp {
	public static void main (String[] args){
		//Bird bird=new Bird("������","����",5);
		Bird bird=new Bird("��ɫ","������","����",5);
		bird.print();


	}
	

}
