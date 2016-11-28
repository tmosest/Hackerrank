#include <stdio.h>

/**
 *	Algorithms -> Implementation -> Viral Advertising
 *	Easy
 */

int calculateTheNumberOfPeopleWhoSeeOnNthDay(int numDays);

int main() {

	int numDays;
	scanf("%d", &numDays);

	int count = calculateTheNumberOfPeopleWhoSeeOnNthDay(numDays);

	printf("%d", count);

	return 0;
}

int calculateTheNumberOfPeopleWhoSeeOnNthDay(int numDays)
{
	int like = 0;
	int startLikes = 5;
	for(int i=1; i <= numDays; i++) {
		like = like + (startLikes / 2);
	    startLikes = (startLikes / 2) * 3;
	}
	return like;
}
