package BitManipulation;

import java.util.Scanner;

/**
 *	Algorithms -> Bit Manipulation -> Cipher
 *	Medium
 */
public class Cipher {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	    
		int N = in.nextInt();
	    int K = in.nextInt();
	    String S_temp = in.next();
	    
	    in.close();
	    
	    int[] S = new int[N + K - 1];
	       
	    for(int i = 0; i < S_temp.length(); i++) {
	    	S[i] = Character.getNumericValue(S_temp.charAt(i));
	    }
	       
	    int[] O = new int[N];
	    int sum = 0, j = 0, tempSum = 0, value = 0;
	    for(int i = 0; i < N; i++) {
	    
	    	if(i >= K) {
	    		sum -= O[j++];
	        }
	           
	        tempSum = sum + S[i];
	        
	        if(tempSum % 2 == 0)
	        	value = 0;
	        else
	        	value = 1;
	            
	        sum += value;
	        O[i] = value;
	    }
	       
	    for(int i = 0; i < N; i++) {
	    	System.out.print(O[i]);
	    }
	}

}
