package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 골드5_7569_토마토 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, H;
    static int[][][] box;
    static Queue<Tomato2> q = new LinkedList<>();
    static int day = 0;
    static int[] dx = {0, 0, 1, -1, 0, 0};
    static int[] dy = {1, -1, 0, 0, 0, 0};
    static int[] dh = {0, -0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());   // col size
        N = Integer.parseInt(st.nextToken());   // row size
        H = Integer.parseInt(st.nextToken());   // high size
        box = new int[H][N][M];
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());    // row
                for (int j = 0; j < M; j++) {
                    String col = st.nextToken();    // col
                    box[h][i][j] = Integer.parseInt(col);
                    if (col.equals("1")) {
                        q.offer(new Tomato2(h, j, i, 0));
                    }
                }
            }
        }

        bfs();

        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (box[h][i][j] == 0) {
                        day = -1;
                    }
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
            Tomato2 tomato = q.poll();
            int x = tomato.x;
            int y = tomato.y;
            int h = tomato.h;
            int days = tomato.day + 1;
            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nh = h + dh[i];
                if (nx >= 0 && nx < M && ny >= 0 && ny < N && nh >= 0 && nh < H) {
                    day = days;
                    if (box[nh][ny][nx] == 0) {
                        q.offer(new Tomato2(nh, nx, ny, days));
                        box[nh][ny][nx] = 1;
                    }
                }
            }
        }
    }
}

class Tomato2 {

    int x;
    int y;
    int h;
    int day;

    Tomato2(int h, int x, int y, int day) {
        this.h = h;
        this.x = x;
        this.y = y;
        this.day = day;
    }
}