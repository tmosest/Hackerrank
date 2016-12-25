package WeekOfCode.Week27;

import java.lang.invoke.MethodHandles.Lookup;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * http://www.cas.mcmaster.ca/~bill/best/algorithms/11MinUnique.pdf
 * @author tmoses
 *
 */

public class HowManySubstrings {
	
	public static void main(String[] args) {
		
		IntervalST<Integer> lookupInterval = new IntervalST<Integer>();
		
		Scanner in = new Scanner(System.in);
		
		int size = in.nextInt();
		int qs = in.nextInt();
		
		String s = in.next();
		
		for(int q = 0; q < qs; q++) {
			int left = in.nextInt();
			int right = in.nextInt();
			
			Interval1D oneD = new Interval1D(left, right);
			
			int count;
			if(lookupInterval.contains(oneD)) {
				count = lookupInterval.get(oneD);
				System.out.println("Used Lookup");
			} else {
				String sub = s.substring(left, right + 1);
				count = numberOfDistinctSubstring(sub);
				lookupInterval.put(oneD, count);
			}
			
			System.out.println(count);
		}
		
		in.close();
	}

	public static int numberOfDistinctSubstring(String input)
	{
		SuffixArrayX suffixArray = new SuffixArrayX(input);
		int indexCount = 0;
		for(int s_i = 0; s_i < 1; s_i++) {
			String suffix = suffixArray.select(s_i);
			//System.out.println(suffix);
			indexCount += suffix.length();
		}
		for(int s_i = 1; s_i < input.length(); s_i++) {
			String suffix = suffixArray.select(s_i);
			//System.out.println(suffix);
			int lcp = suffixArray.lcp(s_i);
			indexCount += suffix.length() - lcp;
			/*for(int i = lcp + 1; i < suffix.length() + 1; i++) {
				String subStr = suffix.substring(0, i);
				System.out.println(subStr);
				indexCount++;
			}*/
		}
		return indexCount;
	}
	
	// start suffix array code
		private static class SuffixArrayX
		{
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
		// end suffix array code
		
		public static class IntervalST<Value>  {

		    private Node root;   // root of the BST

		    // BST helper node data type
		    private class Node {
		        Interval1D interval;      // key
		        Value value;              // associated data
		        Node left, right;         // left and right subtrees
		        int N;                    // size of subtree rooted at this node
		        int max;                  // max endpoint in subtree rooted at this node

		        Node(Interval1D interval, Value value) {
		            this.interval = interval;
		            this.value    = value;
		            this.N        = 1;
		            this.max      = interval.max;
		        }
		    }


		   /***************************************************************************
		    *  BST search
		    ***************************************************************************/

		    public boolean contains(Interval1D interval) {
		        return (get(interval) != null);
		    }

		    // return value associated with the given key
		    // if no such value, return null
		    public Value get(Interval1D interval) {
		        return get(root, interval);
		    }

		    private Value get(Node x, Interval1D interval) {
		        if (x == null)                  return null;
		        int cmp = interval.compareTo(x.interval);
		        if      (cmp < 0) return get(x.left, interval);
		        else if (cmp > 0) return get(x.right, interval);
		        else              return x.value;
		    }


		   /***************************************************************************
		    *  randomized insertion
		    ***************************************************************************/
		   
		    public void put(Interval1D interval, Value value) {
		        if (contains(interval)) { remove(interval);  }
		        root = randomizedInsert(root, interval, value);
		    }

		    // make new node the root with uniform probability
		    private Node randomizedInsert(Node x, Interval1D interval, Value value) {
		        if (x == null) return new Node(interval, value);
		        if (Math.random() * size(x) < 1.0) return rootInsert(x, interval, value);
		        int cmp = interval.compareTo(x.interval);
		        if (cmp < 0)  x.left  = randomizedInsert(x.left,  interval, value);
		        else          x.right = randomizedInsert(x.right, interval, value);
		        fix(x);
		        return x;
		    }

		    private Node rootInsert(Node x, Interval1D interval, Value value) {
		        if (x == null) return new Node(interval, value);
		        int cmp = interval.compareTo(x.interval);
		        if (cmp < 0) { x.left  = rootInsert(x.left,  interval, value); x = rotR(x); }
		        else         { x.right = rootInsert(x.right, interval, value); x = rotL(x); }
		        return x;
		    }


		   /***************************************************************************
		    *  deletion
		    ***************************************************************************/
		    private Node joinLR(Node a, Node b) { 
		        if (a == null) return b;
		        if (b == null) return a;

		        if (Math.random() * (size(a) + size(b)) < size(a))  {
		            a.right = joinLR(a.right, b);
		            fix(a);
		            return a;
		        }
		        else {
		            b.left = joinLR(a, b.left);
		            fix(b);
		            return b;
		        }
		    }

