package CodeWars;
/**
 * Fold an array
 * @author tmosest
 */
public class Kata
{
  public static int[] foldArray(int[] array, int runs)
  {
	int n = array.length;  
    if(n == 1 || runs == 0)
    	return array;
    
	--runs;
    int[] foldedArray;
    int m;
    if(n % 2 == 1) {
    	foldedArray = new int[n / 2 + 1];
    	foldedArray[foldedArray.length - 1] =  array[n / 2];
    } else {
    	foldedArray = new int[n / 2];
    }
    
    
    for(int i = 0; i < n / 2; i++) {
    	foldedArray[i] = array[i] + array[n - i - 1];
    }
    
    return foldArray(foldedArray, runs);
  }
}