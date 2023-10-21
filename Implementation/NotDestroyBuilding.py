# 프로그래머스 2022 카카오 파괴되지않은 건물 -> 누적합
def solution(board, skill):
    answer = 0
    tmp = [[0] * (len(board[0])+1) for _ in range(len(board)+1)]

    # 누적합
    for stype, r1, c1, r2, c2, degree in skill:
        tmp[r1][c1] += degree if stype == 2 else -degree
        tmp[r1][c2+1] += -degree if stype == 2 else degree
        tmp[r2+1][c1] += -degree if stype == 2 else degree
        tmp[r2+1][c2+1] += degree if stype==2 else -degree
    
    # 행기준 누적합
    for i in range(len(tmp) - 1):
        for j in range(len(tmp[0]) - 1):
            tmp[i][j+1] += tmp[i][j]
    
    # 열기준 누적합
    for j in range(len(tmp[0]) - 1):
        for i in range(len(tmp) - 1):
            tmp[i+1][j] += tmp[i][j]
    
    # 기존배열과 합침
    for i in range(len(board)):
        for j in range(len(board[i])):
            board[i][j] += tmp[i][j]
            if board[i][j] > 0: answer += 1
    
    return answer

board = [[5,5,5,5,5],[5,5,5,5,5],[5,5,5,5,5],[5,5,5,5,5]]
skill = [[1,0,0,3,4,4],[1,2,0,2,3,2],[2,1,0,3,1,2],[1,0,1,3,3,1]]
print(solution(board, skill))