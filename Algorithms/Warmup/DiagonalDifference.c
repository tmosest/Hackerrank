#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

/**
 *	Algorithms -> Warmup -> Diagonal Difference
 *	Easy (Super Easy)
 */
int main(){
    int n;
    scanf("%d",&n);
    int a[n][n];
    for(int a_i = 0; a_i < n; a_i++){
       for(int a_j = 0; a_j < n; a_j++){
          scanf("%d",&a[a_i][a_j]);
       }
    }

    int diagnol1 = 0;
    int diagnol2 = 0;

    for(int i = 0; i < n; i++) {
    	diagnol1 += a[i][i];
    	//printf("%d \n", a[i][i]);
    	diagnol2 += a[n - i - 1][i];
    	//printf("%d \n", a[n - i - 1][i]);
    }

    //printf("diag1 %d diag2 %d\n", diagnol1, diagnol2);
    int diagnol = abs(diagnol1 - diagnol2);

    printf("%d", diagnol);

    return 0;
}
