package MathFundamentals;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *	Mathematics -> Fundamentals -> Possible Path
 *	Easy
 */
public class PossiblePath {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		for(int i = 0; i < numCases; i++) {
			
			int x = in.nextInt();
			int y = in.nextInt();
			Point p1 = new Point(x,y);
			
			x = in.nextInt();
			y = in.nextInt();
			Point p2 = new Point(x,y);
			
			String result = "NO";
			
			if(p1.canReachAnotherPoint(p2)) {
				result = "YES";
			}
			
			System.out.println(result);
		}
		
		in.close();
	}
	
	//Start Point
	private static class Point 
	{
		public int x;
		public int y;
		
		public Point(int x, int y) 
		{
			this.x = x;
			this.y = y;
		}
		
		public int calculateGCDofCordinates()
		{
			BigInteger b1 = BigInteger.valueOf(this.x);
		    BigInteger b2 = BigInteger.valueOf(this.y);
		    BigInteger gcd = b1.gcd(b2);
		    return gcd.intValue();
		}
		
		/*
		 * Adam is standing at point (a,b) in an infinite 2D grid. He wants to know if he can reach point (x,y) or not. 
		 * The only operation he can do is to move to point (a+b,b), (a,a+b), (a-b,b), or (a,a-b) from some point (a,b). 
		 * It is given that he can move to any point on this 2D grid,i.e., the points having positive or negative X(or Y) co-ordinates.
		 */
		public boolean canReachAnotherPoint(Point pointToReach)
		{
			boolean canReach = false;
			
			int gcd1 = this.calculateGCDofCordinates();
			int gcd2 = pointToReach.calculateGCDofCordinates();
			
			if(gcd1 == gcd2) {
				canReach = true;
			}
			
			return canReach;
		}
		
		public void printPoint()
		{
			System.out.println(this.x + " " + this.y);
		}
		
		public static boolean canReadPointWithoutDiagnolMoves(Point p1, Point p2)
		{
			
			return false;
		}
		
		public static Point calculatePointReflection(Point p1, Point p2)
		{
			int dX = p2.x - p1.x;
			int dY = p2.y - p1.y;
			int pX = p2.x + dX;
			int pY = p2.y + dY;
			
			Point point = new Point(pX, pY);
			
			return point;
		}
		
	} //end class Point
}
