from math import factorial
n = int(input())
arr = []
for i in range(n):
    arr.append(list(map(int,input().split())))

for i in arr:
    print(int(factorial(i[1]) / (factorial(i[0]) * factorial(i[1]-i[0]))))