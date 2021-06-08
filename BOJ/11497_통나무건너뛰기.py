n = int(input())
arr = []
res = []

for i in range(n):
     m = int(input())
     arr.append(list(map(int, input().split())))
     res.append(list(map(int, [0]*m)))

for i in range(len(arr)):
    arr[i].sort(reverse=True)
    a = len(arr[i]) // 2

    res[i][a] = arr[i][0]
    count = 1
    for j in range(1,len(arr[i])):
        if j % 2 == 0:
            res[i][a+count] = arr[i][j]
            count += 1
        else:
            res[i][a-count] = arr[i][j]

for i in range(len(res)):
    ans = []
    for j in range(1,len(res[i])):
        ans.append(abs(res[i][j-1]-res[i][j]))
    print(max(ans))