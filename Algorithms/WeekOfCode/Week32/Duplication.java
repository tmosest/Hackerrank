package WeekOfCode.Week32;

import java.util.Scanner;

/**
 *	Algorithms -> Week of Code 32 -> Duplication
 *	Easy
 */
public class Duplication {
	
	private static String finalString;
	
	public static String buildString() {
		StringBuilder result = new StringBuilder();
		result.append("0");
		int length = 1;
		while(length < 1000) {
			StringBuilder t = new StringBuilder();
			String s = result.toString();
			for(int s_i = 0; s_i < s.length(); s_i++) {
				char c = s.charAt(s_i);
				if(c == '0') 
					t.append("1");
				else
					t.append("0");
			}
			result.append(t);
			length += t.length();
		}
		return result.toString();
	}
	
	public static String duplication(int x){
		return String.valueOf(finalString.charAt(x));
    }

    public static void main(String[] args) {
    	finalString = buildString();
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int x = in.nextInt();
            String result = duplication(x);
            System.out.println(result);
        }
    }
	
} // end class Duplication