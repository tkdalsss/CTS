from collections import deque

map = [
    [1,0,1,0,1,0],
    [1,1,1,1,1,1],
    [0,0,0,0,0,1],
    [1,1,1,1,1,1],
    [1,1,1,1,1,1]
]

def bfs(map, i, j, n, m):

    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    queue = deque()
    queue.append((i, j))

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or ny < 0 or nx >= n or ny >= m :
                continue

            if map[nx][ny] == 0: 
                continue

            if map[nx][ny] == 1 :
                map[nx][ny] = map[x][y] + 1
                queue.append((nx, ny))

    return map[n-1][m-1]

print(bfs(map, 0, 0, 5, 6))

