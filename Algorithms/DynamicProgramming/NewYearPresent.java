package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

/**
 *	Algorithms -> Dynamic Programming -> New Year Present 
 *	Hard
 */
public class NewYearPresent {
	
	static int maxSizeForArray = (int) (2 * 1e7 + 5);
	
	static long dp1[] = new long[maxSizeForArray];
	static long dp2[] = new long[maxSizeForArray];
	static long dp3[] = new long[maxSizeForArray];
	
	static long ans, ans1, ans2, ans3, pom;
	
	static int arraySize, idx;
	
	static int[] sticks;
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		arraySize = in.nextInt();
		sticks = new int[arraySize];
		
		for(int i = 0; i < arraySize; i++) {
			sticks[i] = in.nextInt();
		}
		
		in.close();
		
		Arrays.sort(sticks);
		
		for(int i = 0; i < arraySize; i++) {
			dp1[sticks[i]]++;
		}
		
		for(int i = 0; i < arraySize - 1; i++) {
			for(int j = i + 1; j < arraySize; j++) {
				dp2[sticks[i] + sticks[j]]++;
			}
		}
		
		for(int i = 0; i < arraySize; i++) {
			for(int j = 0; j < i; j++) {
				if(sticks[i] != sticks[i - 1]) {
					
					dp3[sticks[i]] += dp2[sticks[i] - sticks[j]];
					
					if (3*sticks[j] == sticks[i]) {
						dp3[sticks[i]] -= (dp1[sticks[j]] - 1);
					} else if (2 * sticks[j] < sticks[i]) {
						dp3[sticks[i]] -= dp1[sticks[i] - 2 * sticks[j]];
					}
				}
			}
		}
		
		ans=0;
		
		for (int i = 1; i < arraySize; i++) {
			 if (sticks[i] != sticks[i-1]) {
				 ans += (dp1[sticks[i]] * (dp1[sticks[i]] - 1) * (dp1[sticks[i]] - 2) * dp3[sticks[i]]) / 6;
			 }
		}
		
		for (int i=1 ; i<arraySize; i++) {
			if (sticks[i] != sticks[i-1]) {
				idx=0;
		        pom=0;
		        ans2=0;
		        ans3=0;
		        while (2 * sticks[idx] < sticks[i]) {
		        	if(pom != sticks[idx]) {
		        		pom = sticks[idx];
		                 ans3 += (dp1[sticks[idx]] * (dp1[sticks[idx]]-1) * dp1[sticks[i] - sticks[idx]] * (dp1[sticks[i] - sticks[idx]] - 1)) / 4;
		                 if (sticks[i] % 2 == 0) {
		                    ans3 += (dp1[sticks[idx]] * (dp1[sticks[i] - sticks[idx]]) * dp1[sticks[i]/2] * (dp1[sticks[i]/2] - 1)) / 2;
		                    ans2 += dp1[sticks[idx]] * dp1[sticks[i] - sticks[idx]] * (dp2[sticks[i]] - (dp1[sticks[idx]] * dp1[sticks[i] - sticks[idx]]) - (dp1[sticks[i]/2] * (dp1[sticks[i]/2] - 1)) / 2);
		                 }
		                 else
		                    ans2 += (dp1[sticks[idx]] * dp1[sticks[i] - sticks[idx]]) * (dp2[sticks[i]] - (dp1[sticks[idx]] * dp1[sticks[i] - sticks[idx]]));
		             }
		             idx++;
		       }
		       ans2 = ans2 / 2;
		       ans2 += ans3;
		       if(2 * sticks[idx] == sticks[i]) {
		    	   ans2 += (dp1[sticks[idx]] * (dp1[sticks[idx]] - 1) * (dp1[sticks[idx]] - 2) * (dp1[sticks[idx]] - 3)) / 24;
		       }
		       ans1 += ans2 * (dp1[sticks[i]] * (dp1[sticks[i]]-1)) / 2;
			}
		}
		ans += ans1;
		System.out.println(ans);
	}

}
