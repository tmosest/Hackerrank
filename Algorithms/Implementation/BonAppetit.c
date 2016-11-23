#include <stdio.h>

/**
 *	Algorithms -> Implementation -> Bon Appétit
 *	Easy
 */

int main() {
	int numberOfItems, indexOfItemNotEaten;

	scanf("%d %d", &numberOfItems, &indexOfItemNotEaten);

	int foodCosts[numberOfItems];

	int realFoodCosts = 0;

	for(int i = 0; i < numberOfItems; i++) {
		scanf("%d", &foodCosts[i]);
		if(i != indexOfItemNotEaten) realFoodCosts += foodCosts[i];
	}

	int amountCharged;

	scanf("%d", &amountCharged);

	int amountToCharge = realFoodCosts/2;

	if(amountCharged == amountToCharge) {
		printf("Bon Appetit");
	} else {
		printf("%d", amountCharged - amountToCharge);
	}

	return 0;
}
