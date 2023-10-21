import sys
input = sys.stdin.readline
n, c = list(map(int, input().split()))

house = []
for _ in range(n):
    house.append(int(input()))
house.sort()

start = house[1] - house[0] # 집의 좌표 중에 가장 작은 값
end = house[-1] - house[0] # 집의 좌표 중에 가장 큰 값
result = 0

while start <= end:
    # mid는 가장 인접한 두 공유기 사이의 거리(gap)를 의미
    mid = (start + end) // 2
    value = house[0]
    cnt = 1

    # 현재의 mid값을 이용해 공유기 설치
    for i in range(1, n): # 앞에서부터 설치
        if house[i] >= value + mid:
            value = house[i]
            cnt += 1
    
    if cnt >= c: # C개 이상의 공유기를 설치할 수 있는 경우 거리 증가
        start = mid + 1
        result = mid # 최적의 결과를 저장
    else:
        end = mid - 1

print(result)