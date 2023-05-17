import sys
input = sys.stdin.readline
sys.setrecursionlimit(10000)

def dfs(x, y):
    dx = [0, 0, -1, 1] #상하좌우
    dy = [1, -1, 0, 0] #상하좌우

    for i in range(4): #상하좌우 4번
        ax = x + dx[i]
        ay = y + dy[i]

        if (0 <= ax < m) and (0 <= ay < n):
            if arr[ax][ay] == 1:
                arr[ax][ay] = -1
                dfs(ax, ay)

test = int(input())
for _ in range(test):
    n, m, k = list(map(int, input().split()))
    arr = [[0]*n for _ in range(m)]
    count = 0
    for _ in range(k):
        a, b = list(map(int, input().split()))
        arr[b][a] = 1 #(x,y) = arr[y][x]

    for i in range(m):
        for j in range(n):
            if arr[i][j] > 0:
                dfs(i,j)
                count += 1
    print(str(count))