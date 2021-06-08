#코드포스(Codeforces) http://www.codeforces.com
#탑코더(TopCoder) https://www.topcoder.com
#릿코드(LeetCode) https://leetcode.com
#코드셰프(CODECHEF) https://www.codechef.com
#백준 온라인 저지(BOJ) https://www.acmicpc.net
#코드업(CodeUp) https://codeup.kr
#프로그래머스(Programmers) https://programmers.co.kr
#SW Expert Academy https://swexpertacademy.com

#리플릿(코테 준비 사이트) https://repl.it/languages/python3
#파이썬 튜터 http://pythontutor.com/visualize.html
#코드 라이브러리화 팀 노트 예시 https://github.com/ndb796/Python-Competitive-Programming-Team-Notes

#가장 출제 빈도 높은 알고리즘 유형 : 그리디, 구현, BFS/DFS, 정렬 등

#알고리즘 성능 평가 : 복잡도(시간복잡도_수행시간분석/공간복잡도_메모리사용량분석)

#코테 시간제한은 통상 1~5초 가량인 점 유의
#시간 초과 혹은 메모리 초과가 발생한다면 PyPy로 제출해볼것

#N의 범위가 500인 경우 : 시간 복잡도 O(N^3)인 알고리즘 설계
#N의 범위가 2,000인 경우 : 시간 복잡도 O(N^2)인 알고리즘 설계
#N의 범위가 100,000인 경우 : 시간 복잡도 O(NlogN)인 알고리즘 설계
#N의 범위가 10,000,000인 경우 : 시간 복잡도 O(N)인 알고리즘 설계

#수행시간 측정 소스코드
import time
start_time = time.time() #측정 시작
#프로그램 소스코드
end_time = time.time()
print("time : ", end_time - start_time) #수행 시간 출력

#키 데이터만 뽑아서 리스트로 이용 : keys()함수
#값 데이터만 뽑아서 리스트로 이용 : values()함수

#실전에서 유용한 표준 라이브러리
#내장함수 : 기본 입출력 함수부터 정렬 함수까지 기본적인 함수 제공
#itertools : 파이썬에서 반복되는 형태의 데이터를 처리하기 위한 유용한 기능 제공 (순열과 조합 라이브러리)
#heapq : 힙 자료구조 제공 (우선순위 큐 기능 구현을 위해 사용)
#bisect : 이진 탐색 기능 제공
#collections : 덱, 카운터 등의 유용한 자료구조 포함
#math : 필수적인 수학적 기능 제공 (팩토리얼, 제곱근, 최대공약수, 삼각함수 관련 함수부터 파이같은 상수 포함)