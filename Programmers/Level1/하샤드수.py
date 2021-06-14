def solution(x):
    count = 0
    for i in range(len(str(x))):
        count += int(str(x)[i:i+1])

    if x % count == 0:
        return True
    else:
        return False

print(solution(10))
print(solution(12))
print(solution(11))
print(solution(13))