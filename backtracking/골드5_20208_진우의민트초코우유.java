package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 골드5_20208_진우의민트초코우유 {

    static int N, M, H, map[][], answer;
    static int[] home;
    static List<int[]> mints;
    static boolean used[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        H = stoi(st.nextToken());
        init();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = stoi(st.nextToken());
                if (map[i][j] == 1) {
                    home = new int[]{i, j};
                } else if (map[i][j] == 2) {
                    mints.add(new int[]{i, j});
                }
            }
        }
        used = new boolean[mints.size()];
        permu(0, new ArrayList<>());
        System.out.println(answer);
    }

    static void permu(int depth, List<int[]> list) {
        if (depth == mints.size()) {
            simul(list);
            return;
        }
        for (int i = 0; i < mints.size(); i++) {
            if (!used[i]) {
                used[i] = true;
                list.add(mints.get(i));
                permu(depth + 1, list);
                used[i] = false;
                list.remove(depth);
            }
        }
    }

    static void simul(List<int[]> list) {
        int cur[] = home.clone();
        int curH = M;
        int cnt = 0;
        for (int[] mint : list) {
            int dist = Math.abs(cur[0] - mint[0]) + Math.abs(cur[1] - mint[1]);
            if (dist > curH) {//거리가 더 먼 경우
                break;
            } else {//거리가 되는 경우
                curH -= dist;
                curH += H;
                cnt++;
                cur = new int[]{mint[0], mint[1]};
                //집까지 돌아가는 경우
                int tohome = Math.abs(home[0] - mint[0]) + Math.abs(home[1] - mint[1]);
                if (tohome <= curH) {
                    answer = Math.max(answer, cnt);
                }
            }
        }
    }

    static int stoi(String s) {
        return Integer.valueOf(s);
    }

    static void init() {
        map = new int[N][N];
        mints = new ArrayList<>();
        answer = 0;
    }
}
