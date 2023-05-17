def solution(absolutes, signs):
    answer = 0
    for i in range(len(signs)):
        if signs[i] == True:
            answer += absolutes[i]
        else:
            answer -= absolutes[i]
    return answer
    # return sum(absolutes[i] * (1 if signs[i] else -1) for i in range(len(signs)))

print(solution([4,7,12], [True, False, True]))
print(solution([1,2,3], [False, False, True]))