arr = []
saeng = []

def calc(n):
    leng = len(str(n)) - 1
    for i in range(leng):
        arr.append(n // (10 ** (leng - i)))
        n %= (10 ** (leng - i))
    arr.append(n)
    return arr

for i in range(10000):
    arr = []
    saeng.append(i + sum(calc(i)))
s_saeng = set(saeng)

for x in range(10000):
    if x not in s_saeng:
        print(x)