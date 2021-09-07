def solution(n):
    arr = []
    arr.append(0)
    arr.append(1)

    while len(arr) <= n:
        arr.append(arr[-1] + arr[-2])

    return arr[-1] % 1234567

    # a,b = 0,1
    # for i in range(num):
    #     a,b = b,a+b
    # return a

print(solution(3)) #2
print(solution(5)) #5
