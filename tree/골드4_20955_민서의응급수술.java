package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 골드4_20955_민서의응급수술 {

    static int N, M, count = 0;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        init();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            input(stoi(st.nextToken()), stoi(st.nextToken()));
        }

        HashSet<Integer> hs = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            hs.add(find(i));
        }
        count += hs.size() - 1;

        System.out.println(count);
    }

    private static void input(int a, int b) {
        if (!union(a, b)) {
            count++;
        }
    }

    private static void init() {
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = -1;
        }
    }

    private static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parents[b] = a;
            return true;
        }
        return false;
    }

    private static int find(int a) {
        return parents[a] < 0 ? a : (parents[a] = find(parents[a]));
    }

    private static int stoi(String input) {
        return Integer.parseInt(input);
    }

}
