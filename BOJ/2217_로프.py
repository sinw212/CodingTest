n = int(input())
arr = []
weight = []

for i in range(n):
    arr.append(int(input()))
arr.sort()

for i in arr:
    weight.append(i * n)
    n -= 1
print(max(weight))