import sys
from collections import deque

input = sys.stdin.readline
# n개의 나라, L < 인구 차이 < R
n, l, r = map(int, input().split())

graph = []
for _ in range(n):
    graph.append(list(map(int, input().split())))

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]
result = 0

def process(x, y, index):
    united = []
    united.append((x, y))

    q = deque()
    q.append((x, y))
    union[x][y] = index
    summary = graph[x][y] # 현재 연합 전체 인구 수
    count = 1 # 현재 연합 국가 개수

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < n and union[nx][ny] == -1:
                if l <= abs(graph[nx][ny] - graph[x][y]) <= r:
                    q.append((nx, ny))
                    # 얀합 추가
                    union[nx][ny] = index
                    summary += graph[nx][ny] # 인구 수 추가
                    count += 1
                    united.append((nx, ny)) # 연합국가 좌표 추가
    
    for i, j in united:
        graph[i][j] = summary // count
    
    return count

total_count = 0

# 인구 이동을 더이상 할 수 없을 때까지 반복
while True:
    union = [[-1] * n for _ in range(n)] # n * n index 배열
    index = 0
    for i in range(n):
        for j in range(n):
            if union[i][j] == -1: # 해당 나라가 아직 처리되지 않았다면
                # print(process(i, j, index))
                process(i, j, index)
                index += 1
    if index == n*n:
        break
    total_count += 1

# print(union)
print(total_count)