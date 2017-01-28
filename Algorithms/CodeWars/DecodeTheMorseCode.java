package CodeWars;
/**
 * Decode the Morse code
 * @author tmosest
 */
public class MorseCodeDecoder {
    public static String decode(String morseCode) {
        // your brilliant code here, remember that you can access the preloaded Morse code table through MorseCode.get(code)
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
}
