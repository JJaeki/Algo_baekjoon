package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/16571

public class 골드3_16571_알파틱택토 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] map = new int[3][3];
        int zero = 0; // 맵에서 0개수 카운트

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) zero++;
            }
        }

        // 0이 홀수면 1, 짝수면 2부터 시작
        int win = game(zero % 2 != 0 ? 1 : 2, map);
        char answer;
        if (win == 1) answer = 'W';
        else if (win == 0) answer = 'D';
        else answer = 'L';
        System.out.println(answer);
    }

    public static int game(int now, int[][] map) {
        int min = 2; // 상대방의 최선의 승패를 저장
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (map[i][j] == 0) { // 놓을 수 있는 위치
                    map[i][j] = now; // 여기에 now가 놓는다
                    // (i,j)에 놓을 때 내가 이길 수 있는 경우라면 상대방은 지므로 -1
                    if (isWin(now, map)) min = Math.min(min, -1);
                    // 다음 차례를 재귀로 호출후 그 결과를 min에 저장
                    min = Math.min(min, game(now == 1 ? 2 : 1, map));
                    // 내가 (i, j)에 놓지 않는 경우
                    map[i][j] = 0;
                }
            }
        }

        // min은 상대방의 승패를 저장한 것이므로 나의 승패는 반대로 리턴해줘야 함
        if (min == 1) return -1;
        else if (min == 0 || min == 2) return 0;
        else return 1;
    }

    public static boolean isWin(int now, int[][] map) { // 현재 map에서 now가 이길 수 있는가를 T/F로 리턴
        for (int i = 0; i < 3; i++) {
            if (map[i][0] == now && map[i][0] == map[i][1] && map[i][1] == map[i][2]) return true;
        }

        for (int j = 0; j < 3; j++) {
            if (map[0][j] == now && map[0][j] == map[1][j] && map[1][j] == map[2][j]) return true;
        }

        if (map[0][0] == now && map[0][0] == map[1][1] && map[1][1] == map[2][2]) return true;
        if (map[0][2] == now && map[0][2] == map[1][1] && map[1][1] == map[2][0]) return true;

        return false;
    }
}
