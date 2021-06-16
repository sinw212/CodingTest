def solution(n, arr1, arr2):
    answer = []
    res = []
    for i in range(len(arr1)):
        answer.append(format((arr1[i] | arr2[i]), 'b').zfill(n))

    for i in answer:
        i = i.replace("1", "#")
        i = i.replace("0", " ")
        res.append(i)
    return res

print(solution(5, [9,20,28,18,11], [30,1,21,17,28]))
print(solution(6, [46,33,33,22,31,50], [27,56,19,14,14,10]))
