def solution(x):
    d = [0] * 1001

    d[1] = 1
    d[2] = 3

    for i in range(2, x+1):
        # i-1까지하고 남은 공간은 한가지의 경우로 채워질 수 있음
        # i-2까지하고 남은 공간은 두가지의 경우로 채워질 수 있음
        d[i] = (d[i-1] + 2*d[i-2]) % 796796
    
    return d[x]

print(solution(3))