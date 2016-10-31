#!/bin/python3

'''
Example Case:

2 3
2 4
16 32 96


1 3
1
3 5 11

2 1
1 3
3

1 3
1
2 5 7

1 3
1
4 6 8

3 1 
1 2 4 
100
'''

import sys
import fractions

def isFactor(number, divider):
    if number % divider == 0:
        return True
    else:
        return False

def lcm(a,b): return abs(a * b) / fractions.gcd(a,b) if a and b else 0

n,m = input().strip().split(' ')
n,m = [int(n),int(m)]
a = [int(a_temp) for a_temp in input().strip().split(' ')]
b = [int(b_temp) for b_temp in input().strip().split(' ')]

aLargest = a[n-1] # Could have used len(a) - 1 instead. 
bSmallest = b[0]
bLargest = b[m-1]

#print("A largest: " + str(aLargest))
#print("B smallest: " + str(bSmallest))
#print("B largest: " + str(bLargest))

count = 0

greatestCommonDenomimator = bSmallest

for c in b[1::]:
    greatestCommonDenomimator = fractions.gcd(greatestCommonDenomimator, c)

leastCommon = a[0]

for c in a[1::]:
    leastCommon = lcm(leastCommon, c)

#print("GCD of b: " + str(greatestCommonDenomimator))
#print("LCM of a: " + str(leastCommon))


count = int(greatestCommonDenomimator/leastCommon) + 1
answer = 0
#if answer > 2:
 #   answer = answer - 1

for x in range(1, count):
    if(isFactor(leastCommon, x)):
        answer += 1
    #print(x)

print(answer)
        