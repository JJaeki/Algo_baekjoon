package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 실버1_18290_NM과K1 {

    static int N, M, K, answer;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N + 1][M + 1];
        answer = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 0, 0, 0);
        System.out.println(answer);
    }

    public static void solve(int x, int y, int idx, int sum) {
        if (idx == K) {
            answer = Math.max(answer, sum);
            return;
        } else {
            for (int i = x; i < N; i++) {
                for (int j = y; j < M; j++) {
                    if (!visited[i][j]) {
                        if (check(i, j)) {
                            visited[i][j] = true;
                            solve(x, y, idx + 1, sum + arr[i][j]);
                            visited[i][j] = false;
                        }
                    }
                }
            }
        }

    }

    public static boolean check(int x, int y) {
        boolean flag = true;
        for (int i = 0; i < 4; i++) {
            int next_x = x + dx[i];
            int next_y = y + dy[i];

            if (next_x >= 0 && next_x < N && next_y >= 0 && next_y < M) {
                if (visited[next_x][next_y]) {
                    flag = false;
                }
            }
        }
        return flag;
    }
}
