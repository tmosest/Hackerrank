#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

/**
 *	Algorithms -> Warmup -> Plus Minus
 *	Easy (Super Easy)
 */
int main(){
    int n;
    scanf("%d",&n);
    int arr[n];
    for(int arr_i = 0; arr_i < n; arr_i++){
       scanf("%d",&arr[arr_i]);
    }

    double positiveCount = 0;
    double negativeCount = 0;
    for(int i = 0; i < n; i++) {
    	if(arr[i] != 0) {
    		if(arr[i] > 0) {
    			positiveCount += 1;
    		} else {
    			negativeCount += 1;
    		}
    	}
    }

    double fractionOfPositive = positiveCount / n;
    double fractionOfNegative = negativeCount / n;
    double fractionOfZero = (n - positiveCount - negativeCount) / n;

    printf("%0.4f\n%0.4f\n%0.4f", fractionOfPositive, fractionOfNegative, fractionOfZero);

    return 0;
}
