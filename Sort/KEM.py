# 국어점수는 내림차순, 영어는 오름차순, 수학은 내림차순 정렬 -> 한번에
import sys
input = sys.stdin.readline

n = int(input())
data = []
for _ in range(n):
    data.append(input().split())

data.sort(key = lambda x : (-int(x[1]), int(x[2]), -int(x[3]), x[0]))

for i in data:
    print(i[0])