package WeekOfCode.Week28;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

/**
 *	Algorithms -> Week of Code 28 -> The Value of Friendship
 *	Hard
 */
public class TheValueOfFriendship {

	private static boolean debugMode = false;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int qs = in.nextInt();
		
		for(int q = 0; q < qs; q++) {
			int n = in.nextInt();
			int m = in.nextInt();
			
			FriendCounter fc = new FriendCounter(n);
			
			for(int e = 0; e < m; e++) {
				int node1 = in.nextInt() - 1; 
				int node2 = in.nextInt() - 1;
				fc.addEdge(node1, node2);
			}
			
			System.out.println(fc.printTotal());
			fc = null;
		}
		
		in.close();
	}

	private static class FriendCounter
	{
		private long total;
		private HashSet<Integer>[] bags;
		private HashMap<Integer, HashSet<Integer>> distinctBags;
		
		public FriendCounter(int nodes)
		{
			total = 0;
			bags = new HashSet[nodes];
			distinctBags = new HashMap<Integer, HashSet<Integer>>();
			
			if(debugMode)
				System.out.println("Set total to 0");
			for(int i = 0; i < nodes; i++)
			{
				if(debugMode)
					System.out.println("init node: " + i);
				HashSet<Integer> s = new HashSet<Integer>();
				if(debugMode)
					System.out.println("Created HashSet: " + s);
				s.add(i);
				if(debugMode)
					System.out.println("Added i: " + i + " to HashSet: " + s);
				bags[i] = s;
				distinctBags.put(i, s);
			}
		}
		
		public void addEdge(int node1, int node2)
		{
			HashSet s1 = bags[node1];
			HashSet s2 = bags[node2];
			
			if(debugMode)
				System.out.println("node1: " + node1 + " : " + s1 + " node2: " + node2 + " : " + s2);
			
			//if s1 == s2 then all we need to do is sum the totals again.
			if(s1 != s2) {
				//else check the sizes
				if(s1.size() < s2.size()) {
					s2.addAll(s1);
					bags[node1] = s2;
					s1 = null;
					distinctBags.put(node1, null);
				} else {
					s1.addAll(s2);
					bags[node2] = s1;
					s2 = null;
					distinctBags.put(node2, null);
				}
			}
			
			for(int key : distinctBags.keySet()) {
				int bagSize = (distinctBags.get(key) == null) ? 0 : distinctBags.get(key).size();
				total += (bagSize * (bagSize - 1));
				if(debugMode)
					System.out.println("set: " + key + " : " + bagSize);
			}
		}
		
		public long printTotal()
		{
			return this.total;
		}
	}
}
