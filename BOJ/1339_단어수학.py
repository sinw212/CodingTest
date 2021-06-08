n = int(input())
arr = []
dics = {}
number = []
result = 0

for i in range(n):
    arr.append((input()))

for i in arr:
    count = len(i)-1
    for j in i:
        if j in dics:
            dics[j] += (10 ** count)
        else:
            dics[j] = (10 ** count)
        count -= 1

for i in dics.values():
    number.append(i)
number.sort(reverse=True)

count = 9
for i in range(len(number)):
    result += number[i]*count
    count -= 1
print(result)

#========================================
#***** 틀렸습니다 ***** (반례 해결 못함. 몰라 포기)
n = int(input())
arr = []
count = []
same_remove = []
dics = {}
ans = 0

for i in range(n):
    arr.append((input()))
arr.sort()

for i in arr:
    i = "".join(reversed(i))

    for j in range(len(i)):
        count.append((j, i[j]))
# count.sort(reverse=True)
count.sort(reverse=True, key=lambda count: count[0])

for i in range(len(count)):
    for j in range(i+1, len(count)):
        if count[i][1] == count[j][1]:
            same_remove.append(j)

same_remove = set(same_remove)
for i in same_remove:
    del(count[i])
    count.insert(i,'?')

cou = 9
for i in count:
    if i != '?':
       dics[i[1]] = str(cou)
       cou -= 1

for i in arr:
    temp = ''
    for j in range(len(i)):
        temp += dics.get(i[j])
    ans += int(temp)

print(ans)