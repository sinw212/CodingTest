from itertools import product
def solution(word):
    alph = ['A', 'E', 'I', 'O', 'U']
    list_alph = []
    for i in range(1,len(alph)+1):
        list_alph.append(list(map(''.join, product(alph, repeat = i))))

    list_alph = list_alph[0] + list_alph[1] + list_alph[2] + list_alph[3] + list_alph[4]
    list_alph.sort()

    for i in range(len(list_alph)):
        if list_alph[i] == word:
            return i+1

print(solution("AAAAE")) #6
print(solution("AAAE")) #10
print(solution("I")) #1563
print(solution("EIO")) #1189