#include <stdio.h>

/**
 *	Algorithms -> Implementation -> Angry Professor
 *	Easy
 */

int main() {
	int testCases;

	scanf("%d", &testCases);

	for(int i = 0; i < testCases; i++) {
		int numberOfStudents, studentsRequired;
		scanf("%d %d", &numberOfStudents, &studentsRequired);

		int onTimeCount = 0;
		for(int student_i = 0; student_i < numberOfStudents; student_i++) {
			int time;
			scanf("%d", &time);
			if(time <= 0) onTimeCount += 1;
		}

		if(onTimeCount < studentsRequired) {
			printf("YES\n");
		} else {
			printf("NO\n");
		}
	}

	return 0;
}
