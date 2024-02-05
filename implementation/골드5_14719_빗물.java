package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 골드5_14719_빗물 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken()); // 세로
        int W = Integer.parseInt(st.nextToken()); // 가로

        st = new StringTokenizer(br.readLine());

        int[] height = new int[W]; // 인덱스 별 높이 지정
        for (int i = 0; i < W; i++) height[i] = Integer.parseInt(st.nextToken());

        int rain = 0;

        for (int i = 1; i < W - 1; i++) { // 첫 인덱스와 마지막 인덱스엔 빗물이 고일 수 없음
            int leftHeight = 0;
            int rightHeight = 0;

            for (int j = 0; j < i; j++) {
                leftHeight = Math.max(height[j], leftHeight); // 현재 인덱스 기준 왼쪽 최고 높이 찾기
            }

            for (int j = (i + 1); j < W; j++) {
                rightHeight = Math.max(height[j], rightHeight); // 현재 인덱스 기준 오른쪽 최고 높이 찾기
            }

            // 빗물이 고이기 위해선 현재 인덱스의 높이가 왼쪽 최고 높이와 오른쪽 최고 높이보다 작아야함
            // 빗물은 왼쪽, 오른쪽 중 최소 높이만큼은 참
            if (height[i] < leftHeight && height[i] < rightHeight)
                rain += Math.min(leftHeight, rightHeight) - height[i];
        }
        System.out.println(rain);
    }
}
