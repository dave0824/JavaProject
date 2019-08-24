package fourth.object;

import java.time.LocalDate;

/**
 * This is program tests the Employee class.
 * @author Superhero
 * @version 2018年12月15日下午10:18:50
 */
public class EmployeeTest
{
	public static void main(String[] args)
	{
		// fill the staff array with three Employee objects
		Employee [] staff = new Employee[3];
		
		staff[0] = new Employee("dave",20000,2020,8,24);
		staff[1] = new Employee("xiaoming",18888,2021,7,12);
		staff[2] = new Employee("xiaohong",16666,2019,5,4);
		
		// raise everyone's salary by 5%
		//for(Employee e : staff) equivalent to
		//for(integer i=0;i<staff.length;i++)
		//this is enhancement mode for loop
		//Employee e indicate for staff array element object
		for(Employee e : staff)
			e.raiseSalary(5);
		
		// print out information about all Employee objects
		for(Employee e : staff)
			System.out.println("name:"+e.getName()+",salary:"+e.getSalary()+",hireDay:"+e.getHireDay());
	}
}


class Employee
{
	private String name;
	private double salary;
	private LocalDate hireDay;
	
	public Employee(String name, double salary, int year, int mouth, int day)
	{
		super();
		this.name = name;
		this.salary = salary;
		this.hireDay = LocalDate.of(year,mouth,day);
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getSalary()
	{
		return salary;
	}
	
	public LocalDate getHireDay()
	{
		return hireDay;
	}
	
	public void raiseSalary(double byPercent)
	{
		double raise = salary * byPercent / 100;
		salary += raise;
	}
	
	
}
