package CodeWars;
/**
 * Buying a car
 * @author tmosest
 */
public class BuyCar {
	
	public static final double percentLossIncreaseAmount = 0.5;
	
	public static int[] nbMonths(int startPriceOld, int startPriceNew, int savingperMonth, double percentLossByMonth) {
		int[] results = {0, 0}; // months, money left;

		while(startPriceOld + results[0] * savingperMonth < startPriceNew) {
			++results[0]; // increment by a month
			if(results[0] % 2 == 0) {
				percentLossByMonth += percentLossIncreaseAmount;
			}
			startPriceOld = (int) (startPriceOld - (percentLossByMonth/100) * startPriceOld);
			startPriceNew = (int) (startPriceNew - (percentLossByMonth/100) * startPriceNew); 
			System.out.println("month: " + results[0] + " savings: "  + 
					results[0] * savingperMonth + " startPriceOld: " + startPriceOld + " startPriceNew: " + startPriceNew);
		}
		
		results[1] = startPriceOld + results[0] * savingperMonth - startPriceNew;
		
		return results;
	}
	
}

/**
 * Javascript function.
 * @return
 */
function nbMonths(startPriceOld, startPriceNew, savingperMonth, percentLossByMonth){
	var results = new Array(2);
	results[0] = 0;
	results[1] = 0;

	while(startPriceOld + results[0] * savingperMonth < startPriceNew) {
		++results[0]; // increment by a month
		if(results[0] % 2 == 0) {
			percentLossByMonth += 0.5;
		}
		startPriceOld = (startPriceOld - (percentLossByMonth/100) * startPriceOld);
		startPriceNew = (startPriceNew - (percentLossByMonth/100) * startPriceNew); 
	}
	
	results[1] = Math.round(startPriceOld + results[0] * savingperMonth - startPriceNew);
	
	return results;
}