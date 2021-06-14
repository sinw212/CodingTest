def solution(n):
    temp = n ** 0.5
    if n == (int(temp)**2):
        return int(temp+1)**2
    else:
        return -1

print(solution(121))
print(solution(3))