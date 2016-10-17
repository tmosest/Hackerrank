package Implementation;

import java.util.Scanner;

/**
 *	Algorithms -> Implementations -> Save the Prisoner!
 *	Easy
 */
public class SaveThePrisoner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        long t=sc.nextLong();
        for(int i=0;i<t;i++){
            long noOfprisoner=sc.nextLong();
            long noOfSweet=sc.nextLong();
            long startId=sc.nextLong();

            long result=(startId+noOfSweet-1)% noOfprisoner;    

                if(result ==0){
                    System.out.println(noOfprisoner);
                } else {
                    System.out.println(result);
                }
        }
        sc.close();
	}

}
