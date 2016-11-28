#include <stdio.h>

/**
 *	Algorithms -> Implementation -> Utopian Tree
 *	Easy
 */

int calculateUtopianTreeGrowth(int cycles);

int main() {
	int numCases;
	scanf("%d", &numCases);
	for(int i = 0; i < numCases; i++) {
		int n;
		scanf("%d", &n);
		int height = calculateUtopianTreeGrowth(n);
		printf("%d\n", height);
	}
	return 0;
}

int calculateUtopianTreeGrowth(int cycles)
{
	int height = 1;
	for(int i = 1; i <= cycles; i++) {
		if(i % 2 == 0) {
			height += 1;
		} else {
			height *= 2;
		}
	}
	return height;
}
