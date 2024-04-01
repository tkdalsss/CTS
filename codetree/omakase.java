import java.util.*;

public class Omakase {

    static Map<Integer, List<String>> sushiMap = new HashMap<>();
    static Map<Integer, Map<String, Integer>> personMap = new HashMap<>();
    static int l;
    static int q;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        l = sc.nextInt(); // 벨트 길이
        q = sc.nextInt(); // 명령 수
        sc.nextLine();

        for (int i = 0; i < l; i++) {
            sushiMap.put(i, new ArrayList<>());
        }

        int cnt = 1;
        for (int i = 0; i < q; i++) {
            String s = sc.nextLine();
            String[] tmp = s.split(" ");
            String code = tmp[0];
            int t = Integer.parseInt(tmp[1]);

            switch (code) {
                case "100":
                    addSushi(i, t, Integer.parseInt(tmp[2]), tmp[3]);
                    break;
                case "200":
                    eatSushi(i, Integer.parseInt(tmp[2]), tmp[3], Integer.parseInt(tmp[4]));
                    break;
                case "300":
                    takePicture(i, t, cnt);
                    break;
                default:
                    break;
            }

            if (t != cnt)
                cnt = t + 1;
            else
                cnt++;
        }
    }

    private static void addSushi(int m, int t, int x, String name) {
        loop(m);
        List<String> strings = sushiMap.get(x);
        strings.add(name);
        sushiMap.put(x, strings);
        if (!personMap.isEmpty() && m < q)
            current();
    }

    private static void eatSushi(int m, int x, String name, int n) {
        loop(m);
        int tmp = n;
        List<String> strings = sushiMap.get(x);
        for (String s : strings) {
            if (s.equals(name)) {
                tmp -= 1;
            }
        }
        for (int i = 0; i < n - tmp; i++) {
            strings.remove(name);
        }
        sushiMap.put(x, strings);
        if (tmp > 0) {
            Map<String, Integer> map = new HashMap<>();
            map.put(name, tmp);
            personMap.put(x, map);
        }
        if (!personMap.isEmpty() && m < q)
            current();
    }

    private static void takePicture(int m, int t, int cnt) {
        int sushiCnt = 0;
        int personCnt = 0;

        if (t > cnt) {
            for (int i = 0; i <= t - cnt; i++) {
                loop(m + i);
            }
        } else
            loop(m);

        if (!personMap.isEmpty() && m < q)
            current();

        personCnt += personMap.size();
        for (int i = 0; i < l; i++) {
            sushiCnt += sushiMap.get(i).size();
        }

        System.out.println(personCnt + " " + sushiCnt);
    }

    private static void loop(int m) {
        List<String> lastThing = sushiMap.get(l - 1);
        for (int i = l - 1; i > 0; i--) {
            List<String> strings = sushiMap.get(i - 1);
            sushiMap.put(i, strings);
        }
        sushiMap.put(0, lastThing);
    }

    private static void current() {
        for (int i = 0; i < l; i++) {
            if (personMap.get(i) != null) {
                // 현재 대기중인 사람
                String personName = null;
                for (String k : personMap.get(i).keySet()) {
                    personName = k;
                }
                Integer i1 = personMap.get(i).get(personName); // 먹어야할 스시 개수
                int cnt = 0;
                // 현재 스시가 있는지 확인
                List<String> strings = sushiMap.get(i);
                for (String s : strings) {
                    if (s.equals(personName)) {
                        i1 -= 1;
                        cnt++;
                    }
                }
                for (int j = 0; j < cnt; j++) {
                    strings.remove(personName);
                }
                sushiMap.put(i, strings);
                if (i1 > 0) {
                    Map<String, Integer> map = new HashMap<>();
                    map.put(personName, i1);
                    personMap.put(i, map);
                } else {
                    personMap.remove(i);
                }
            }
        }
    }

}