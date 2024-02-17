package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 골드4_22856_트리순회 {

    static class Node {
        int left;
        int right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    static List<Node>[] list;
    static List<Integer> inOrder;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            list[a].add(new Node(l, r));
        }

        inOrder = new ArrayList<>();
        dfs(1, 0, true);
        dfs(1, 0, false);
    }

    static void dfs(int here, int pa, boolean f) {
        for (Node node : list[here]) {
            if (node.left != -1) {
                dfs(node.left, here, f);
                if (!f) cnt++;
            }
            if (f) {
                inOrder.add(here);
            } else {
                if (inOrder.get(inOrder.size() - 1) == here) {
                    System.out.println(cnt);
                    return;
                }
                cnt++;
            }
            if (node.right != -1) {
                dfs(node.right, here, f);
                if (!f) cnt++;
            }
        }
    }
}
