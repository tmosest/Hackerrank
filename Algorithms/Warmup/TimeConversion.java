package Warmup;

import java.util.Scanner;
/**
 *	Algorithms -> Warmup -> Time Conversion
 *	Easy (Super Easy)
 */
public class TimeConversion {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        String time = in.next();
        in.close();
        String r = convertTime(time);
        System.out.println(r);
	}
	
	public static String convertTime(String time) 
	{
		String substring = time.substring(Math.max(time.length() - 2, 0));
        int hours = 0;
        if(substring.equals("PM")) {
            hours = Integer.parseInt(time.substring(0,2));
            if(hours != 12) {
           	 hours += 12;
            }
            time = hours + time.substring(2,  time.length() - 2);
            return time;
        } else {
            hours = Integer.parseInt(time.substring(0,2));
            if(hours == 12) {
                time = "00" + time.substring(2,  time.length() - 2);   
            } else {
                time = time.substring(0, time.length() - 2);    
            }
            return time;
        }
	}
}
