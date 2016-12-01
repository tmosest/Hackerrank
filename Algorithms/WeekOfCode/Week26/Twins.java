package WeekOfCode.Week26;

import java.util.Scanner;

/**
 *	Algorithms -> Week of Code 26 -> Twins
 *	Medium
 */
public class Twins {
	static public boolean[] usedPrimes;
	static public int start;
	static public int end;
    static public boolean debugMode;
	
	public static void main(String[] args) {
        debugMode = false;
		Scanner in = new Scanner(System.in);
		start = in.nextInt();
        end = in.nextInt();
		in.close();
		int twins = 0;
		for(int i = start; i <= (end - 2); i++)
        {
            if(isPrime(i) == true && isPrime(i+2) == true)
            {
            	twins++;
            }
        }
        System.out.println(twins);
	}
	
	 static boolean isPrime(int n) //funton for checking prime
    {
        int count=0;
        for(int i=1; i<=n; i++)
            {
                if(n%i == 0)
                    count++;
            }
        if(count == 2)
            return true;
         else
            return false;
    }

}
