# input map row & column
n, m = map(int, input().split())

# visited check
d = [[0] * m for _ in range(n)]
x, y, direction = map(int, input().split())
d[x][y] = 1
# create map
array = []
for i in range(n):
    array.append(list(map(int, input().split())))

# direction -> 0
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def turn_left():
    global direction
    direction -= 1
    if direction == -1:
        direction = 3

count = 1
turn_time = 0 # 네방향 모두 갈 수 없는 경우를 위한 cnt

while True:
    turn_left() # 왼쪽으로 방향 돌리기
    nx = x + dx[direction]
    ny = y + dy[direction]

    # 방문하지 않았거나 육지인 경우 이동
    if d[nx][ny] == 0 and array[nx][ny] == 0:
        d[nx][ny] = 1 # visit check
        x, y = nx, ny
        count += 1
        turn_time = 0 # initialization
        continue
    else:
        turn_time += 1
    
    # 네 방향 모두 갈 수 없는 경우
    if turn_time == 4:
        nx = x - dx[direction]
        ny = y - dx[direction]
        
        # 뒤로 갈 수 있으면 이동
        if array[nx][ny] == 0:
            x = nx
            y = ny
        # 뒤가 바다로 막혀있는 경우
        else:            
            break

        turn_time = 0

print(count)