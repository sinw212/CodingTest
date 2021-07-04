def solution(letters, k):
    letters = list(letters)
    sort_letters = list(letters)
    sort_letters.sort(reverse=True)

    count = k
    answer = []
    i, j = 0, 0
    while count != 0:
        if sort_letters[i] == letters[j]:
            if j <= len(letters)-count:
                answer.append(letters[j])
                count -= 1
                del[sort_letters[i]]
                i = 0
            else:
                i += 1
            j = 0
        else:
            j += 1

    return "".join(answer)

print(solution("zbgaj", 3)) #zgj
# print(solution("bgazj", 3)) #gzj