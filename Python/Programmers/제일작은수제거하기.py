def solution(arr):
    arr.remove(min(arr))
    if len(arr) == 0:
        arr.append(-1)
    return arr

print(solution([4,3,2,1]))
print(solution([10]))