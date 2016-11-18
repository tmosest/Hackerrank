package MathFundamentals;

import java.util.Scanner;

/**
 *	Mathematics -> Fundamentals -> Find the Point
 *	Easy
 */
public class FindThePoint {
	
	private static class Point 
	{
		public int x;
		public int y;
		
		public Point(int x, int y) 
		{
			this.x = x;
			this.y = y;
		}
		
		public void printPoint()
		{
			System.out.println(this.x + " " + this.y);
		}
		
		public static Point calculatePointReflection(Point p1, Point p2)
		{
			int dX = p2.x - p1.x;
			//System.out.println("dX " + dX);
			int dY = p2.y - p1.y;
			//System.out.println("dY " + dY);
			int pX = p2.x + dX;
			//System.out.println("pX " + pX);
			int pY = p2.y + dY;
			//System.out.println("pY " + pY);
			
			Point point = new Point(pX, pY);
			
			return point;
		}
	} //end class Point
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        
        for(int i = 0; i < testCases; i++) {
            
        	int x = in.nextInt();
            int y = in.nextInt();
            
            Point p1 = new Point(x, y);
            //p1.printPoint();
            
            x = in.nextInt();
            y = in.nextInt();
            
            Point p2 = new Point(x,y);
            //p2.printPoint();
            
            Point reflection = Point.calculatePointReflection(p1, p2);
            reflection.printPoint();
        }
        in.close();
	}

}
