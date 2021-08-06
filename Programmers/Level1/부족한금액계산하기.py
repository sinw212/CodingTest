def solution(price, money, count):
    sum = 0
    for i in range(count):
        sum += (i+1)
    return 0 if price*sum < money else (price*sum)-money

print(solution(3, 20, 4)) #10