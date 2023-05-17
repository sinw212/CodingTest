# def solution(n):
#     answer = 0
#     num = 0
#     while True:
#         if num == n:
#             break
#         num += 1
#         if n%num == 0:
#             answer += num
#     return answer

def solution(n):
    answer = 0
    for i in range(1, n+1):
        if n%i==0:
            answer += i
    return answer

print(solution(12))
print(solution(5))