A = [1, 2, 5, 4, 3]
B = [5, 5, 6, 6, 5]

def solution(arrA, arrB, k):
    arrA.sort()
    arrB.sort(key=lambda x:-1)
    answer = 0

    for i in range(k):
        arrA[i], arrB[i] = arrB[i], arrA[i]

    for j in range(len(arrA)):
        answer += arrA[j]

    return answer

print(solution(A, B, 3))