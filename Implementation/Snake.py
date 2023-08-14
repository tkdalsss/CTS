n = int(input()) # board
k = int(input()) # apple
data = [[0] * (n+1) for _ in range(n+1)] # map
info = [] # direction rotation info

# apple location
for _ in range(k):
    a, b = map(int, input().split())
    data[a][b] = 1 

# rotation
l = int(input()) 
for _ in range(l):
    x, c = input().split()
    info.append((int(x), c))

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

def turn(direction, c): # 방향 전환은 L 또는 D
    if c == 'L':
        direction = (direction-1) % 4
    else:
        direction = (direction+1) % 4
    return direction

def simulate():
    x, y = 1, 1 # -> map이 n+1 * n+1 배열
    data[x][y] = 2
    direction = 0 # 출발 방향 오른쪽 (동쪽)
    time = 0 # 총 걸린 시간 체크
    index = 0 # 방향 회전 횟수 체크
    q = [(x, y)] # 뱀 꼬리 정보
    while True:
        nx = x + dx[direction]
        ny = y + dy[direction]
        if 1 <= nx and nx <= n and 1 <= ny and ny <= n and data[nx][ny] != 2:
            if data[nx][ny] == 0: # 사과없을 때
                data[nx][ny] = 2 # 뱀 머리 위치
                q.append((nx, ny)) # 몸통 붙이기
                # 꼬리 떼기
                px, py = q.pop(0) 
                data[px][py] = 0
            if data[nx][ny] == 1: # 사과있을 때
                data[nx][ny] = 2 # 뱀 머리위치 이동시킥고
                q.append((nx, ny)) # 뱀 길이 늘리기
        else: # 게임이 종료된 경우
            time += 1
            break
        x, y = nx, ny # 다음 좌표 지정
        time += 1

        if index < l and time == info[index][0]:
            direction = turn(direction, info[index][1])
            index += 1
    
    return time

print(simulate())