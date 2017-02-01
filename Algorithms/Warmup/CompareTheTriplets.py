#!/bin/python

import sys

a = map(int, raw_input().strip().split(' '))
b = map(int, raw_input().strip().split(' '))

sumA = 0
sumB = 0

for i in range(0, len(a)):
    if(a[i] > b[i]):
        sumA += 1
    if(a[i] < b[i]):
        sumB += 1

print(str(sumA) + " " + str(sumB))
