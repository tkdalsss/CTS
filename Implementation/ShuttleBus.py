# 프로그래머스 셔틀버스 - 2019 카카오
def solution(n, t, m, timetable):
    answer = 0

    # 쉬운 비교를 위해 시간을 숫자로 변환
    crewTime = [int(time[:2])*60 + int(time[3:]) for time in timetable]
    crewTime.sort()
    busTime = [9*60 + t*i for i in range(n)] # 9시부터 출발이기 떄문에

    i = 0
    for time in busTime:
        cnt = 0 # 현재 타임에 탈 수 있는 인원

        while cnt < m and i < len(timetable) and crewTime[i] <= time:
            i += 1 # 전체 인원 비교
            cnt += 1
        
        if cnt < m : # 현재 버스에 탈수 있다면
            answer = time
        else: # 탈수 없다면 제일 늦은 크루보다 1분더 일찍 오면 됨
            answer = crewTime[i-1] - 1

    return str(answer//60).zfill(2) + ":" + str(answer%60).zfill(2)

timetable = ["08:00", "08:01", "08:02", "08:03"]
print(solution(1, 1, 5, timetable))