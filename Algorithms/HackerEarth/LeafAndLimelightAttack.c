/**
 * Leaf and Limelight Attack
 * Algorithms  Dynamic Programming  Introduction to Dynamic Programming 1
 * Easy
 * @author tmosest
 *
 */

#include <stdio.h>

#define MOD 1000000009L // (long) 10e9 + 9
#define LIMIT 10000000L // (int) 10e7

long long int sumOfDiagnols[LIMIT + 1];

void fillSumOfDiagnols();
long long sumOfOutsideLayer(int n);


/**
 *Get the party started
 */
int main()
{
	fillSumOfDiagnols();

	int qs;
	long long n;

	scanf("%d", &qs);

	for(int q = 0; q < qs; q++) {
		scanf("%lld", &n);
		printf("%lld\n", sumOfDiagnols[n]);
	}

	return 0;
}

/**
 * Function to fill the sumOfDiagnols in a D.P. style
 */
void fillSumOfDiagnols()
{
	sumOfDiagnols[0] = 0;
	sumOfDiagnols[1] = 1;
	sumOfDiagnols[2] = 10;
	for(int i = 3; i <= LIMIT; i++) {
		sumOfDiagnols[i] = ((sumOfOutsideLayer(i) % MOD) + (sumOfDiagnols[i - 2] % MOD)) % MOD;
	}
}

/**
 * Sums the four corners of an n by n spiral matrix
 */
long long sumOfOutsideLayer(int n)
{
	long long sum = 0;
	long long n2 = ((n % MOD) * (n % MOD)) % MOD;
	for(int i = 0; i < 4; i++) {
		sum += ((n2 - (((n - 1) % MOD) * i) % MOD) % MOD;
	}
	return sum;
}
