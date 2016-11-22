#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

/**
 *	Algorithms -> Warmup -> A Very Big Sum
 *	Easy (Super Easy)
 */
int main(){
    int n;
    scanf("%d",&n);
    long long sum = 0;
    for(int arr_i = 0; arr_i < n; arr_i++){
       long input = 0;
       scanf("%ld", &input);
       sum += input;
    }
    printf("%lld", sum);
    return 0;
}
