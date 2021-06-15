def solution(arr,divisor):
    # answer = []
    # arr.sort()
    # for i in arr:
    #     if i%divisor == 0:
    #         answer.append(i)
    # if len(answer) == 0:
    #     answer.append(-1)
    # return answer
    return sorted([n for n in arr if n%divisor==0]) or [-1]

print(solution([5,9,7,10], 5))
print(solution([2,36,1,3], 1))
print(solution([3,2,6], 10))
