package DP1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 실버2_11568_민균이의계략 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;

        int num = Integer.parseInt(br.readLine());
        List<Integer> dp = new ArrayList<>();
        stringTokenizer = new StringTokenizer(br.readLine());

        dp.add(Integer.parseInt(stringTokenizer.nextToken()));

        for (int i = 1; i < num; i++) {
            int number = Integer.parseInt(stringTokenizer.nextToken());

            for (int j = 0; j < dp.size(); j++) {
                if (dp.get(j) >= number) {
                    dp.remove(j);
                    dp.add(j, number);
                    break;
                }

                if (j == dp.size() - 1) {
                    dp.add(number);
                }
            }
        }

        bw.write(dp.size() + "\n");
        bw.flush();
    }

}
