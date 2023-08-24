# 프로그래머스 풍선 터뜨리기
def solution(a):
    # 양방향의 최솟값중 하나라도 자신보다 작으면 살아남음
    n = len(a)
    if n == 1: return 1
    answer = 2

    l_min = [a[0]]
    r_min = [a[-1]]

    for i in range(1, n):
        # 왼쪽 최솟값 리스트
        if l_min[-1] > a[i]:
            l_min.append(a[i])
        else:
            l_min.append(l_min[-1])
        # 오른쪽 최솟값 리스트
        if r_min[-1] > a[n - 1 - i]:
            r_min.append(a[n - 1 - i])
        else:
            r_min.append(r_min[-1])
    r_min.reverse()

    print(l_min, r_min)

    for i in range(1, n-1):
        if l_min[i-1] > a[i] or r_min[i+1] > a[i]:
            answer += 1
    
    return answer
        
a = [-16,27,65,-2,58,-92,-71,-68,-61,-33]
print(solution(a))