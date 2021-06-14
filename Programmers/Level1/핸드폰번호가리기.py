def solution(pn):
    # return len(pn[0:len(pn)-4])*'*' + pn[len(pn)-4:len(pn)]
    return (len(pn)-4) * '*' + pn[-4:]

print(solution("01033334444"))
print(solution("027778888"))