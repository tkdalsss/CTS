import sys
input = sys.stdin.readline

n = int(input())
data = list(map(int, input().split()))

add, sub, mul, div = map(int, input().split())

min_value = 1e9
max_value = -1e9

def dfs(i, now, add, sub, mul, div):
    global min_value, max_value
    if i == n:
        min_value = min(min_value, now)
        max_value = max(max_value, now)
        return
    
    if add > 0: dfs(i+1, now+data[i], add-1, sub, mul, div)
    if sub > 0: dfs(i+1, now-data[i], add, sub-1, mul, div)
    if mul > 0: dfs(i+1, now*data[i], add, sub, mul-1, div)
    if div > 0: dfs(i+1, int(now/data[i]), add, sub, mul, div-1)
        
dfs(1, data[0], add, sub, mul, div)
print(max_value)
print(min_value)