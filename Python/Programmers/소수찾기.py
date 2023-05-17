from math import sqrt

def solution(n):
    arr = [True] * (n+1)
    arr[0], arr[1] = False, False

    for i in range(2, int(sqrt(n))+1):
        if arr[i] == True:
            j = 2
            while True:
                if (i*j) > n:
                    break
                arr[i*j] = False
                j += 1

    count = 0
    for i in range(len(arr)):
        if arr[i]==True:
            count += 1
    return count

print(solution(10))
print(solution(5))