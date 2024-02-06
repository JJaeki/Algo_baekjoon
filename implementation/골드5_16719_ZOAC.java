package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 골드5_16719_ZOAC {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int N = s.length();
        List<Integer> lst = new ArrayList<Integer>();
        recursion(0, N - 1, s, lst);
    }

    public static void recursion(int startIdx, int endIdx, String s, List<Integer> lst) {
        if (startIdx > endIdx) return;
        int minIdx = 0;
        char minChar = 'Z' + 1;
        for (int i = startIdx; i <= endIdx; i++) {
            if (s.charAt(i) < minChar) {
                minIdx = i;
                minChar = s.charAt(i);
            }
        }
        lst.add(minIdx);
        Collections.sort(lst);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lst.size(); i++) {
            sb.append(s.charAt(lst.get(i)));
        }
        System.out.println(sb.toString());
        recursion(minIdx + 1, endIdx, s, lst);
        recursion(startIdx, minIdx - 1, s, lst);

    }
}
