package defaultLocation;


/**
 * 
 * @author Superhero
 * @version 2018年12月16日上午10:48:53
 */


public class NullPointerExceptionTest2
{
	public static void main(String[] args)
	{
		Books[] books = new Books[3];
		books[0] = new Books("NullPointerException","Superhero",88.8);
		books[1] = new Books("NullPointerException","Superhero",88.8);
		books[2] = new Books("NullPointerException","Superhero",88.8);
		for(Books book : books)
			System.out.println("name:"+book.getName()+", author:"+book.getAuthor()+", price:"+book.getPrice());
	}
}

