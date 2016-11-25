#include <stdio.h>

/**
 *	Algorithms -> Implementation -> Matrix Layer Rotation
 *	Hard
 */

/**
 * Declare Function
 */
void rotateMatrix(int matrix[][], int rotations, int rows, int columns);

/**
 * Main
 */
int main() {
	int rows, columns, rotations;

	scanf("%d %d %d", rows, columns, rotations);

	int matrix[rows][columns];

	for(int r = 0; r < rows; r++) {
		for(int c = 0; c < columns, c++) {
			scanf("%d", &matrix[r][c]);
		}
	}



	return 0;
}

/**
 * Define Functions
 */
void rotateMatrix(int[][] matrix, int rotations, int rows, int columns)
{
	int k = 0;
	int formula = 1;

	int end;
	if(columns < rows) {
		end = columns;
	} else {
		end = rows;
	}

	while(formula > 0) {
		formula = (rows - (2 * k + 1)) * 2 + (columns - (2 * k + 1)) * 2;

		if(formula > 0) {
			int cyclicGroup[formula];

			int topLeft[] = {0 + k, 0 + k};
			int botLeft[] = {(rows - 1) - k, 0 + k};
			int topRight[] = {0 + k, (columns - 1) - k};
			int botRight[] = {(rows - 1) - k, (columns - 1) - k};

			int diffTopBotLeft = botLeft[0] - topLeft[0];
			int diffBotLeftBotRight = botRight[1] - botLeft[1];
			int diffBotRightTopRight = topRight[0] - botRight[0];
			int diffTopRightTopLeft = topLeft[1] - topRight[1];

			if(diffTopBotLeft <= 0 || diffBotLeftBotRight <= 0 ||
			   diffBotRightTopRight >= 0 || diffTopRightTopLeft >= 0) {
				break;
			}

			int count = 0;
			int i = topLeft[0];
			int j = topLeft[1];

			while(count < formula) {
				cyclicGroup[count] = matrix[i][j];
				if(diffTopBotLeft != 0) {
					i += 1;
					diffTopBotLeft -= 1;
				} else if(diffBotLeftBotRight != 0) {
					j += 1;
					diffBotLeftBotRight -= 1;
				} else if(diffBotRightTopRight != 0) {
					i -= 1;
					diffBotRightTopRight += 1;
				} else if(diffTopRightTopLeft != 0){
					j -= 1;
					diffTopRightTopLeft += 1;
				}
				count += 1;
			}// end while count < formula



		} // end if formula

		k += 1;
	} // end while formula
}

