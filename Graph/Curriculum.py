from collections import deque
import copy

v = 5
indegree = [0] * (v+1)
graph = [[] for _ in range(v+1)]
time = [0] * (v+1)

for i in range(1, v+1):
    data = list(map(int, input().split()))
    time[i] = data[0] # 과목별 시간
    for x in data[1:-1]:
        indegree[i] += 1
        # i번째 과목을 듣기 위한 선수 과목 x 그래프 연결
        graph[x].append(i)
    
def topology_sort():
    # 알고리즘 수행 결과를 담을 리스트
    result = copy.deepcopy(time)
    q = deque()

    for i in range(1, v+1):
        if indegree[i] == 0:
            q.append(i)

    while q:
        now = q.popleft()

        for i in graph[now]:
            result[i] = max(result[i], result[now]+time[i])
            indegree[i] -= 1
            if indegree[i] == 0:
                q.append(i)

        for i in range(1, v+1):
            print(result[i])

topology_sort()