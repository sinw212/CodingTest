def solution(x, n):
    answer = []
    for i in range(1,n+1):
        answer.append(x*i)
    return answer

print('예상답1 : [2,4,6,8,10], 실제답1 : ' + str(solution(2,5)))
print('예상답2 : [4,8,12], 실제답2 : ' + str(solution(4,3)))
print('예상답3 : [-4,-8], 실제답3 : ' + str(solution(-4,2)))