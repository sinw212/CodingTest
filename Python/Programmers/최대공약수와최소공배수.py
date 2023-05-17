from math import gcd

def solution(n,m):
    return [gcd(n,m), int((n*m)/gcd(n,m))]

print(solution(3,12))
print(solution(2,5))