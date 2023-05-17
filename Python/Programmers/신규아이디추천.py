import re
def solution(new_id):
    n_new_id = []
    new_id = new_id.lower()
    new_id = re.sub('[^a-z0-9-_.]', '', new_id)
    if len(new_id) == 0:
        new_id = "a"
    else:
        if len(new_id) > 1:
            n_new_id.append(new_id[0])
            for i in range(1, len(new_id)):
                if new_id[i] == ".":
                    if new_id[i-1] != ".":
                        n_new_id.append(new_id[i])
                else:
                    n_new_id.append(new_id[i])
            new_id = "".join(n_new_id)

        if new_id[0] == ".":
            if len(new_id) <= 1:
                new_id = "a"
            else:
                new_id = new_id[1:len(new_id)]
        if new_id[len(new_id)-1] == ".":
            new_id = new_id[0:len(new_id)-1]

        if len(new_id) > 15:
            new_id = new_id[0:15]
            if new_id[len(new_id)-1] == ".":
                new_id = new_id[0:len(new_id)-1]

        if len(new_id) < 3:
            while len(new_id) < 3:
                new_id += new_id[len(new_id)-1:len(new_id)]
    return new_id

# import re
# def solution2(new_id):
#     st = new_id
#     st = st.lower()
#     st = re.sub('[^a-z0-9\-_.]', '', st)
#     st = re.sub('\.+', '.', st)
#     st = re.sub('^[.]|[.]$', '', st)
#     st = 'a' if len(st) == 0 else st[:15]
#     st = re.sub('^[.]|[.]$', '', st)
#     st = st if len(st) > 2 else st + "".join([st[-1] for i in range(3-len(st))])
#     return st

print(solution("...!@BaT#*..y.abcdefghijklm"))
print(solution("z-+.^."))
print(solution("=.="))
print(solution("123_.def"))
print(solution("abcdefghijklmn.p"))
print(solution("!@^("))

#1. 대문자 -> 소문자 치환
#2. 소문자,숫자,-,_,. 제외 문자 제거
#3. .가 2번 이상 연속되면 .으로 치환
#4. .이 맨 앞이나 뒤에 위치하면 제거
#5. 빈 문자열이면 "a" 대입
#6. 길이가 16자 이상이면 15자까지만 자르기. 제거했는데 맨 뒤가 .이면 제거
#7. 길이가 2자 이하면 마지막문자를 길이가 3될때까지 반복