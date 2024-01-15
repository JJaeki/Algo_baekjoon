package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 실버2_14247_나무자르기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Long answer = 0L;
        for (int i = 0; i < N; i++) {
            answer += Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] growth = new int[N];
        for (int i = 0; i < N; i++) {
            growth[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(growth);
        for (int i = 0; i < N; i++) {
            answer += growth[i] * i;
        }
        System.out.println(answer);
    }
}
