import java.util.*;
class Solution {
    static class Time {
        private int startTime;
        private int endTime;
        
        public Time (int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
    public int solution(int k, int n, int[][] reqs) {
        int answer = 0;
        List<List<Time>> timeForType = new ArrayList<>();
        int[][] waitTime = new int[k+1][n+1];
        int[] basicCounselors = new int[k+1]; //상담원 한명씩 배치
        int remainCounselors = n - k;
        
        // list 초기화
        for (int i = 0; i < k + 1; i++) {
            timeForType.add(new ArrayList<>());
        }
        
        for (int[] req : reqs) {
            int startTime = req[0];
            int duration = req[1];
            int type = req[2];
            
            timeForType.get(type).add(new Time(startTime, startTime + duration));
        }
        
        // 상담자 숫자에 따른 각 대기 시간 저장
        for (int i = 1; i < k+1; i++) {
            if (timeForType.get(i).size()==0) continue;
            
            // 상담원 배정
            for (int j = 1; j <= n-k+1; j++) {
                int wt = calculateTime(timeForType.get(i), j);
                waitTime[i][j] = wt;
            }
        }
        
        for (int i = 1; i < k + 1; i++) {
            basicCounselors[i] = 1;
        }
        
        while(remainCounselors > 0) {
            int max = 0; // 대기시간이 가장 많이 줄어드는 시간
            int typeNum = 0;
            
            // 상담원 수를 늘렸을 때 대기시간이 제일 많이 줄어드는 것을 찾는다
            for (int i = 1; i < k+1; i++) {
                // 현재 상담원 수
                int currentCounselor= basicCounselors[i];
                // 현재 상담원 수로 진행했을 때 대기시간
                int waitingTime = waitTime[i][currentCounselor];
                // 상담원 수를 늘렸을 때 대기시간
                int nextWaitingTime = waitTime[i][currentCounselor+1];
                // 상담원 수 증가로 인한 대기시간 감소 계산
                int reduceTime = Math.abs(waitingTime - nextWaitingTime);
                
                if (reduceTime >= max) {
                    max = reduceTime;
                    typeNum = i;
                }
            }
            
            if (max == 0) break;
            basicCounselors[typeNum] += 1;
            
            remainCounselors -= 1;
        }
        
        // 계산된 최소 대기시간 answer에 출력
        for (int i = 1; i < k + 1; i++) {
            if(timeForType.get(i).size() == 0) continue;
            int counselors = basicCounselors[i];
            answer += waitTime[i][counselors];
        }
        
        return answer;
    }
    static int calculateTime(List<Time> typeTime, int counselors) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int waitTime = 0;
        
        for (Time t:typeTime) {
            if (pq.isEmpty() || pq.size() < counselors) {
                pq.add(t.endTime);
            } else {
                int tmp = pq.poll(); // 진행중인 상담 중 가장 빨리 끝나는 시간
                if (t.startTime < tmp) {
                    // 대기시간 추가
                    waitTime += (tmp - t.startTime);
                    // 다음 상담 종료 시간 pq에 저장
                    pq.add(tmp + (t.endTime-t.startTime));
                } else {
                    pq.add(t.endTime);
                }
            }
        }
        return waitTime;
    }
}