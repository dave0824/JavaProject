package fourth.object;

/**
 * This program demonstrates static methods
 * @author Superhero
 * @version 2018年12月15日下午10:53:22
 */

public class StaticTest
{
	public static void main(String[] args)
	{
		// fill the staff array with three Employee objects
		Employee2 [] staff = new Employee2[3];
		
		staff[0] = new Employee2("dave",20000);
		staff[1] = new Employee2("xiaoming",18888);
		staff[0] = new Employee2("xiaohong",16666);
		

		
		// print out information about all Employee objects
		for(Employee2 e : staff)
		{
			e.setId();
			System.out.println("name:"+e.getName()+",id:"+e.getId()+",salary:"+e.getSalary());
		}
		
		int n = Employee2.getNextId();
		System.out.println("Next availabe id =" + n);
   }
}


class Employee2
{
	private static int nextId = 1;
	
	private String name;
	private double salary;
	private int id;
	
	public Employee2(String name, double salary)
	{
		super();
		this.name = name;
		this.salary = salary;
		id = 0;
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getSalary()
	{
		return salary;
	}
	
	public void setId()
	{
		id = nextId;
		nextId++;
	}
	
	public int getId()
	{
		return id;
	}
	
	public static int getNextId()
	{
		return nextId;
	}
  
	/**
	 * This main methods used to test Employee2 class.
	 * @param args
	 */
	public static void main(String[] args)
	{
		Employee2 e = new Employee2("dave",88888);
		System.out.println(e.getName()+""+e.getSalary());
	}
	
	
}