package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 실버3_15657_N과M8 {

    static int N, M;
    static int[] ans;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        ans = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dfs(0, 0);
    }

    public static void dfs(int depth, int index) {
        if (depth == M) {
            for (int x : ans) {
                System.out.printf("%d ", x);
            }
            System.out.println();
            return;
        }
        for (int i = index; i < N; i++) {
            ans[depth] = arr[i];
            dfs(depth + 1, i);
        }
    }
}
