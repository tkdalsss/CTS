import sys
from collections import deque
input = sys.stdin.readline

n, k = map(int, input().split())
graph = []
data = []

for i in range(n):
    graph.append(list(map(int, input().split())))
    for j in range(n):
        if graph[i][j] != 0:
            # 바이러스 번호, 시간, x, y
            data.append((graph[i][j], 0, i, j))

data.sort()
q = deque(data)

# s초 뒤에 (x,y)에 있는 바이러스 반환
target_s, target_x, target_y = map(int, input().split())

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

while q:
    virus, time, x, y = q.popleft()
    if time == target_s:
        break
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx >= 0 and nx < n and ny >= 0 and ny < n:
            if graph[nx][ny] == 0:
                graph[nx][ny] = virus
                q.append((virus, time+1, nx, ny))

print(graph[target_x-1][target_y-1])