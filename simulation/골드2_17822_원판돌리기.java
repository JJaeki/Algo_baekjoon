package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/17822

public class 골드2_17822_원판돌리기 {

    static int n, m, t;
    static ArrayList<Integer> al[];
    static boolean change;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        t = Integer.parseInt(stz.nextToken());
        al = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            al[i] = new ArrayList<Integer>();
            stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                al[i].add(Integer.parseInt(stz.nextToken()));
        }

        for (int i = 0; i < t; i++) {
            stz = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stz.nextToken());
            int d = Integer.parseInt(stz.nextToken());
            int k = Integer.parseInt(stz.nextToken());
            change = false;
            rotate(x, d, k);
            for (int a = 1; a <= n; a++) {
                for (int b = 0; b < m; b++)
                    if (al[a].get(b) != -1)
                        check(a, b, al[a].get(b));
            }

            if (!change)
                cal();
        }
        System.out.println(sum());
    }

    public static void rotate(int x, int d, int k) {
        for (int i = 1; i <= n; i++) {
            if (i % x == 0) {
                if (d == 0) {
                    for (int j = 0; j < k; j++)
                        al[i].add(0, al[i].remove(al[i].size() - 1));
                } else {
                    for (int j = 0; j < k; j++) {
                        int number = al[i].remove(0);
                        al[i].add(al[i].size(), number);
                    }
                }
            }
        }
    }

    public static void check(int x, int y, int value) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (ny == m)
                ny = 0;
            if (ny == -1)
                ny = m - 1;

            if (check(nx) && al[nx].get(ny) == value && al[nx].get(ny) != -1) {
                al[nx].set(ny, -1);
                change = true;
                check(nx, ny, value);
            }
        }
    }

    public static int sum() {
        int sum = 0;
        for (int a = 1; a <= n; a++) {
            for (int b = 0; b < m; b++)
                if (al[a].get(b) != -1)
                    sum += al[a].get(b);
        }

        return sum;
    }

    public static void cal() {
        int sum = 0;
        int count = 0;
        for (int a = 1; a <= n; a++) {
            for (int b = 0; b < m; b++)
                if (al[a].get(b) != -1) {
                    sum += al[a].get(b);
                    count++;
                }
        }
        if (count == 0)
            return;
        double avg = (double) sum / count;
        for (int a = 1; a <= n; a++) {
            for (int b = 0; b < m; b++) {
                if (al[a].get(b) != -1) {
                    if (al[a].get(b) > avg)
                        al[a].set(b, al[a].get(b) - 1);
                    else if (al[a].get(b) < avg)
                        al[a].set(b, al[a].get(b) + 1);
                }
            }
        }
    }

    public static boolean check(int x) {
        return x >= 1 && x <= n;
    }
}
