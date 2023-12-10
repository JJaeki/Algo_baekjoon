package DP2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 골드2_20181_꿈틀꿈틀호석애벌레_효율 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long[] dp = new long[N + 1];
        long sum = arr[0];
        int left = 0, right = 1;

        while (right <= N) {
            if (sum >= K) {
                while (sum >= K) {
                    dp[right] = Math.max(dp[right], dp[left] + sum - K);
                    sum -= arr[left++];
                }
            } else {
                dp[right] = Math.max(dp[right], dp[right - 1]);

                if (right == N)
                    break;

                sum += arr[right++];
            }
        }

        System.out.println(dp[N]);
    }
}
