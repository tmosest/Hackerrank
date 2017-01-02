package HackerEarth;

import java.util.Scanner;

/**
 * Roy and Profile Picture
 * Very-Easy
 * @author tmosest
 *
 */
public class RoyAndProfilePicture {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int qs = in.nextInt();
		for(int q = 0; q < qs; q++)
			System.out.println(photoTask(in.nextInt(), in.nextInt(), n));
		in.close();
	}

	public static String photoTask(int width, int height, int n)
	{
		String res = "";
		if(height < n || width < n) {
			res = "UPLOAD ANOTHER";
		} else if(height != width) {
			res = "CROP IT";
		} else {
			res = "ACCEPTED";
		}
		return res;
	}
}
