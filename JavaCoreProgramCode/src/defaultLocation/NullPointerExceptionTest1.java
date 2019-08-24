package defaultLocation;

/**
    *  引用类型变量没有指向对象所引起的空指针异常
 * @author Superhero
 * @version 2018年12月16日上午10:32:43
 */
class Books
{
	static String name;
	private String author;
	private double price;
	
	public Books()
	{
		
	}
	
	public Books(String name, String author, double price)
	{
		this.name = name;
		this.author = author;
		this.price = price;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getAuthor()
	{
		return author;
	}
	
	public double getPrice()
	{
		return price;
	}
}

public class NullPointerExceptionTest1
{
	public static void main(String[] args)
	{
		Books book=null;
		System.out.println(book.name);
		System.out.println("name:"+book.getName()+", author:"+book.getAuthor()+", price:"+book.getPrice());
	}
}
