v, e = 7, 12
parent = [0] * (v+1)
edges = [
    [1, 2, 3],
    [1, 3, 2],
    [3, 2, 1],
    [2, 5, 2],
    [3, 4, 4],
    [7, 3, 6],
    [5, 1, 5],
    [1, 6, 2],
    [6, 4, 1],
    [6, 5, 3],
    [4, 5, 3],
    [6, 7, 4]
]
result = 0
last = 0 # 최소 신장 트리를 찾은 뒤에 가장 큰 간선을 제거

# 부모 테이블 초기화
for i in range(v+1):
    parent[i] = i

def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

edges.sort(key = lambda x : x[2]) # 정렬해서 맨 마지막 간선의 비용을 제거
# print(edges)

for edge in edges:
    a, b, cost = edge
    if find_parent(parent, a) != find_parent(parent, b):
        union_parent(parent, a, b)
        result += cost
        last = cost

print(result - last)