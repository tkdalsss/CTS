input_data = input()
row = int(input_data[1])
column = int(ord(input_data[0])) - int(ord('a')) + 1

result = 0
# Example in book
steps = [(-2,-1), (-1,-2), (1,-2), (2,-1), (2,1), (1,2), (-1,2), (-2,1)]

for step in steps:
    next_row = row + step[0]
    next_column = row + step[1]
    #if next_row >= 1 and next_row <=8 and next_column >=1 and next_column <=8:
        #result += 1

# dx, dy
dx = [2, 2, 1, -1, -2, -2, 1, -1]
dy = [-1, 1, 2, 2, 1, -1, -2, -2]

for i in range(len(dx)):
    next_row = row + dx[i]
    next_column = column + dy[i]
    #if next_row >= 1 and next_row <= 8 and next_column >= 1 and next_column <=8:
    if next_row > 0 and next_row < 9 and next_column > 0 and next_column < 9:
        result += 1

print(result)