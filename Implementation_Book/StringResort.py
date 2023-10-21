input = input()

def solution(input):
    answer = ""
    sum, max = 0, 0
    input = sorted(input)

    for i in range(len(input)):
        if str.isdigit(input[i]) == False:
            max = i
            break
        sum += int(input[i])
    
    input = input[max:]
    
    for j in range(len(input)):
        answer += (input[j])
    
    answer += str(sum)
    
    print(answer)


solution(input)