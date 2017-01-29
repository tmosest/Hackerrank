package CodeWars;
/**
 * Can you get the loop ?
 * Floyd's cycle-finding algorithm
 * @author tmosest
 */
public class LoopInspector {

	private static final boolean debugMode = true;
	
	public int loopSize(Node node) {
		Node hare = node.getNext(), tortuse = node;
		// Main algo move hair twice as fast.
		while(tortuse != hare) {
			if(debugMode)
				System.out.println("Tortuse: " + tortuse + " hare: " + hare);
			tortuse = tortuse.getNext();
			hare = hare.getNext().getNext();
		}
		// Determine loop start position at mu
		int mu = 0;
		tortuse = node;
		while(tortuse != hare) {
			tortuse = tortuse.getNext();
			hare = hare.getNext();
			mu++;
		}
		// Find the length of the shortest cycle.
		int lam = 1;
		hare = tortuse.getNext();
		while(tortuse != hare) {
			hare = hare.getNext();
			lam++;
		}
		
		return lam;
	}

}
