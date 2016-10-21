package Strings;

import java.util.Scanner;

/**
 *	Algorithms -> Strings -> Mars Exploration
 *	Easy
 */
public class MarsExploration {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        String S = in.next();
        in.close();
        int numIncorrect = countNumberOfIncorrectSOS(S);
        System.out.println(numIncorrect);
	}
	
	public static int countNumberOfIncorrectSOS(String SOSs)
	{
		int numIncorrect = 0;
		//System.out.println("Length: " + SOSs.length());
		for(int i = 0; i < SOSs.length(); i +=3) {
			//System.out.println("i: " + i);
			char S1 = SOSs.charAt(i);
			char O = SOSs.charAt(i + 1);
			char S2 = SOSs.charAt(i + 2);
			//System.out.println(S1 + "" + O +S2);
			if(S1 != 'S') numIncorrect++;
			if(O != 'O') numIncorrect++;
			if(S2 != 'S') numIncorrect++;
		}
		return numIncorrect;
	}
}
