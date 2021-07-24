import sys
input = sys.stdin.readline

def dfs(graph, root):
    visit = []
    stack = [root]

    while stack:
        node = stack.pop()
        if node not in visit:
            visit.append(node)
            if node in graph:
                stack.extend(graph[node])
    return visit

computer = int(input())
network = int(input())

graph = {}
for i in range(network):
    a, b = list(map(int, input().split()))
    if a in graph:
        graph[a].append(b)
    else:
        graph[a] = [b]

    if b in graph:
        graph[b].append(a)
    else:
        graph[b] = [a]

print((len(dfs(graph, 1)))-1)