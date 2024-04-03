import java.util.*;
import java.text.*;
class Solution {
    static final String finalTime = "23:59";
    static final Map<String, Long> feeMap = new HashMap<>();
    static final Map<String, Long> feeResultMap = new HashMap<>();
    static int basicTime;
    static int basicFee;
    static int addTime;
    static int addFee;
    
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        basicTime = fees[0];
        basicFee = fees[1];
        addTime = fees[2];
        addFee = fees[3];
        
        Map<String, String> inMap = new HashMap<>();
        
        for (String r : records) {
            String[] tmp = r.split(" ");
            if (tmp[2].equals("IN")) {
                inMap.put(tmp[1], tmp[0]);
            } else {
                String inTime = inMap.get(tmp[1]);
                inMap.remove(tmp[1]);
                String outTime = tmp[0];
                
                long interval = checkTimeInterval(inTime, outTime);
                long fee = feeMap.getOrDefault(tmp[1], 0l);
                
                feeMap.put(tmp[1], fee + interval);
            }
        }
        
        
        for (String s : inMap.keySet()) {
            long fee =feeMap.getOrDefault(s, 0l);
            fee += checkTimeInterval(inMap.get(s), finalTime);
            feeMap.put(s, fee);
        }
        
        answer = new int[feeMap.size()];
    
        for (String s : feeMap.keySet()) {
            feeResultMap.put(s, calIntervalFee(feeMap.get(s)));
        }
        
        // 정렬
        List<String> keySet = new ArrayList<>(feeResultMap.keySet());
        Collections.sort(keySet);
        
        for (int i = 0; i < keySet.size(); i++) {
            answer[i] = feeResultMap.get(keySet.get(i)).intValue();
        }
        
        return answer;
    }
    private static long checkTimeInterval(String inTime, String outTime) {
        long diff;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            
            Date in = sdf.parse(inTime);
            Date out = sdf.parse(outTime);
            
            long inMil = in.getTime();
            long outMil = out.getTime();
            diff = (outMil-inMil)/(1000*60);
            
        } catch (ParseException e) {
            throw new RuntimeException();
        }
        return diff;
    }
    private static long calIntervalFee(long interval) {
        long totalFee = basicFee;
        if(interval > basicTime) {
            totalFee += Math.ceil((double) (interval - basicTime) / addTime) * addFee;
        }
        return totalFee;
    }
}