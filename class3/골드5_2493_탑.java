package class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

class Top { // 탑에 대한 정보
    int idx; // 탑의 번호
    int height; // 탑의 높이

    Top(int idx, int height) {
        this.idx = idx;
        this.height = height;
    }
}

public class 골드5_2493_탑 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());	// 탑 개수

        Stack<Top> stack = new Stack<>();		// 탑

        StringBuilder str = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            int top_height = Integer.parseInt(st.nextToken());

            // 스택 빈 경우 : 0을 출력하고 현재 탑을 push
            if (stack.isEmpty()) {
                str.append("0 ");
                stack.push(new Top(i, top_height));
            }
            else {
                while (true) {
                    // 스택 빈 경우 : 0을 출력하고 현재 탑을 push
                    if (stack.isEmpty()) {
                        str.append("0 ");
                        stack.push(new Top(i, top_height));
                        break;		// 출력 발생하면 바로 다음 탑 읽어오기
                    }

                    Top old = stack.peek();
                    int old_height = old.height;
                    int old_idx = old.idx;


                    // 이전 탑의 높이가 현재 탑의 높이보다 높은 경우
                    if (old_height > top_height) {
                        str.append(old_idx).append(" "); 	// 이전 탑의 번호를 출력
                        stack.push(new Top(i, top_height));		// 현재 탑을 스택에 push
                        break;			// 출력 발생하면 바로 다음 탑 읽어오기
                    }
                    // 이전 탑의 높이가 현재 탑의 높이보다 낮은 경우
                    else {
                        stack.pop(); // 스택에서 pop
                    }
                }
            }
        }

        bw.write(str.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}