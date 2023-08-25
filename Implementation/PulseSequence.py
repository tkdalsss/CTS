# 프로그래머스 연속 펄스 부분 수열의 합
def solution(sequence):
    answer = -1e9
    size = len(sequence)
    s1 = s2 = 0
    s1_min = s2_min = 0
    pulse = 1

    # E까지의 누적합 - E 이전까지의 누적합 최솟값 => 연속 펄스 부분 수열의 최대합
    for i in range(size):
        s1 += sequence[i] * pulse
        s2 += sequence[i] * (-pulse)

        answer = max(answer, s1-s1_min, s2-s2_min)

        s1_min = min(s1_min, s1)
        s2_min = min(s2_min, s2)

        pulse *= -1
    
    return answer

sequence = [2, 3, -6, 1, 3, -1, 2, 4]
print(solution(sequence))