package WeekOfCode.Week30;

import java.util.Scanner;

/**
 *	Algorithms -> Week of Code 30 -> Candy Replenishing Robot
 *	Easy
 */
public class CandyReplenishingRobot {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int l = in.nextInt();
        int[] c = new int[l];
        for(int i = 0; i < l; i++)
            c[i] = in.nextInt();
        in.close();
        CandyRefiller cr = new CandyRefiller(n, c);
        System.out.println(cr.getRefillCount());
	}
	
	public static class CandyRefiller
    {
        private int refillCount, remainingCandies;
        /*
         * Class Constructor Does the heavy lifting. 
         */
        public CandyRefiller(int size, int[] candyCounts)
        {   
            this.refillCount = 0;
            this.remainingCandies = size;
            
            int time = candyCounts.length,
                c = 0;
            for(int t = 0; t < time; t++) {
                c = candyCounts[t];
                this.remainingCandies -= c;
                if(t != time - 1) {
                    if(this.remainingCandies < 5) {
                      this.refillCount += (size - this.remainingCandies);  
                      this.remainingCandies = size;
                    }
                }
            }
        }
        
        public int getRefillCount()
        {
            return this.refillCount;    
        }
    } // end class CandyRefiller
} // end class CandyReplenishingRobot
