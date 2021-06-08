#방법1
n = int(input())
count = 0
while n>1 :
    if n >= 500:
        a = n // 500
        count = count + a
        n = n - 500*a
    elif n >= 100:
        a = n // 100
        count = count + a
        n = n - 100*a
    elif n >= 50:
        a = n // 50
        count = count + a
        n = n - 50*a
    elif n >= 10:
        a = n // 10
        count = count + a
        n = n - 10*a
print(count)

#방법2 (답안 예시)
n = 1260
count = 0
array = [500, 100, 50, 10]

for coin in array:
    count += n // coin
    n %= coin
print(count)
