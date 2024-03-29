package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 실버1_15566_개구리1 {

    static int N, M, type[][], frog[][], flower[], log[][];
    static int frogans[];
    static boolean ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        type = new int[N][4];
        frog = new int[N][2];
        log = new int[N][N];
        flower = new int[N];
        frogans = new int[N];
        ans = false;
        Arrays.fill(flower, -1);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                type[i][j] = stoi(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            frog[i][0] = stoi(st.nextToken()) - 1;
            frog[i][1] = stoi(st.nextToken()) - 1;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = stoi(st.nextToken()) - 1;
            int v = stoi(st.nextToken()) - 1;
            int t = stoi(st.nextToken()) - 1;
            log[u][v] = t;
            log[v][u] = t;
        }
        recursion(0);
        if (ans) {
            System.out.println("YES");
            for (int i = 0; i < N; i++)
                System.out.print(frogans[i] + 1 + " ");
        } else
            System.out.println("NO");
    }

    static boolean recursion(int frogindex) {
        if (frogindex == N) {
            if (isValid()) {
                ans = true;
                return true;
            }
            return false;
        }
        for (int i = 0; i < 2; i++) {
            int tempflower = frog[frogindex][i];
            if (flower[tempflower] == -1) {
                flower[tempflower] = frogindex;
                if (recursion(frogindex + 1))
                    return true;
                flower[tempflower] = -1;
            }
        }
        return false;
    }

    static boolean isValid() {
        boolean valid = true;
        out:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j && log[i][j] != 0) {
                    int f1 = flower[i];
                    int f2 = flower[j];
                    int target = log[i][j];
                    if (type[f1][target] == type[f2][target]) {
                        continue;
                    } else {
                        valid = false;
                        break out;
                    }
                }
            }
        }
        if (valid)
            frogans = flower.clone();
        return valid;
    }

    static int stoi(String s) {
        return Integer.valueOf(s);
    }
}
