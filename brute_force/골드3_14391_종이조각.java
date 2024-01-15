package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 골드3_14391_종이조각 {

    public static int N, M;
    public static int[][] map;
    public static boolean[][] visited; //방문처리
    public static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        simulate(0, 0);
        System.out.println(answer);


    }

    public static void simulate(int row, int col) {
        //행이 N과 같아지면, 탐색이 끝난것
        if (row == N) {
            calculate();
            return;
        }

        //열 넘어가면 해당 로직처리
        if (col >= M) {
            simulate(row + 1, 0);
            return; //가로 계산이 끝나면 종료시켜야함.
        }

        //가로라면 true처리
        visited[row][col] = true;
        simulate(row, col + 1);

        //가로 방문안한경우도 처리 ( 이경우 세로로 사용됨 )
        visited[row][col] = false;
        simulate(row, col + 1);

    }

    public static void calculate() {
        int result = 0;
        int sumTemp = 0;

        //가로 계산
        for (int i = 0; i < N; i++) {
            sumTemp = 0;
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == true) {
                    sumTemp *= 10;
                    sumTemp += map[i][j];
                } else {
                    result += sumTemp;
                    sumTemp = 0;
                }
            }
            //행 한줄 계산 끝날때마다 result에 + 연산 추가
            result += sumTemp;
        }

        for (int i = 0; i < M; i++) {
            sumTemp = 0;
            for (int j = 0; j < N; j++) {
                if (visited[j][i] == false) {
                    sumTemp *= 10;
                    sumTemp += map[j][i];
                } else {
                    result += sumTemp;
                    sumTemp = 0;
                }
            }
            result += sumTemp;
        }

        answer = Math.max(answer, result);

    }
}
