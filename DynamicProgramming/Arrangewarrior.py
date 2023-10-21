# 백준 병사 배치하기
import sys
input = sys.stdin.readline

n = int(input())
warriors = list(map(int, input().split()))
warriors.reverse()

dp = [1] * n

for i in range(1, n):
    for j in range(0, i):
        if warriors[j] < warriors[i]:
            dp[i] = max(dp[i], dp[j]+1)

print(n - max(dp))