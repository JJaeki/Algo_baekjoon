package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 골드5_19598_최소회의실개수 {

    public static int N, K;
    public static Node[] node;
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        node = new Node[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            node[i] = new Node(startTime, endTime);
        }

        Arrays.sort(node);

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.offer(node[0].endTime);

        for (int i = 1; i < N; i++) {
            if (pq.peek() <= node[i].startTime) {
                pq.poll();
            }
            pq.add(node[i].endTime);
        }
        System.out.println(pq.size());

    }
}

class Node implements Comparable<Node> {
    int startTime;
    int endTime;

    public Node(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Node other) {
        if (this.startTime == other.startTime)
            return this.endTime - other.endTime;

        return this.startTime - other.startTime;
    }

}
