def solution(a,b):
    # if a <= b:
    #     min = a
    #     max = b
    # else:
    #     min = b
    #     max = a
    if a>b:
        a,b = b,a #default가 a<b라서 아닌 경우만 바꿔주기
    return sum(range(a, b+1))
    # count = min
    # answer = min
    # while True:
    #     if count == max:
    #         break
    #     count += 1
    #     answer += count
    # return answer

print(solution(3,5))
print(solution(3,3))
print(solution(5,3))