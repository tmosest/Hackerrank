package WeekOfCode.Week27;

import java.util.Scanner;

/**
 *	Algorithms -> Week of Code 27 -> Drawing Book
 *	Easy
 */
public class DrawingBook {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int pages = in.nextInt();
		int pageTofind = in.nextInt();
		
		in.close();
		
		/*
		 * Now we need to determine how many turns to see the page.
		 */
		Book book = new Book(pages);
		System.out.println(book.calculateNumberOfPageTurnsToFindAPage(pageTofind));
		
	}

	private static class Book
	{
		private int pages[];
		
		public Book(int numPages) {
			if(numPages % 2 == 0)
				pages = new int[numPages + 2];
			else 
				pages = new int[numPages + 1];
			
			for(int i = 0; i < pages.length; i++)
				pages[i] = i;
		}
		
		public int calculateNumberOfPageTurnsToFindAPage(int pageToFind)
		{
			int pageTurnsForwards = 0;
			
			for(int i = 0; i < pages.length; i += 2) {
				if(i == pageToFind || i + 1 == pageToFind) {
					break;
				}
				pageTurnsForwards++;
			}
			
			int pageTurnsBackwards = 0;
			
			for(int i = pages.length - 1; i > 0; i -= 2) {
				if(i == pageToFind || i - 1 == pageToFind) {
					break;
				}
				pageTurnsBackwards++;
			}
			
			return Math.min(pageTurnsForwards, pageTurnsBackwards);
		}
	}
}
