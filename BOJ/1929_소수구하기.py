n , m = list(map(int,input().split()))
arr = [True] * (m+1)

for i in range(2, (int(m**0.5))+1):
    if arr[i] == True:
        j = 2
        while i*j <= m:
            arr[i*j] = False
            j += 1

arr[0] = False
arr[1] = False

for i in range(n, m+1):
    if arr[i]:
        print(i)