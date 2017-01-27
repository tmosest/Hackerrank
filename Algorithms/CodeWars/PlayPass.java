package CodeWars;
/**
 * Playing with passphrases
 * @author tmosest
 */
public class PlayPass {
	private static final boolean debugMode = false;
	
	public static String playPass(String s, int n) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(isLetter(c)) {
				c = shiftLetter(c, n);
				if(i % 2 == 0)
					sb.append(Character.toUpperCase(c));
				else
					sb.append(Character.toLowerCase(c));
				if(debugMode)
					System.out.println(c);
			} else if(isDigit(c)) {
				sb.append(ninesCompliment(c));
				if(debugMode)
					System.out.println(c);
			} else {
				sb.append(c);
			}
		}
		return sb.reverse().toString();
	}
	
	public static boolean isLetter(char c)
	{
		return 'A' <= c && c <= 'z';
	}
	
	public static boolean isUpperCase(char c)
	{
		return 'A' <= c && c <= 'Z';
	}
	
	public static boolean isLowerCase(char c)
	{
		return 'a' <= c && c <= 'z';
	}
	
	public static boolean isDigit(char c)
	{
		return '0' <= c && c <= '9';
	}
	
	public static char shiftLetter(char c, int k)
	{
		if(!isLetter(c))
			return c;
		
		int mod = 26, diff = 0;
		if(isUpperCase(c)) {
			diff = (c - 'A' + k) % mod;
			return ((char) ('A' + diff));
		}
		
		diff = (c - 'a' + k) % mod;
		return ((char) ('a' + diff));
	}
	
	public static char ninesCompliment(char c)
	{
		if(!isDigit(c))
			return c;
		int n = Integer.parseInt(String.valueOf(c));
		n = 9 - n;
		return String.valueOf(n).charAt(0);
	}
}