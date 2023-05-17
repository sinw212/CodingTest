arr = []
res = []

while True:
    n = input().split()
    if  n == ['0', '0', '0']:
        break
    arr.append(list(map(int, n)))

for i in arr:
    if (i[2]%i[1] >= i[0]):
        count = ((i[2]//i[1])*i[0]) + i[0]
    else:
        count = ((i[2]//i[1])*i[0]) + (i[2]%i[1])
    res.append(count)

for i in range(len(res)):
    print('Case ' + str(i+1) + ': ' + str(res[i]))