package DP1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class 실버3_17175_피보나치는지겨웡 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[51];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (1 + dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        System.out.print(dp[n]);
    }
}
