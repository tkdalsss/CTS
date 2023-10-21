# 프로그래머스 최고의 집합
def solution(n, s):
    answer = []

    if n > s: return [-1]

    mid = s // n
    for _ in range(n):
        answer.append(mid) # [4, 4]

    idx = len(answer) - 1
    for _ in range(s % n):
        answer[idx] += 1 # [4, 5]
        idx -= 1
    
    return answer

print(solution(2, 9))