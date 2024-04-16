import java.util.*;
class Solution {
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        // a - 실내온도와 희망온도 불일치시 전력소비량
        // b - 실내온도와 희망온도 일치시 전력소비량
        int k = 1000 * 100;
        
        // 전체 온도 범위가 -10도 이므로 10 더해줌
        t1 += 10; // 쾌적온도 하한선
        t2 += 10; // 쾌적온도 상한선 
        temperature += 10; // 실외온도
        
        int[][] DP = new int[onboard.length][51]; // 시간 + 입력가능한 모든 온도
        for (int i = 0; i < DP.length; i++) {
            for (int j = 0; j < 51; j++) {
                DP[i][j] = k;
            }
        }
        
        int flag = 1; // 최적온도 상한선보다 작으면은 상승
        if (temperature > t2) {
            flag = -1; // 최적온도 상한선 보다 크면은 하강
        }
        
        DP[0][temperature] = 0; // 처음 시작할 때는 실외온도로 시작하고 비용은 0
        
        // i=0은 x
        for (int i = 1; i < onboard.length; i++) { // 모든 시간내에
            // 모든 온도에 대해 조사?
            for (int j = 0 ; j < 51; j++) {
                int min = k;
                // 사람이 탑승하고 최적 온도 내에 있는 경우, 사람이 탑승하지 않았을 경우
                if ((onboard[i] == 1 && t1 <= j && j <= t2) || onboard[i]==0) {
                    // System.out.println(j);
                    if (0 <= j+flag && j+flag <=50) {
                        min = Math.min(min, DP[i-1][j+flag]);
                    }
                    if (j == temperature) {
                        min = Math.min(min, DP[i-1][j]);
                    }
                    if (0 <= j-flag && j-flag <= 50) {
                        min = Math.min(min, DP[i-1][j-flag] + a);
                    }
                    if (t1 <= j && j <= t2) {
                        min = Math.min(min, DP[i-1][j] + b);
                    }
                    // 희망온도와 현재 온도가 일치할 때
                    // 에어컨을 켜야할 떄
                    // 에어컨을 꺼도될 떄
                    DP[i][j] = min;
                }
            }  
        }
        
        int i = onboard.length - 1;
        // System.out.println(Arrays.toString(DP[i]));
        int answer = DP[i][0];
        for (int j = 1; j < 51; j++) {
            answer = Math.min(answer, DP[i][j]);
        }
        
        return answer;
    }
}
        
        
        
//         int answer = 0;
//         // int inTemp = temperature; // 처음 실내온도는 실외온도와 같음
//         int expectTemp1 = t1; // 희망온도 범위
//         int expectTemp2 = t2;
//         int expectTemp = temperature <= expectTemp1 ? expectTemp1 : temperature >= expectTemp2 ? expectTemp2 : temperature; // 희망온도 지정 - 실외온도보다 t1이 높으면 t1, t2가 실외온도보다 낮으면 t2
        
//         int ec1 = a; // 실내 != 희망 전력소비
//         int ec2 = b; // 실내 == 희망 전력소비
//         boolean turnon = false;
//         int[] minec = new int[expectTemp2 - expectTemp1 + 1]; // 전력소비를 최소로 하게끔 저장하는 배열
//         // int minec = 0;
        
//         for (int t = expectTemp1; t <= expectTemp2; t++) {
//             int tmp = 0;
//             int inTemp = temperature;
//             for (int i = 0; i < onboard.length; i++) {
//             // 탑승 ox?
//                 if (inTemp > t) {
//                         turnon = true;
//                         inTemp -= 1;
//                         tmp += ec1;
//                 } else if (inTemp < t) {
//                     inTemp += 1;
//                     if (turnon) tmp += ec1;
//                 } else {
//                     if (t-expectTemp2 == onboard.length - i) {
//                         turnon = false;
//                         inTemp += 1;
//                     }
//                     if (turnon) tmp += ec2;
//                 }
//             }
//             minec[t-expectTemp1] = tmp;
//         }
        
//         Arrays.sort(minec);
//         System.out.println(Arrays.toString(minec));
        
//         return minec[0];
//     }
// }