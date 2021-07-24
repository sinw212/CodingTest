from itertools import permutations
def solution(S, pattern):
    list_pattern = list(pattern)
    ptrn = set(list(map(''.join, permutations(list_pattern))))

    S = list(S)
    count = 0
    for i in ptrn:
        for j in range((len(S) - len(pattern)) + 1):
            if i == "".join(S[j:len(pattern) + j]):
                count += 1

    # count = 0
    # for i in range(len(S) - len(pattern) + 1):
    #     data = []
    #     for j in range(i, i + len(pattern)):
    #         data.append(S[j])
    #     if sorted(data) == sorted(list(pattern)):
    #         count += 1
    return count

#permutations 안쓰고 푸는 방법
# def solution(S, pattern):
#     count = 0
#     for i in range(len(S)-len(pattern)+1):
#         data = []
#         for j in range(i,i+len(pattern)):
#             data.append(S[j])
#         if sorted(data) == sorted(list(pattern)):
#             count += 1
#     return count

print(solution("tegsornamwaresomran","ransom")) #2
print(solution("wreawerewa","ware")) #4
print(solution("ababababababa","aabba")) #5
print(solution("abcde","edcba")) #1
print(solution("aabbccddee","abcde")) #0
print(solution("aaaaaa","a")) #6