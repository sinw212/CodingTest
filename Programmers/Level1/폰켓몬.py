def solution(nums):
    return len(set(nums)) if len(set(nums)) <= int(len(nums)/2) else int(len(nums)/2)

print(solution([3,1,2,3])) #2
print(solution([3,3,3,2,2,4])) #3
print(solution([3,3,3,2,2,2])) #2