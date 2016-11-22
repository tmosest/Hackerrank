#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

/**
 *	Algorithms -> Warmup -> Circular Array Rotation
 *	Easy
 */
int main() {
	int n;
	int k;
	int q;
	scanf("%d %d %d",&n,&k,&q);

	int array[n];

	for(int a_i = 0; a_i < n; a_i++){
		scanf("%d",&array[a_i]);
	}

	int rot = k % n;
	for(int i = 0; i < q; i++) {
		int idx;
		scanf("%d", &idx);
		//printf("%d", idx);
		if(idx - rot >= 0) {
			printf("%d\n", array[idx - rot]);
		} else {
			printf("%d\n", array[idx - rot + n]);
		}
	}

	return 0;
}
