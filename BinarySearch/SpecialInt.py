# 시간복잡도를 O(logN)으로
from bisect import bisect_left, bisect_right
def cnt_by_range(arr, left_value, right_value):
    right_idx = bisect_right(arr, right_value)
    left_idx = bisect_left(arr, left_value)
    return right_idx - left_idx

n, x = map(int, input().split())
numbers = list(map(int, input().split()))

cnt = cnt_by_range(numbers, x, x)

if cnt == 0:
    print(-1)
else:
    print(cnt)

#############################################
# import sys
# input = sys.stdin.readline

# n, m = map(int, input().split())
# number = list(map(int, input().split()))

# if m > max(number): 
#     print(-1)
# else:
#     number = str(number)
#     cnt = number.count(str(m))

# print(cnt)