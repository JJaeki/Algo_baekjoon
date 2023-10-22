package DP1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 실버2_22857_가장긴짝수연속한부분수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken());
        int K = stoi(st.nextToken());
        int arr[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = stoi(st.nextToken());
        }
        int R = 0, L = 0;
        int odd = 0;
        int even = 0;
        if (arr[0] % 2 == 0) even++;
        else odd++;
        int answer = even;
        while (R >= L) {
            if (odd > K) {
                if (arr[L] % 2 == 0) even--;
                else odd--;
                L++;
            } else {
                R++;
                if (R >= N) break;
                if (arr[R] % 2 == 0) even++;
                else odd++;
                answer = Math.max(answer, even);
            }
        }
        System.out.println(answer);
    }

    static int stoi(String s) {
        return Integer.valueOf(s);
    }

}
