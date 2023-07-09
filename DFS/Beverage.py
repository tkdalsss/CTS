map = [
    [0,0,1,1,0],
    [0,0,0,1,1],
    [1,1,1,1,1],
    [0,0,0,0,0]
]

def solution(map, n, m):
    
    result = 0

    def dfs(x, y):

        if x < 0 or x >= n or y < 0 or y >= m :
            return False
        
        if map[x][y] == 0:

            map[x][y] = 1
            dfs(x, y+1)
            dfs(x, y-1)
            dfs(x+1, y)
            dfs(x-1, y)
            
            return True
        
        return False
        
    
    for i in range(n):
        for j in range(m):
            if dfs(i, j) == True:
                result += 1

    return result

print(solution(map, 4, 5))