def solution(board, moves):
    bucket = []
    for i in moves:
        for j in board:
            if j[i-1] != 0:
                bucket.append(j[i-1])
                j[i-1] = 0
                break
    count = 0
    i = 1
    while i < len(bucket):
        if bucket[i] == bucket[i-1]:
            count += 2
            del(bucket[i])
            del(bucket[i-1])
            i = 1
        else:
            i += 1
    return count

print(solution([[0,0,0,0,0], [0,0,1,0,3], [0,2,5,0,1], [4,2,4,4,2], [3,5,1,3,1]], [1,5,3,5,1,2,1,4])) #4
print(solution([[0,1,1], [1,1,1], [1,1,1]], [2,3,1,3,2,3]))