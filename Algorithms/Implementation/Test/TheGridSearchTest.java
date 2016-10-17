package Implementation.Test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

import Implementation.TheGridSearch;

public class TheGridSearchTest {

	BufferedReader in = null;
	BufferedReader out = null;
	
	@Test
	public void testSmallerGridIsInside() throws IOException {
		in = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("data/GridSearch/TestCase0Input.txt")));
		out = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("data/GridSearch/TestCase0Output.txt")));
			
		int cases = Integer.parseInt(in.readLine());
		assertEquals(3, cases); // check array size
		for(int a0 = 0; a0 < cases; a0++){
			
			String[] bigSize = in.readLine().split(" ");
            int R = Integer.parseInt(bigSize[0]);
            Integer.parseInt(bigSize[1]);
            
            String G[] = new String[R];
            
            for(int G_i=0; G_i < R; G_i++){
                G[G_i] = in.readLine();
            }
            
            String[] littleSize = in.readLine().split(" ");
            int r = Integer.parseInt(littleSize[0]);
            Integer.parseInt(littleSize[0]);
            String P[] = new String[r];
            for(int P_i=0; P_i < r; P_i++){
                P[P_i] = in.readLine();
            }
            //Perform grid search
            boolean result = TheGridSearch.smallerGridIsInside(G, P);
            String outline = out.readLine();
            if(result) {
            	assertEquals(outline + " " + a0, "YES" + " " + a0);
            } else {
            	assertEquals(outline + " " + a0, "NO" + " " + a0);
            }
        }
		
	}

}
