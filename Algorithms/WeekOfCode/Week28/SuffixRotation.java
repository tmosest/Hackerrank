package WeekOfCode.Week28;

import java.util.Scanner;

/**
 *	Algorithms -> Week of Code 28 -> Choosing White Balls
 *	Hard
 *  http://softwareengineering.stackexchange.com/questions/127919/smallest-lexicographical-rotation-of-a-string-using-suffix-arrays-in-on
 *  http://p--np.blogspot.com/2011/12/suffix-array.html
 */

public class SuffixRotation {

	private static boolean debugMode = true;
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int qs = in.nextInt();
		
		for(int q = 0; q < qs; q++) {
			if(debugMode)
				System.out.println("");
			
			String s = in.next();
			
			CountsForCycleSort ccs = new CountsForCycleSort(s);
			
			ccs.printSuffixArray();
		}
		
		in.close();
	}
	
	private static class CountsForCycleSort
	{
		private int n, count;
		private String s;
		private String alphabet = "abcdefghijklmnopqrstuvwxyz";
		
		public CountsForCycleSort(String s)
		{
			this.s = s;
			this.n = s.length();
			this.count = 0;
		}
		
		public void calculateCountBruteForce()
		{
			char check = s.charAt(0);
			for(int i = 0; i < n; i++) {
				
			}
		}
		
		public int getCount()
		{ return this.count; }
		
		public void printSuffixArray()
		{
			SuffixArrayX sa = new SuffixArrayX(s);
			for(int i = 0; i < s.length(); i++)
				System.out.println(sa.select(i));
			
			for(int s_i = 0; s_i < s.length(); s_i++) {
				String suffix = sa.select(s_i);
					//System.out.println(suffix);
					int lcp = -1;
					if(s_i > 0) {
						lcp = sa.lcp(s_i);
					}
					for(int i = lcp + 1; i < suffix.length() + 1; i++) {
						String subStr = suffix.substring(0, i);
						System.out.println(subStr);
					}
			}
		}
	}
	
	private static class SuffixArrayX {
	    private static final int CUTOFF =  5;   // cutoff to insertion sort (any value between 0 and 12)

	    private final char[] text;
	    private final int[] index;   // index[i] = j means text.substring(j) is ith largest suffix
	    private final int n;         // number of characters in text

	    /**
	     * Initializes a suffix array for the given {@code text} string.
	     * @param text the input string
	     */
	    public SuffixArrayX(String text) {
	        n = text.length();
	        text = text + '\0';
	        this.text = text.toCharArray();
	        this.index = new int[n];
	        for (int i = 0; i < n; i++)
	            index[i] = i;

	        sort(0, n-1, 0);
	    }

	    // 3-way string quicksort lo..hi starting at dth character
	    private void sort(int lo, int hi, int d) { 

	        // cutoff to insertion sort for small subarrays
	        if (hi <= lo + CUTOFF) {
	            insertion(lo, hi, d);
	            return;
	        }

	        int lt = lo, gt = hi;
	        char v = text[index[lo] + d];
	        int i = lo + 1;
	        while (i <= gt) {
	            char t = text[index[i] + d];
	            if      (t < v) exch(lt++, i++);
	            else if (t > v) exch(i, gt--);
	            else            i++;
	        }

	        // a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi]. 
	        sort(lo, lt-1, d);
	        if (v > 0) sort(lt, gt, d+1);
	        sort(gt+1, hi, d);
	    }

	    // sort from a[lo] to a[hi], starting at the dth character
	    private void insertion(int lo, int hi, int d) {
	        for (int i = lo; i <= hi; i++)
	            for (int j = i; j > lo && less(index[j], index[j-1], d); j--)
	                exch(j, j-1);
	    }

	    // is text[i+d..n) < text[j+d..n) ?
	    private boolean less(int i, int j, int d) {
	        if (i == j) return false;
	        i = i + d;
	        j = j + d;
	        while (i < n && j < n) {
	            if (text[i] < text[j]) return true;
	            if (text[i] > text[j]) return false;
	            i++;
	            j++;
	        }
	        return i > j;
	    }

	    // exchange index[i] and index[j]
	    private void exch(int i, int j) {
	        int swap = index[i];
	        index[i] = index[j];
	        index[j] = swap;
	    }

	    /**
	     * Returns the length of the input string.
	     * @return the length of the input string
	     */
	    public int length() {
	        return n;
	    }


	    /**
	     * Returns the index into the original string of the <em>i</em>th smallest suffix.
	     * That is, {@code text.substring(sa.index(i))} is the <em>i</em> smallest suffix.
	     * @param i an integer between 0 and <em>n</em>-1
	     * @return the index into the original string of the <em>i</em>th smallest suffix
	     * @throws java.lang.IndexOutOfBoundsException unless {@code 0 <=i < n}
	     */
	    public int index(int i) {
	        if (i < 0 || i >= n) throw new IndexOutOfBoundsException();
	        return index[i];
	    }

	    /**
	     * Returns the length of the longest common prefix of the <em>i</em>th
	     * smallest suffix and the <em>i</em>-1st smallest suffix.
	     * @param i an integer between 1 and <em>n</em>-1
	     * @return the length of the longest common prefix of the <em>i</em>th
	     * smallest suffix and the <em>i</em>-1st smallest suffix.
	     * @throws java.lang.IndexOutOfBoundsException unless {@code 1 <= i < n}
	     */
	    public int lcp(int i) {
	        if (i < 1 || i >= n) throw new IndexOutOfBoundsException();
	        return lcp(index[i], index[i-1]);
	    }

	    // longest common prefix of text[i..n) and text[j..n)
	    private int lcp(int i, int j) {
	        int length = 0;
	        while (i < n && j < n) {
	            if (text[i] != text[j]) return length;
	            i++;
	            j++;
	            length++;
	        }
	        return length;
	    }

	    /**
	     * Returns the <em>i</em>th smallest suffix as a string.
	     * @param i the index
	     * @return the <em>i</em> smallest suffix as a string
	     * @throws java.lang.IndexOutOfBoundsException unless {@code 0 <= i < n}
	     */
	    public String select(int i) {
	        if (i < 0 || i >= n) throw new IndexOutOfBoundsException();
	        return new String(text, index[i], n - index[i]);
	    }

	    /**
	     * Returns the number of suffixes strictly less than the {@code query} string.
	     * We note that {@code rank(select(i))} equals {@code i} for each {@code i}
	     * between 0 and <em>n</em>-1. 
	     * @param query the query string
	     * @return the number of suffixes strictly less than {@code query}
	     */
	    public int rank(String query) {
	        int lo = 0, hi = n - 1;
	        while (lo <= hi) {
	            int mid = lo + (hi - lo) / 2;
	            int cmp = compare(query, index[mid]);
	            if      (cmp < 0) hi = mid - 1;
	            else if (cmp > 0) lo = mid + 1;
	            else return mid;
	        }
	        return lo;
	    } 

	    // is query < text[i..n) ?
	    private int compare(String query, int i) {
	        int m = query.length();
	        int j = 0;
	        while (i < n && j < m) {
	            if (query.charAt(j) != text[i]) return query.charAt(j) - text[i];
	            i++;
	            j++;

	        }
	        if (i < n) return -1;
	        if (j < m) return +1;
	        return 0;
	    }
	}
}
