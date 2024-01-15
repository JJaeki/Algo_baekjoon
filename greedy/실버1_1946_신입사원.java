package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class 실버1_1946_신입사원 {
    static int T, num;
    static int[][] score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine()); // 테스트케이스

        for (int i = 0; i < T; i++) {
            num = Integer.parseInt(br.readLine());
            score = new int[num][2];

            for (int j = 0; j < num; j++) {
                String[] str = br.readLine().split(" ");
                score[j][0] = Integer.parseInt(str[0]);
                score[j][1] = Integer.parseInt(str[1]);
            }

            // 서류 등수 순으로 정렬
            Arrays.sort(score, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return Integer.compare(o1[0], o2[0]);
                }

            });

            int top = score[0][1];    //서류1등의 면접점수 (서류 1등은 무조건 통과)
            int cnt = 0;
            for (int j = 1; j < num; j++) {
                if (top < score[j][1]) {    //서류 등수가 더 높은 지원자보다 면접등수가 낮으면 탈락
                    cnt++;
                    continue;
                }
                top = score[j][1];    //탈락 안된 지원자의 면접점수
            }

            System.out.println(num - cnt);    //총 인원 - 탈락자 수
        }

    }
}
