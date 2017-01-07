package Facebook.HackerCup17;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * http://stackoverflow.com/questions/13652518/efficiently-find-points-inside-a-circle-sector
 * https://academo.org/demos/rotation-about-point/
 * https://www.caveofprogramming.com/java/java-file-reading-and-writing-files-in-java.html
 * http://www3.ntu.edu.sg/home/ehchua/programming/java/j5b_io.html
 * @author tmosest
 * 
		5
		0 55 55
		12 55 55
		13 55 55
		99 99 99
		87 20 40
 *
 */
public class ProgressPie {
	
	private static boolean debugMode = false;
	private static String inFileStr = "Facebook/HackerCup17/ProgressPieIn.txt";
    private static String outFileStr = "Facebook/HackerCup17/ProgressPieOut.txt";
    
	/*
	 * Make sure to shift all points to make (50,50) the origin
	 * 
	 */
	public static void main(String[] args) throws IOException
	{
		// FileReader reads text files in the default encoding.
        FileReader fileReader = 
            new FileReader(inFileStr);

        // Always wrap FileReader in BufferedReader.
        BufferedReader bufferedReader = 
            new BufferedReader(fileReader);
        
	     // Assume default encoding.
	        FileWriter fileWriter =
	            new FileWriter(outFileStr);

        // Always wrap FileWriter in BufferedWriter.
        BufferedWriter bufferedWriter =
            new BufferedWriter(fileWriter);
		
        int qs = Integer.valueOf(bufferedReader.readLine());
        
        for(int q = 1; q <= qs; q++) {
        	String[] line = bufferedReader.readLine().split(" ");
			int p = Integer.valueOf(line[0]);
			int x = Integer.valueOf(line[1]) - 50;
			int y = Integer.valueOf(line[2]) - 50;
			
			Vector v = new Vector(x, y);
			if(debugMode) 
				System.out.println("\nCreated new Vector: (" + x + ", " + y + ")");
			isInsideSector iis = new isInsideSector(p);
			
			String c = "Case #"+ q +": ";
			String color = (iis.isInside(v)) ? "black" : "white";
			
			bufferedWriter.write(c + color);
	        bufferedWriter.newLine();
			if(debugMode) 
				System.out.println("");
		}
        
        // Always close files.
        bufferedReader.close();
        bufferedWriter.close();
		/*
		Scanner in = new Scanner(System.in);
		
		int qs = in.nextInt();
		
		for(int q = 1; q <= qs; q++) {
			int p = in.nextInt();
			int x = in.nextInt() - 50;
			int y = in.nextInt() - 50;
			
			Vector v = new Vector(x, y);
			if(debugMode) 
				System.out.println("\nCreated new Vector: (" + x + ", " + y + ")");
			isInsideSector iis = new isInsideSector(p);
			
			String c = "Case #"+ q +": ";
			String color = (iis.isInside(v)) ? "black" : "white";
			
			System.out.println(c + color);
			if(debugMode) 
				System.out.println("");
		}
		
		in.close();
		*/
	}
	
	/*
	 * Going to shift this to (0,0) and have radius of 50.
	 */
	private static class isInsideSector
	{
		private Vector endArm, startArm;
		private double percent; 
		private int radiusSquared;
		
		public isInsideSector(int p)
		{
			this.percent = ((double) p) / 100;
			this.startArm = new Vector(0, 50);
			this.radiusSquared = 50 * 50;
			this.endArm = Vector.rotatedVector(startArm, this.percent * 360);
				
			if(debugMode) {
				System.out.println("Start Arm At (" + startArm.x + ", " + startArm.y + ")");
				System.out.println("End Arm At (" + endArm.x + ", " + endArm.y + ")");
				System.out.println("percent: " + this.percent);
				System.out.println("degrees: " + (this.percent * -360));
			}
		}
		
		public boolean isInside(Vector v)
		{
			if(debugMode) {
				System.out.println("CW from start arm: " + v.isCwTo(this.startArm));
				System.out.println("CCW from end arm: " + !v.isCwTo(this.endArm));
				System.out.println("within radius: " + v.isWithinRadius(radiusSquared));
			}
			return  !v.isCwTo(this.endArm) &&
					//v.isCwTo(this.startArm) &&
					v.isWithinRadius(radiusSquared);
		}
	}
	
	private static class Vector
	{
		int x;
		int y;
		
		public Vector(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
		
		public boolean isCwTo(Vector v)
		{
			return -v.x * this.y + v.y * this.x > 0;
			//return -this.x * v.y + this.y * v.x > 0;
		}
		
		public boolean isWithinRadius(int radiusSquared)
		{
			return this.x * this.x + this.y * this.y <= radiusSquared;
		}
		
		/* Rotate a Vector CCW */
		public static Vector rotatedVector(Vector v, double degrees)
		{
			double radians = Math.toRadians(degrees);
			if(debugMode) 
				System.out.println("radians: " + radians);
			int x = (int) (v.x * Math.cos(radians) + v.y * Math.sin(radians));
			int y = (int) (v.y * Math.cos(radians) + v.x * Math.sin(radians));
			return new Vector(x, y);
		}
	}
}
