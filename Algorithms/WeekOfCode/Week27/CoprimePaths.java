package WeekOfCode.Week27;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CoprimePaths {
 
	public static boolean isNodeCoprime;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int verticies = in.nextInt();
		int queries = in.nextInt();
		
		long[] weights = new long[verticies];
		
		for(int v = 0; v < verticies; v++) {
			weights[v] = in.nextLong();
		}
		
		Graph g = new Graph(verticies, weights);
		
		for(int v = 0; v < verticies - 1; v++) {
			g.addEdge(in.nextInt() - 1, in.nextInt() - 1);
		}
		
		for(int q = 0; q < queries; q++) {
			BreadthFirstPaths bfs = new BreadthFirstPaths(g, in.nextInt() - 1);
			int coprimes = bfs.numberOfCoprimes(in.nextInt() - 1);
			System.out.println(coprimes);
		}
		
		in.close();
	}

	public static class CoprimeNode
	{
		public static boolean isCoprime(long a, long b) 
		{
			return gcd(a, b) == 1;
		}
		
		public static long gcd(long a, long b)
		{
			if(b == 0) return a;
			return gcd(b, a % b);
		}
	}
	
	public static class BreadthFirstPaths
	{
		private static final int INFINITY = Integer.MAX_VALUE;
	    private boolean[] marked;  // marked[v] = is there an s-v path
	    private int[] edgeTo;      // edgeTo[v] = previous edge on shortest s-v path
	    private int[] distTo;      // distTo[v] = number of edges shortest s-v path
	    //private int[] coprimeCount;
        private Graph G;
	    
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
	        //coprimeCount = new int[G.V()];
            this.G = G;
	        bfs(G, s);
	    }

	    // breadth-first search from a single source
	    private void bfs(Graph G, int s) {
	        Queue<Integer> q = new Queue<Integer>();
	        for (int v = 0; v < G.V(); v++)
	            distTo[v] = INFINITY;
	        distTo[s] = 0;
	        //coprimeCount[s] = 0;
	        marked[s] = true;
	        q.enqueue(s);

	        while (!q.isEmpty()) {
	            int v = q.dequeue();
	            for (int w : G.adj(v)) {
	                if (!marked[w]) {
	                    edgeTo[w] = v;
	                    distTo[w] = distTo[v] + 1;
	                    //int add = (isNodeCoprime) ? 1 : 0;
	                    //coprimeCount[w] = coprimeCount[v] + add;
	                    marked[w] = true;
	                    q.enqueue(w);
	                }
	            }
	        }
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
	    
	    public ArrayList<Integer> pathTo(int v) {
	        if (!hasPathTo(v)) return null;
	        ArrayList<Integer> path = new ArrayList<Integer>();
	        int x;
	        for (x = v; distTo[x] != 0; x = edgeTo[x])
	            path.add(x);
	        path.add(x);
	        return path;
	    }
	    
	    public int numberOfCoprimes(int v) {
            int coprimeCountSum = 0;
            ArrayList<Integer> pathTo = pathTo(v);
            
            for(int  i = 0; i < pathTo.size() - 1; i++) {
                for(int j = i + 1; j < pathTo.size(); j++) {
                    boolean coprime = CoprimeNode.isCoprime(G.weights[pathTo.get(i)], G.weights[pathTo.get(j)]);
                    if(coprime) coprimeCountSum += 1;
                }
            }
            
	    	return coprimeCountSum;
	    }
	}
	
	/**
	 * A class to hold a graph
	 * @author tmosest
	 *
	 */
	public static class Graph
	{	
		 private final int V; // # Vertices
		 private int E;	// # Edges
		 private Bag<Integer>[] adj; // The Adjacency Matrix
		 public long[] weights;
	
		 public Graph(int V) {
			 if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
		     this.V = V;
		     this.E = 0;
		     adj = (Bag<Integer>[]) new Bag[V];
		     for (int v = 0; v < V; v++) {
		    	 adj[v] = new Bag<Integer>();
		     }
		}
		 
		public Graph(int V, long[] values) {
			 if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
		     this.V = V;
		     this.E = 0;
		     adj = (Bag<Integer>[]) new Bag[V];
		     weights = new long[V];
		     for (int v = 0; v < V; v++) {
		    	 adj[v] = new Bag<Integer>();
		    	 weights[v] = values[v];
		     }
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
	        boolean coprime = false;//CoprimeNode.isCoprime(weights[v], weights[w]);
	        adj[v].add(w, coprime);
	        adj[w].add(v, coprime);
	    }
		
		public Iterable<Integer> adj(int v) {
	        //validateVertex(v);
	        return adj[v];
	    }
	}
	
	/**
	 * A class to hold items.
	 * @author tmosest
	 *
	 * @param <Item>
	 */
	public static class Bag<Item> implements Iterable<Item>
	{
		private Node<Item> first;    // beginning of bag
	    private int n;               // number of elements in bag

	    private class Node<Item> {
	        private Item item;
	        private Node<Item> next;
	        //public boolean isCoprime;
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
	    
	    public void add(Item item, boolean isCoprime)
	    {
	    	Node<Item> oldFirst = first;
	    	first = new Node<Item>();
	    	first.item = item;
	    	//first.isCoprime = isCoprime;
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
	            //isNodeCoprime = current.isCoprime;
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
