n, m = list(map(int,input().split()))
res = []

arr = list(map(int,input().split()))

for i in range(len(arr)):
    hap1 = 0
    hap1 += arr[i]
    for j in range(i+1,len(arr)):
        hap2 = hap1
        hap2 += arr[j]
        for k in range(j+1, len(arr)):
            hap3 = hap2
            hap3 += arr[k]
            if hap3 <= m:
                res.append(hap3)
res = set(res)

print(max(res))