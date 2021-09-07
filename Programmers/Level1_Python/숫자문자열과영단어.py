def solution(s):
    dict = {"zero":"0", "one":"1", "two":"2", "three":"3", "four":"4",
            "five":"5", "six":"6", "seven":"7", "eight":"8", "nine":"9"}

    # for key, value in dict.items():
    #     s = s.replace(key, value)
    # return int(s)
    res = []
    alpha = ""

    for i in s:
        if i.isdigit():
            res.append(i)
        else: #i.isalpha()
            alpha += i
            if alpha in dict:
                res.append(dict[alpha])
                alpha = ""
    return int("".join(res))

# def solution(s):
#     words = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine']
#     for i in range(len(words)):
#         s = s.replace(words[i], str(i))
#     return s

print(solution("one4seveneight")) #1478
print(solution("23four5six7")) #234567
print(solution("2three45sixseven")) #234567
print(solution("123")) #123