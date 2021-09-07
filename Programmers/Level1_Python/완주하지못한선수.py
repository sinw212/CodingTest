# import collections
def solution(participant,  completion):
    # answer = collections.Counter(participant) - collections.Counter(completion)
    # return list(answer)[0]
    hash = {}
    for i in participant:
        if i in hash:
            hash[i] += 1
        else:
            hash[i] = 1

    for i in completion:
        if hash[i] == 1:
            del(hash[i])
        else:
            hash[i] -= 1

    return list(hash)[0]
    # return list(hash.items())[0][0]

print(solution(["leo", "kiki", "eden"],["eden", "kiki"]))
print(solution(["marina", "josipa", "nikola", "vinko", "filipa"], ["josipa", "filipa", "marina", "nikola"]))
print(solution(["mislav", "stanko", "mislav", "ana"], ["stanko", "ana", "mislav"]))