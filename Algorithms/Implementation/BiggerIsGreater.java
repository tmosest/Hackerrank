package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *	Algorithms -> Implementations -> Bigger is Greater
 *	Medium
 */
public class BiggerIsGreater {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int testCases = 0;
        try {
            testCases = Integer.parseInt(in.readLine());
        } catch(Exception e) {
            
        }
        for(int i = 0; i < testCases; i++) {
           String word = in.readLine();
           String result =  largestWord(word);
           System.out.println(result);
        }
        in.close();
	}
	
	public static String largestWord(String word) {
	   String result = "no answer";
       char[] wordArray = word.toCharArray();
       char[] arrayToPermutate = wordArray.clone();
       if(nextPermutation(arrayToPermutate)) {
    	   result = String.valueOf(arrayToPermutate);    
       }
       return result;
	}
	
	public static boolean nextPermutation(char[] array) {
	    // Find longest non-increasing suffix
	    int i = array.length - 1;
	    while (i > 0 && array[i - 1] >= array[i])
	        i--;
	    // Now i is the head index of the suffix
	    
	    // Are we at the last permutation already?
	    if (i <= 0)
	        return false;
	    
	    // Let array[i - 1] be the pivot
	    // Find rightmost element that exceeds the pivot
	    int j = array.length - 1;
	    while (array[j] <= array[i - 1])
	        j--;
	    // Now the value array[j] will become the new pivot
	    // Assertion: j >= i
	    
	    // Swap the pivot with j
	    char temp = array[i - 1];
	    array[i - 1] = array[j];
	    array[j] = temp;
	    
	    // Reverse the suffix
	    j = array.length - 1;
	    while (i < j) {
	        temp = array[i];
	        array[i] = array[j];
	        array[j] = temp;
	        i++;
	        j--;
	    }
	    
	    // Successfully computed the next permutation
	    return true;
	}

}
