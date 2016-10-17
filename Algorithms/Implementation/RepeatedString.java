package Implementation;

import java.util.Scanner;

/**
 *	Algorithms -> Implementations -> Repeated String
 *	Easy
 */
public class RepeatedString {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        String s = in.next();
        long n = in.nextLong();
        in.close();
        long result = countAsInInfiniteString(s, n);
        System.out.println(result);
	}

	public static long countAsInInfiniteString(String baseString, long n) {
		int A = 0;
	    int B = 0;
		for (int i = 0; i < (int)baseString.length(); i++) {
	       if (baseString.charAt(i) == 'a') A++;
	       if ((long)i < n % (long)baseString.length() && baseString.charAt(i) == 'a') B++;
	    }
		long answer = n /  (long)baseString.length() * (long) A + (long) B;
		return answer;
	}
}
