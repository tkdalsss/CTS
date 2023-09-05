import sys
sys.setrecursionlimit(10**6)

result = 0
def solution(a, edges):
    if sum(a) != 0 : return -1

    n = len(a)
    graph = [[] for _ in range(n)]
    for node_a, node_b in edges:
        graph[node_a].append(node_b)
        graph[node_b].append(node_a)
    
    dfs(0, 0, graph, a)

    return result

def dfs(child, parent, graph, a):
    global result
    for c in graph[child]:
        if c != parent:
            dfs(c, child, graph, a)
    a[parent] += a[child]
    result += abs(a[child])

a = [-5, 0, 2, 1, 2]
edges = [[0,1],[3,4],[2,3],[0,3]]
print(solution(a, edges))