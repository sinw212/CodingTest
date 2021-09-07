def solution(strings, n):
    strings.sort()
    arr = []
    answer = []

    for i in range(len(strings)):
        arr.append([strings[i][n], i])
    arr.sort()

    for i in arr:
        answer.append(strings[i[1]])
    return answer
    # return sorted(strings, key=lambda x:x[n])

print(solution(["sun", "bed", "car"],1))
print(solution(["abce", "abcd", "cdx"],2))