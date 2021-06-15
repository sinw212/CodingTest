def solution(s):
    return "".join(sorted(s, reverse=True))
    # return "".join(sorted(sorted(s, reverse=True), key=lambda x:x.islower(), reverse=True))

print(solution("Zbcdefg"))