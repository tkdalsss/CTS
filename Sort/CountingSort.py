arr = [7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2]
# Count Check
count = [0] * (max(arr) + 1)

for i in range(len(arr)):
    count[arr[i]] += 1

for j in range(len(count)):
    for k in range(count[j]):
        print(j, end =' ')