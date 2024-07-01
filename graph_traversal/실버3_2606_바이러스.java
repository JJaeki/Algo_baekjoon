package graph_traversal;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/2606

public class 실버3_2606_바이러스 {
    static int com, line;
    static boolean[] isvisited;
    static int[][] arr;
    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        com = Integer.parseInt(br.readLine());
        line = Integer.parseInt(br.readLine());
        arr = new int[com + 1][com + 1];
        isvisited = new boolean[com + 1];

        for (int i = 0; i < line; i++) {
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            // 연결된 쌍 저장
            arr[a][b] = arr[b][a] = 1;
        }
        dfs(1);
        System.out.println(count);
    }

    public static void dfs(int start) {
        // 방문한 컴은 감염 o
        isvisited[start] = true;
        for (int i = 0; i <= com; i++) {
            // 연결된 쌍 , 감염 o
            if (arr[start][i] == 1 && isvisited[i] == false) {
                count++;
                dfs(i);
            }
        }
    }
}
