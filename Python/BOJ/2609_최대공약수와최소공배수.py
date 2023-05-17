from math import gcd
n, m = map(int,input().split())
print(gcd(n,m))
print(int(n*m / gcd(n,m)))