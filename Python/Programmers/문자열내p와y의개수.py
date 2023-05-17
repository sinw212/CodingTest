def solution(s):
    # count_p, count_y = 0, 0
    # s = list(s.lower())
    # for i in s:
    #     if i=='p':
    #         count_p += 1
    #     elif i=='y':
    #         count_y += 1
    # return True if count_p==count_y else False
    return s.lower().count('p') == s.lower().count('y')

print(solution("pPoooyY"))
print(solution("Pyy"))