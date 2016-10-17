package Implementation;

import java.util.Scanner;

/**
 *	Algorithms -> Implementations -> Bon Appétit
 *	Easy
 */
public class BonAppetit {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int numberOfITems = in.nextInt();
        int indecOFItemNotEaten = in.nextInt();
        int[] foodCostsArry = new int[numberOfITems];
        int realFoodCosts = 0;
        for(int i = 0; i < numberOfITems; i ++) {
            foodCostsArry[i] = in.nextInt();
            if(i != indecOFItemNotEaten) realFoodCosts += foodCostsArry[i];
        }
        int amountCharged = in.nextInt();
        int amountToCharge = realFoodCosts/2;
        if(amountCharged == amountToCharge) {
            System.out.println("Bon Appetit");   
        } else {
            System.out.println(amountCharged - amountToCharge);
        }
        in.close();
	}

}
