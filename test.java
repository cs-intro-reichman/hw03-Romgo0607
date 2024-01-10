public class test 
{ 
	public static void main(String[] args) 
	{
        int dayOfMonth = 1;   
	    int month = 1;
	    int year = 1900;
	    int dayOfWeek = 2;     // 1.1.1900 was a Monday
	    int nDaysInMonth = 31;
        while(year == 1900)
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
		System.out.println(dayOfMonth + "/" + month + "/" + year);
        if(dayOfMonth == 1)
		{
            if(dayOfWeek == 1)
			    System.out.print("Sunday");
		}
	}
        }
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
