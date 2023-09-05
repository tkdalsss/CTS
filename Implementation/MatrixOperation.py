from collections import deque

def solution(rc, operations):
    r_len, c_len = len(rc), len(rc[0])

    # 중간에 위치한 원소들
    rows = deque(deque(row[1:-1]) for row in rc)
    # 바깥에 위치한 원소들
    out_cols = [deque(rc[r][0] for r in range(r_len)),
                deque(rc[r][c_len-1] for r in range(r_len))]
    
    for operation in operations:
        if operation[0] == "S": # ShiftRow
            rows.appendleft(rows.pop()) # 중간 바꿔주고
            # 밑에 있는 원소를 제일 위로
            out_cols[0].appendleft(out_cols[0].pop()) 
            out_cols[1].appendleft(out_cols[1].pop()) 
        
        else: # Rotate
            # clock-wise
            rows[r_len - 1].append(out_cols[1].pop())
            out_cols[0].append(rows[r_len-1].popleft())
            rows[0].appendleft(out_cols[0].popleft())
            out_cols[1].appendleft(rows[0].pop())
    
    answer = []
    for r in range(r_len):
        answer.append([])
        answer[r].append(out_cols[0][r])
        answer[r].extend(rows[r])
        answer[r].append(out_cols[1][r])
    
    return answer

rc = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
operations = ["Rotate", "ShiftRow"]
print(solution(rc, operations))