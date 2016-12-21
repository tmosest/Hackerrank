package GraphTheory;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *	Algorithms -> Graph Theory -> Breadth First Search: Shortest Reach
 *	Medium
 */
public class BreadthFirstSearchShortestReach {

	static int edgeLength = 6;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int cases = in.nextInt();
		
		for(int c = 0; c < cases; c++) {
			int nodes = in.nextInt();
			int edges = in.nextInt();
			
			Graph g = new Graph(nodes);
			
			for(int e = 0; e < edges; e++) {
				int node1 = in.nextInt() - 1;
				int node2 = in.nextInt() - 1;
				g.addEdge(node1, node2);
			}
			
			int root = in.nextInt() - 1;
			BreadthFirstPaths bfps = new BreadthFirstPaths(g, root);
			
			for(int i = 0; i < nodes; i++) {
				if(i != root) {
					if(bfps.hasPathTo(i)) {
						System.out.print(bfps.distTo(i) * edgeLength + " ");
					} else {
						System.out.print(-1 + " ");
					}
				}
			}
			System.out.println("");
		}
		
		in.close();
	}
	
	public static class BreadthFirstPaths
	{
		private static final int INFINITY = Integer.MAX_VALUE;
	    private boolean[] marked;  // marked[v] = is there an s-v path
	    private int[] edgeTo;      // edgeTo[v] = previous edge on shortest s-v path
	    private int[] distTo;      // distTo[v] = number of edges shortest s-v path
	    
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
	        q.enqueue(s);

	        while (!q.isEmpty()) {
	            int v = q.dequeue();
	            for (int w : G.adj(v)) {
	                if (!marked[w]) {
	                    edgeTo[w] = v;
	                    distTo[w] = distTo[v] + 1;
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
	}

	public static class Graph
	{	
		 private final int V; // # Vertices
		 private int E;	// # Edges
		 private Bag<Integer>[] adj; // The Adjacency Matrix
	
		 public Graph(int V) {
			 if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
		     this.V = V;
		     this.E = 0;
		     adj = (Bag<Integer>[]) new Bag[V];
		     for (int v = 0; v < V; v++) {
		    	 adj[v] = new Bag<Integer>();
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
	        adj[v].add(w);
	        adj[w].add(v);
	    }
		
		public Iterable<Integer> adj(int v) {
	        //validateVertex(v);
	        return adj[v];
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