		    // remove and return value associated with given interval;
		    // if no such interval exists return null
		    public Value remove(Interval1D interval) {
		        Value value = get(interval);
		        root = remove(root, interval);
		        return value;
		    }

		    private Node remove(Node h, Interval1D interval) {
		        if (h == null) return null;
		        int cmp = interval.compareTo(h.interval);
		        if      (cmp < 0) h.left  = remove(h.left,  interval);
		        else if (cmp > 0) h.right = remove(h.right, interval);
		        else              h = joinLR(h.left, h.right);
		        fix(h);
		        return h;
		    }


		   /***************************************************************************
		    *  Interval searching
		    ***************************************************************************/

		    // return an interval in data structure that intersects the given inteval;
		    // return null if no such interval exists
		    // running time is proportional to log N
		    public Interval1D search(Interval1D interval) {
		        return search(root, interval);
		    }

		    // look in subtree rooted at x
		    public Interval1D search(Node x, Interval1D interval) {
		        while (x != null) {
		            if (interval.intersects(x.interval)) return x.interval;
		            else if (x.left == null)             x = x.right;
		            else if (x.left.max < interval.min)  x = x.right;
		            else                                 x = x.left;
		        }
		        return null;
		    }


		    // return *all* intervals in data structure that intersect the given interval
		    // running time is proportional to R log N, where R is the number of intersections
		    public Iterable<Interval1D> searchAll(Interval1D interval) {
		        LinkedList<Interval1D> list = new LinkedList<Interval1D>();
		        searchAll(root, interval, list);
		        return list;
		    }

		    // look in subtree rooted at x
		    public boolean searchAll(Node x, Interval1D interval, LinkedList<Interval1D> list) {
		         boolean found1 = false;
		         boolean found2 = false;
		         boolean found3 = false;
		         if (x == null)
		            return false;
		        if (interval.intersects(x.interval)) {
		            list.add(x.interval);
		            found1 = true;
		        }
		        if (x.left != null && x.left.max >= interval.min)
		            found2 = searchAll(x.left, interval, list);
		        if (found2 || x.left == null || x.left.max < interval.min)
		            found3 = searchAll(x.right, interval, list);
		        return found1 || found2 || found3;
		    }


		   /***************************************************************************
		    *  useful binary tree functions
		    ***************************************************************************/

		    // return number of nodes in subtree rooted at x
		    public int size() { return size(root); }
		    private int size(Node x) { 
		        if (x == null) return 0;
		        else           return x.N;
		    }

		    // height of tree (empty tree height = 0)
		    public int height() { return height(root); }
		    private int height(Node x) {
		        if (x == null) return 0;
		        return 1 + Math.max(height(x.left), height(x.right));
		    }


		   /***************************************************************************
		    *  helper BST functions
		    ***************************************************************************/

		    // fix auxilliar information (subtree count and max fields)
		    private void fix(Node x) {
		        if (x == null) return;
		        x.N = 1 + size(x.left) + size(x.right);
		        x.max = max3(x.interval.max, max(x.left), max(x.right));
		    }

		    private int max(Node x) {
		        if (x == null) return Integer.MIN_VALUE;
		        return x.max;
		    }

		    // precondition: a is not null
		    private int max3(int a, int b, int c) {
		        return Math.max(a, Math.max(b, c));
		    }

		    // right rotate
		    private Node rotR(Node h) {
		        Node x = h.left;
		        h.left = x.right;
		        x.right = h;
		        fix(h);
		        fix(x);
		        return x;
		    }

		    // left rotate
		    private Node rotL(Node h) {
		        Node x = h.right;
		        h.right = x.left;
		        x.left = h;
		        fix(h);
		        fix(x);
		        return x;
		    }

		}
		
		public static class Interval1D {

		    /**
		     * Compares two intervals by min endpoint.
		     */
		    public static final Comparator<Interval1D> MIN_ENDPOINT_ORDER  = new MinEndpointComparator();

		    /**
		     * Compares two intervals by max endpoint.
		     */
		    public static final Comparator<Interval1D> MAX_ENDPOINT_ORDER = new MaxEndpointComparator();

		    /**
		     * Compares two intervals by length.
		     */
		    public static final Comparator<Interval1D> LENGTH_ORDER = new LengthComparator();

		    private final int min;
		    private final int max;

