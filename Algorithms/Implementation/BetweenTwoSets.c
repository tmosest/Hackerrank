#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

/**
 *	Algorithms -> Warmup -> Between Two Sets
 *	Easy
 */

/*
 * Function declaration
 */
int gcd(int a, int b);
int lcm(int a, int b);
int isFactor(int number, int divisor);

/*
 * Main
 */
int main(){

	int sizeOfA, sizeOfB;

	scanf("%d %d", &sizeOfA, &sizeOfB);

	int A[sizeOfA];

	for(int i = 0; i < sizeOfA; i++) {
		scanf("%d", &A[i]);
	}

	int B[sizeOfB];

	for(int i = 0; i < sizeOfB; i++) {
		scanf("%d", &B[i]);
	}

	int gcdB = B[0];

	for(int i = 1; i < sizeOfB; i++) {
		gcdB = gcd(gcdB, B[i]);
	}

	int lcmA = A[0];

	for(int i = 1; i < sizeOfA; i++) {
		lcmA = lcm(lcmA, A[i]);
	}

	int counter = 0;

	for(int i = lcmA; i <= gcdB; i++) {
		if(isFactor(gcdB, i) == 1 && isFactor(i, lcmA) == 1) {
			counter++;

		}
	}

	printf("%d", counter);

    return 0;
}

/**
 * Functions
 */

// Calculate the greatest common denominator of two numbers.
int gcd(int a, int b)
{
	if(b == 0) return a;
	return gcd(b, a % b);
}

// Calculate the least common multiple of two numbers.
int lcm(int a, int b)
{
	return abs(a * b) / gcd(a, b);
}

// Determines if a number is a divisor of another number
int isFactor(int number, int divisor)
{
	int isDivisor = 0;
	if(number % divisor == 0) {
		isDivisor = 1;
	}
	return isDivisor;
}
