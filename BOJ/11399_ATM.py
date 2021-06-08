n = int(input())
time = list(map(int, input().split()))
time.sort()
res = []
count = 0
result = 0

for i in time:
    count += i
    res.append(count)

for i in res:
    result += i

print(result)