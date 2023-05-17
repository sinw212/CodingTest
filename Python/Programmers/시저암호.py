def solution(s, n):
    s = list(s)
    for i in range(len(s)):
        if s[i].isupper():
            if (ord(s[i])+n) > 90:
                s[i] = chr(65+((ord(s[i])+n)-91))
            else:
                s[i] = chr(ord(s[i])+n)
        elif s[i].islower():
            if (ord(s[i])+n) > 122:
                s[i] = chr(97+((ord(s[i])+n)-123))
            else:
                s[i] = chr(ord(s[i])+n)
    return "".join(s)

print(solution("AB", 1))
print(solution("z", 1))
print(solution("a B z", 4))

# print(ord('A')) #65
# print(ord('Z')) #90
# print(ord('a')) #97
# print(ord('z')) #122