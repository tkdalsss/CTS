arr = [
    ['이순신', 95],
    ['홍길동', 77]
]

def solution(arr):
    arr.sort(key=lambda x:-x[1])
    
    for student in arr:
        print(student[0], end=' ')

solution(arr)