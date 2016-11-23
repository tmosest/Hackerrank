package Implementation;

import java.util.Scanner;

/**
 *	Algorithms -> Implementations -> Designer PDF Viewer
 *	Easy
 */
public class DesignerPdfViewer {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int[] alphabetHeights = new int[26];
		for(int i = 0; i < 26; i++) {
			alphabetHeights[i] = in.nextInt();
		}
		
		String word = in.next();
		
		int maxHeight = 0;
		
		for(char letter: word.toCharArray()) {
			int height = alphabetHeights[letter - 'a'];
			if(height > maxHeight) maxHeight = height;
		}
		
		int area = maxHeight * word.length();
		
		System.out.println(area);
		
		in.close();
	}

}
