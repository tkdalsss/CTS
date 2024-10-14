import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static class ConveyorBelt {
        private int durability;
        private boolean robot;

        public ConveyorBelt(int durability) {
            this.durability = durability;
            robot = false;
        }

        public void putRobot() {
            this.robot = true;
            this.durability -= 1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        LinkedList<ConveyorBelt> conveyorBelts = new LinkedList<>();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 2 * N; i++) {
            conveyorBelts.add(i, new ConveyorBelt(Integer.parseInt(st.nextToken())));
        }

        int step = 0;
        while (K > 0) {
            // 컨베이어 벨트 돌리기
            step += 1;
            conveyorBelts.add(0, conveyorBelts.removeLast());

            // 로봇 내리기
            if(conveyorBelts.get(N-1).robot) conveyorBelts.get(N-1).robot = false;

            for (int i = N - 1; i > 0; i--) {
                // 벨트위에 로봇 없으면 넘어가기
                if (!conveyorBelts.get(i).robot) continue;

                // 로봇이 이동하려면 이동하려는 칸에 로봇이 없어야 하고, 내구도가 1 이상이어야 함
                if (conveyorBelts.get(i+1).robot || conveyorBelts.get(i+1).durability <= 0) continue;

                // 로봇 이동
                conveyorBelts.get(i).robot = false;
                conveyorBelts.get(i+1).putRobot();
                if (conveyorBelts.get(i+1).durability <= 0) K -= 1;

                // 인덱스가 0부터 이므로 N-1 다음은 내리는 위치
                if (i + 1 == N - 1) conveyorBelts.get(i+1).robot = false;
            }

            if(conveyorBelts.get(0).durability > 0) {
                conveyorBelts.get(0).putRobot();
                if (conveyorBelts.get(0).durability <= 0) K -= 1;
            }
        }

        System.out.println(step);
    }
}