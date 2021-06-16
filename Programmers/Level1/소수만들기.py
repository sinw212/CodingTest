from math import sqrt
from itertools import combinations as cb

def solution(nums):
    sum_th = []
    # for i in range(len(nums)):
    #     count_i = nums[i]
    #     for j in range(i+1, len(nums)):
    #         count_j = (count_i + nums[j])
    #         for k in range(j+1, len(nums)):
    #             count_k = (count_j + nums[k])
    #             sum_th.append(count_k)
    # sum_th.sort()
    #
    for a in cb(nums,3):
        sum_th.append(sum(a))

    last_num = sum_th[len(sum_th)-1]
    t_guess = [True] * (last_num+1)
    t_guess[0], t_guess[1] = False, False

    for i in range(2, int(sqrt(last_num))+1):
        j=2
        while (i*j) <= last_num:
            t_guess[i*j] = False
            j+=1

    res = []
    for i in range(len(t_guess)):
        if t_guess[i] == True:
            res.append(i)

    count = 0
    for i in res:
        for j in sum_th:
            if i==j:
                count += 1
    return count

print(solution([1,2,3,4]))
print(solution([1,2,7,6,4]))