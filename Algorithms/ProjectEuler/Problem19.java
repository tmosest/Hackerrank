package ProjectEuler;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * Project Euler #19: Counting Sundays 
 * Easy
 */
public class Problem19 {
	
	private static boolean debugMode = true;
	
	public static void main(String[] args) throws ParseException
	{
		Scanner in = new Scanner(System.in);
		
		int qs = in.nextInt();
		in.nextLine();
		
		DateFormat df = new SimpleDateFormat("y M d"); 
		Calendar c = Calendar.getInstance();
		
		for(int q = 0; q < qs; q++) {
			
			String startDateString = in.nextLine();
			String endDateString = in.nextLine();
			
			if(debugMode)
				System.out.println("start date: " + startDateString + " end date: " + endDateString);
			
			Date startDate = df.parse(startDateString);
			Date endDate = df.parse(endDateString);
			
			if(debugMode) {
				System.out.println("Start Date:");
				System.out.println("Year: " + startDate.getYear());
				System.out.println("Month: " + startDate.getMonth());
				System.out.println("Day: " + startDate.getDay());
			}
			
			int counter = 0;
			c.setTime(startDate);
			while(c.getTime().compareTo(endDate) <= 0) {
				int day_of_week = c.get(Calendar.DAY_OF_WEEK);
	             if(day_of_week == Calendar.SUNDAY){
	            	 counter++;
	             }
				c.add(Calendar.DATE, 1);
			}
			System.out.println(counter);
		}
		
		in.close();
	}
	
	/*
	public static int countSundays()
	{
		 int counter = 0;
	     Calendar c = Calendar.getInstance();
	     int Day_Of_Month=1; //This makes it easier in case you want to tweak the test, to say, 

	     for (int year = 1901; year<=2000; year++){
	    	 for (int month = 0; month < 12; month++){
	    		 c.set(year, month, 1);
	             int day_of_week = c.get(Calendar.DAY_OF_WEEK);
	             if(day_of_week == Calendar.SUNDAY){
	            	 counter++;
	             }
	         }
	     }
	        
	}
	*/
}
