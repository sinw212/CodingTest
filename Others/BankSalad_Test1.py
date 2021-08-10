def solution(arr):
    arr.sort()
    res = []
    res.append(arr[0])

    for i in range(1, len(arr)):
        if arr[i][0] > res[-1][1]:
            res.append(arr[i])
        else:
            if arr[i][1] > res[-1][1]:
                res[-1] = (res[-1][0], arr[i][1])
    return res

print(solution([(1,3), (5,8), (4,10), (20,25), (22,27)])) #[(1,3), (4,10) ,(20,27)]
print(solution([(1,3), (3,7), (4,9), (20, 24), (22, 28)])) #[(1,9), (20, 28)]