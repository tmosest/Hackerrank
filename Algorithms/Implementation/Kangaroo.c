#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

/**
 *	Algorithms -> Warmup -> Kangaroo
 *	Easy
 */

struct Kangaroo {
	int position;
	int velocity;
} kangaroo;

/*
 * Function declaration
 */
int willSecondKangarooCatchTheFirst(struct Kangaroo k1, struct Kangaroo k2);

/*
 * Main
 */
int main(){

	struct Kangaroo k1;
	struct Kangaroo k2;

	scanf("%d %d %d %d", &k1.position, &k1.velocity, &k2.position, &k2.velocity);

	int result = willSecondKangarooCatchTheFirst(k1, k2);

	if(result == 1) {
		printf("YES");
	} else {
		printf("NO");
	}

    return 0;
}

/*
 * Functions
 */
int willSecondKangarooCatchTheFirst(struct Kangaroo k1, struct Kangaroo k2) {

	double i = (double) (k1.position - k2.position) / (k2.velocity - k1.velocity);

	int result = 0;
	if(i > 0 && i == (int) i) {
		result = 1;
	}
	return result;
}
