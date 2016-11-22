#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

/**
 *	Algorithms -> Warmup -> Compare the Triplets
 *	Easy (Super Easy)
 */
int main(){
	int amy[3]; // Store the first triplet.

	scanf("%d %d %d", &amy[0], &amy[1], &amy[2]); // Scan in first one

	int bob[3]; // Store the second triplet.

	scanf("%d %d %d", &bob[0], &bob[1], &bob[2]); // Scan in second one

	//printf("size of amy %d", sizeof(amy));

	//Store the scores in an array;
	int score[] = {0 , 0};

	// Loop through and calculate scores
	for(int i = 0; i < 3; i++) {
		if(!(amy[i] == bob[i])) {
			if(amy[i] > bob[i]) {
				score[0] += 1;
			} else {
				score[1] += 1;
			}
		}
	}

    printf("%d %d", score[0], score[1]);
    return 0;
}
