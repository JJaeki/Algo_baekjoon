package DP1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 실버2_14430_자원캐기 {

    static int[] dx = {-1, 0};
    static int[] dy = {0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int left = (j - 1 < 0) ? 0 : board[i][j - 1];
                int up = (i - 1 < 0) ? 0 : board[i - 1][j];
                board[i][j] += Math.max(left, up);
            }
        }
        System.out.println(board[N - 1][M - 1]);
    }

}
