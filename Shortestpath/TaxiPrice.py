# 프로그래머스 합승택시요금 - 2021 카카오 
# 플로이드-와샬
def solution (n, s, a, b, fares):
    answer = 1e9
    cost = [[1e9] * (n+1) for _ in range(n+1)]

    def floyd_warshall():
        for k in range(1, n+1):
            for i in range(1, n+1):
                for j in range(1, n+1):
                    if i == j:
                        cost[i][j] = 0
                    else:
                        cost[i][j] = min(cost[i][k] + cost[k][j], cost[i][j])
    
    for i, j, c in fares:
        print(i, j)
        cost[i][j] = c
        cost[j][i] = c
    floyd_warshall()

    for i in range(1, n+1):
        answer = min(cost[s][i] + cost[i][a] + cost[i][b], answer)
    
    return answer

fares = [
    [4, 1, 10], [3, 5, 24], [5, 6, 2], [3, 1, 41], [5, 1, 24], [4, 6, 50], [2, 4, 66], [2, 3, 22], [1, 6, 25]
]
print(solution(6, 4, 6, 2, fares))