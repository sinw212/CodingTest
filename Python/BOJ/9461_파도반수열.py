n = int(input())
num = []

for i in range(n):
    num.append(int(input()))

suy = [1,1,1,2,2]
for i in range(5, max(num)):
    suy.append(suy[i-1] + suy[i-5])

for i in num:
    print(suy[i-1])