def solution(s,c):
    name = []
    email = []
    res = []
    s_name = s.split(", ")
    c = c.lower()

    for i in s_name:
        i = i.replace("-", "").capitalize()
        name.append(i.split(" "))

    for i in name:
        email.append(str(i[0]) + '.' + str(i[len(i)-1]))

    count = 3
    for i in range(len(email)):
        for j in range(i):
            if email[i] == email[j]:
                if (email[i][len(email[i])-1]).isnumeric():
                    email[i] = email[i].replace(email[i], email[i][0:len(email[i])-1] + str(count))
                    count += 1
                else:
                    email[i] = email[i].replace(email[i], email[i] + str("2"))
    print(email)

    for i in range(len(email)):
        res.append(s_name[i] + str(" <") + email[i] + str("@") + c + str(".com>"))
    return ", ".join(res)

print(solution("John Doe, Peter Benjamin Parker, Mary Jane Watson-Parker, John Elvis Doe, John Evan Doe, Jane Doe, Peter Brian Parker", "Example"))