package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 실버1_20117_호반우상인의이상한품질계산법 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N;
        N = Integer.parseInt(br.readLine());
        int i;
        int[] arr = new int[N];

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        for (i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        Arrays.sort(arr); // 배열을 소팅
        if (N % 2 == 0) { // 짝수일 경우에는
            for (i = N - 1; i >= N / 2; i--) {
                sum += arr[i] * 2; // 가장 마지막 수 부터 N/2까지 두 배 하여 합해주기만 하면 되고,
            }
        } else { // 홀수일 경우에는
            for (i = N - 1; i > N / 2; i--) {
                sum += arr[i] * 2; // 가장 마지막 수 부터 N/2 + 1까지 두 배 하여 합쳐주고,
            }
            sum += arr[i]; // 중간 값은 한 번 더해주기만 하면 됨
        }
        System.out.println(sum);
    }
}
