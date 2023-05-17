n = input()
arr = n.split('-')
result = []

for i in arr:
    count = 0
    sep = i.split('+')
    for j in sep:
        count += int(j)
    result.append(count)

res = result[0]
for i in range(1,len(result)):
    res -= result[i]
print(res)