package HackerEarth;


import java.util.Scanner;

/**
 * Magical Word
 * Medium
 * @author tmosest
 *
 */
public class MagicalWord {

	private static boolean primes[] = new boolean[128];
	
	private static void fillSeive()
	{
		primes[0] = true;
		primes[1] = true;
		for(int i = 2; i < primes.length; i++) {
			if(!primes[i]) {
				for(int j = 2; j * i < primes.length; j++)
					primes[i * j] = true;
			}
		}
	}
	
	public static void main(String[] args)
	{
		fillSeive();
		Scanner in = new Scanner(System.in);
		int qs = in.nextInt();
		for(int q = 0; q < qs; q++) {
			int n = in.nextInt();
			String s = in.next();
			System.out.println(convertToMagicWord(s));
		}
		in.close();
	}
	
	private static String convertToMagicWord(String s)
	{
		StringBuilder sb = new StringBuilder(s.length());
		for(int i = 0; i < s.length(); i++) {
			char letter = s.charAt(i);
			int index = letter - 'A' + 65;
			if(primes[index]) {
				int j, k;
				j = k = index;
				while(primes[j] && primes[k]) {
				    //System.out.println("j: " + j + " k: " + k);
					if(j > 0) {
						j--;
						if(!primes[j]) {
							index = j;
						    break;
						}
					}
					if(k < 127) {
						k++;
						if(!primes[k]) {
							index = k;
							break;
						}
					}
				}
			}
			if(index < (int) 'C') index = (int) 'C';
			if(index > (int) 'z') index = (int) 'q';
			sb.append((char) index);
		}
		return sb.toString();
	}
}
