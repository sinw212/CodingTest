e, s, m = list(map(int, input().split()))
earth = 0
sun = 0
moon = 0
year = 0

while True:
    earth += 1
    sun += 1
    moon += 1
    year += 1

    if e==earth and s==sun and m==moon:
        break
    if earth==15:
        earth = 0
    if sun==28:
        sun = 0
    if moon==19:
        moon = 0
print(year)