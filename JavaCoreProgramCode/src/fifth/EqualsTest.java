package fifth;

import java.time.LocalDate;
import static java.lang.System.out;
import java.util.Objects;

/**
 * This program demonstrates the equals method
 * @author Superhero
 * @version 2018年12月17日下午10:47:44
 */

public class EqualsTest
{
	public static void main(String[] args)
	{
		Employee dave1 = new Employee("dave",75000,2020,8,24);
		Employee dave2 = dave1;
		Employee dave3 = new Employee("dave",75000,2020,8,24);
		Employee Yang = new Employee("Yang",7000,2020,9,24);
		
		out.println("dave1 == dave2 " + (dave1 == dave2));//true
		
		out.println("dave1 == dave3 " + (dave1 == dave3));//false
		
		out.println("dave1.equals(dave3)" + dave1.equals(dave3));//true
		
		out.println("dave1.equals(Yang)" + dave1.equals(Yang));//flase
		
		out.println("dave1.hashCode()" + dave1.hashCode());
		
		out.println("dave2.hashCode()" + dave2.hashCode());
		
		out.println("dave3.hashCode()" + dave3.hashCode());
		
		out.println("Yang.hashCode()" + Yang.hashCode());
		
		out.println("dave1.toString()" + dave1.toString());
		
		out.println("dave2.toString()" + dave2.toString());
		
		out.println("dave3.toString()" + dave3.toString());
		
		
		Manager dive = new Manager("dive",888888,2020,8,24);
		Manager boss = new Manager("dive",888888,2020,8,24);
		boss.setBonus(50000);
		
		out.println("boss.toString()" + boss.toString());
		out.println("dive.equals(boss)" + dive.equals(boss));
		out.println("dive.hashCode()" + dive.hashCode());
		out.println("boss.hashCode()" + boss.hashCode());
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
	
	public Employee()
	{
		
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
	
	@Override
	public boolean equals(Object otherObject)
	{
		// a quick test to see if the objects are identical
		if(this == otherObject)
			return true;
		
		// must return false if the explicit parameter is null
		if(otherObject == null)
			return false;
		
		// if the classes don't match,they can't be equal
		if(getClass() != otherObject.getClass())
		{
			return false;
		}
		
		// now we know otherObject is a non-null Employee
		Employee other = (Employee)otherObject;
		
		// text whether the fields have identical values
		return Objects.equals(name, other.name) &&
				salary == other.salary &&
				Objects.equals(hireDay, other.hireDay);
	}
	
	@Override
	public int hashCode()
	{
		return Objects.hash(name,salary,hireDay);	
	}
	
	@Override
	public String toString()
	{
		return getClass().getName() + "[name:" + name + ",salary:" + salary + ",hireDay:" + hireDay + "]"; 
	}
	
	
}

class Manager extends Employee
{
	private double bonus;

	public Manager(String name, double salary, int year, int mouth, int day)
	{
		super(name, salary, year, mouth, day);
		this.bonus = 0;
	}
	
	public Manager()
	{
		
	}

	@Override
	public double getSalary()
	{
		double baseSalary = super.getSalary();
		return baseSalary + bonus;
	}
	
	public void setBonus(double bonus)
	{
		this.bonus = bonus;
	}
	
	@Override
	public boolean equals(Object otherObject)
	{
		if(super.equals(otherObject))
			return false;
		Manager other = (Manager) otherObject;
		
		// super.equals checked that this and other belong to same class
		return bonus == other.bonus;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public int hashCode()
	{
		return super.hashCode() + 17* new Double(bonus).hashCode();
	}
	
	@Override
	public String toString()
	{
		return super.toString() + "[bonus" + bonus +"]";
	}
}
