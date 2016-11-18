package Sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 *	Algorithms -> Sorting -> Counting Sort 3
 *	Medium
 */
public class TheFullCountingSort {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final String[] strings = new String[n];
        final int[] heads = new int[100];
        final int[] tails = new int[100];
        final int[] next = new int[n];
        Arrays.fill(heads, -1);
        Arrays.fill(tails, -1);
        Arrays.fill(next, -1);
        int length = 0;
        for(int i = 0; i < n; i++) {
            final int number = scanner.nextInt();
            if(heads[number] == -1) {
                heads[number] = i;
            } else {
                next[tails[number]] = i;
            }
            tails[number] = i;
            String s = scanner.next();
            strings[i] = i < n/2 ? "-" : s;
            length += strings[i].length() + 1;
        }
        scanner.close();
        StringBuilder sb = new StringBuilder(length);
        for(int nxt : heads) {
            while(nxt != -1) {
                sb.append(strings[nxt]);
                sb.append(' ');
                nxt = next[nxt];
            }
        }
        System.out.println(sb.toString());
	}
	
	
}
