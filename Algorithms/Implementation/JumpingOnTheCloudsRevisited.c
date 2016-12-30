#include <stdio.h>

/**
 *	Algorithms -> Implementation -> Jumping on the Clouds: Revisited
 *	Easy
 */

// let's get this party started!!
int main() 
{
    int clouds, jumpSize, energy = 100;

    scanf("%d %d", &clouds, &jumpSize);

    int cloud[clouds];

    for(int i = 0; i < clouds; i++) {
        scanf("%d", &cloud[i]);
    }

    for(int i = jumpSize % clouds; i != 0;  i = (i + jumpSize) % clouds) {
        energy -= 1;
        if(cloud[i] == 1) energy -= 2;
    }

    energy -= 1;
    if(cloud[0] == 1) energy -= 2;

    printf("%d", energy);

    return 0;
}
// end the party