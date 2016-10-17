package Implementation;

import java.util.Scanner;

/**
 *	Algorithms -> Implementations -> The Grid Search
 *	Medium
 *	Great example of how easy it is to be off by one!
 *	row_i <= rowSizeDifference not row_i < rowSizeDifference
 *	col_j <= colSizeDifference not col_j < colSizeDifference
 */
public class TheGridSearch {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int R = in.nextInt();
            in.nextInt();
            String G[] = new String[R];
            for(int G_i=0; G_i < R; G_i++){
                G[G_i] = in.next();
            }
            int r = in.nextInt();
            in.nextInt();
            String P[] = new String[r];
            for(int P_i=0; P_i < r; P_i++){
                P[P_i] = in.next();
            }
            //Perform grid search
            boolean result = smallerGridIsInside(G, P);
            if(result) {
            	System.out.println("YES");
            } else {
            	System.out.println("NO");
            }
        }
        in.close();
	}
	
	public static boolean smallerGridIsInside(String[] bigGrid, String[] smallGrid)
	{
		char initialSearchChar = smallGrid[0].charAt(0);
		
		int rowSizeDifference = bigGrid.length - smallGrid.length;
		int columnSizeDifference = bigGrid[0].length() - smallGrid[0].length();
		boolean foundMatch = false;
		
		for(int row_i = 0; row_i <= rowSizeDifference; row_i++) {
			
			for(int col_j = 0; col_j <= columnSizeDifference; col_j++) {
				
				if(bigGrid[row_i].charAt(col_j) == initialSearchChar) {
					//System.out.println("Found a Candidate");
					//Loop through little one and find it.
					boolean foundPotentialMatch = true;
					for(int row_s = 0; row_s < smallGrid.length; row_s++) {
						for(int col_s = 0; col_s < smallGrid[0].length(); col_s++) {
							if(smallGrid[row_s].charAt(col_s) != bigGrid[row_i + row_s].charAt(col_j + col_s)) {
								foundPotentialMatch = false;
								break;
							}
						}
						if(!foundPotentialMatch) break;
					}// end //Loop through little one and find it.
					if(foundPotentialMatch) foundMatch = true;
				} //end if
				if(foundMatch) break;
			}//end for col_j
			if(foundMatch) break;
		}//end for row_i
		
		return foundMatch;
	}

}
