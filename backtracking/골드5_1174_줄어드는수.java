package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 골드5_1174_줄어드는수 {

    static int[] digit = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    static List<Long> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();

        makeNum(0, 0);

        Collections.sort(list);

        if (N > list.size()) {
            System.out.println(-1);
        } else {
            System.out.println(list.get(N - 1));
        }

    }

    private static void makeNum(long num, int idx) {

        if (idx == 10) {
            if (!list.contains(num)) {
                list.add(num);
            }
            return;
        }

        // 해당 인덱스를 선택안하고 넘어감
        makeNum(num, idx + 1);

        // 해당 인덱스를 선택한 경우 num에 더함
        makeNum(num * 10 + digit[idx], idx + 1);
    }
}
