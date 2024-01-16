package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 실버1_17615_볼모으기 {

    public static int N, K;
    public static char[] arr;
    public static int answer = 500001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        arr = new char[N];
        st = new StringTokenizer(br.readLine());
        arr = st.nextToken().toCharArray();

        int firstBallCnt = 0;
        int redCnt = 0;
        int blueCnt = 0;

        //전체 공의 색깔 계산
        for (int i = 0; i < N; i++) {
            if (arr[i] == 'R') {
                redCnt += 1;
            }
            if (arr[i] == 'B') {
                blueCnt += 1;
            }
        }

        //1. 'R'을 맨 왼쪽으로 모으는 경우 RRRRRBBBBB
        for (int i = 0; i < N; i++) {
            if (arr[i] == 'R') {
                firstBallCnt += 1;
            } else {
                break;
            }
        }

        answer = Math.min(answer, redCnt - firstBallCnt);

        firstBallCnt = 0;
        //2. 'R'을 맨 오른쪽으로 모으는 경우
        for (int i = N - 1; i >= 0; i--) {
            if (arr[i] == 'R') {
                firstBallCnt += 1;
            } else {
                break;
            }
        }

        answer = Math.min(answer, redCnt - firstBallCnt);

        firstBallCnt = 0;
        //1. 'R'을 맨 왼쪽으로 모으는 경우 RRRRRBBBBB
        for (int i = 0; i < N; i++) {
            if (arr[i] == 'B') {
                firstBallCnt += 1;
            } else {
                break;
            }
        }

        answer = Math.min(answer, blueCnt - firstBallCnt);

        firstBallCnt = 0;
        //2. 'R'을 맨 오른쪽으로 모으는 경우
        for (int i = N - 1; i >= 0; i--) {
            if (arr[i] == 'B') {
                firstBallCnt += 1;
            } else {
                break;
            }
        }

        answer = Math.min(answer, blueCnt - firstBallCnt);

        System.out.println(answer);
    }

}
