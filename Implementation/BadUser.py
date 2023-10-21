# 프로그래머스 불량사용자 2019 카카오
from itertools import permutations

def check(users, banned_id):
    for i in range(len(banned_id)):
        if len(users[i]) != len(banned_id[i]):
            return False
        
        for j in range(len(users[i])):
            if banned_id[i][j] == '*':
                continue
            if banned_id[i][j] != users[i][j]:
                return False
    
    return True

def solution(users, banned_id):
    user_permutation = list(permutations(users, len(banned_id)))
    ban_set = []

    for users in user_permutation:
        if not check(users, banned_id):
            continue
        else:
            users = set(users)
            if users not in ban_set:
                ban_set.append(users)

    return len(ban_set)

users = ["frodo", "fradi", "crodo", "abc123", "frodoc"]
banned_id = ["fr*d*", "abc1**"]
print(solution(users, banned_id))