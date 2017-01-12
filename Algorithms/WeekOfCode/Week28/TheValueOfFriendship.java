package WeekOfCode.Week28;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *	Algorithms -> Week of Code 28 -> The Value of Friendship
 *	Hard
 */
public class TheValueOfFriendship {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int qs = in.nextInt();
		
		for(int q = 0; q < qs; q++) {
			int n = in.nextInt();
			int m = in.nextInt();
			
			Graph g = new Graph(n);
			
			for(int e = 0; e < m; e++) {
				int node1 = in.nextInt() - 1; 
				int node2 = in.nextInt() - 1;
				g.addEdge(node1, node2);
			}
		}
		
		in.close();
	}

	/**
	 * Graph Class
	 * @author tmosest
	 *
	 */
	public static class Graph
	{	
		 private final int V; // # Vertices
		 private int E;	// # Edges
		 private Bag<Integer>[] adj; // The Adjacency Matrix
		 public int[][] weights;
	
		 public Graph(int V) {
			 if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
		     this.V = V;
		     this.E = 0;
		     adj = (Bag<Integer>[]) new Bag[V];
		     for (int v = 0; v < V; v++) {
		    	 adj[v] = new Bag<Integer>();
		     }
		}
		 
		public Graph(int V, int[] values) {
			 if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
		     this.V = V;
		     this.E = 0;
		     adj = (Bag<Integer>[]) new Bag[V];
		     weights = new int[V][3];
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
	        E++;
	        boolean coprime = false;//CoprimeNode.isCoprime(weights[v], weights[w]);
	        adj[v].add(w, coprime);
	        adj[w].add(v, coprime);
	    }
		
		public Iterable<Integer> adj(int v) {
	        return adj[v];
	    }
	}
	
	/**
	 * Bag Class
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
	
	/**
	 * Queue Class
	 * @author tmosest
	 *
	 * @param <Item>
	 */
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
	
	/**
	 * Stack Class
	 * @author tmosest
	 *
	 * @param <Item>
	 */
	public class Stack<Item> implements Iterable<Item> {
	    private Node<Item> first;     // top of stack
	    private int n;                // size of the stack

	    // helper linked list class
	    private class Node<Item> {
	        private Item item;
	        private Node<Item> next;
	    }

	    /**
	     * Initializes an empty stack.
	     */
	    public Stack() {
	        first = null;
	        n = 0;
	    }

	    /**
	     * Returns true if this stack is empty.
	     *
	     * @return true if this stack is empty; false otherwise
	     */
	    public boolean isEmpty() {
	        return first == null;
	    }

	    /**
	     * Returns the number of items in this stack.
	     *
	     * @return the number of items in this stack
	     */
	    public int size() {
	        return n;
	    }

	    /**
	     * Adds the item to this stack.
	     *
	     * @param  item the item to add
	     */
	    public void push(Item item) {
	        Node<Item> oldfirst = first;
	        first = new Node<Item>();
	        first.item = item;
	        first.next = oldfirst;
	        n++;
	    }

	    /**
	     * Removes and returns the item most recently added to this stack.
	     *
	     * @return the item most recently added
	     * @throws NoSuchElementException if this stack is empty
	     */
	    public Item pop() {
	        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
	        Item item = first.item;        // save item to return
	        first = first.next;            // delete first node
	        n--;
	        return item;                   // return the saved item
	    }


	    /**
	     * Returns (but does not remove) the item most recently added to this stack.
	     *
	     * @return the item most recently added to this stack
	     * @throws NoSuchElementException if this stack is empty
	     */
	    public Item peek() {
	        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
	        return first.item;
	    }

	    /**
	     * Returns a string representation of this stack.
	     *
	     * @return the sequence of items in this stack in LIFO order, separated by spaces
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
	     * Returns an iterator to this stack that iterates through the items in LIFO order.
	     *
	     * @return an iterator to this stack that iterates through the items in LIFO order
	     */
	    public Iterator<Item> iterator() {
	        return new ListIterator<Item>(first);
	    }

	    // an iterator, doesn't implement remove() since it's optional
	    private class ListIterator<Item> implements Iterator<Item> {
	        private Node<Item> current;

	        public ListIterator(Node<Item> first) {
	            current = first;
	        }

	        public boolean hasNext() {
	            return current != null;
	        }

	        public void remove() {
	            throw new UnsupportedOperationException();
	        }

	        public Item next() {
	            if (!hasNext()) throw new NoSuchElementException();
	            Item item = current.item;
	            current = current.next; 
	            return item;
	        }
	    }
	}
}
