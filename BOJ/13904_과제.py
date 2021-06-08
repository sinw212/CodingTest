n = int(input())
arr = []
max_days = 0
report = []
res = 0

for i in range(n):
    arr.append(list(map(int, input().split())))
arr.sort(reverse=True)
max_days = arr[0][0]
arr.sort(reverse=True, key = lambda arr:arr[1])

for i in range(max_days):
    report.append(list(map(int, [0]*2)))

for i in arr:
    for j in range(i[0]):
        if report[i[0]-1-j] == [0,0]:
            report[i[0]-1-j] = i
            break

for i in report:
    res += i[1]
print(res)