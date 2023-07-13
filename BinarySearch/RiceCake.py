N = 4
M = 6
rice_cake = [19, 15, 10, 17]

def binary_search(array, target, start, end):
    if start > end: return None

    mid = (start+end) // 2 #middle value -> 자르는 길이의 최댓값..?
    count = 0

    for rice_cake in array:
        to = rice_cake - mid
        if to > 0:
            count += to
    #print(count)

    if count == target:
        return mid
    elif count < target:
        return binary_search(array, target, start, mid-1)
    else:
        return binary_search(array, target, mid+1, end)
    
print(binary_search(rice_cake, M, 0, max(rice_cake)-1))