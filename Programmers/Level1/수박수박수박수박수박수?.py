def solution(n):
    return ('수박' * n)[0:n]
    # if n%2==0:
    #     s = '수박' * (n//2)
    # else:
    #     s = ('수박' * (n//2)) + '수'
    # return s

print(solution(3))
print(solution(4))