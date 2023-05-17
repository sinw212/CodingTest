def solution(n):
    res = ""
    while n > 0:
        res += str(n%3)
        n //= 3
        # n, mod = divmod(n,3)
        # res += str(mod)
    return int(res,3)

print(solution(45))
print(solution(125))