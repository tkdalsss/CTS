n = 2
min_max = 0

for i in range(0, n):
    data_input = list(map(int, input().split()))
    data_input.sort()
    if min_max < data_input[0]:
        min_max = data_input[0]

print(min_max)