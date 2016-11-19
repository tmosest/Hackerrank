package Implementation;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 *	Algorithms -> Implementations -> Happy Ladybugs
 *	Easy
 */
public class HappyLadybugs {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); int Q = in.nextInt();
	    for(int a0 = 0; a0 < Q; a0++) {
	        int n = in.nextInt();
	        String b = in.next();
	        if(b.length()==1){
	            if(b.equals("_")){
	                System.out.println("YES"); 
	            }
	            else{
	                System.out.println("NO");
	            }                
	        }
	        else
	        {
	            HashMap<Character,Integer> map = new HashMap<>();
	            int underscores=0;
	            for(int i=0;i<b.length();i++){
	                char c = b.charAt(i);
	                if(c!='_'){
	                if(!map.containsKey(c))
	                    map.put(c, 1);
	                else
	                    map.put(c, map.get(c)+1);
	                }else underscores++;
	            }
	            boolean happybug = true;
	            if(underscores>0)
	            for(Entry e:map.entrySet()){
	                if(((int)e.getValue())==1){
	                    happybug=false;break;
	                }
	            }
	                else{
	                    for(int i=0;i<b.length();i++){
	                        char curr = b.charAt(i);
	                        boolean happy = false;
	                        if(i+1<b.length())
	                            happy = curr == b.charAt(i+1);
	                        if(!happy && i >0)
	                            happy = curr == b.charAt(i-1);
	                        if(!happy){
	                            happybug=false;
	                            break;
	                        }
	                    }
	                }
	                System.out.println(happybug?"YES":"NO");
	            }

	    }
		
		in.close();
	}

}
