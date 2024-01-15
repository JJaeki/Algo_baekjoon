package tree;

import java.util.*;
import java.io.*;

public class 골드4_9489_사촌 {

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            // get n,k info
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            // end condition
            if (n == 0 && k == 0) {
                break;
            }
            // input node values and make tree
            int[][] tree = new int[n][2]; //[노드의 입력 인덱스][0=자신의값,1=부모의 값]
            int kIdx = 0; // k의 인덱스
            int pIdx = 0; // 트리를 만들때 부모 노드가 뭔지 기억하기 위함.
            int prev = -1; // 이전 값을 담기위한 변수
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                // get a node number
                int input = Integer.parseInt(st.nextToken());
                // save k's Idx
                if (input == k) {
                    kIdx = i;
                }
                // if not continuous pIdx++
                if (prev + 1 != input && i > 1) {
                    pIdx++;
                }
                // if first Input -> parent Idx = -1 / other -> pIdx
                tree[i] = new int[]{input, i == 0 ? -1 : pIdx};
                // set prev for the next
                prev = input;
            }
            // Logic
            int ans = 0; // 정답을 담을 변수(k의 사촌의 수)
            int kpIdx = tree[kIdx][1]; // k의 부모 인덱스
            for (int idx = 1; idx < n; idx++) {
                int iVal = tree[idx][1]; // 현재 노드의 부모 인덱스
                if (tree[kpIdx][0] != tree[iVal][0] // 부모는 다른데
                        && tree[kpIdx][1] == tree[iVal][1]) {
                    ans++; // 부모의부모(조부모)는 같다면 ans++
                }
            }
            // follow the answer
            sb.append(ans).append("\n");
        }
        // Output
        System.out.print(sb.toString());
    }

}
