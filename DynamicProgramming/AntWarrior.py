arr = [1,3,1,5]
def solution(x, arr):
    d = [0] * 100 # 1 <= n <= 100

    d[0] = arr[0]
    d[1] = max(arr[0], arr[1])

    for i in range(2, x):
        d[i] = max(d[i-1], d[i-2] + arr[i])

    return d[x-1]

print(solution(4, arr))