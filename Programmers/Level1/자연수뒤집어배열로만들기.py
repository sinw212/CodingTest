def solution(n):
    # answer = []
    # arr = list(str(n))[::-1]
    # for i in arr:
    #     answer.append(int(i))
    # return answer

    return list(map(int, str(n)[::-1]))
    # return list(map(int, reversed(str(n))))

print(solution(12345))