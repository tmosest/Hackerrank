package Implementation;

import java.util.Scanner;

/**
 *	Algorithms -> Implementations -> Encryption
 *	Medium
 */
public class Encryption {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        String s = in.next();
        in.close();
        String result = performEncryption(s);
        System.out.println(result);
	}
	
	public static String performEncryption(String toEncrpy)
	{
		int stringLength = toEncrpy.length();
		int floorLength = (int) Math.floor(Math.sqrt( (double) stringLength));
		int ceilLength = (int) Math.ceil(Math.sqrt( (double) stringLength));
		
		//System.out.println("Length: " + stringLength);
		//System.out.println("Floor of Length: " + floorLength);
		//System.out.println("Ceil of Length: " + ceilLength);
		
		if(floorLength * ceilLength < stringLength) floorLength++;
		
		StringBuilder sb = new StringBuilder(stringLength + ceilLength + 1);
		String[] encryptionMatrix = new String[floorLength];
		for(int i = 0; i < floorLength; i++) {
			if(i != floorLength- 1) {
				encryptionMatrix[i] = toEncrpy.substring(i * ceilLength, i * ceilLength + ceilLength);
			} else {
				encryptionMatrix[i] = toEncrpy.substring(i * ceilLength);
			}
			//System.out.println("Row "+ i +": " + encryptionMatrix[i]);
		}
		for(int i = 0; i < ceilLength; i++) {
			StringBuilder word = new StringBuilder(floorLength);
			for(int j = 0; j < floorLength; j++) {
				if(encryptionMatrix[j].length() > i) word.append(encryptionMatrix[j].charAt(i));
			}
			sb.append(word + " ");
			//System.out.println(word + " ");
		}
		return sb.toString();
	}

}
