package CodeWars;
/**
 * Evil Autocorrect Prank
 * @author tmosest
 */
public class Kata {
	
	public static String autocorrect(String input) {
		
		StringBuilder sb = new StringBuilder();
		StringBuilder uTracker = new StringBuilder();
		
		for(int i = 0; i < input.length(); i++) {
			char letter = input.charAt(i);
			if('A' <= letter && letter <= 'z' && i < input.length() - 1) {
				uTracker.append(letter);
			} else {
				if(i == input.length() - 1 && 'A' <= letter && letter <= 'z') {
					uTracker.append(letter);
				}
				//Check if uTracker is u you or youUUUUU
				String tracker = uTracker.toString();
				boolean isYou = (tracker.length() > 0) ? true : false;
				for(int j = 0; j < tracker.length(); j++) {
					char uLetter = tracker.charAt(j);
					if(j == 0) {
						if(!(uLetter == 'u' || uLetter == 'U' || 
								uLetter == 'Y' || uLetter == 'y')) {
							isYou = false;
							break;
						}
					} else if(j == 1) {
						if(!(uLetter == 'o' || uLetter == 'O')) {
							isYou = false;
							break;
						}
					} else {
						if(!(uLetter == 'u' || uLetter == 'U')) {
							isYou = false;
							break;
						}
					}
				}
				if(isYou)
					sb.append("your sister");
				else
					sb.append(tracker);
				if(!('A' <= letter && letter <= 'z')) {
					sb.append(input.charAt(i));
				}
				uTracker = new StringBuilder();
			}
		}
		
	    return sb.toString();
	}
	
}