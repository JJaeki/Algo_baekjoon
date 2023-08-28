package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 골드5_7576_토마토 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[][] box;
    static Queue<Tomato> q = new LinkedList<>();
    static int day = 0;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());   // col size
        N = Integer.parseInt(st.nextToken());   // row size
        box = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());    // row
            for (int j = 0; j < M; j++) {
                String col = st.nextToken();    // col
                box[i][j] = Integer.parseInt(col);
                if (col.equals("1")) {
                    q.offer(new Tomato(j, i, 0));
                }
            }
        }

        bfs();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    day = -1;
                }
            }
        }
        if (day != -1) {
            System.out.println(day - 1);
        } else {
            System.out.println(day);
        }
    }// end main

    public static void bfs() {

        while (!q.isEmpty()) {
            Tomato tomas = q.poll();
            int x = tomas.x;
            int y = tomas.y;
            int days = tomas.day + 1;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    day = days;
                    if (box[ny][nx] == 0) {
                        q.offer(new Tomato(nx, ny, days));
                        box[ny][nx] = 1;
                    }
                }
            }
        }
    }
}

class Tomato {

    int x;
    int y;
    int day;

    Tomato(int x, int y, int day) {
        this.x = x;
        this.y = y;
        this.day = day;
    }
}

