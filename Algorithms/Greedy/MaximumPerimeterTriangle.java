package Greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 *	Algorithms ->  Greedy -> Maximum Perimeter Triangle
 *	Easy
 */
public class MaximumPerimeterTriangle {
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        scanner.close();
        Arrays.sort(a);
        int x, y, z;
        for(x=n-3, y=n-2, z=n-1; a[x]+a[y]<=a[z]; x--, y--, z--){
            if(x==0) {
                System.out.print(-1);
                return;
            }
        }
        System.out.printf("%d %d %d", a[x], a[y], a[z]);
    }
	
}
