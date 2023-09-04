package Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 골드4_1863_스카이라인쉬운거 {

    static int n;
    static int answer;
    static int[] height;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n=Integer.parseInt(br.readLine());
        height = new int[n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            height[i]=Integer.parseInt(st.nextToken());

        }
        Stack<Integer> stack = new Stack<>();
        for(int h :height ) {
            // 0을 저장하면 안되므로 스택을 비움
            if(h==0) {
                answer+=stack.size();
                stack.clear();
            }
            else if(!stack.isEmpty()) {
                int peek=stack.peek();
                // 높이가 높아지면 스택에 push
                if(peek<h) {
                    stack.push(h);
                }else {
                    //높이가 낮아지면 그 높이보다 높은 건물들을 스택에서 꺼냄
                    while
                    (!stack.isEmpty() && stack.peek()>h) {
                        stack.pop();
                        answer++;
                    }
                    // 스택에 없는 새로운 높이라면 push
                    if(!stack.isEmpty() && stack.peek()<h)
                        stack.push(h);
                    if(stack.isEmpty())
                        stack.push(h);
                }
            }else {
                // 스택이 비어있으면 무조건 push
                stack.push(h);
            }
        }
        answer += stack.size();
        stack.clear();
        System.out.println(answer);


    }
}
