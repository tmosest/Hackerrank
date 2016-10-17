package Implementation;

import java.util.Scanner;

/**
 *	Algorithms -> Implementations -> Chocolate Feast
 *	Easy
 */
public class ChocolateFeast {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int c = in.nextInt();
            int m = in.nextInt();
            System.out.println(
            	calculateNumberOfChoclatesConsumed(n, c, m)
            );
        }
        in.close();
	}
	
	public static int calculateNumberOfChoclatesConsumed(int dollars, int cost, int wrappersRequired)
	{
		
		int chocs = dollars/cost;  //chocolates bought with Money
        int wrapper = chocs; //wrappers from chocolate
        while(wrapper>=wrappersRequired){
        	int ex_chocs = wrapper / wrappersRequired;  //chocolates from wrappers
            wrapper = ex_chocs + wrapper % wrappersRequired;
            chocs += ex_chocs;
        }
		return chocs;
	}

}
