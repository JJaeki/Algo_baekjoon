package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 골드5_15918_랭퍼든수열쟁이야 {

    static int[] arr;
    static boolean[] visited;
    static int n, x, y;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        arr = new int[25];
        visited = new boolean[13];

        arr[x] = arr[y] = y - x - 1;
        visited[y - x - 1] = true;

        backtracking(1);
        System.out.println(cnt);
    }

    static void backtracking(int idx) {
        if (idx == 2 * n) {
            cnt++;
            return;
        }
        if (arr[idx] == 0) {
            for (int i = 1; i <= n; i++) {
                if (visited[i] == true) continue;
                if (idx + i + 1 <= 2 * n && arr[idx + i + 1] == 0) {
                    arr[idx] = arr[idx + i + 1] = i;
                    visited[i] = true;
                    backtracking(idx + 1);
                    arr[idx] = arr[idx + i + 1] = 0;
                    visited[i] = false;
                }
            }
        } else {
            backtracking(idx + 1);
        }
    }
}
