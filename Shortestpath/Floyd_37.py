import sys
input = sys.stdin.readline

n = int(input())
m = int(input())
# graph = []

graph = [[1e9] * (n+1) for _ in range(n+1)]

for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a][b] = c

for k in range(1, n+1):
    for i in range(1, n+1):
        for j in range(1, n+1):
            if i == j:
                graph[i][j] = 0
            graph[i][j] = min(graph[i][j], graph[i][k]+graph[k][j])

for i in range(1, n+1):
    x, a, b, c, d, e = graph[i]
    print(a, b, c, d, e)

# print(graph)