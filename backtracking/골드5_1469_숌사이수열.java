package backtracking;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 골드5_1469_숌사이수열 {

    private static int N;
    private static boolean[] isVisited;
    private static int[] arr, comb;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        comb = new int[N * 2];
        Arrays.fill(comb, -1);
        isVisited = new boolean[N * 2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        bw.write(solve());
        bw.close();
    }

    private static String solve() {
        sb = new StringBuilder();

        DFS(0);
        if (sb.length() == 0) {
            sb.append(-1);
        }

        return sb.toString();
    }

    private static void DFS(int depth) {
        if (depth == 2 * N) {
            for (int i = 0; i < N * 2; i++) {
                sb.append(comb[i]).append(' ');
            }
            return;
        }

        if (sb.length() != 0) return;

        if (comb[depth] != -1) {
            DFS(depth + 1);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isVisited[i]) continue;
            if (depth + arr[i] + 1 < N * 2 && comb[depth] == -1 && comb[depth + arr[i] + 1] == -1) {
                isVisited[i] = true;
                comb[depth] = comb[depth + arr[i] + 1] = arr[i];
                DFS(depth + 1);
                comb[depth] = comb[depth + arr[i] + 1] = -1;
                isVisited[i] = false;
            }
        }
    }
}
