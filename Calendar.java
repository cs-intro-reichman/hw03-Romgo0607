/** 
 * Prints the calendars of selected year
 */
public class Calendar {	
    //Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     
	static int nDaysInMonth = 31; 
	
	public static void main(String args[]) {
        int selectYear = Integer.parseInt(args[0]);
	 	while (year <= selectYear) {
            if(year == selectYear) {
                if(dayOfWeek == 1) {
				    System.out.println(dayOfMonth + "/" + month + "/" + year + " Sunday");
			    } else {
				    System.out.println(dayOfMonth + "/" + month + "/" + year);
			    }
            }
        advance();
        }
	}

	 // Advances the date (day, month, year) and the day-of-the-week.
	 // If the month changes, sets the number of days in this month.
	 // Side effects: changes the static variables dayOfMonth, month, year, dayOfWeek, nDaysInMonth.
	 private static void advance() {
		if(dayOfWeek < 7) {
            dayOfWeek++;
        } else {
            dayOfWeek = 1;
        }
        if(dayOfMonth < nDaysInMonth(month, year)) {
			dayOfMonth++;
		} else {
			month++;
			dayOfMonth = 1;
		}
		if(month == 13) {
           month = 1;
		   year++;
        }	
	 } 	 
    // Returns true if the given year is a leap year, false otherwise.
	private static boolean isLeapYear(int year) {
		boolean isLeapYear = false;
		isLeapYear = (((year % 400) == 0) || (((year % 4) == 0) && ((year % 100) != 0)));
		return isLeapYear;
	}

	// Returns the number of days in the given month and year.
	private static int nDaysInMonth(int month, int year) {
		int result;
		result = 28;
		if((isLeapYear(year)) && (month == 2)) {
            result = 29;
		} else { 
            if((month == 4) || (month == 6) || (month == 9) || (month == 11)) {
				result = 30;
			} else if((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12)) {
					result = 31;
                    }
                }
		return result;
	}
}
