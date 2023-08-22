import heapq
def solution(jobs):
    answer, now, i, start = 0, 0, 0, -1
    heap = []

    while i < len(jobs):
        for j in jobs:
            if start < j[0] <= now:
                heapq.heappush(heap, [j[1], j[0]])
        
        if len(heap) > 0:
            cur = heapq.heappop(heap)
            start = now # 인덱스 뒤로 떙기기
            now += cur[0] # 소요시간
            answer += now - cur[1] # 요청시간
            i += 1
        else:
            now += 1

    answer = answer // len(jobs)
    return answer

jobs = [
    [0, 3],
    [1, 9],
    [2, 6]
]
print(solution(jobs))