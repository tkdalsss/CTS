import heapq
def isReverse(cur_pos, next_pos, cur_state, traps_idx):
    is_cur_trap_on, is_next_trap_on = False, False

    # cur_pos or next_pos 가 트랩이라면 1, 아니라면 0 반환
    if cur_pos in traps_idx:
        is_cur_trap_on = (cur_state & (1 << traps_idx[cur_pos])) > 0
    if next_pos in traps_idx:
        is_next_trap_on = (cur_state & (1 << traps_idx[next_pos])) > 0

    return is_cur_trap_on != is_next_trap_on

def getNextState(next_pos, cur_state, traps_idx):
    if next_pos in traps_idx:
        return cur_state ^ (1 << traps_idx[next_pos])
    return cur_state

def solution(n, start, end, roads, traps):
    answer = 1e9
    min_cost = [[1e9 for _ in range(n+1)] for _ in range(2**len(traps))]
    traps_idx = {v:i for i, v in enumerate(traps)}
    graph = [[] for _ in range(n+1)]
    
    for _start, _end, _cost in roads:
        graph[_start].append([_end, _cost, False]) # not trap
        graph[_end].append([_start, _cost, True]) # trap
    
    heap = []
    heapq.heappush(heap, [0, start, 0]) # [sum, cur_pos, cur_state]
    min_cost[0][start] = 0

    while heap:
        cur_sum, cur_pos, cur_state = heapq.heappop(heap)

        if cur_pos == end: 
            answer = min(answer, cur_sum)
            continue
        if cur_sum > min_cost[cur_state][cur_pos]:
            continue

        for next_pos, next_cost, is_reverse in graph[cur_pos]:
            if is_reverse != isReverse(cur_pos, next_pos, cur_state, traps_idx):
                continue
                
            next_state = getNextState(next_pos, cur_state, traps_idx)
            next_sum = next_cost + cur_sum

            if next_sum >= min_cost[next_state][next_pos]:
                continue
            
            min_cost[next_state][next_pos] = next_sum
            heapq.heappush(heap, [next_sum, next_pos, next_state])
    
    return answer

roads = [[1,2,2], [3,2,3]]
traps = [2]
print(solution(3, 1, 3, roads, traps))