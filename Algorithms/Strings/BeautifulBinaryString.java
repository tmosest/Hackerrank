package Strings;

import java.util.Scanner;

/**
 *	Algorithms -> Strings -> Beautiful Binary String
 *	Easy
 */
public class BeautifulBinaryString {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int stringLength = in.nextInt();
        String binaryString = in.next();
        in.close();
        int count = countChangesNeededToMakeBeautiful(binaryString);
        System.out.println(count);
	}
	
	public static int countChangesNeededToMakeBeautiful(String binaryString)
	{
		int count = (binaryString.length() - binaryString.replace("010", "").length())/3;
		return count;
	}
	
}
