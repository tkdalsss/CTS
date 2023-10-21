def solution(s):
    answer = []
    
    s = list(s)
    zero_cnt = 0
    bin_cnt = 0
    
    while len(s) > 1:
        tmp = []
        for i in range(len(s)):
            if s[i] == '0':
                zero_cnt += 1
            else:
                tmp.append(s[i])
        
        n = len(tmp)
        n_bin = bin(n)[2:]
        bin_cnt += 1
        
        s = list(n_bin)
    
    answer.append(bin_cnt)
    answer.append(zero_cnt)
    
    return answer