package tree;

import java.io.*;

public class 골드5_5639_이진검색트리 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 루트 노드
        Node node = new Node(Integer.parseInt(br.readLine()));

        // 하위 노드
        while (true) {
            String read = br.readLine();
            if (read == null || read.equals("")) break;

            int input = Integer.parseInt(read);
            node.insert(input);
        }

        post(node, bw);

        bw.flush();
        bw.close();
        br.close();
    }

    // 후위 탐색
    private static void post(Node node, BufferedWriter bw) throws IOException {
        if (node.left != null) post(node.left, bw);
        if (node.right != null) post(node.right, bw);
        bw.write(node.number + System.lineSeparator());
    }

    private static class Node {
        int number;
        Node left, right;

        public Node(int number) {
            this.number = number;
        }

        void insert(int input) {
            // 삽입 노드가 현재 노드보다 작을 때(왼쪽 삽입)
            if (this.number > input) {
                if (this.left == null) {
                    this.left = new Node(input);
                } else {
                    this.left.insert(input);
                }
            }
            // 삽입 노드가 현재 노드보다 클 때(오른쪽 삽입)
            else {
                if (this.right == null) {
                    this.right = new Node(input);
                } else {
                    this.right.insert(input);
                }
            }

        }
    }

}
