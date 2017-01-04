package ProjectEuler;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Project Euler #18: Maximum path sum I 
 * Easy
 */
public class Problem18 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int qs = in.nextInt();
		for(int q = 0; q < qs; q++) {
			
			int n = in.nextInt();
			//System.out.println("n: " + n);
			int nodes = ((n) * (n + 1)) / 2;
			
			Graph G = new Graph(nodes);
			
			int node = 0;
			int parentNode = 0;
			for(int row = 0; row < n; row++) {
				for(int col = 0; col < row + 1; col++) {
					G.setWeight(node, in.nextInt());
					//System.out.println("node: " + node + " row: " + row + " col: " + col);
					if(col < row) {
						//System.out.println("node: " + node + " parent node: " + parentNode);
						G.addEdge(parentNode, node); 
						G.addEdge(parentNode, node + 1);
						parentNode++;
					}
					node++;
				}
			}
			
			BreadthFirstPaths bfs = new BreadthFirstPaths(G, 0);
			System.out.println(bfs.maxSum());
			
		}
		in.close();
	}

	public static class BreadthFirstPaths
	{
		private static final int INFINITY = Integer.MAX_VALUE;
	    private boolean[] marked;  // marked[v] = is there an s-v path
	    private int[] edgeTo;      // edgeTo[v] = previous edge on shortest s-v path
	    private int[] distTo;      // distTo[v] = number of edges shortest s-v path
	    
	    private long[] sums;
	    private long maxSum = 0; /* holder for the max sum of a path */
	    
	    /**
	     * Computes the shortest path between the source vertex {@code s}
	     * and every other vertex in the graph {@code G}.
	     * @param G the graph
	     * @param s the source vertex
	     * @throws IllegalArgumentException unless {@code 0 <= s < V}
	     */
	    public BreadthFirstPaths(Graph G, int s) {
	        marked = new boolean[G.V()];
	        distTo = new int[G.V()];
	        edgeTo = new int[G.V()];
	        sums = new long[G.V()];
	        //validateVertex(s);
	        bfs(G, s);

	        //assert check(G, s);
	    }

	    // breadth-first search from a single source
	    private void bfs(Graph G, int s) {
	        Queue<Integer> q = new Queue<Integer>();
	        for (int v = 0; v < G.V(); v++)
	            distTo[v] = INFINITY;
	        distTo[s] = 0;
	        marked[s] = true;
	        sums[s] = G.getWeight(s);
	        maxSum = sums[s];
	        q.enqueue(s);

	        while (!q.isEmpty()) {
	            int v = q.dequeue();
	            //System.out.println("v: " + v);
	            for (int w : G.adj(v)) {
	            	 //System.out.println("w: " + w);
	            	if(v < w && sums[w] < sums[v] + G.getWeight(w)) {
	                    sums[w] = sums[v] + G.getWeight(w);
	                    if(sums[w] > maxSum)
	                    	maxSum = sums[w];
	            	}
	            	//System.out.println("w: " + w + " sum["+ v +"]: " + sums[v] + " w: " +  G.getWeight(w));
	            	//System.out.println(" sum["+ w +"]: " + sums[w]);
	            	if (!marked[w]) {
	                    edgeTo[w] = v;
	                    distTo[w] = distTo[v] + 1;
	                    marked[w] = true;
	                    q.enqueue(w);
	                }
	            }
	        }
	    }
	    
	    public long maxSum() {
	    	return this.maxSum;
	    }
	    
	    /**
	     * Is there a path between the source vertex {@code s} (or sources) and vertex {@code v}?
	     * @param v the vertex
	     * @return {@code true} if there is a path, and {@code false} otherwise
	     * @throws IllegalArgumentException unless {@code 0 <= v < V}
	     */
	    public boolean hasPathTo(int v) {
	        //validateVertex(v);
	        return marked[v];
	    }
	    
	    /**
	     * Returns the number of edges in a shortest path between the source vertex {@code s}
	     * (or sources) and vertex {@code v}?
	     * @param v the vertex
	     * @return the number of edges in a shortest path
	     * @throws IllegalArgumentException unless {@code 0 <= v < V}
	     */
	    public int distTo(int v) {
	        //validateVertex(v);
	        return distTo[v];
	    }
	}

	public static class Graph
	{	
		 private final int V; // # Vertices
		 private int E;	// # Edges
		 private Bag<Integer>[] adj; // The Adjacency Matrix
		 
		 private int[] nodeWeights;
	
		 public Graph(int V) {
			 if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
		     this.V = V;
		     this.E = 0;
		     adj = (Bag<Integer>[]) new Bag[V];
		     for (int v = 0; v < V; v++) {
		    	 adj[v] = new Bag<Integer>();
		     }
		     nodeWeights = new int[V];
		}
		 
		public int V() {
			return V;
		}
		
		public int E() {
	        return E;
	    }
		
		public void addEdge(int v, int w) {
	        //validateVertex(v);
	        //validateVertex(w);
	        E++;
	        adj[v].add(w);
	        adj[w].add(v);
	    }
		
		public Iterable<Integer> adj(int v) {
	        //validateVertex(v);
	        return adj[v];
	    }
		
		public void setWeight(int node, int value)
		{
			nodeWeights[node] = value;
		}
		
		public int getWeight(int node) {
			return nodeWeights[node];
		}
	}
	
	public static class Bag<Item> implements Iterable<Item>
	{
		private Node<Item> first;    // beginning of bag
	    private int n;               // number of elements in bag

	    private class Node<Item> {
	        private Item item;
	        private Node<Item> next;
	    }

	    public Bag() {
	        first = null;
	        n = 0;
	    }
	    
	    public boolean isEmpty() {
	        return first == null;
	    }
	    
	    public int size() {
	        return n;
	    }
	    
	    public void add(Item item)
	    {
	    	Node<Item> oldFirst = first;
	    	first = new Node<Item>();
	    	first.item = item;
	    	first.next = oldFirst;
	    	n++;
	    }
	    
		@Override
		public Iterator<Item> iterator() {
			return new ListIterator<Item>(first);  
		}
		
		private class ListIterator<Item> implements Iterator<Item> {
	        private Node<Item> current;

	        public ListIterator(Node<Item> first) {
	            current = first;
	        }

	        public boolean hasNext()  { return current != null;                     }
	        public void remove()      { throw new UnsupportedOperationException();  }

	        public Item next() {
	            if (!hasNext()) throw new NoSuchElementException();
	            Item item = current.item;
	            current = current.next; 
	            return item;
	        }
	    }
	}
	
	public static class Queue<Item> implements Iterable<Item> {
	    private Node<Item> first;    // beginning of queue
	    private Node<Item> last;     // end of queue
	    private int n;               // number of elements on queue

	    // helper linked list class
	    private class Node<Item> {
	        private Item item;
	        private Node<Item> next;
	    }

	    /**
	     * Initializes an empty queue.
	     */
	    public Queue() {
	        first = null;
	        last  = null;
	        n = 0;
	    }

	    /**
	     * Returns true if this queue is empty.
	     *
	     * @return {@code true} if this queue is empty; {@code false} otherwise
	     */
	    public boolean isEmpty() {
	        return first == null;
	    }

	    /**
	     * Returns the number of items in this queue.
	     *
	     * @return the number of items in this queue
	     */
	    public int size() {
	        return n;
	    }

	    /**
	     * Returns the item least recently added to this queue.
	     *
	     * @return the item least recently added to this queue
	     * @throws NoSuchElementException if this queue is empty
	     */
	    public Item peek() {
	        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
	        return first.item;
	    }

	    /**
	     * Adds the item to this queue.
	     *
	     * @param  item the item to add
	     */
	    public void enqueue(Item item) {
	        Node<Item> oldlast = last;
	        last = new Node<Item>();
	        last.item = item;
	        last.next = null;
	        if (isEmpty()) first = last;
	        else           oldlast.next = last;
	        n++;
	    }

	    /**
	     * Removes and returns the item on this queue that was least recently added.
	     *
	     * @return the item on this queue that was least recently added
	     * @throws NoSuchElementException if this queue is empty
	     */
	    public Item dequeue() {
	        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
	        Item item = first.item;
	        first = first.next;
	        n--;
	        if (isEmpty()) last = null;   // to avoid loitering
	        return item;
	    }

	    /**
	     * Returns a string representation of this queue.
	     *
	     * @return the sequence of items in FIFO order, separated by spaces
	     */
	    public String toString() {
	        StringBuilder s = new StringBuilder();
	        for (Item item : this) {
	            s.append(item);
	            s.append(' ');
	        }
	        return s.toString();
	    } 

	    /**
	     * Returns an iterator that iterates over the items in this queue in FIFO order.
	     *
	     * @return an iterator that iterates over the items in this queue in FIFO order
	     */
	    public Iterator<Item> iterator()  {
	        return new ListIterator<Item>(first);  
	    }

	    // an iterator, doesn't implement remove() since it's optional
	    private class ListIterator<Item> implements Iterator<Item> {
	        private Node<Item> current;

	        public ListIterator(Node<Item> first) {
	            current = first;
	        }

	        public boolean hasNext()  { return current != null;                     }
	        public void remove()      { throw new UnsupportedOperationException();  }

	        public Item next() {
	            if (!hasNext()) throw new NoSuchElementException();
	            Item item = current.item;
	            current = current.next; 
	            return item;
	        }
	    }
	}
}
