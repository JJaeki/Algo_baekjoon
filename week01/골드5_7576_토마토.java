package week01;

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
    static Queue<toma> q = new LinkedList<>();
    static int day = 0;

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];
        for (int i = 0; i < N; i++) {
            String low = br.readLine();
            st = new StringTokenizer(low);
            for (int j = 0; j < M; j++) {
                String bbb = st.nextToken();
                box[i][j] = Integer.parseInt(bbb);
                if (bbb.equals("1")) {
                    q.offer(new toma(i, j, 0));
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
        int[] xrange = {1, -1, 0, 0};
        int[] yrange = {0, 0, 1, -1};

        while (!q.isEmpty()) {
            toma tomas = q.poll();
            int nx = tomas.x;
            int ny = tomas.y;
            int days = tomas.day + 1;
            for (int i = 0; i < 4; i++) {
                int nnx = nx + xrange[i];
                int nny = ny + yrange[i];
                if (nnx >= 0 && nnx < N && nny >= 0 && nny < M) {
                    day = days;
                    if (box[nnx][nny] == 0) {
                        q.offer(new toma(nnx, nny, days));
                        box[nnx][nny] = 1;
                    }
                }
            }
        }
    }
}

class toma {

    int x;
    int y;
    int day;

    toma(int x, int y, int day) {
        this.x = x;
        this.y = y;
        this.day = day;
    }
}

