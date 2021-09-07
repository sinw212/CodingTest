def solution(dartResult):
    arr, res, ans = [], [], []
    for i in dartResult:
        if i.isdigit():
            arr.append(i)
        elif i.isalpha():
            res.append((int(''.join(arr)))**1) if i == 'S' else res.append((int(''.join(arr)))**2) if i == 'D' else res.append((int(''.join(arr)))**3)
            arr = []
        else:
            res.append(i)

    for i in range(len(res)):
        if res[i] == '*':
            if i == 1:
                res[0] = res[0]*2
            else:
                res[i-1] = res[i-1]*2
                if res[i-2] == '*' or res[i-2] == '#':
                    res[i-3] = res[i-3]*2
                else:
                    res[i-2] = res[i-2]*2
        if res[i] == '#':
            res[i-1] = res[i-1]*(-1)

    for i in res:
        if i != '*' and i != '#':
            ans.append(i)

    return sum(ans)

print(solution("1S2D*3T")) #37
print(solution("1D2S#10S")) #9
print(solution("1D2S0T")) #3
print(solution("1S*2T*3S")) #23
print(solution("1D#2S*3S")) #5
print(solution("1T2D3D#")) #-4
print(solution("1D2S3T*")) #59

#S(ingle)^1, D(ouble)^2, T(riple)^3
#*:해당점수와 바로전에 얻은 점수 각2배 / #:해당점수 마이너스
#*이 첫번째 올경우, 첫번째점수만 2배
#*이 중첩될경우, 해당 점수는 4배
#*와 #가 중첩될 경우, -2배