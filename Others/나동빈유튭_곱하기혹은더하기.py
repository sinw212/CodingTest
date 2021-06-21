#방법1
s = list(map(int, input()))
answer = s[0]

for i in range(len(s) - 1):
    if answer == 0 or s[i + 1] == 0:
        answer += s[i + 1]
    else:
        answer *= s[i + 1]

print(answer)

#방법2 (답안 예시)
data = input()
result = int(data[0])

for i in range(1, len(data)):
    num = int(data[i])
    if num <= 1 or result <= 1:
        result += num
    else:
        result *= num

print(result)