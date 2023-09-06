n = int(input())

def solution(n):
    input = str(n)
    forward = 0
    backward = 0

    for i in range(int(len(input)/2)):
        forward += int(input[i])
        backward += int(input[len(input)-(i+1)])

    if forward != backward:
        print("READY")
        return

    print("LUCKY")

solution(n)
    