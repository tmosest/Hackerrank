#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

/**
 *	Algorithms -> Implementation -> Designer PDF Viewer
 *	Easy
 */
int main(){
    int alphabet[26];
    for(int h_i = 0; h_i < 26; h_i++){
       scanf("%d",&alphabet[h_i]);
    }
    char* word = (char *)malloc(512000 * sizeof(char));
    scanf("%s",word);

    int length = strlen(word);

    int maxHeight = 0;
    for(int i = 0; i < length; i++) {
    	int height = alphabet[ word[i] - 'a' ];
    	if(height > maxHeight) maxHeight = height;
    }

    int area = length * maxHeight;

    printf("%d", area);

    return 0;
}
