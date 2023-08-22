# 프로그래머스 가사 검색 - 2020 카카오
from bisect import bisect_left, bisect_right

def cnt_by_range(a, left_value, right_value):
    right_idx = bisect_right(a, right_value)
    left_idx = bisect_left(a, left_value)
    return right_idx - left_idx

arr = [[] for _ in range(10001)]
reversed_arr = [[] for _ in range(10001)]

def solution(words, queries):
    answer = []
    for word in words:
        arr[len(word)].append(word)
        reversed_arr[len(word)].append(word[::-1])
    
    for i in range(10001):
        arr[i].sort()
        reversed_arr[i].sort()

    for query in queries:
        if query[0] != '?': # 접미사에 와일드카드
            res = cnt_by_range(arr[len(query)], query.replace('?','a'), query.replace('?', 'z'))
        else: # 접두사에 와일드카드
            res = cnt_by_range(reversed_arr[len(query)], query[::-1].replace('?', 'a'), query[::-1].replace('?', 'z'))
        answer.append(res)
    
    return answer

words = [
    "frodo", "front", "frost", "frozen", "frame", "kakao"
]
queries = [
    "fro??", "????o", "fr???", "fro???", "pro?"
]
print(solution(words, queries))