# 프로그래머스 표현가능한 이진트리 - 2023 카카오 블라인드
def possible(number):
    length = len(number)

    if length == 1 or '1' not in number or '0' not in number:
        return True
    
    mid = length // 2
    if number[mid] == '0':
        return False
    
    return possible(number[:mid]) and possible(number[mid+1:])

def solution(numbers):
    bin_numbers = [bin(number)[2:] for number in numbers]
    bin_list = [2**x - 1 for x in range(50)]
    answer = []

    for number in bin_numbers:
        length = len(number)
        for bin_num in bin_list:
            if bin_num >= length:
                number = '0'*(bin_num-length) + number
                break
        answer.append(1 if possible(number) else 0)
    
    return answer

print(solution([7, 42, 5]))