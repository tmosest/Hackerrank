package Implementation;

import java.util.Scanner;

/**
 *	Algorithms -> Implementations -> Angry Professor
 *	Easy (Super Easy)
 */
public class AngryProfessor {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            int a[] = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            String result = determinIfClassWillBeHeld(a, k);
            System.out.println(result);
        }
        in.close();
	}
	
	public static String determinIfClassWillBeHeld(int a[], int k)
	{
		int onTime = 0;
		for(int a_i=0; a_i < a.length; a_i++){
            if(a[a_i] <= 0) onTime++;
        }
        String result = "YES";
        if(onTime >= k) {
        	result = "NO";
        }
		return result;
	}
}
