import java.util.*;
class Solution {
    static int[][] usersArr;
    static int[] emoticonsArr;
    static int[] percent = {0, 10, 20, 30, 40};
    
    static int plus_join = 0, emoticon_price = 0, min = Integer.MAX_VALUE;
    
    public int[] solution(int[][] users, int[] emoticons) {
        usersArr = users;
        emoticonsArr = emoticons;
        
        for (int[] user : users) {
            min = Math.min(user[0], min);
        }
        for (int i = 0; i < 5; i++) {
            if (min <= percent[i]) {
                min = i;
                break;
            }
        }
        
        int[] discounts = new int[emoticons.length]; // 이모티콘별 할인율 저장
        combination(discounts, 0, emoticons.length);
        
        return new int[]{plus_join, emoticon_price};
    }
    static void combination(int[] discounts, int s, int n) {
        // 중복조합
        if (s == n) {
            calculate(discounts);
            return;
        }
        
        for (int i = s; i < n; i++) {
            for (int j = min; j < 5; j++) {
                discounts[i] = percent[j];
                combination(discounts, i+1, n);
            }
        }
    }
    static void calculate(int[] discounts) {
        int e_join = 0;
        int e_price = 0;
        
        for (int[] user : usersArr) {
            int price = 0;
            
            for (int i = 0; i < discounts.length; i++) {
                if (user[0] <= discounts[i]) {
                    price += (emoticonsArr[i] / 100) * (100 - discounts[i]);
                } 
            }
            
            if (price >= user[1]) e_join += 1;
            else e_price += price;
        }
        
        if (e_join > plus_join) {
            plus_join = e_join;
            emoticon_price = e_price;
        } else if (e_join == plus_join) {
            emoticon_price = Math.max(emoticon_price, e_price);
        }
    }
}