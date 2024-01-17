package greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 실버1_16206_롤케이크 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> cakes1 = new ArrayList<>();
        ArrayList<Integer> cakes2 = new ArrayList<>();
        int temp;
        for (int i = 0; i < n; i++) {
            temp = Integer.parseInt(st.nextToken());
            if (temp % 10 == 0) cakes1.add(temp);
            else cakes2.add(temp);
        }
        int result = 0;
        int cut, piece;

        cakes1.sort(Comparator.naturalOrder());
        for (int cake : cakes1) {
            if (count <= 0) break;

            piece = cake / 10;
            cut = piece - 1;

            if (count < cut) {
                cut = count;
                piece = cut;
                if (cake - (piece * 10) == 10) piece++;
            }
            count -= cut;
            result += piece;
        }

        for (int cake : cakes2) {
            if (count <= 0) break;

            piece = cake / 10;
            cut = piece;

            if (count < cut) {
                cut = count;
                piece = cut;
            }
            count -= cut;
            result += piece;
        }

        bw.write(String.valueOf(result));

        bw.write("\n"); // for return value
        bw.flush(); // flush
        bw.close(); // close
        br.close(); // close
    }
}
