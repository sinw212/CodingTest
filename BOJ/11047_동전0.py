n, m = list(map(int,input().split()))
value = []
count = 0

for i in range(n):
    value.append(int(input()))
value.sort(reverse=True)

for i in value:
    if m >= i:
        count += m // i
        m %= i
print(count)