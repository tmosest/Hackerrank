package CodeWars;
/**
 * Decode the Morse code, advanced
 * @author tmosest
 */
public class MorseCodeDecoder {
	
    private static final boolean debugMode = false;
	
	private static final int DOT = 1;
	private static final int DASH = 3;
	private static final int DOT_DASH_PAUSE = 1;
	private static final int CHAR_PAUSE = 3;
	private static final int WORD_PAUSE = 7;
	
	public static String decodeBits(String bits) {
		if(debugMode)
			System.out.println("bits: " + bits);
		
		int unit = determineUnitSize(bits);
		
		if(debugMode)
			System.out.println("unit: " + unit);
    	
		StringBuilder result = new StringBuilder();
		StringBuilder word = new StringBuilder();
		
		char last = bits.charAt(0), letter;
		word.append(last);
		int i;
		for(i = 1; i < bits.length(); i++) {
    		letter = bits.charAt(i);
    		if(letter != last) {
    			if(word.length() == DOT * unit) {
    				if(last == '1') // Append a dot
    					result.append('.');
    			} else if(word.length() == DASH * unit) {
    				if(last == '1') // Append a dot
    					result.append('-');
    				else
    					result.append(' ');
    			} else if(word.length() >= WORD_PAUSE * unit) {
    				if(last == '0')
    					result.append("   ");
    			}
    			if(debugMode)
    				System.out.println("word: " + word.toString());
    			last = letter;
    			word = new StringBuilder();
    		}
    		word.append(letter);
    	}
		if(bits.length() > 1) {
			if(word.length() == DOT * unit) {
				if(last == '1') // Append a dot
					result.append('.');
			} else if(word.length() == DASH * unit) {
				if(last == '1') // Append a dot
					result.append('-');
				else
					result.append(' ');
			} else if(word.length() >= WORD_PAUSE * unit) {
				if(last == '0')
					result.append("   ");
			}
			if(debugMode)
				System.out.println("word: " + word.toString());
		} else if(bits.length() == 1 && last == '1') {
			result.append(".");
		}
		if(debugMode)
			System.out.println("result: " + result.toString());
		return result.toString();
    }
    
    public static String decodeMorse(String morseCode) {
    	StringBuilder sb = new StringBuilder();
    	StringBuilder word = new StringBuilder();
    	boolean foundSpace = false;
    	for(int i = 0; i < morseCode.length(); i++) {
    		char letter = morseCode.charAt(i);
    		if(i < morseCode.length() - 1 && letter != ' ') {
    			word.append(letter);
    			foundSpace = false;
    		} else {
    			if(i == morseCode.length() - 1 && letter != ' ') {
    				word.append(letter);
    			}
    			if(word.length() > 0) {
    				String decWord = MorseCode.get(word.toString());
        			sb.append(decWord);
    			}
    			if(i != morseCode.length() - 1 && i > 0 &&
    					!foundSpace && sb.length() > 0 &&
    					morseCode.charAt(i - 1) == ' ' &&
    					morseCode.charAt(i + 1) == ' ' && 
    					letter == ' ') {
    				sb.append(letter);
    				foundSpace = true;
    			}
    			word = new StringBuilder();
    		}
    	}
    	return sb.toString();
    }
    
    public static int determineUnitSize(String bits)
    {
    	// Return short strings
    	if(bits.length() <= 1)
    		return bits.length();
    	//Trim Leading and Ending Zeros
    	bits = bits.replaceAll("^0+", ""); // Leading
    	bits = bits.replaceAll("0+$", ""); // Trailing
    	
    	// Determine the unit
    	int unit = Integer.MAX_VALUE;
    	char last = bits.charAt(0);
    	int count = 1;
    	boolean hasChanged = false;
    	for(int i = 1; i < bits.length(); i++) {
    		char letter = bits.charAt(i);
    		if(letter != last) {
    			if(count > 0) {
    				unit = Math.min(count, unit);
    			}
    			count = 0;
    			last = letter;
    			hasChanged = true;
    		}
    		count++;
    	}
    	if(!hasChanged)
    		unit = bits.length();
    	return unit;
    } // end determineUnitSize
}
