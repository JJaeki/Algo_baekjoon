package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 실버3_18429_근손실 {

    static int n, k, answer;
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        visit = new boolean[n];
        answer = 0;
        dfs(500, 0);
        System.out.println(answer);
    }

    public static void dfs(int sum, int cnt) {
        if (cnt == n) {
            answer++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visit[i] && sum + arr[i] - k >= 500) {
                visit[i] = true;
                dfs(sum + arr[i] - k, cnt + 1);
                visit[i] = false;
            }
        }
    }
}
