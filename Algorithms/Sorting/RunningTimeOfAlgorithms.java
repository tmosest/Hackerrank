package Sorting;

import java.util.Scanner;

public class RunningTimeOfAlgorithms {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
        }
        in.close();
        int moves = insertIntoSortedMoves(ar);
        System.out.println(moves);
	}
	
	public static int insertIntoSortedMoves(int[] ar) {
		int moves = 0;
		for(int i = 1; i < ar.length; i++) {
			int j = i;
			while(j > 0 && ar[j] < ar[j-1]) {
				int holder = ar[j];
				ar[j] = ar[j-1];
				ar[j-1] = holder;
				j--;
				moves++;
			}
		}
		return moves;
    }
	
}
