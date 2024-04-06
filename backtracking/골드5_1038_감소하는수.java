package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 골드5_1038_감소하는수 {

    static List<Long> arr = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N <= 10) System.out.println(N);
        else {
            for (int i = 0; i < 10; i++) set(i, 1);
            if (N >= arr.size()) System.out.println(-1);
            else {
                Collections.sort(arr);
                System.out.println(arr.get(N));
            }
        }
    }

    static void set(long num, int val) {
        if (val > 10) return;

        arr.add(num);
        for (int i = 0; i < num % 10; i++) {
            set((num * 10) + i, val + 1);
        }
    }
}
