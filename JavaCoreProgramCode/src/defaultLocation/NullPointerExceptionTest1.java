package defaultLocation;

/**
    *  �������ͱ���û��ָ�����������Ŀ�ָ���쳣
 * @author Superhero
 * @version 2018��12��16������10:32:43
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
