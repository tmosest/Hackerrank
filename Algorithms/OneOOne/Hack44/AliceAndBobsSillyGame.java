package OneOOne.Hack44;

import java.util.Scanner;

public class AliceAndBobsSillyGame {
	
	private static boolean debugMode = false;
	
	private static boolean[] seive;
	private static int primeCount;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int cases = in.nextInt();
		
		for(int t = 0; t < cases; t++) {
			int number = in.nextInt();
			fillSieve(number);
			if(primeCount % 2 == 0) {
				System.out.println("Bob");
			} else {
				System.out.println("Alice");
			}
		}
		
		in.close();
	}

	public static void fillSieve(int number) 
	{	
		seive = new boolean[number + 1];
		primeCount = 0;
		
		seive[0] = true;
		seive[1] = true;
		
		for(int i = 2; i <= number; i++) {
			if(!seive[i]) {
				primeCount++;
				for(int j = 1; j * i <= number; j++) {
					seive[i * j] = true;
				}
			}
		}
	}
}
