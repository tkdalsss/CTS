import java.util.Scanner;

public class Main {
    
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        int count = 0; // 그룹단어 개수
        int n = sc.nextInt(); // 몇개 입력할지
        
        for (int i = 0; i < n; i++) {
            if (checkGroup() == true) {
                count++;
            }
        }
        
        System.out.println(count);
    }
    
    static boolean checkGroup() {
        boolean[] check = new boolean[26]; // 알파벳 체크
        int prev = 0;
        String str = sc.next();
        
        for (int i = 0; i < str.length(); i++) {
            int now = str.charAt(i);
            
            if (prev != now) {
                if (check[now - 'a'] == false) {
                    check[now - 'a'] = true;
                    prev = now;
                } else return false;
            } else continue;
        }
        
        return true;
    }
}