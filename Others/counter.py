def solution(N, A):
    dataset = [0] * N
    for i in A:
        if i == N+1:
            dataset = [max(dataset)] * N
        else:
            dataset[i-1] += 1
    return dataset

#시간복잡도 66퍼
print(solution(5, [3,4,4,6,1,4,4]))

def solution2(N, A):
    answer = [0] * N
    max = 0
    for i in A:
        if i == N+1:
            answer = [max] * N
        else:
            answer[i-1] += 1
            if max < answer[i-1]:
                max = answer[i-1]
    return answer

#시간복잡도 7X퍼
print(solution2(5, [3,4,4,6,1,4,4]))