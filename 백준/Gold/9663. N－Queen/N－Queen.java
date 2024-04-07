import java.io.*;
public class Main {
    static int N;
    static int[] cols; // 퀸 위치
    static int result; // N개의 퀸을 놓을 수 있는 경우의 수
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        
        cols = new int[N];
        
        bt(0);
        
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
    
    static void bt(int cnt) {
        if (cnt == N) {
            result += 1;
            return;
        }
        
        for (int i = 0; i < N; i++) {
            cols[cnt] = i; 
            if (isPossibleTo(cnt)) bt(cnt + 1); // 계속해서 돌린 다음 N개 설치하면 return 해서 다시 여기
        }
    }
    
    static boolean isPossibleTo(int cnt) {
        for (int i = 0; i < cnt; i++) {
            if (cols[i] == cols[cnt] || Math.abs(cnt - i) == Math.abs(cols[cnt] - cols[i])){
                return false;
            }
        }
        return true;
    }
}