# 프로그래머스 징검다리
def solution(distance, rocks, n):
    answer = 0
    left, right = 0, distance
    rocks.append(distance)
    rocks.sort()

    while left <= right:
        mid = (left + right) // 2
        current, remove = 0, 0
        min_distance = 1e9

        for rock in rocks:
            dis = rock - current
            if dis < mid:
                remove += 1
            else:
                current = rock
                min_distance = min(min_distance, dis)
        
        if remove > n:
            right = mid - 1
        else:
            left = mid + 1
            answer = min_distance

    return answer

rocks = [2, 14, 11, 21, 17]	
print(solution(25, rocks, 2))