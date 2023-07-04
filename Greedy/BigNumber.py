# n = size
# m = iteration
# k = max number iteration 
n = 5
m = 8
k = 3
# n, m, k = map(int, input().split())
# data = list(map(int, input().split()))

arr = [2, 4, 5, 4, 6]
arr.sort()
arrmax = arr[n-1]
arrmax2 = arr[n-2]
sum, cnt, cnt2 = 0, 0, 0

while True:
    if(cnt < k):
        sum += arrmax
        cnt += 1
    elif(cnt == k):
        sum += arrmax2
        cnt = 0

    cnt2 += 1

    if(cnt2 == m): break

print(sum)
