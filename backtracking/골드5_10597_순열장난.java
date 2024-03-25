package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 골드5_10597_순열장난 {

    private static int N;
    private static boolean[] visited;
    private static String str;
    private static int[] result;
    private static boolean flag;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        flag = false;

        // 단계 1. N을 구하기
        // 등차수열 공식 활용
        // An = A1 + (n-1)d
        if (str.length() < 10) {
            N = str.length();
            visited = new boolean[N + 1];
            result = new int[N];
        } else {
            N = (str.length() + 7) / 2 + 1;
            visited = new boolean[N + 1];
            result = new int[N];
        }

        // 단계 2. 재귀함수를 사용
        dfs(0, 0);

    }

    private static void dfs(int cnt, int idx) {
        if (idx >= N) {
            for (int i = 0; i < result.length; i++) {
                if (i == result.length - 1) System.out.print(result[i]);
                else System.out.print(result[i] + " ");
            }
            // 단계 3. 조건에 맞으면 boolean 변수 flag를 사용 빠져나가게 함
            flag = true;
            return;
        }


        // 단계 2. 기준cnt에서 한자리수와 두자리수를 만들어서 조건에 맞으면 재귀함수 진행
        if (flag) return;
        int num1 = str.charAt(cnt) - '0'; // 1자리수
        if (num1 != 0 && !visited[num1]) {
            visited[num1] = true;
            result[idx] = num1;
            dfs(cnt + 1, idx + 1);
            if (flag) return;
            visited[num1] = false;
        }

        if (cnt + 1 < str.length()) {
            String str2 = str.substring(cnt, cnt + 2);
            int num2 = Integer.parseInt(str2); // 2자리 수

            if (num2 <= N && !visited[num2]) {
                visited[num2] = true;
                result[idx] = num2;
                dfs(cnt + 2, idx + 1);
                if (flag) return;
                visited[num2] = false;
            }
        }

    }

}
