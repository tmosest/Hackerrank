package Implementation;

import java.util.Scanner;

/**
 *	Algorithms -> Implementations -> Append and Delete
 *	Easy
 */
public class AppendAndDelete {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
        String t = in.next();
        
        int k = in.nextInt();
        int i = 0;
        
        for(; i <s.length() && i < t.length(); i++) {
          if(s.charAt(i) != t.charAt(i)) {
        	  break;
          }
        }
        
        in.close();
        
        int d = s.length() - i;
        int a = t.length() - i;
        
        int  p= k - d - a;
        if(p == 0) {
          System.out.println("Yes");
        } else if(p < 0) {
          System.out.println("No");
        } else {
          if(p%2 == 0) {
            System.out.println("Yes");
          } else {
            if(p >= (2*i)) {
            	System.out.println("Yes");
            	
            } else {
            	System.out.println("No");
            }
              
          }
        }
	}

}
