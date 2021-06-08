from math import factorial
n = int(input())
fact = str(factorial(n))
last = len(fact)
count = 0

for i in range(1,last):
    if fact[last-i:last-(i-1)] == '0':
        count += 1
    elif fact[last-i:last-(i-1)] != '0':
        break
print(count)