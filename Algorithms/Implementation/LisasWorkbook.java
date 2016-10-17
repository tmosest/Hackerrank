package Implementation;

import java.util.Scanner;

/**
 *	Algorithms -> Implementations -> Lisa's Workbook
 *	Easy
 */
public class LisasWorkbook {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int numberOfChs = in.nextInt();
        int numberOfProbsPerPage = in.nextInt();
        int[] problemsPerChapter = new int[numberOfChs];
        for(int i = 0; i < numberOfChs; i++) {
            problemsPerChapter[i] = in.nextInt();
        }
        int numberOfPages = 0;
        int magic = 0;
        for(int i = 0; i < numberOfChs; i++) {
            numberOfPages++;
            int k = 1;
            for(int j = 1; j <= problemsPerChapter[i]; j++) {
                if(numberOfProbsPerPage * k < j) {
                    k++;
                    numberOfPages++;
                }
                if(numberOfPages == j) magic++;
            }
        }
        System.out.println(magic);
        in.close();
	}

}
