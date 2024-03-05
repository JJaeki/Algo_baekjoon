package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 실버3_15656_N과M7 {

    private static int[] result; // 결과 값을 저장할 배열
    private static int[] result_set; // 가능한 숫자를 저장할 배열
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        // 가능한 숫자
        int N = Integer.parseInt(temp[0]);
        // 숫자 자리수
        int M = Integer.parseInt(temp[1]);

        // 결과 값 저장 배열 선언
        result = new int[M];

        result_set = new int[N];

        temp = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            result_set[i] = Integer.parseInt(temp[i]);
        }

        Arrays.sort(result_set); // 가능한 숫자들을 오름차순으로 정렬
        get_NM(N, M, 0); // 조합을 구하는 함수 호출

        System.out.println(sb); // 결과 출력

    }

    private static void get_NM(int N, int M, int depth) {

        if (depth == M) {
            // 결과 배열에 저장된 숫자들을 순서대로 출력
            for (int num : result) {
                sb.append(result_set[num - 1]).append(" ");
            }
            sb.append("\n"); // 개행 문자 삽입
            return;
        }

        // 가능한 숫자 개수만큼 반복
        for (int i = 1; i <= N; i++) {
            result[depth] = i; // 결과 배열에 숫자 저장
            get_NM(N, M, depth + 1); // 다음 자리 숫자를 구하기 위해 재귀 호출
        }
    }
}
