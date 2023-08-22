# 프로그래머스 야근 지수 / 최대힙
import heapq

def solution(n, works):
    answer = 0

    if n >= sum(works):
        return answer
    
    works = [-w for w in works]
    heapq.heapify(works)
    for _ in range(n):
        i = heapq.heappop(works)
        i += 1
        heapq.heappush(works, i)
    
    answer = sum([w ** 2 for w in works])
    return answer

# print(solution(4, [4,3,3])) -> 12
# print(solution(1, [2,1,2])) -> 6