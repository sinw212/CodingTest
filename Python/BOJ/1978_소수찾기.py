n = int(input())
arr = list(map(int,input().split()))
res = 0

for num in arr:
    count = 0
    if num > 1:
        for i in  range(2,num+1):
            if(num%i==0):
                count += 1
    if count == 1:
        res += 1
print(res)