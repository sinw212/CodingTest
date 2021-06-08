n, m = list(map(int,input().split()))
count = 0

while True:
    if m % 2 == 0:
        m /= 2
    else:
        m = (m-1)/10
    count += 1

    if m <= n:
        break

if m < n:
    print(-1)
else:
    print(count+1)