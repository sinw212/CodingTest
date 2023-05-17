n = int(input())
m = int(input())
arr = [True] * (m+1)
arr[0] = False
arr[1] = False
res = []

for i in range(2, (int(m**0.5))+1):
    if arr[i] == True:
        j = 2
        while i*j <= m:
            arr[i*j] = False
            j += 1

for i in range(n, m+1):
    if arr[i] == True:
        res.append(i)

if len(res) == 0:
    print(-1)
else:
    print(sum(res))
    print(min(res))