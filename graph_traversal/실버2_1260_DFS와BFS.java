package graph_traversal;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/1260

public class 실버2_1260_DFS와BFS {

    static int[][] map; 		//간선 연결상태
    static boolean[] isvisited; //확인 여부
    static int n; 				//정점개수
    static int m; 				//간선개수
    static int s; 				//시작정점
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        s = Integer.parseInt(str[2]);

        map = new int[1001][1001]; 		//좌표를 그대로 받아들이기 위해 +1해서 선언
        isvisited = new boolean[1001];

        //간선 연결상태 저장
        for(int i = 0; i < m; i++) {
            str = br.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);

            map[x][y] = map[y][x] = 1;
        }

        sb = new StringBuilder();
        dfs(s);
        System.out.println(sb);

        isvisited = new boolean[1001]; 	//확인상태 초기화

        sb = new StringBuilder();
        bfs();
        System.out.println(sb);
    }


    public static void dfs(int stsrt) {
        isvisited[stsrt] = true;
        sb.append(stsrt).append(" ");

        for(int j = 1; j <= n; j++) {
            // 연결 o 확인 x
            if(map[stsrt][j] == 1 && isvisited[j] == false) {
                dfs(j);
            }
        }
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(s); // 시작점도 Queue에 저장
        isvisited[s] = true;
        sb.append(s).append(" ");

        //Queue가 빌 때까지 반복. 방문 정점은 확인, 출력 후 Queue에 넣어 순서대로 확인
        while(!queue.isEmpty()) {
            int start = queue.poll();

            for(int j = 1; j <= n; j++) {
                // 연결 o 확인 x
                if(map[start][j] == 1 && isvisited[j] == false) {
                    queue.offer(j);
                    isvisited[j] = true;
                    sb.append(j).append(" ");
                }

            }

        }
    }
}
