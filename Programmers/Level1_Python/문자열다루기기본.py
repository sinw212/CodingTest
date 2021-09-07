def solution(s):
    # if len(s)==4 or len(s)==6:
    #     if s.isdecimal():
    #         return True
    #     else:
    #         return False
    # else:
    #     return False
    return s.isdecimal() and len(s) in (4,6)

print(solution("a234"))
print(solution("12345")) 
print(solution("1234"))