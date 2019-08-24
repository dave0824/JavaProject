package myWorks;
import java.time.*;
/**
 * 日历
 * @author Superhero
 * @version 2018年11月20日下午9:05:36
 */
public class CalendarText 
{

	public static void main(String[] args)
	{
		LocalDate date = LocalDate.now();
		int month = date.getMonthValue();
		int today = date.getDayOfMonth();
		
		date = date.minusDays(today-1);// set to start of month
		DayOfWeek weekday = date.getDayOfWeek();
		int value = weekday.getValue();//1 = Monday,... 7=Sunday
		
		System.out.println("Sun Mon Tue Wed Thu Fri Sat");
		if(value != 7)
		{
			for(int i = 1;i<value+1;i++)
			{
				System.out.print("    ");
			}
		}
			while(date.getMonthValue() == month )
			{
				System.out.printf("%3d", date.getDayOfMonth());
				if(date.getDayOfMonth() == today)
				{
					System.out.print("*");
				}
				else
				{
					System.out.print(" ");
				}
				date = date.plusDays(1);
				if(date.getDayOfWeek().getValue() == 7)
				{
					System.out.println();
				}
			}
			
			if(date.getDayOfWeek().getValue() !=7 )
			{
				System.out.println();
			}
	}
}
