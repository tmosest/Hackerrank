#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

/**
 *	Algorithms -> Implementation -> Apple and Orange
 *	Easy
 */
int main(){

	int houseStart, houseEnd, appleTree, orangeTree, numApples, numOranges;

	scanf("%d %d", &houseStart, &houseEnd);

	scanf("%d %d", &appleTree, &orangeTree);

	scanf("%d %d", &numApples, &numOranges);

	int apples[numApples];

	for(int i = 0; i < numApples; i++) {
		scanf("%d", &apples[i]);
	}

	int oranges[numOranges];

	for(int i = 0; i < numOranges; i++) {
			scanf("%d", &oranges[i]);
	}

	long appleCount = 0;

	for(int apple_i = 0; apple_i < numApples; apple_i++) {
		if(apples[apple_i] + appleTree >= houseStart &&
				apples[apple_i] + appleTree <= houseEnd)
			appleCount += 1;
	}

	long orangeCount = 0;

	for(int orange_i = 0; orange_i < numOranges; orange_i++) {
			if(oranges[orange_i] + orangeTree >= houseStart &&
					oranges[orange_i] + orangeTree <= houseEnd)
				orangeCount += 1;
	}

	printf("%ld\n%ld", appleCount, orangeCount);

    return 0;
}
