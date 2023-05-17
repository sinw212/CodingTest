n = int(input())
arr = []
res = 0

for i in range(n):
    arr.append(int(input()))

arr = arr[::-1]
count = arr[0]

for i in range(1,len(arr)):
    count -= 1
    if arr[i] != count:
        if count < arr[i]:
            res += (arr[i] -  count)
        elif count > arr[i]:
            count = arr[i]
print(res)