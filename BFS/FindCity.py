from collections import deque

# n = 도시 개수, m = 도로 개수, k = 최단 거리, x = 출발도시번호
n, m, k, x = map(int, input().split())
citymap = [[] for _ in range(n+1)]

for _ in range(m):
    a, b = map(int, input().split())
    citymap[a].append(b)

distance = [-1] * (n+1)
distance[x] = 0
q = deque([x]) # 출발 도시 추가

while q:
    now = q.popleft()
    for go in citymap[now]:
        if distance[go] == -1:
            distance[go] = distance[now] + 1
            q.append(go)

check = False
for i in range(1, n+1):
    if distance[i] == k:
        print(i)
        check = True

if check == False:
    print(-1)