		    /**
		     * Initializes a closed interval [min, max].
		     *
		     * @param  min the smaller endpoint
		     * @param  max the larger endpoint
		     * @throws IllegalArgumentException if the min endpoint is greater than the max endpoint
		     * @throws IllegalArgumentException if either {@code min} or {@code max}
		     *         is {@code Double.NaN}, {@code Double.POSITIVE_INFINITY} or
		     *         {@code Double.NEGATIVE_INFINITY}

		     */
		    public Interval1D(int min, int max) {
		        if (Double.isInfinite(min) || Double.isInfinite(max))
		            throw new IllegalArgumentException("Endpoints must be finite");
		        if (Double.isNaN(min) || Double.isNaN(max))
		            throw new IllegalArgumentException("Endpoints cannot be NaN");

		        // convert -0.0 to +0.0
		        if (min == 0.0) min = 0;
		        if (max == 0.0) max = 0;

		        if (min <= max) {
		            this.min = min;
		            this.max = max;
		        }
		        else throw new IllegalArgumentException("Illegal interval");
		    }

			/**
		     * Returns the left endpoint of this interval.
		     *
		     * @return the left endpoint of this interval
		     * @deprecated Replaced by {@link #min()}.
		     */
		    @Deprecated
		    public int left() { 
		        return min;
		    }

		    /**
		     * Returns the right endpoint of this interval.
		     * @return the right endpoint of this interval
		     * @deprecated Replaced by {@link #max()}.
		     */
		    @Deprecated
		    public int right() { 
		        return max;
		    }

		    /**
		     * Returns the min endpoint of this interval.
		     *
		     * @return the min endpoint of this interval
		     */
		    public int min() { 
		        return min;
		    }

		    /**
		     * Returns the max endpoint of this interval.
		     *
		     * @return the max endpoint of this interval
		     */
		    public int max() { 
		        return max;
		    }

		    /**
		     * Returns true if this interval intersects the specified interval.
		     *
		     * @param  that the other interval
		     * @return {@code true} if this interval intersects the argument interval;
		     *         {@code false} otherwise
		     */
		    public boolean intersects(Interval1D that) {
		        if (this.max < that.min) return false;
		        if (that.max < this.min) return false;
		        return true;
		    }

		    public int compareTo(Interval1D that) {
		        if      (this.min  < that.min)  return -1;
		        else if (this.min  > that.min)  return +1;
		        else if (this.max < that.max) return -1;
		        else if (this.max > that.max) return +1;
		        else                            return  0;
		    }
		    	
		    /**
		     * Returns true if this interval contains the specified value.
		     *
		     * @param x the value
		     * @return {@code true} if this interval contains the value {@code x};
		     *         {@code false} otherwise
		     */
		    public boolean contains(int x) {
		        return (min <= x) && (x <= max);
		    }

		    /**
		     * Returns the length of this interval.
		     *
		     * @return the length of this interval (max - min)
		     */
		    public int length() {
		        return max - min;
		    }

		    /**
		     * Returns a string representation of this interval.
		     *
		     * @return a string representation of this interval in the form [min, max]
		     */
		    public String toString() {
		        return "[" + min + ", " + max + "]";
		    }

		    /**
		     * Compares this transaction to the specified object.
		     *
		     * @param  other the other interval
		     * @return {@code true} if this interval equals the other interval;
		     *         {@code false} otherwise
		     */
		    public boolean equals(Object other) {
		        if (other == this) return true;
		        if (other == null) return false;
		        if (other.getClass() != this.getClass()) return false;
		        Interval1D that = (Interval1D) other;
		        return this.min == that.min && this.max == that.max;
		    }

		    /**
		     * Returns an integer hash code for this interval.
		     *
		     * @return an integer hash code for this interval
		     */
		    public int hashCode() {
		        int hash1 = ((Integer) min).hashCode();
		        int hash2 = ((Integer) max).hashCode();
		        return 31*hash1 + hash2;
		    }

		    // ascending order of min endpoint, breaking ties by max endpoint
		    private static class MinEndpointComparator implements Comparator<Interval1D> {
		        public int compare(Interval1D a, Interval1D b) {
		            if      (a.min < b.min) return -1;
		            else if (a.min > b.min) return +1;
		            else if (a.max < b.max) return -1;
		            else if (a.max > b.max) return +1;
		            else                    return  0;
		        }
		    }

		    // ascending order of max endpoint, breaking ties by min endpoint
		    private static class MaxEndpointComparator implements Comparator<Interval1D> {
		        public int compare(Interval1D a, Interval1D b) {
		            if      (a.min < b.max) return -1;
		            else if (a.min > b.max) return +1;
		            else if (a.min < b.min) return -1;
		            else if (a.min > b.min) return +1;
		            else                    return  0;
		        }
		    }

		    // ascending order of length
		    private static class LengthComparator implements Comparator<Interval1D> {
		        public int compare(Interval1D a, Interval1D b) {
		            double alen = a.length();
		            double blen = b.length();
		            if      (alen < blen) return -1;
		            else if (alen > blen) return +1;
		            else                  return  0;
		        }
		    }
		}

}
