package CodeWars;
/**
 * Word a10n (abbreviation)
 * @author tmosest
 */
public class Abbreviator {

	  public String abbreviate(String string) {
		  StringBuilder sb = new StringBuilder();
		  StringBuilder smallWord = new StringBuilder();
		  int count = 0;
		  for(int i = 0; i < string.length(); i++) {
			  char letter = string.charAt(i);
			  if(i == string.length() - 1) {
				  smallWord.append(string.charAt(i));
				  if(count > 4) {
					  count++;
					  String tmp = smallWord.toString();
					  sb.append(tmp.charAt(0));
					  sb.append(String.valueOf(count - 2));
					  sb.append(tmp.charAt(tmp.length() - 1));  
				  } else {
					  sb.append(sb.append(smallWord.toString()));
				  }
			  } else if('A' <= letter && letter <= 'z') {
				  smallWord.append(string.charAt(i));
				  count++;
			  //} else if(smallWord.length() != 0 && letter != ' ' && (letter < 'A' || letter > 'z')) {
				 // sb.append(string.charAt(i));
				 // count = 0;
			  } else {
				  String tmp = smallWord.toString();
				  if(count > 3) {
					  sb.append(tmp.charAt(0));
					  sb.append(String.valueOf(count - 2));
					  sb.append(tmp.charAt(tmp.length() - 1));  
				  } else {
					  sb.append(tmp);
				  }
				  sb.append(string.charAt(i));
				  smallWord = new StringBuilder();
				  count = 0;
			  }
		  }
		  return sb.toString();
	  }

}

