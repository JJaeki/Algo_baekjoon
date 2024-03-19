package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 실버2_19699_소난다 {


    static int N, M;
    static int[] cow, group;
    static boolean[] prime;
    static TreeSet<Integer> ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cow = new int[N];
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cow[i] = Integer.parseInt(st.nextToken());
            sum += cow[i];
        }

        prime = new boolean[sum + 1];
        prime[0] = prime[1] = true;
        for (int i = 2; i * i <= sum; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= sum; j += i) {
                    prime[j] = true;
                }
            }
        }

        ans = new TreeSet<>();
        group = new int[M];
        makeGroup(0, 0);

        if (ans.size() != 0) {
            ans.stream().forEach(num -> System.out.print(num + " "));
        } else {
            System.out.println(-1);
        }

    }

    private static void makeGroup(int cnt, int idx) {
        if (cnt == M) {
            int sum = 0;
            for (int i = 0; i < M; i++) {
                sum += group[i];
            }
            if (!prime[sum]) {
                ans.add(sum);
            }
            return;
        }

        for (int i = idx; i < N; i++) {
            group[cnt] = cow[i];
            makeGroup(cnt + 1, i + 1);
        }
    }
}
