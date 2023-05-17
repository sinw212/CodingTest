def solution(lottos, win_nums):
    answer = [6,6,5,4,3,2,1]
    c_count = 0
    for i in lottos:
        if i in win_nums:
            c_count += 1

    zero_count = lottos.count(0)

    return answer[zero_count+c_count], answer[c_count]

    # if c_count+zero_count == 6:
    #     answer.append(1)
    # elif c_count+zero_count == 5:
    #     answer.append(2)
    # elif c_count+zero_count == 4:
    #     answer.append(3)
    # elif c_count+zero_count == 3:
    #     answer.append(4)
    # elif c_count+zero_count == 2:
    #     answer.append(5)
    # else:
    #     answer.append(6)
    #
    # if c_count == 6:
    #     answer.append(1)
    # elif c_count == 5:
    #     answer.append(2)
    # elif c_count == 4:
    #     answer.append(3)
    # elif c_count == 3:
    #     answer.append(4)
    # elif c_count == 2:
    #     answer.append(5)
    # else:
    #     answer.append(6)
    #
    # return answer

print(solution([44,1,0,0,31,25], [31,10,45,1,6,19])) #[3,5]
print(solution([0,0,0,0,0,0], [38,19,20,40,15,25])) #[1,6]
print(solution([45,4,35,20,3,9], [20,9,3,45,4,35])) #[1,1]