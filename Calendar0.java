/*
 * Checks if a given year is a leap year or a common year,
 * and computes the number of days in a given month and a given year. 
 */
public class Calendar0 {	
	
	// Gets a year (command-line argument), and tests the functions isLeapYear and nDaysInMonth.
	public static void main(String args[]) 
	{
		int year = Integer.parseInt(args[0]);
		isLeapYearTest(year);

		for(int i=1; i<=12; i++)
		{
			System.out.println("Month " + i + " has " + nDaysInMonth(i, year) + " days");
		}
		
	}
		 
	// Tests the isLeapYear function.
	private static void isLeapYearTest(int year) {
		String commonOrLeap = "common";
		if (isLeapYear(year)) {
			commonOrLeap = "leap";
		}
		System.out.println(year + " is a " + commonOrLeap + " year");  
	}

	// Tests the nDaysInMonth function.
	private static void nDaysInMonthTest(int month, int year) 
	{
		int yearCheck = year;
		int monthCheck = month;
		System.out.println(nDaysInMonth(monthCheck, yearCheck));
	}

	// Returns true if the given year is a leap year, false otherwise.
	public static boolean isLeapYear(int year) 
	{
		int yearCheck = year;
		boolean isLeapYear = false;
		isLeapYear = (((yearCheck % 400) == 0) || (((yearCheck % 4) == 0) && ((yearCheck % 100) != 0)));
		return isLeapYear;
	}
	 
	// Returns the number of days in the given month and year.
	// April 4, June 6, September 9 , and November 11 have 30 days each.
	// February 2 has 28 days in a common year, and 29 days in a leap year.
	// All the other months have 31 days.
	public static int nDaysInMonth(int month, int year) 
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

