arr = [2, 3]
def solution(x, arr):
    d = [10001] * (x+1)
    d[0] = 0

    for i in range(len(arr)):
        for j in range(arr[i], x+1):
            if d[j-arr[i]] != 10001:
                d[j] = min(d[j], d[j-arr[i]]+1)

    if d[x] == 10001: return -1
    else: return d[x]

print(solution(15, arr))