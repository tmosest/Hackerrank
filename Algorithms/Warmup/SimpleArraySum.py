#!/bin/python

import sys

n = int(raw_input().strip())
arr = map(int,raw_input().strip().split(' '))
s = 0
for x in arr:
    s += x
print(s)
