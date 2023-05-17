def solution(s):
    s = s.split(' ')
    answer = []
    for i in s:
        for j in range(len(i)):
            if j%2==0:
                answer.append(i[j].upper())
            else:
                answer.append(i[j].lower())
        answer.append(' ')
    return "".join(answer[:-1])

print(solution("try hello world"))
print(solution("I WANT you"))