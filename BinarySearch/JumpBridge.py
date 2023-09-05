def solution(stones, k):
    # answer = 0

    left = 1
    right = max(stones)

    while left <= right:
        mid = (left + right) // 2
        cnt = 0

        for stone in stones:
            if stone - mid <= 0:
                cnt += 1
            else:
                cnt = 0
            if cnt >= k:
                break
        
        if cnt < k:
            left = mid + 1
        else:
            right = mid - 1
    
    return left

print(solution([2,4,5,3,2,1,4,2,5,1], 3))

# def solution(stones, k):
#     answer = 0
    
#     while True: # 친구들의 수는 무제한
#         jump_cnt = 0
        
#         for stone in stones:
#             if stone == 0:
#                 jump_cnt += 1
#                 continue
#             stone -= 1
        
#         if jump_cnt >= k:
#             break
        
#         answer += 1
                
#     return answer