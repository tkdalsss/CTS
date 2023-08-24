# 프로그래머스 다단계 칫솔 판매
def find(parents, money, number, answer):
    if parents[number] == number or money // 10 == 0: return

    send = money // 10
    mine = money - send
    answer[number] = mine
    find(parents, send, parents[number], answer)

    return

def solution(enroll, referral, seller, amount):
    n = len(enroll)
    answer = [0] * (n+1) # 판매원 각각의 수익 저장
    d = {} # 판매원, 인덱스 정보 저장
    parents = [i for i in range(n+1)] # 판매원 추천인 정보 저장

    for i in range(n):
        d[enroll[i]] = i + 1
    
    for i in range(n):
        if referral[i] == '-':
            parents[i+1] = 0
        else:
            parents[i+1] = d[referral[i]]
    
    for i in range(len(seller)):
        find(parents, amount[i] * 100, d[seller[i]], answer)
    
    return answer[1:] # 제일 처음에는 루트노드 민호가 포함되어 있기 때문에 잘라야함


enroll = ["john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"]
referral = ["-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"]
seller = ["young", "john", "tod", "emily", "mary"]
amount = [12, 4, 2, 5, 10]
print(solution(enroll, referral, seller, amount))