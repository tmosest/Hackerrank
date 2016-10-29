import java.util.Scanner;

/**
 * Project Euler #1: Multiples of 3 and 5
 *
 */
public class Problem1 {

	public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int n = 0;
        n = in.nextInt();
        for(int i = 0; i < n; i++) {
            long k = in.nextInt();
            k = sumOf3sAnd5sLessThanN(k);
            System.out.println(k);
        }
        in.close();
    }
	
    public static long sumOf3sAnd5sLessThanN(long n) {
        long total  = 0;
        n = n - 1;
        long i = n/3;
        total += 3 * gaussSum(i);
        i = n/5;
        total += 5 * gaussSum(i);
        i = n/15;
        total -= 15 * gaussSum(i);
        return total;
    }
    
    public static long gaussSum(long n){
        return (n * (n + 1)) / 2;
    }

}
