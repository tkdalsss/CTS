# from collections import deque
# 프로그래머스 2021 카카오 표 편집
def solution(n, k, cmd):
    answer = ''
    original_size = n
    save = []
    
    for c in cmd:
        if c != 'C' and c != 'Z':
            dic, num = c.split(' ')
            if dic == 'D':
                k += int(num)
            else:
                k -= int(num)
        else:
            if c == 'C': 
                save.append(k) # 현재 포인트 저장 -> z
                if k+1 == n: # 마지막 행에서 삭제했을 경우 올려주기
                    k -= 1
                n -= 1 
            else:
                point = save.pop()
                if point <= k:
                    k += 1
                n += 1
                
    save.sort()
    for i in range(original_size):
        if i in save:
            answer += ('X')
            continue
        answer += ('O')
        
    return answer

cmd = ["D 2","C","U 3","C","D 4","C","U 2","Z","Z"]
print(solution(8,2,cmd))