#include <stdio.h>

/**
 *	Algorithms -> Implementation -> Divisible Sum Pairs
 *	Easy
 */

int main() {
	int arraySize, mod;

	scanf("%d %d", &arraySize, &mod);

	int array[arraySize];

	for(int i = 0; i < arraySize; i++) {
		scanf("%d", &array[i]);
	}

	int pairCount = 0;

	for(int i = 0; i < arraySize - 1; i++) {
		for(int j = i + 1; j < arraySize; j++) {
			if( (array[i] + array[j]) % mod == 0 ) pairCount += 1;
		}
	}

	printf("%d", pairCount);

	return 0;
}
