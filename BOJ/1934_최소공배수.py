from math import gcd
n = int(input())
arr = []

for i in range(n):
    arr.append(list(map(int,input().split())))

for j in arr:
    print(int(j[0] * j[1] / gcd(j[0], j[1])))