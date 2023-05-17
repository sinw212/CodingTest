def solution(left, right):
    answer = 0
    for i in range(left, right+1):
        count = 0
        for num in range(1, i+1):
            if i%num==0:
                count += 1
        if count%2==0:
            answer += i
        else:
            answer -= i
    return answer

print(solution(13,17))
print(solution(24,27))