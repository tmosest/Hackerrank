package Implementation;

import java.util.Scanner;

/**
 *	Algorithms -> Implementations -> Grading Students
 *	Easy
 */
public class GradingStudents {
	
	private static boolean debugMode = false;
	
	/**
	 * Finds the next multiple of 5 that is larger than the input number.
	 * @param number
	 * @return
	 */
	private static int findNextLargestMultipleOfFive(int number) {
		return ((number / 5) + 1) * 5;
	}
	
	/**
	 * Determines the final grade based on rounding rules.
	 * @param grade
	 * @return
	 */
	private static int roundGrade(int grade) {
		int roundedGrade = grade;
		if(grade >= 38) {
			int multOfFive = findNextLargestMultipleOfFive(grade);
			if(debugMode) {
				System.out.println("Grade: " + grade + " Closest Five: " + multOfFive);
			}
			if(multOfFive - grade < 3) {
				roundedGrade = multOfFive;
			}
		}
		return roundedGrade;
	}
	
	/**
	 * Loops through an array of grades and returns the rounded grades.
	 * @param grades
	 * @return
	 */
	private static int[] solve(int[] grades){
        int[] finalGrades = new int[grades.length];
        
        for(int i = 0; i < grades.length; i++) {
        	finalGrades[i] = roundGrade(grades[i]);
        }
        
        return finalGrades;
    }

	/**
	 * Main to test the story.
	 * @param args
	 */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] grades = new int[n];
        for(int grades_i=0; grades_i < n; grades_i++){
            grades[grades_i] = in.nextInt();
        }
        int[] result = solve(grades);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");
    }

}
