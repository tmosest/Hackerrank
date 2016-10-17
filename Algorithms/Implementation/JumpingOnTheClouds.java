package Implementation;

import java.util.Scanner;

/**
 *	Algorithms -> Implementations -> Jumping on the Clouds
 *	Easy
 */
public class JumpingOnTheClouds {

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        in.close();
        int jumps = countJumps(c);
        System.out.println(jumps);
	}

	public static int countJumps(int[] c)
	{
		int jump = 0;
        int cloud_i = 0;
        int finalCloud = c.length - 1;
        while(cloud_i != finalCloud) {
        	if(cloud_i != finalCloud - 1 && c[cloud_i + 2] != 1) {
        		cloud_i += 2;
        	} else {
        		cloud_i++;
        	}
        	jump++;
        }
        return jump;
	}
}
