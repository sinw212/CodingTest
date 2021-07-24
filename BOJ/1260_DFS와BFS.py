import sys
from collections import deque
input = sys.stdin.readline

def dfs(graph, root):
    visit = []
    stack = [root]
    while stack:
        node = stack.pop()
        if node not in visit:
            visit.append(node)
            if node in graph:
                stack.extend(reversed(graph[node]))
    return visit

# def dfs(graph, root, visit=[]): #재귀
#     visit.append(root)
#
#     for node in graph[root]:
#         if node not in visit:
#             dfs(graph, node, visit)
#     return visit

def bfs(graph, root):
    visit = []
    queue = deque([root])
    while queue:
        node = queue.popleft()
        if node not in visit:
            visit.append(node)
            if node in graph:
                queue.extend(graph[node])
    return visit

n, m, v = list(map(int, input().split(" "))) #n : 정점의 개수 / m : 간선의 개수 / v : 탐색을 시작할 정점의 번호
graph = {}
for i in range(m):
    a, b = list(map(int, input().split(" ")))
    if a in graph:
        graph[a].append(b)
    else:
        graph[a] = [b]

    if b in graph:
        graph[b].append(a)
    else:
        graph[b] = [a]

    graph[a].sort()
    graph[b].sort()
# print(graph) #{5: [4, 2], 4: [5, 3], 2: [5, 1], 1: [2, 3], 3: [4, 1]}

print(" ".join(map(str,dfs(graph, v))))
print(" ".join(map(str,bfs(graph, v))))