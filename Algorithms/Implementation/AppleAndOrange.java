package Implementation;

import java.util.Scanner;

/**
 *	Algorithms -> Implementations -> Apple and Orange
 *	Easy
 */
public class AppleAndOrange {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        int[] apple = new int[m];
        for(int apple_i=0; apple_i < m; apple_i++){
            apple[apple_i] = in.nextInt();
        }
        int[] orange = new int[n];
        for(int orange_i=0; orange_i < n; orange_i++){
            orange[orange_i] = in.nextInt();
        }
        
        in.close();
        
        long appleCount = 0;
        for(int apple_i=0; apple_i < m; apple_i++){
            if(apple[apple_i] + a >= s && apple[apple_i] + a <= t) appleCount++;
        }
        long orangeCount = 0;
        for(int orange_i=0; orange_i < n; orange_i++){
            if(orange[orange_i] + b <= t && orange[orange_i] + b >= s) orangeCount++;
        }
        System.out.println(appleCount);
        System.out.println(orangeCount);
        
	}
	
}
