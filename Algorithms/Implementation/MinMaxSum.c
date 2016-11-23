#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

/**
 *	Algorithms -> Warmup -> A Very Big Sum
 *	Easy
 */
int main(){
	long long a, b, c, d, e;

	scanf("%lld %lld %lld %lld %lld",&a,&b,&c,&d,&e);

	long long array[] = {a, b, c, d, e};

	long long min = a + b + c + d + e;
	long long max = 0;

	for(int i = 0; i < 5; i++) {
		long long sum = 0;
		for(int j = 0; j < 5; j++) {
			if(i != j) sum += array[j];
		}
		if(sum > max) max = sum;
		if(sum < min) min = sum;
	}

	printf("%lld %lld", min, max);

    return 0;
}
