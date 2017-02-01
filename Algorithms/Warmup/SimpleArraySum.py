#!/bin/python

import sys

def sumArray(arr):
    sum = 0
    for number in arr:
        sum += number
    return sum

n = int(raw_input().strip())
arr = map(int,raw_input().strip().split(' '))
print(sumArray(arr))

