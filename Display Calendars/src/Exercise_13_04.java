/*
*
 */

/**
 *
 * @author Alexander Hansen.
 */
import java.util.*;

public class Exercise_13_04 {
    
    public static void main(String[] args){
        
        int yy = getUserYear();
        int mm = getUserMonth();
  
        Calendar gregCal = new GregorianCalendar(yy, mm, 1);
        //System.out.println("Today:\t\t\t"+ gregCal.get(Calendar.DAY_OF_MONTH));
        //System.out.println("Day of Week: \t\t" + gregCal.get(Calendar.DAY_OF_WEEK));
        //System.out.println("First Day of Week: \t" + gregCal.getFirstDayOfWeek());
        //System.out.println("Month: \t\t\t" + gregCal.get(Calendar.MONTH));
        //System.out.println("Last Day of Month: \t" + gregCal.getMaximum(Calendar.DAY_OF_MONTH));
        //System.out.println("First Day of Month: \t" + gregCal.getMinimum(Calendar.DAY_OF_MONTH));
        
        int lastDay = gregCal.getMaximum(Calendar.DAY_OF_MONTH);
        
       // String mm = gregCal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
        //System.out.println(mm);
        
       // for (int i = 1; i < lastDay; i++){
       //     System.out.println(i + " ");
       // }
        gregCal.get(Calendar.LONG_FORMAT);
        //System.out.println("Month: \t\t\t" + gregCal.get(Calendar.MONTH));
        
        // Crate a Caleander object
		Calendar calendar = gregCal;
		// Display calander header
		printHeader(calendar); 
		

		// Pad space before the first day of the month
		for (int i = 1; i < calendar.get(Calendar.DAY_OF_WEEK); i++) 
			System.out.print("    ");

		// Print days in month
		while (calendar.get(Calendar.DATE) <
			calendar.getActualMaximum(Calendar.DATE)) {

			if (calendar.get(Calendar.DAY_OF_WEEK) == 7)
				System.out.printf("%4d\n", calendar.get(Calendar.DATE));
			else
				System.out.printf("%4d", calendar.get(Calendar.DATE));

			// Add a day
			calendar.add(Calendar.DATE, 1);
		}
		System.out.printf("%4d\n", calendar.get(Calendar.DATE));
                System.out.println(monthName(mm)+", "+yy+" contains "+gregCal.getMaximum(Calendar.DAY_OF_MONTH)+" days");
	}
    //array to pull the name of month
public static String monthName(int mm) {
    int i = mm;
    String[] months = {"January", "February", "March", "April", "May", "June", 
			"July", "August", "September", "October", "November", "December"};
    return months[i];
}
    /**
     * This method will prompt user for year
     */
    public static int getUserYear() {
        int userYear = 0;
        Scanner readInp;
        
        while (true) {
            try {
                readInp = new Scanner(System.in);
                System.out.print("Please enter a numeric year: ");
                userYear = readInp.nextInt();
                return userYear;
            }
            catch (Exception e) {
                System.out.println("Non-numeric input");
                
            }
                    
        }
        
    }
    //get the user month
    public static int getUserMonth() {
        int userMonth = 0;
        Scanner readInp;
        
        while (true) {
            try {
                readInp = new Scanner(System.in);
                System.out.print("Please enter a numeric month: ");
                userMonth = readInp.nextInt();
                userMonth = userMonth - 1;
                return userMonth;
            }
            catch (Exception e) {
                System.out.println("Non-numeric input");
                
            }
                    
        }
        
    }
    
    /** Returns an String array of month names */
	public static String[] getMonths() {
		String[] months = {"January", "February", "March", "April", "May", "June", 
			"July", "August", "September", "October", "November", "December"};
		return months;
	}
    
    /** Display calendar header */
	public static void printHeader(Calendar calendar) {
		// Create an array of month names
		String[] months = getMonths();

		// Center month and year center format
		int length = 29 / 2 - (months[calendar.get(Calendar.MONTH)].length() / 2 + 3);
		System.out.println();
		for (int i = 0; i < length; i++)
			System.out.print(" ");
		System.out.println(months[calendar.get(Calendar.MONTH)] + ", " + 
			calendar.get(Calendar.YEAR));

		// Print week day names
		System.out.println("-----------------------------");
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
}
}
	