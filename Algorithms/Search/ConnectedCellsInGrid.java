package Search;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *	Algorithms -> Search -> Connected Cells in a Grid
 *	Medium
 *
 * Sample Input:
    4
	4
	1 1 0 0
	0 1 1 0
	0 0 1 0
	1 0 0 0
 *
 * Sample Output:
    5
 */
public class ConnectedCellsInGrid {
	
	private static final String NEWLINE = System.getProperty("line.separator");
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int rows = in.nextInt();
		int columns = in.nextInt();
		
		int[][] grid = new int[rows][columns];
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				grid[i][j] = in.nextInt();
			}
		}
		
		in.close();
		
		Graph graph = new Graph(rows * columns);
		
		/*
		 * if converted to 1D then rows * columns size
		 * rows * i + columns
		 * 0 1 2
		 * 3 4 5
		 * 6 7 8
		 */
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				if(grid[i][j] == 1) {
					int fromNode = i * columns + j;
					
					boolean topClear = i - 1 > 0;
					boolean bottomClear = i + 1 < rows;
					boolean leftClear = j - 1 > 0;
					boolean rightClear = j + 1 < columns;
					
					if(leftClear) {
						if(grid[i][j - 1] == 1) {
							int endNode = i * columns + j - 1;
							graph.addEdge(fromNode, endNode);
						}
					}
					if(rightClear) {
						if(grid[i][j + 1] == 1) {
							int endNode = i * columns + j + 1;
							graph.addEdge(fromNode, endNode);
						}
					}
					if(bottomClear) {
						if(grid[i + 1][j] == 1) {
							int endNode = (i + 1) * columns + j;
							//System.out.println("i: " + i + " j: " + j + " end: " + endNode);
							graph.addEdge(fromNode, endNode);
						}
					}
					if(topClear) {
						if(grid[i - 1][j] == 1) {
							int endNode = (i - 1) * columns + j;
							graph.addEdge(fromNode, endNode);
						}
					}
					if(leftClear && topClear) {
						if(grid[i - 1][j - 1] == 1) {
							int endNode = (i - 1) * columns + j - 1;
							graph.addEdge(fromNode, endNode);
						}
					}
					if(rightClear && topClear) {
						if(grid[i - 1][j + 1] == 1) {
							int endNode = (i - 1) * columns + j + 1;
							graph.addEdge(fromNode, endNode);
						}
					}
					if(leftClear && bottomClear) {
						if(grid[i + 1][j - 1] == 1) {
							int endNode = (i + 1) * columns + j - 1;
							graph.addEdge(fromNode, endNode);
						}
					}
					if(rightClear && bottomClear) {
						if(grid[i + 1][j + 1] == 1) {
							int endNode = (i + 1) * columns + j + 1;
							graph.addEdge(fromNode, endNode);
						}
					}
				} // end if i,j = 1
			} // end for j
		} // end for i
		
		//String graphString = graph.toString();
		//System.out.println(graphString);
		
		int count = 0;
		for(int i = 0; i < rows * columns - 1; i++) {
			DepthFirstSearch dfs = new DepthFirstSearch(graph, i);
			if( dfs.count() > count ) {
				count = dfs.count();
			}
		}
		
		System.out.println(count);
		
	} // end main
	
	private static class DepthFirstSearch 
	{
		private boolean[] marked;    // marked[v] = is there an s-v path?
	    private int count;           // number of vertices connected to s

	    /**
	     * Computes the vertices in graph {@code G} that are
	     * connected to the source vertex {@code s}.
	     * @param G the graph
	     * @param s the source vertex
	     */
	    public DepthFirstSearch(Graph G, int s) {
	        marked = new boolean[G.V()];
	        dfs(G, s);
	    }

	    // depth first search from v
	    private void dfs(Graph G, int v) {
	        count++;
	        marked[v] = true;
	        for (int w : G.adj(v)) {
	            if (!marked[w]) {
	                dfs(G, w);
	            }
	        }
	    }

	    /**
	     * Is there a path between the source vertex {@code s} and vertex {@code v}?
	     * @param v the vertex
	     * @return {@code true} if there is a path, {@code false} otherwise
	     */
	    public boolean marked(int v) {
	        return marked[v];
	    }

	    /**
	     * Returns the number of vertices connected to the source vertex {@code s}.
	     * @return the number of vertices connected to the source vertex {@code s}
	     */
	    public int count() {
	        return count;
	    }
	    
	} // end DepthFirstSearch
	
	private static class Graph 
	{
		private final int V;
	    private int E;
	    private Bag<Integer>[] adj;
	    
	    /**
	     * Initializes an empty graph with {@code V} vertices and 0 edges.
	     * param V the number of vertices
	     *
	     * @param  V number of vertices
	     * @throws IllegalArgumentException if {@code V < 0}
	     */
	    public Graph(int V) {
	        if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
	        this.V = V;
	        this.E = 0;
	        adj = (Bag<Integer>[]) new Bag[V];
	        for (int v = 0; v < V; v++) {
	            adj[v] = new Bag<Integer>();
	        }
	    }
	    
	    /**
	     * Returns the number of vertices in this graph.
	     *
	     * @return the number of vertices in this graph
	     */
	    public int V() {
	        return V;
	    }

	    /**
	     * Returns the number of edges in this graph.
	     *
	     * @return the number of edges in this graph
	     */
	    public int E() {
	        return E;
	    }
	    
	    // throw an IndexOutOfBoundsException unless {@code 0 <= v < V}
	    private void validateVertex(int v) {
	        if (v < 0 || v >= V)
	            throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V-1));
	    }
	    
	    /**
	     * Adds the undirected edge v-w to this graph.
	     *
	     * @param  v one vertex in the edge
	     * @param  w the other vertex in the edge
	     * @throws IndexOutOfBoundsException unless both {@code 0 <= v < V} and {@code 0 <= w < V}
	     */
	    public void addEdge(int v, int w) {
	        validateVertex(v);
	        validateVertex(w);
	        E++;
	        adj[v].add(w);
	        adj[w].add(v);
	    }


	    /**
	     * Returns the vertices adjacent to vertex {@code v}.
	     *
	     * @param  v the vertex
	     * @return the vertices adjacent to vertex {@code v}, as an iterable
	     * @throws IndexOutOfBoundsException unless {@code 0 <= v < V}
	     */
	    public Iterable<Integer> adj(int v) {
	        validateVertex(v);
	        return adj[v];
	    }

	    /**
	     * Returns the degree of vertex {@code v}.
	     *
	     * @param  v the vertex
	     * @return the degree of vertex {@code v}
	     * @throws IndexOutOfBoundsException unless {@code 0 <= v < V}
	     */
	    public int degree(int v) {
	        validateVertex(v);
	        return adj[v].size();
	    }


	    /**
	     * Returns a string representation of this graph.
	     *
	     * @return the number of vertices <em>V</em>, followed by the number of edges <em>E</em>,
	     *         followed by the <em>V</em> adjacency lists
	     */
	    public String toString() {
	        StringBuilder s = new StringBuilder();
	        s.append(V + " vertices, " + E + " edges " + NEWLINE);
	        for (int v = 0; v < V; v++) {
	            s.append(v + ": ");
	            for (int w : adj[v]) {
	                s.append(w + " ");
	            }
	            s.append(NEWLINE);
	        }
	        return s.toString();
	    }
	    
	} // end Graph
	
	private static class Bag<Item> implements Iterable<Item> 
	{
		private Node<Item> first;    // beginning of bag
	    private int n;               // number of elements in bag

	    // helper linked list class
	    private class Node<Item> {
	        private Item item;
	        private Node<Item> next;
	    }

	    /**
	     * Initializes an empty bag.
	     */
	    public Bag() {
	        first = null;
	        n = 0;
	    }

	    /**
	     * Returns true if this bag is empty.
	     *
	     * @return {@code true} if this bag is empty;
	     *         {@code false} otherwise
	     */
	    public boolean isEmpty() {
	        return first == null;
	    }

	    /**
	     * Returns the number of items in this bag.
	     *
	     * @return the number of items in this bag
	     */
	    public int size() {
	        return n;
	    }

	    /**
	     * Adds the item to this bag.
	     *
	     * @param  item the item to add to this bag
	     */
	    public void add(Item item) {
	        Node<Item> oldfirst = first;
	        first = new Node<Item>();
	        first.item = item;
	        first.next = oldfirst;
	        n++;
	    }


	    /**
	     * Returns an iterator that iterates over the items in this bag in arbitrary order.
	     *
	     * @return an iterator that iterates over the items in this bag in arbitrary order
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
	    
	} //end Bag
	
} // end ConnectedCellsInGrid
