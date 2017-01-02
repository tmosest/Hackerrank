package TopCoder;

/**
 * TopCoder -> Practice -> Substitute
 * Easy/Single/250
 * @author tmosest
 *
 */
public class Substitute {
	
	public static void main(String[] args)
	{
		
	}
	
	public int getValue(String key, String code)
	{
		int value = 0;
		
		for(int i = 0; i < code.length(); i++) {
			char letter = code.charAt(i);
			for(int j = 0; j < key.length(); j++) {
				if(letter == key.charAt(j)) {
					value *= 10;
					if(j != key.length() - 1) {
						if(j + 1 >= 10)
							value *= 10;
						value += (j + 1);
					}
				}
			}
		}
		
		return value;
	}
	
}
