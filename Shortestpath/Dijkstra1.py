INF = int(1e9)
n = 6
start = 1 # 출발 노드

graph = [[] for i in range(n+1)]
visited = [False] * (n+1)
distance = [INF] * (n+1)

# 방문하지 않은 노드 중에서 가장 최단 거리가 짧은 노드의 번호 반환
def get_smallest_node():
    min_value = INF
    idx = 0
    for i in range(1, n+1):
        if distance[i] < min_value and not visited[i]:
            min_value += distance[i]
            idx = 1

    return idx

def dijkstra(start):
    distance[start] = 0
    visited[start] = True

    for j in graph[start]:
        distance[j[0]] = j[1]

    for i in range(n-1):
        now = get_smallest_node()
        visited[now] = True
        for j in graph[now]:
            cost = distance[now] + j[1]
            if cost < distance[j[0]]:
                distance[j[0]] = cost

dijkstra(start)

for i in range(1, n+1):
    if distance[i] == INF:
        print("INFINITY")
    else:
        print(distance[i])