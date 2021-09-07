def solution(array, commands):
    answer = []
    for i in commands:
        answer.append((sorted(array[(i[0]-1):(i[1])]))[i[2]-1])
    return answer

    # answer = []
    # res = []
    # for i in commands:
    #     answer.append(array[(i[0] - 1):(i[1])])
    #
    # for i in range(len(answer)):
    #     answer[i].sort()
    #     res.append(answer[i][commands[i][2] - 1])
    # return res

    # return list(map(lambda x:sorted(array[x[0]-1:x[1]])[x[2]-1], commands))

print(solution([1,5,2,6,3,7,4], [[2,5,3], [4,4,1], [1,7,3]]))