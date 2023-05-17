def solution(n, lost, reserve):
    answer = n - len(lost)
    lost.sort()
    reserve.sort()
    stu = []

    for i in range(n+2):
        stu.append(0)

    for i in reserve:
        stu[i] += 1

    stu_lost = []

    for i in lost:
        if stu[i] > 0:
            answer += 1
            stu[i] = 0
            stu_lost.append(i)

    for i in stu_lost:
        lost.remove(i)

    for i in lost:
        if stu[i-1] > 0:
            answer += 1
            stu[i-1] = 0
        elif stu[i+1] > 0:
            answer += 1
            stu[i+1] = 0
    return answer

print('예상답1 : 5 / 실제답1 : ' + str(solution(5, [2,4], [1,3,5])))
print('예상답2 : 4 / 실제답2 : ' + str(solution(5, [2,4], [3])))
print('예상답3 : 2 / 실제답3 : ' + str(solution(3, [3], [1])))
print('예상답4 : 5 / 실제답4 : ' + str(solution(5, [4], [5])))
print('예상답5 : 8 / 실제답5 : ' + str(solution(8, [1, 2, 4, 6], [1, 2, 4, 6])))