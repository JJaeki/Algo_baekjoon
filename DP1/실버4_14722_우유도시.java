package DP1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 실버4_14722_우유도시 {
    static int N; //우유도시 영역 크기
    static int map[][];
    static int dp[][][];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        dp = new int[N][N][3]; //좌표 (x,y) 가게까지 어떤 우유를 마셨을 때 우유의 최대 개수

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        //딸기->초코->바나나->딸기
        //0 : 딸기
        //1 : 초코
        //2 : 바나나
        //동쪽 혹은 남쪽으로만 움직임

        if (map[0][0] == 0) dp[0][0][0] = 1;

        //초기셋팅
        for (int i = 1; i < N; i++) {
            int milk = map[0][i]; //현재 가로열에 무슨 우유인지 가지고 오기

            dp[0][i][0] = milk == 0 ? dp[0][i - 1][2] + 1 : dp[0][i - 1][0]; //처음이 딸기 우유면? 이전 바나나우유 +1 : 아니면 이전 딸기우유 그대로 가져오기
            dp[0][i][1] = milk == 1 && dp[0][i][2] < dp[0][i][0] ? dp[0][i - 1][0] + 1 : dp[0][i - 1][1]; //초코우유고 && 바나나우유보다 딸기우유가 더크면? 딸기우유 +1 : 아니면 그냥 초코우유
            dp[0][i][2] = milk == 2 && dp[0][i][0] < dp[0][i][1] ? dp[0][i - 1][1] + 1 : dp[0][i - 1][2]; // 바나나우유 && 딸기우유보다 초코우유가 더크면 ? 초코우유 +1 : 바나나우유

        }
        for (int i = 1; i < N; i++) {
            int milk = map[i][0]; //세로축 기준

            dp[i][0][0] = milk == 0 ? dp[i - 1][0][2] + 1 : dp[i - 1][0][0];
            dp[i][0][1] = milk == 1 && dp[i][0][2] < dp[i][0][0] ? dp[i - 1][0][0] + 1 : dp[i - 1][0][1];
            dp[i][0][2] = milk == 2 && dp[i][0][0] < dp[i][0][1] ? dp[i - 1][0][1] + 1 : dp[i - 1][0][2];
        }


        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                int milk = map[i][j];

                //무조건 동쪽 || 남쪽으로만 갈 수 있으니까
                //i-1,j-1(이전 위치) 중에서 큰 값 가져와서 +1 해주기
                dp[i][j][0] = milk == 0
                        ? Math.max(dp[i][j - 1][2] + 1, dp[i - 1][j][2] + 1)
                        : Math.max(dp[i][j - 1][0], dp[i - 1][j][0]);
                dp[i][j][1] = milk == 1 && dp[i][j][2] < dp[i][j][0]
                        ? Math.max(dp[i][j - 1][0] + 1, dp[i - 1][j][0] + 1)
                        : Math.max(dp[i][j - 1][1], dp[i - 1][j][1]);

                dp[i][j][2] = milk == 2 && dp[i][j][0] < dp[i][j][1]
                        ? Math.max(dp[i][j - 1][1] + 1, dp[i - 1][j][1] + 1)
                        : Math.max(dp[i][j - 1][2], dp[i - 1][j][2]);
            }
        }


        System.out.println(Math.max(dp[N - 1][N - 1][0], Math.max(dp[N - 1][N - 1][1], dp[N - 1][N - 1][2])));

    }
}
