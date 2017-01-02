package HackerEarth;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Monk's Love for Food
 * Very Easy
 * @author tmosest
 *
 */
public class MonksLoveForFood {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		
		Scanner in = new Scanner(System.in);
		
		int qs = in.nextInt();
		
		for(int q = 0; q < qs; q++) {
			int n = in.nextInt();
			if(n == 2) {
				int cost = in.nextInt();
				stack.push(cost);
			} else {
				try {
					System.out.println(stack.pop());
				} catch (NoSuchElementException e) {
					System.out.println("No Food");
				}
			}
		}
		
		in.close();
	}

	public static class Stack<Item>
	{
		private Node<Item> first;     // top of stack
	    private int n;                // size of the stack

	    // helper linked list class
	    private static class Node<Item> {
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
	} // end stack
	
}
