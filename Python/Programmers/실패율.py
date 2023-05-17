def solution(N, stages):
    stages.sort()
    dict = {}
    length = len(stages)

    for i in range(1, N+1):
        count = 0
        for j in range(len(stages)):
            if i==stages[j]:
                count += 1
        if count == 0:
            dict[i] = 0
        else:
            dict[i] = count/length
        length -= count

    res = sorted(dict.items(), key=(lambda x:x[1]), reverse=True)
    ans = []
    for i in res:
        ans.append(i[0])
    return ans

print(solution(5, [2,1,2,6,2,4,3,3]))
print(solution(4, [4,4,4,4,4]))