# 프로그래머스 표현가능한 이진트리 - 2023 카카오 블라인드
def possible(number):
    length = len(number)

    if length == 1 or '1' not in number or '0' not in number:
        return True
    
    mid = length // 2
    if number[mid] == '0': 
        # 이진 트리를 만들 수 없으므로 False return
        return False
    
    return possible(number[:mid]) and possible(number[mid+1:])

def solution(numbers):
    # 2진수로 변환하면 0bxxx의 형태로 나오기 때문에 '0b'를 제거하고 리스트에 저장
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