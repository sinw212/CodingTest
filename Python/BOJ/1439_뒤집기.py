n = input()
arr = []
count = 0

arr.append(n[0:1])
for i in range(1,len(n)):
    if n[i-1:i] != n[i:i+1]:
        arr.append(n[i:i+1])

for i in arr:
    if i == '0':
        count += 1

if count >= len(arr)-count:
    print(len(arr)-count)
elif count < len(arr)-count:
    print(count)