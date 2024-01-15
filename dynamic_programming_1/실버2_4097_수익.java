package dynamic_programming_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 실버2_4097_수익 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N;
        int[] arr;
        int max;
        StringBuilder sb = new StringBuilder();

        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }

            arr = new int[N];
            max = Integer.MIN_VALUE;

            for (int i = 0; i < N; i++) {
                int x = Integer.parseInt(br.readLine());
                arr[i] = x;

                if (i > 0) {
                    int y = arr[i - 1];

                    if (x + y > x) {   //직전 값과 현재 idx의 값을 더한게 더 클 때
                        arr[i] = x + y;
                    }
                }

                max = Math.max(max, arr[i]);
            }

            sb.append(max).append("\n");
        }

        System.out.print(sb);
    }


}
