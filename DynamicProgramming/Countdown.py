INF = 1e9

# arr[0]은 싱글, 불로 만들 수 있는 점수
# arr[1]은 싱글, 불로 만들 수 없는 점수
def create_table():
    arr = []
    arr.append([i for i in range(1, 21)])
    arr[0].append(50)
    nxt = []

    for i in range(1, 21):
        for j in range(2, 4):
            ret = i * j
            if ret > 20: # 싱글로 만들 수 없으면
                nxt.append(ret)
    
    arr.append(list(set(nxt)))
    return arr

# print(create_table())
def solution(target):
    table = create_table()

    dp = [[INF, 0] for _ in range(target+1)]
    dp[0][0] = 0

    for i in range(1, target+1):
        for j in range(2):
            for k in range(len(table[j])):
                prev = i - table[j][k]

                if prev < 0: continue

                # 총 횟수, 싱글 혹은 불을 최대로 사용하는 횟수
                total, valid = dp[prev][0] + 1, dp[prev][1] + 1 - j # 싱글 또는 불로 만드는 경우가 아니라면 -1

                if total < dp[i][0]:
                    dp[i] = [total, valid]
                elif total == dp[i][0]:
                    dp[i] = [total, max(dp[i][1], valid)]
    
    return dp[target]

print(solution(58))