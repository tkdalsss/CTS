import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 65536;
        // 두개씩 묶는 함수 - 알파벳 이외의 문자는 제거
        List<String> str1Tmp = divide(str1);
        List<String> str2Tmp = divide(str2);
        
        // 합집합
        List<String> union = new ArrayList<>();
        List<String> intersect = new ArrayList<>();
        for (String s : str1Tmp) {
            if (str2Tmp.remove(s)) intersect.add(s);
            union.add(s);
        }
        
        for (String s : str2Tmp) {
            union.add(s);
        }
        
        // add
        double jakard = 0;
        
        if (union.size() == 0) {
            jakard = 1;
        } else {
            jakard = (double) intersect.size() / (double) union.size();
        }
        
        return (int) (answer * jakard); 
    }
    
    private static List<String> divide(String str) {
        char[] tmp = str.toCharArray();
        List<String> cList = new ArrayList<>();
        for (int i = 0; i < tmp.length - 1; i++) {
            if (Character.isAlphabetic(tmp[i]) && Character.isAlphabetic(tmp[i+1])) {
                cList.add((String.valueOf(tmp[i]) + String.valueOf(tmp[i+1])).toUpperCase());
            }
        }
        return cList;
    }
}