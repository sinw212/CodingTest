def solution(answers):
    answer = []
    last_num = len(answers)
    arr = [[1,2,3,4,5], [2,1,2,3,2,4,2,5], [3,3,1,1,2,2,4,4,5,5]]
    supo = [[], [], []]
    count = []

    for i in range(len(arr)):
        arr_num = len(arr[i])
        if arr_num < last_num:
            supo[i] = arr[i] * ((last_num // arr_num)+1)
        elif arr_num >= last_num:
            supo[i] = arr[i]

    for i in supo:
        cou = 0
        for j in range(len(answers)):
            if answers[j] == i[j]:
                cou += 1
        count.append(cou)

    for i in range(len(count)):
        if max(count) == count[i]:
            answer.append(i+1)
    return answer

print('예상답1 : [1] / 실제답1 : ' + str(solution([1,2,3,4,5])))
print('예상답2 : [1,2,3] / 실제답2 : ' + str(solution([1,3,2,4,2])))
print('예상답3 : [3] / 실제답3 : ' + str(solution([1,1,1,1])))
print('예상답4 : [1,3] / 실제답4 : ' + str(solution([5,5,5,1,4,1])))