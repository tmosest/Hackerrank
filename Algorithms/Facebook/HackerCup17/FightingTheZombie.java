package Facebook.HackerCup17;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * http://mathforum.org/library/drmath/view/52207.html
 * http://stackoverflow.com/questions/29854866/dice-sum-probability-with-different-types-of-dice
 * http://math.stackexchange.com/questions/4632/how-can-i-algorithmically-count-the-number-of-ways-n-m-sided-dice-can-add-up-t
 * @author tmosest
 *
 */
public class FightingTheZombie {
	
	private static boolean debugMode = true;
	private static String inFileStr =  "Facebook/HackerCup17/FightingTheZombieIn.txt";
    private static String outFileStr = "Facebook/HackerCup17/FightingTheZombieOut.txt";
	
	public static void main(String[] args) throws IOException {
		// FileReader reads text files in the default encoding.
        FileReader fileReader = 
            new FileReader(inFileStr);

        // Always wrap FileReader in BufferedReader.
        BufferedReader bufferedReader = 
            new BufferedReader(fileReader);
        
	     // Assume default encoding.
	        FileWriter fileWriter =
	            new FileWriter(outFileStr);

        // Always wrap FileWriter in BufferedWriter.
        BufferedWriter bufferedWriter =
            new BufferedWriter(fileWriter);
		
        int zombies = Integer.valueOf(bufferedReader.readLine());
        
        for(int z = 1; z <= zombies; z++) {
        	String[] line = bufferedReader.readLine().split(" ");
        	int health = Integer.valueOf(line[0]);
        	String[] spells = bufferedReader.readLine().split(" ");
        	double probability = calulcateProbabilityOfKillingZombie(health, spells);
        	bufferedWriter.write("Case #"+ z +": " + probability);
        }
        
        // Always close files.
        bufferedReader.close();
        bufferedWriter.close();
	}
	
	private static double calulcateProbabilityOfKillingZombie(int zombieHealth, String[] spells)
	{
		double maxProbability = 0.0;
		
		for(String spell: spells) {
			double probability = probabilityOfGreaterThanOrEqualToSum(spell, zombieHealth);
			if(probability > maxProbability)
				maxProbability = probability;
		}
		return maxProbability;
	}
	
	/**
	 * 10d6-10 1d6+1 2d4 1d8
	 * @param diceConfig
	 * @return
	 */
	private static double probabilityOfGreaterThanOrEqualToSum(String diceConfig, int sum)
	{
		double probability = 0.0;
		int numDice = 0;
		int numSides = 0;
		int bonus = 0;
		//Split the String at d
		String[] splitD = diceConfig.split("d");
		
		if(debugMode)
			System.out.println(splitD[0] + " " + splitD[1]);
		
		numDice = Integer.valueOf(splitD[0]);
		if(splitD[1].contains("+")) {
			String[] splitBonus = splitD[1].split("\\+");
			numSides = Integer.valueOf(splitBonus[0]);
			bonus = Integer.valueOf(splitBonus[1]);
		} else if(splitD[1].contains("-")) {
			String[] splitBonus = splitD[1].split("-");
			numSides = Integer.valueOf(splitBonus[0]);
			bonus = -1 * Integer.valueOf(splitBonus[1]);
		} else 
			numSides = Integer.valueOf(splitD[1]);
		
		if(debugMode)
			System.out.println("numDice: " + numDice + " numSides: " + numSides + " bonus: " + bonus);
		
		int diceCount = 0;
		int[] diceValues = new int[numDice];
		int count = 0;
		int total = 0;
		
		while(diceCount < diceValues.length && diceValues[numDice - 1] + 1 < numSides) {
			int diceSum = 0;
			for(int i = 0; i < diceValues.length; i++) {
				diceSum += (diceValues[i] + 1);
			}
			total++;
			diceValues[diceCount]++;
			if(diceSum - bonus > sum) count++;
			if(diceValues[diceCount] + 1 == numSides) {
				diceCount++;
			}
		}
		
		if(debugMode)
			System.out.println("count: " + count + " total: " + total);
		
		return probability;
	}
}
