def solution(n):
    arr = list(str(n))
    # arr = []
    # answer = ''
    # for i in range(len(str(n))):
    #     arr.append(str(n)[i:i+1])
    arr.sort(reverse=True)

    # for i in arr:
    #     answer += i
    # return int(answer)
    return int("".join(arr))

print(solution(118372))