/** 
 * Prints the calendars of all the years in the 20th century.
 */
public class Calendar1 
{	
    // Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January
	
	/** 
	 * Prints the calendars of all the years in the 20th century. Also prints the  
	 * number of Sundays that occured on the first day of the month during this period.
	 */
	public static void main(String args[]) {
		// Advances the date and the day-of-the-week from 1/1/1900 till 31/12/1999, inclusive.
	    // Prints each date dd/mm/yyyy in a separate line. If the day is a Sunday, prints "Sunday".
	    // The following variable, used for debugging purposes, counts how many days were advanced so far.
	    int debugDaysCounter = 0; 
		int sundayCounter = 0;
		
	    //// Write the necessary initialization code, and replace the condition
	    //// of the while loop with the necessary condition 
	 	while (year <= 1999) 
		{
			advance();
			if((dayOfWeek == dayOfMonth) && (dayOfMonth ==1))
			{
				System.out.println(dayOfMonth + "/" + month + "/" + year + " Sunday");
				sundayCounter++;
			}
			else
			{
				System.out.println(dayOfMonth + "/" + month + "/" + year);
			}
	 		debugDaysCounter++;
	 		//// If you want to stop the loop after n days, replace the condition of the
	 		//// if statement with the condition (debugDaysCounter == n)
	 		/*if (debugDaysCounter == nDays) {  
	 			break;
	 		}*/
        }
		System.out.println("During the 20th century, " + sundayCounter + " Sundays fell on the first day of the month");
	 	//// Write the necessary ending code here
	 }
	
	 // Advances the date (day, month, year) and the day-of-the-week.
	 // If the month changes, sets the number of days in this month.
	 // Side effects: changes the static variables dayOfMonth, month, year, dayOfWeek, nDaysInMonth.
	 private static void advance() 
	 {
		if(dayOfWeek < 7) //adds days to the week yntil its the 7st day
        {
            dayOfWeek++;
        }
        else
		{
            dayOfWeek = 1; //reset the days of the week
        }

		if(dayOfMonth < nDaysInMonth(month, year)) //Calculates the expected days in a month - adds days until the month ends. 
		{
			dayOfMonth++;
		}
		else //when its the last day of the month - reset the days back to 1, moves 1 month ahead
		{
			month++;
			dayOfMonth = 1;
		}
		if(month == 13) //when its the last month of the year - adds year.
        {
           month = 1;
		   year++;
        }	
	 } 
		 
    // Returns true if the given year is a leap year, false otherwise.
	private static boolean isLeapYear(int year) {
	    int yearCheck = year;
		boolean isLeapYear = false;
		isLeapYear = (((yearCheck % 400) == 0) || (((yearCheck % 4) == 0) && ((yearCheck % 100) != 0)));
		return isLeapYear;
	}
	 
	// Returns the number of days in the given month and year.
	// April, June, September, and November have 30 days each.
	// February has 28 days in a common year, and 29 days in a leap year.
	// All the other months have 31 days.
	private static int nDaysInMonth(int month, int year) 
	{
		int yearCheck = year;
		int monthCheck = month;
		int result;

		result = 28;
		if((isLeapYear(yearCheck)) && (monthCheck == 2))
		{
				result = 29;
		}
		else
		{
			if((monthCheck == 4) || (monthCheck == 6) || (monthCheck == 9) || (monthCheck == 11))
			{
				result = 30;
			}
			else
				if((monthCheck == 1) || (monthCheck == 3) || (monthCheck == 5) || (monthCheck == 7) ||
				 (monthCheck == 8) || (monthCheck == 10) || (monthCheck == 12))
				 {
					result = 31;
				 }
		}
	
		return result;
	}
	
}
