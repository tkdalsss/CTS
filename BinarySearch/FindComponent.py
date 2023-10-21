N = 5
component = [8, 3, 7, 9, 2]

M = 3
findComponent = [5, 7, 9]

answer = []

def binary_search(com, target_com, start, end):
    if start > end: return None

    mid = (start + end) // 2

    if com[mid] == target_com:
        return mid
    elif com[mid] > target_com:
        return binary_search(com, target_com, start, mid-1)
    else:
        return binary_search(com, target_com, mid+1, end)

for i in range(M):
    answer.append(binary_search(component, findComponent[i], 0, len(component)-1))

print(answer)