package Implementation;

import java.util.Scanner;

/**
 *	Algorithms -> Implementations -> Absolute Permutation
 *	Medium
 */
public class AbsolutePermutation {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int a[];
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            a= new int[n];
            boolean flag=false;
            for(int i=1;i<=n;i++){
                int temp;
                if(i<=k)
                    temp=i+k;
                else
                    temp=i-k;
                if(temp<=n)
                {
                    if(a[temp-1]==0)
                        a[temp-1]=i;
                    else if(i+k-1<n&&a[i+k-1]==0)
                        a[i+k-1]=i;
                    else{
                        flag=true;
                        break;
                    }
                }
                else
                {
                    flag=true;
                    break;
                }
            }
            if(flag==true)
                System.out.println("-1");
            else
            {
                for(int i=0;i<n;i++){
                    System.out.print(a[i]+" ");
                }
                System.out.println();
            }
        }
        in.close();
	}

}
