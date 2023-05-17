def solution(table, languages, preference):
    arr, res = [], []
    for i in table:
        arr = []
        reversedList = list(reversed(i.split(" ")))

        for j in range(len(languages)):
            if languages[j] not in reversedList:
                arr.append(0)
            else:
                arr.append(preference[j] * (reversedList.index(languages[j])+1))
        res.append(arr)
    ans = []
    for i in res:
        ans.append(sum(i))

    dict = []
    if ans.count(max(ans)) == 1:
        return list(table[ans.index(max(ans))].split(" "))[0]
    else:
        for i in range(len(ans)):
            if ans[i] == max(ans):
                dict.append(list(table[i].split(" "))[0])
        dict.sort()
        return dict[0]

print(solution(["SI sumJAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
                "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP",
                "GAME C++ C# JAVASCRIPT C JAVA"], ["PYTHON", "C++", "SQL"], [7, 5, 5])) #HARDWARE
print(solution(["SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
                "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP",
                "GAME C++ C# JAVASCRIPT C JAVA"], ["JAVA", "JAVASCRIPT"], [7, 5])) #PORTAL