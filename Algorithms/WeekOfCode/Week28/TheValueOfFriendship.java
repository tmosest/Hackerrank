package WeekOfCode.Week28;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 *	Algorithms -> Week of Code 28 -> The Value of Friendship
 *	Hard

1
14 14
7 8
1 2
2 3
1 3
4 5
4 6
5 6
10 11
13 12
12 11
13 11
13 10
12 10
12 9

 */
public class TheValueOfFriendship {

	private static boolean debugMode = false;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int qs = in.nextInt();
		
		for(int q = 0; q < qs; q++) {
			int n = in.nextInt();
			int m = in.nextInt();
			
			FriendCounterUF fc = new FriendCounterUF(n);
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

	private static class FriendCounterUF
	{
		private BigInteger total;
		private long repeats;
		private WeightedQuickUnionPathHalvingUF uf;
		private long longTotal = 0;
		
		public FriendCounterUF(int nodes)
		{
			total = BigInteger.ZERO;
			repeats = 0;
			uf = new WeightedQuickUnionPathHalvingUF(nodes);
		}
		
		public void addEdge(int node1, int node2)
		{
			if(!uf.connected(node1, node2)) {
				uf.union(node1, node2);
			} else {
				++repeats;
			}
			if(debugMode)
				uf.printArrays();
			if(debugMode)
				System.out.println("Already connected: " + repeats);
		}
		
		private void calculateLongTotal()
		{
			long[] counts = uf.getCounts();
			Arrays.sort(counts);
			
			long holder = 0;
			
			int i = counts.length - 1;
			while(counts[i] > 0) {
				long count = counts[i];
				
				long sum = gaussFormala(count - 1);
				long lastTerm = count * (count - 1);
				
				if(debugMode)
					System.out.println("sum: " + sum + " lastTerm: " + lastTerm + " holder: " + holder + " total: " + longTotal);

				longTotal += (holder * (count - 1) + sum);
				holder += lastTerm;
				i--;
			}
			longTotal += repeats * holder;
		}
		
		private void calculateTotal()
		{
			long[] counts = uf.getCounts();
			Arrays.sort(counts);
			
			BigInteger holder = BigInteger.ZERO;
			
			int i = counts.length - 1;
			while(counts[i] > 0) {
				BigInteger count = new BigInteger(String.valueOf(counts[i]));
				BigInteger countMinusOne = count.subtract(BigInteger.ONE);
				BigInteger sum = gaussFormalaBig(countMinusOne);
				
				BigInteger lastTerm = count.multiply(countMinusOne);
				
				if(debugMode)
					System.out.println("sum: " + sum + " lastTerm: " + lastTerm + " holder: " + holder + " total: " + total);

				total = total.add(holder.multiply(countMinusOne)).add(sum);
				holder = holder.add(lastTerm);
				i--;
			}
			BigInteger reps = new BigInteger(String.valueOf(repeats));
			total = total.add(reps.multiply(holder));
		}
		
		private long gaussFormala(long n)
		{
			return ((n) * (n + 1) * (n + 2)) / 3;
		}
		
		private BigInteger gaussFormalaBig(BigInteger n) {
			BigInteger two = new BigInteger("2");
			BigInteger three = new BigInteger("3");
			n = n.multiply(n.add(BigInteger.ONE)).multiply(n.add(two));
			return n.divide(three);
		}
		
		public BigInteger printTotal()
		{	
			calculateTotal();
			return this.total; 	
		}
		
		public long printLongTotal()
		{ 
			calculateLongTotal();
			return this.longTotal;
		}
	}
	
	public static class WeightedQuickUnionPathHalvingUF {
	    private int[] parent;  // parent[i] = parent of i
	    private int[] size;    // size[i] = number of sites in tree rooted at i
	                           // Note: not necessarily correct if i is not a root node
	    private int count;     // number of components
	    private long[] counts;
	    
	    /**
	     * Initializes an empty union–find data structure with {@code n} sites
	     * {@code 0} through {@code n-1}. Each site is initially in its own 
	     * component.
	     *
	     * @param  n the number of sites
	     * @throws IllegalArgumentException if {@code n < 0}
	     */
	    public WeightedQuickUnionPathHalvingUF(int n) {
	        count = n;
	        parent = new int[n];
	        size = new int[n];
	        counts = new long[n];
	        for (int i = 0; i < n; i++) {
	            parent[i] = i;
	            size[i] = 1;
	            counts[i] = 1;
	        }
	    }

	    /**
	     * Returns the number of components.
	     *
	     * @return the number of components (between {@code 1} and {@code n})
	     */
	    public int count() {
	        return count;
	    }
	  
	    /**
	     * Returns the component identifier for the component containing site {@code p}.
	     *
	     * @param  p the integer representing one object
	     * @return the component identifier for the component containing site {@code p}
	     * @throws IndexOutOfBoundsException unless {@code 0 <= p < n}
	     */
	    public int find(int p) {
	        validate(p);
	        while (p != parent[p]) {
	            parent[p] = parent[parent[p]];    // path compression by halving
	            p = parent[p];
	        }
	        return p;
	    }

	    // validate that p is a valid index
	    private void validate(int p) {
	        int n = parent.length;
	        if (p < 0 || p >= n) {
	            throw new IndexOutOfBoundsException("index " + p + " is not between 0 and " + (n-1));  
	        }
	    }

	    /**
	     * Returns true if the the two sites are in the same component.
	     *
	     * @param  p the integer representing one site
	     * @param  q the integer representing the other site
	     * @return {@code true} if the two sites {@code p} and {@code q} are in the same component;
	     *         {@code false} otherwise
	     * @throws IndexOutOfBoundsException unless
	     *         both {@code 0 <= p < n} and {@code 0 <= q < n}
	     */
	    public boolean connected(int p, int q) {
	        return find(p) == find(q);
	    }

	    /**
	     * Merges the component containing site {@code p} with the 
	     * the component containing site {@code q}.
	     *
	     * @param  p the integer representing one site
	     * @param  q the integer representing the other site
	     * @throws IndexOutOfBoundsException unless
	     *         both {@code 0 <= p < n} and {@code 0 <= q < n}
	     */
	    public void union(int p, int q) {
	    	if(debugMode) 
	    		System.out.println(p + " : " + q);
	        int rootP = find(p);
	        int rootQ = find(q);
	        long countP = counts[rootP];
	        long countQ = counts[rootQ];
	        if(debugMode) 
	    		System.out.println(rootP + " : " + rootQ);
	        if (rootP == rootQ) return;
	        if(debugMode)
	        	System.out.println(size[rootP] + " : " + size[rootP]);
	        // make smaller root point to larger one
	        if (size[rootP] < size[rootQ]) {
	            parent[rootP] = rootQ;
	            size[rootQ] += size[rootP];
	            counts[rootQ] += countP;
	            counts[rootP] -= countP;
	        }
	        else {
	            parent[rootQ] = rootP;
	            size[rootP] += size[rootQ];
	            counts[rootP] += countQ;
	            counts[rootQ] -= countQ;
	        }
	        count--;
	    }
	    
	    public long[] getCounts()
	    {
	    	return counts;
	    }
	    
	    public void printArrays()
	    {
	    	System.out.println("Size:");
	    	for(int s : size) {
	    		System.out.print(s + " ");
	    	}
	    	System.out.println("\nParent:");
	    	for(int s : parent) {
	    		System.out.print(s + " ");
	    	}
	    	System.out.println("\nCounts:");
	    	for(long s : counts) {
	    		System.out.print(s + " ");
	    	}
	    	System.out.println("");
	    }
	}
}

