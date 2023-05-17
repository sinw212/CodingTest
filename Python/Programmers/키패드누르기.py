def solution(numbers, hand):
    answer = ''
    dict = {1: (0, 0), 2: (0, 1), 3: (0, 2), 4: (1, 0), 5: (1, 1), 6: (1, 2), 7: (2, 0), 8: (2, 1), 9: (2, 2), '*': (3, 0), 0: (3, 1), '#': (3, 2)}
    L_hand, R_hand = '*', '#'

    for i in range(len(numbers)):
        L_distance = abs(dict.get(numbers[i])[0] - dict.get(L_hand)[0]) + abs(dict.get(numbers[i])[1] - dict.get(L_hand)[1])
        R_distance = abs(dict.get(numbers[i])[0] - dict.get(R_hand)[0]) + abs(dict.get(numbers[i])[1] - dict.get(R_hand)[1])
        if numbers[i]==1 or numbers[i]==4 or numbers[i]==7:
            L_hand = numbers[i]
            answer += 'L'
        elif numbers[i]==3 or numbers[i]==6 or numbers[i]==9:
            R_hand = numbers[i]
            answer += 'R'
        elif numbers[i]==2 or numbers[i]==5 or numbers[i]==8 or numbers[i]==0:
            if L_distance < R_distance:
                L_hand = numbers[i]
                answer += "L"
            elif L_distance > R_distance:
                R_hand = numbers[i]
                answer += "R"
            elif L_distance == R_distance:
                if hand=="left":
                    L_hand = numbers[i]
                    answer += "L"
                elif hand=="right":
                    R_hand = numbers[i]
                    answer += "R"
    return answer