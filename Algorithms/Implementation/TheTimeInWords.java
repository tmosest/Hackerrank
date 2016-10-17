package Implementation;

import java.util.Scanner;

/**
 *	Algorithms -> Implementations -> The Time in Words
 *	Medium
 */
public class TheTimeInWords {

	private static final String[] tensNames = {
			"",
	        " ten",
	        " twenty",
	        " thirty",
	        " forty",
	        " fifty",
	        " sixty",
	        " seventy",
	        " eighty",
	        " ninety"
	      };

	      private static final String[] numNames = {
	        "",
	        " one",
	        " two",
	        " three",
	        " four",
	        " five",
	        " six",
	        " seven",
	        " eight",
	        " nine",
	        " ten",
	        " eleven",
	        " twelve",
	        " thirteen",
	        " fourteen",
	        " fifteen",
	        " sixteen",
	        " seventeen",
	        " eighteen",
	        " nineteen"
	      };
	
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
        int h = in.nextInt();
        int m = in.nextInt();
        String result = convertTimetoWords(h, m);
        System.out.println(result);
	}
	
	
	private static String convertLessThanOneThousand(int number) 
	{
        String soFar;

        if (number % 100 < 20){
          soFar = numNames[number % 100];
          number /= 100;
        }
        else {
          soFar = numNames[number % 10];
          number /= 10;

          soFar = tensNames[number % 10] + soFar;
          number /= 10;
        }
        if (number == 0) return soFar;
        return numNames[number] + " hundred" + soFar;
      }
	
	public static String convertTimetoWords(int hours, int minutes)
	{
		StringBuilder sb = new StringBuilder(100);
		String hoursWord, minutesWord;
		if(minutes == 0) {
			hoursWord = convertLessThanOneThousand(hours);
			sb.append(hoursWord + " o' clock");
            sb.deleteCharAt(0);
		} else if(minutes <= 30) {
            if(minutes == 15) {
				minutesWord = "quarter";
				sb.append(minutesWord);
            } else if(minutes == 30) {
				minutesWord = "half";
				sb.append(minutesWord);
			} else {
				minutesWord = convertLessThanOneThousand(minutes);
				sb.append(minutesWord);
				sb.append(" minute");
				if(minutes > 1) sb.append("s");
                sb.deleteCharAt(0);
			}
			sb.append(" past");
			hoursWord = convertLessThanOneThousand(hours);
			sb.append(hoursWord);
		} else {
            if(minutes == 45) {
				minutesWord = "quarter";
				sb.append(minutesWord);
			} else {
                minutes = 60 - minutes;
                minutesWord = convertLessThanOneThousand(minutes);
                sb.append(minutesWord);
                sb.append(" minute");
                if(minutes > 1) sb.append("s");  
                sb.deleteCharAt(0);
            }
			sb.append(" to");
			hoursWord = convertLessThanOneThousand(hours + 1);
			sb.append(hoursWord);
		}
		String s = sb.toString();
		return s;
	}

}
