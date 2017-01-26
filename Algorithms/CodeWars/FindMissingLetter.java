package CodeWars;

/**
 * Find the missing letter
 * @author tmosest
 */
public class Kata
{
  public static char findMissingLetter(char[] array)
  {
	for(int i = 0; i < array.length - 1; i++) {
		if(array[i + 1] - array[i] > 1) {
			return (char) ((char) array[i] + 1);
		}
	}
    return ' ';
  }
}