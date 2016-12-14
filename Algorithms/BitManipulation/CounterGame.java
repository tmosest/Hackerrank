package BitManipulation;

import java.util.Scanner;

/**
 *	Algorithms -> Bit Manipulation -> Counter game
 *	Medium
 */
public class CounterGame {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
        byte t= Byte.parseByte(s.nextLine());
        
        for(int j=1;j<=t;j++){
            Long n = Long.parseUnsignedLong(s.nextLine());
            String str=new String(Long.toBinaryString(n));
            char ch[]=str.toCharArray();
            int a=(Long.bitCount(n))-1;
			int count=0;
            for(int i=(ch.length)-1;ch[i]!='1';i--){
                count++;
            }
			int turn=a+count;
            if(turn%2==0){
                System.out.println("Richard");
            }else
                System.out.println("Louise");
        }
	}

}
