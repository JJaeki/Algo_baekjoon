package dynamic_programming_1;

import java.util.Arrays;
import java.util.Scanner;

public class 실버2_20152_GameAddiction {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int N = sc.nextInt();
        int D = Math.abs(N - H);
        long[][] dp = new long[D + 1][D + 1];
        Arrays.fill(dp[0], 1);

        for (int i = 1; i <= D; i++) {
            dp[i][i] = dp[i - 1][i];
            for (int j = i + 1; j <= D; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        System.out.println(dp[D][D]);

    }
}
