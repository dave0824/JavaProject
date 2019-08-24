package fourth.object;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 *This program show a calendar for now mouth
 * @author Superhero
 * @version 2018年12月15日下午10:22:18
 */

public class CalendarTest 
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
