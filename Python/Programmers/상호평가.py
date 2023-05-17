def solution(scores):
    arr, res, ans = [], [], []
    for i in range(len(scores)):
        for j in range(len(scores)):
            arr.append(scores[j][i])
        res.append(arr)
        arr = []

    for i in range(len(res)):
        if (max(res[i]) <= res[i][i] and res[i].count(res[i][i]) == 1) or (min(res[i]) >= res[i][i] and res[i].count(res[i][i]) == 1):
            del(res[i][i])
        avg = sum(res[i]) / len(res[i])
        ans.append('A') if avg >= 90 else ans.append('B') if avg >= 80 else ans.append('C') if avg >= 70 else ans.append('D') if avg >= 50 else ans.append('F')

    return ''.join(ans)

print(solution([[100, 90, 98, 88, 65], [50, 45, 99, 85, 77], [47, 88, 95, 80, 67], [61, 57, 100, 80, 65], [24, 90, 94, 75, 65]])) #FBABD
print(solution([[50, 90], [50, 87]])) #DA
print(solution([[70, 49, 90], [68, 50, 38], [73, 31, 100]])) #CFD