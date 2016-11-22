#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

/**
 *	Algorithms -> Warmup -> Time Conversion
 *	Easy
 */
int main(){
	char timestamp[11] = "\0\0\0\0\0\0\0\0\0\0\0";
	int hr=0;

	scanf("%s", timestamp);

	if(timestamp[8] == 'P'){
		hr = 10*(timestamp[0]-'0')+(timestamp[1]-'0');
	    if(hr < 12) hr += 12;
	} else{
		hr = 10*(timestamp[0]-'0')+(timestamp[1]-'0');
	    if(hr == 12) hr = 0;
	}

	timestamp[0] = hr/10 + '0';
	timestamp[1] = hr%10 + '0';
	timestamp[8] = '\0';
	timestamp[9] = '\0';

	printf("%s", timestamp);
	return 0;
}
