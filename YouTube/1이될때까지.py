#방법1
n = int(input())
k = int(input())
count = 0

while n>1:
    if n%k==0:
        n = n // k
    else:
        n -= 1
    count += 1
print(count)

#방법2 (답안 예시)
n, k = map(int, input().split())
result = 0

while True:
    #N이 K로 나누어 떨어지는 가장 가까운 수가 뭔지 예측하는 방법
    target = (n // k) * k
    result += (n - target)
    n = target
    #N이 K보다 작을 때 (더이상 나눌 수 없을 때) 반복문 탈출
    if n < k:
        break
    result += 1
    n //= k
result += (n - 1)
print(result)