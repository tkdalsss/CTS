# 프로그래머스 이중 우선순위큐
import heapq
def solution(operations):
    answer = []
    q = []

    for operation in operations:
        x, num = operation.split()
        num = int(num)

        if x == "I":
            heapq.heappush(q, num)
        elif x == "D" and num == 1:
            if len(q) != 0:
                max_value = max(q)
                q.remove(max_value)
        else:
            if len(q) != 0:
                heapq.heappop(q)
    
    if len(q) == 0:
        answer = [0, 0]
    else:
        answer = [max(q), heapq.heappop(q)]
    
    return answer

# operations = ["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"] -> [0, 0]
operations = ["I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"]
print(solution(operations))