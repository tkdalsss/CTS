# 프로그래머스 2020 카카오 외벽 점검
from itertools import permutations
def solution(n, weak, dist):
    answer = 0
    L = len(weak)
    cand = []
    weak_points = weak + [w+n for w in weak]

    for i, start in enumerate(weak):
        for friends in permutations(dist):
            count = 1
            position = start
            for friend in friends:
                position += friend
                # 모든 벽을 점검하지 못했을 때
                if position < weak_points[i+L-1]:
                    count += 1 # 도움을 줄 친구 투입
                    # 현재 위치보다 멀리 있는 취약지점 중 가까운 거리로
                    position = [w for w in weak_points[i+1:i+L]
                                if w > position][0]
                # 모든 벽을 점검하였을 때
                else:
                    cand.append(count)
                    break
    
    return min(cand) if cand else -1

weak = [1, 5, 6, 10]
dist = [1, 2, 3, 4]
print(solution(12, weak, dist))