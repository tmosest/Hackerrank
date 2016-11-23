#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

/**
 *	Algorithms -> Warmup -> Beautiful Days at the Movies
 *	Easy
 */

// Takes an integer and returns the reverse of it
int reverseInteger(int number) {
	int reverse = 0;
	int n = number;
	while (n != 0) {
		reverse = reverse * 10;
	    reverse = reverse + n % 10;
	    n = n / 10;
	}
	//printf("reverse: %d\n", reverse);
	return reverse;
}

//Checks if a day is beautiful mod k
int isDayBeautiful(int number, int mod) {
	int result = 0;
	//printf("abs(number - reverseInteger(number)) mod: %d\n", abs(number - reverseInteger(number)) % mod);
	if(abs(number - reverseInteger(number)) % mod == 0) {
		result = 1;
	}
	return result;
}

int main(){
	int startDay, endDay, divisibilityFactor;

	scanf("%d %d %d", &startDay, &endDay, &divisibilityFactor);

	int beautifulCount = 0;

	for(int day = startDay; day <= endDay; day++) {
		beautifulCount += isDayBeautiful(day, divisibilityFactor);
	}

	printf("%d", beautifulCount);

    return 0;
}

