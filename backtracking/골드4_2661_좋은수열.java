package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/2661

public class 골드4_2661_좋은수열 {

    static int start = 1;
    static int end = 3;
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        backtracking("");
    }

    public static void backtracking(String str) {
        if (str.length() == n) {
            System.out.println(str);
            System.exit(0);
        }

        for (int i = start; i <= end; i++) {
            if (can_make_str(str + i)) backtracking(str + i);
        }
    }

    public static boolean can_make_str(String str) {
        for (int i = 1; i <= str.length() / 2; i++) {
            String front = str.substring(str.length() - i * 2, str.length() - i);
            String back = str.substring(str.length() - i, str.length());
            if (front.equals(back)) return false;
        }
        return true;
    }
}
