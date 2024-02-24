package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 실버2_171728_소가정보섬에올라온이유 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N, Q, ans = 0;
        int[] A;
        int[] dp;

        N = Integer.parseInt(st.nextToken());   // 소의 수
        Q = Integer.parseInt(st.nextToken());   // 장난칠 횟수
        A = new int[N];                         // 소들의 품질 점수
        dp = new int[N];

        //품질 점수 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        //dp에 저장
        for (int i = 0; i < N; i++) {
            int temp = 1;
            int a1, a2, a3, a4;

            if (i >= N) a1 = i % (N - 1) - 1;
            else a1 = i;
            if (i + 1 >= N) {
                if ((i + 1) % (N - 1) == 0)
                    a2 = a1 + 1;
                else
                    a2 = (i + 1) % (N - 1) - 1;
            } else a2 = i + 1;
            if (i + 2 >= N) {
                if ((i + 2) % (N - 1) == 0)
                    a3 = a2 + 1;
                else
                    a3 = (i + 2) % (N - 1) - 1;
            } else a3 = i + 2;
            if (i + 3 >= N) {
                if ((i + 3) % (N - 1) == 0)
                    a4 = a3 + 1;
                else
                    a4 = (i + 3) % (N - 1) - 1;
            } else a4 = i + 3;

            temp *= A[a1];
            temp *= A[a2];
            temp *= A[a3];
            temp *= A[a4];
            dp[i] += temp;
            ans += temp;
        }

        //Q번만큼 재계산
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            int qi = Integer.parseInt(st.nextToken());
            if (--qi == -1)
                qi = N - 1;
            for (int j = 0; j < 4; j++) {
                dp[qi] = -dp[qi];
                ans += 2 * dp[qi];
                if (--qi == -1) {
                    qi = N - 1;
                }
            }
            sb.append(ans + "\n");
        }
        System.out.println(sb.toString());
    }

}
