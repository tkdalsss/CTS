import java.util.*;
class Solution {
    static class Plan {
        String name;
        int start, playtime;
        public Plan(String name, int start, int playtime){
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }
        public Plan(String name, int playtime) {
            this.name = name;
            this.playtime = playtime;
        }
    }
    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        // list = new ArrayList<>();
        PriorityQueue<Plan> pq = new PriorityQueue<>((o1, o2) -> (
        o1.start - o2.start));
        
        for (String[] p : plans) {
            String[] startSplit = p[1].split(":");
            int tmpS = Integer.parseInt(startSplit[0]) * 60 + Integer.parseInt(startSplit[1]);
            int tmpP = Integer.parseInt(p[2]);
            
            pq.add(new Plan(p[0], tmpS, tmpP));
        } 
        
        // Collections.sort(list, (o1, o2) -> (o1.start - o2.start));
        
        // int startTime = list.get(0).start;
        Stack<Plan> stopPlan = new Stack<>();
        while (!pq.isEmpty()) {
            Plan current = pq.poll();
            
            String curName = current.name;
            int curStart = current.start;
            int curPlayTime = current.playtime;
            
            int currentTime = curStart;
            
            if (!pq.isEmpty()) {
                // 다음 진행될 과제
                Plan nextPlan = pq.peek();
                // 다음 과제 시작 전까지 과제할 수 있을 때
                if (curStart + curPlayTime < nextPlan.start) {
                    // pq에서 이미 삭제되었으므로 삭제안해도 되고 answer에만 추가
                    answer.add(curName);
                    // 현재 시간 업데이트 -> 잠시 멈춘 과제를 위해 필요
                    currentTime += curPlayTime;
                    
                    // 남은 과제가 없을때까지 반복 -> 다음 과제 시간 전까지만
                    while (!stopPlan.isEmpty()) {
                        Plan stoppedPlan = stopPlan.pop();
                        
                        if (currentTime + stoppedPlan.playtime <= nextPlan.start) {
                            currentTime += stoppedPlan.playtime;
                            answer.add(stoppedPlan.name);
                            continue;
                        } else {
                            int remainTime = currentTime + stoppedPlan.playtime - nextPlan.start;
                            stopPlan.push(new Plan(stoppedPlan.name, remainTime));
                            break;
                        }
                    }
                } else if (curStart + curPlayTime == nextPlan.start) {
                    answer.add(curName);
                    continue;
                } else {
                    // 다음 과제 시작 전까지 과제를 못끝내고 남는 시간이 발생할 때
                    // 잠시 멈춘 과제에 남은 시간과 추가
                    int remainTime = currentTime + curPlayTime - nextPlan.start;
                    stopPlan.push(new Plan(curName, remainTime));
                }
            }
            else {
                // 새로운 과제가 없을 때
                if (stopPlan.isEmpty()) {
                    // 남아있는 과제도 없다면 추가
                    currentTime += curPlayTime;
                    answer.add(curName);
                } else {
                    // 새로운 과제를 수행한 다음
                    answer.add(curName);
                    // 남아있는 모든 과제를 수행
                    while(!stopPlan.isEmpty()){
                        Plan remainPlan = stopPlan.pop();
                        answer.add(remainPlan.name);
                    }
                }
            }
//             if (list.size() == 1) {
//                 answer.add(list.get(0).name);
//                 break;
//             }
//             Plan p1 = list.get(0);
//             Plan p2 = list.get(1);
            
//             if (p1.start + p1.playtime <= p2.start) {
//                 answer.add(p1.name);
//                 // list.remove(0);
//             } else {
//                 int remainTime = p1.start + p1.playtime - p2.start;
//                 int afterTime = p2.start + p2.playtime;
//                 System.out.println(remainTime + " " + afterTime);
//                 Plan newPlan = new Plan(p1.name, afterTime, remainTime);
//                 // list.remove(0);
//                 list.add(newPlan);
//                 // Collections.sort(list, (o1, o2) -> (o1.start - o2.start));
//             }
//             list.remove(0);
        }
        // System.out.println(list.get(0).start);
        
        return answer.toArray(new String[answer.size()]);
        // return answer;
    }
}