def solution(a,b):
    answer = ''
    days = ["FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"]
    day, month, date = 0, 1, 1

    while True:
        if month == a and date == b:
            break

        if month == 2:
            if date == 29:
                date = 0
                month += 1
        elif month==1 or month==3 or month==5 or month==7 or month==8 or month==10 or month==12:
            if date == 31:
                date = 0
                month += 1
        elif month==4 or month==6 or month==9 or month==11:
            if date == 30:
                date = 0
                month += 1

        if day == 6:
            day = -1

        date += 1
        day += 1
    answer = days[day]
    return answer

print('예상답1 : "TUE" / 실제답1 : ' + str(solution(5,24)))
print('예상답2 : "MON" / 실제답2 : ' + str(solution(2,29)))
print('예상답3 : "TUE" / 실제답3 : ' + str(solution(3,1)))