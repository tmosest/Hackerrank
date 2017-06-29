package Implementation;

import java.util.Scanner;

/**
 *	Algorithms -> Implementations -> Breaking The Rules
 *	Medium
 */
public class BreakingTheRules {
	/**
	 * Takes a set of scores and returns the number of times the best and worst records were broken.
	 * @param s
	 * @return
	 */
	private static int[] getRecord(int[] s) {
        int[] records = new int[2];
        records[0] = records[1] = 0;
        
        int worst, best;
        best = worst = s[0];
        
        for(int i = 1; i < s.length; i++) {
        	int score = s[i];
        	if(score < worst) {
        		worst = score;
        		++records[1];
        	}
        	if(score > best) {
        		best = score;
        		++records[0];
        	}
        }
        
        return records;
    }
	
	/**
	 * Main
	 * @param args
	 */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = in.nextInt();
        }
        int[] result = getRecord(s);
        String separator = "", delimiter = " ";
        for (Integer val : result) {
            System.out.print(separator + val);
            separator = delimiter;
        }
        System.out.println("");
    }
	
}
