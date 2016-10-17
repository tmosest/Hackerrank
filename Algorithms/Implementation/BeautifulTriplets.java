package Implementation;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *	Algorithms -> Implementations -> Beautiful Triplets
 *	Easy
 */
public class BeautifulTriplets {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	     int n = in.nextInt(), d = in.nextInt();
	     ArrayList<Integer> elements = new ArrayList<>();
	     for( int i = 0; i < n; i++ ) {
	       elements.add( in.nextInt() );
	     }
	     in.close();
	     System.out.println( beautifulTripletsCount(elements, n, d) );
	}
	
	public static int beautifulTripletsCount( ArrayList<Integer> e, int n, int d ) {
        int count = 0;
        for( Integer v : e ) {
            if( e.contains( (v + d) ) && e.contains( (v + 2*d) ) )
                count++;
        }
        return count;
    }

}
