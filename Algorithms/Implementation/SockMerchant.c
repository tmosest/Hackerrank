#include <stdio.h>

/**
 *	Algorithms -> Implementation -> Sock Merchant
 *	Easy
 */

void quickSort( int a[], int l, int r);
int partition( int a[], int l, int r);


int main() {
	int numberOfSocks;

	scanf("%d", &numberOfSocks);

	int socks[numberOfSocks];

	for(int i = 0; i < numberOfSocks; i++) {
		scanf("%d", &socks[i]);
	}

	quickSort(socks, 0, numberOfSocks - 1);

	int pairs = 0;

	int pairsHolders = 1;

	int holder = socks[0];

	for(int i = 1; i < numberOfSocks; i++) {
		if(socks[i] == holder) {
			pairsHolders += 1;
		} else {
			pairsHolders = 1;
		}
		holder = socks[i];
		if(pairsHolders == 2) {
			pairs += 1;
			pairsHolders = 1;
			holder = -1000; // Arbitrary number probably a better way to do this.
		}
	}

	printf("%d", pairs);

	return 0;
}

void quickSort( int a[], int l, int r)
{
   int j;

   if( l < r )
   {
   	// divide and conquer
        j = partition( a, l, r);
       quickSort( a, l, j-1);
       quickSort( a, j+1, r);
   }

}

int partition( int a[], int l, int r)
{
   int pivot, i, j, t;
   pivot = a[l];
   i = l; j = r+1;

   while( 1)
   {
   	do ++i; while( a[i] <= pivot && i <= r );
   	do --j; while( a[j] > pivot );
   	if( i >= j ) break;
   	t = a[i]; a[i] = a[j]; a[j] = t;
   }
   t = a[l]; a[l] = a[j]; a[j] = t;
   return j;
}
