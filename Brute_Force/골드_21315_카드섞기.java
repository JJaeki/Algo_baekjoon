package Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 골드_21315_카드섞기 {

    static String target = ""; //최종적으로 나와야하는 카드순서
    static int n; //카드개수
    static LinkedList<Integer> list; //섞고나서 카드를 저장할 리스트
    static StringBuilder ans = new StringBuilder(); //정답

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            target += st.nextToken();


        //1단계 = 2^k
        //...
        //i단계 = 2^(k-i+1)
        StringBuilder sb = new StringBuilder();
        dfs(0, sb);


    }

    //depth:카드섞을 횟수, sb:k의 종류
    public static void dfs(int depth, StringBuilder sb) {
        if (depth == 2) {
            int k1 = sb.charAt(0) - '0', k2 = sb.charAt(1) - '0';

            //리스트 초기화
            list = new LinkedList<Integer>();
            for (int i = 0; i < n; i++)
                list.add(i + 1);

            mix(k1);//섞기
            mix(k2);//섞기

            for (int l : list)
                ans.append(l);

            if (!ans.toString().equals(target)) ans.setLength(0);
            else {
                System.out.println(k1 + " " + k2);
                System.exit(0);
            }

            return;
        }

        //조합으로 k를 다뽑음
        for (int i = 1; i < n; i++) {
            if (i >= n || (int) Math.pow(2, i) >= n) continue;//제한조건
            sb.append(i);
            dfs(depth + 1, sb);
            sb.delete(sb.length() - 1, sb.length());
        }
    }

    public static void mix(int k) {
        //cnt: 섞일 카드수
        int cnt = (int) Math.pow(2, k);

        firstStep(cnt); //1단계
        NStep(k, cnt, 2, k - 1); //n단계
    }

    public static void firstStep(int cnt) {
        while (cnt-- > 0) {
            int num = list.pollLast();
            list.addFirst(num);
        }
    }

    //pre:이전에 섞은 카드수, i:단계, limit:k-i+1
    public static void NStep(int k, int pre, int i, int limit) {
        while (limit >= 0) {
            int cnt = (int) Math.pow(2, limit);//섞일 카드수
            int left = pre - (int) Math.pow(2, limit);//섞일 카드들 기준으로 왼쪽에 있는 카드들
            int right = list.size() - pre;//섞일 카드들 기준으로 오른쪽에 있는 카드들

            LinkedList<Integer> leftList = new LinkedList<Integer>();//왼쪽카드들 저장해줄 임시리스트
            LinkedList<Integer> rightList = new LinkedList<Integer>();//오른쪽카드들 저장해줄 임시리스트

            //카드 임시저장
            while (left-- > 0)
                leftList.add(list.poll());
            while (right-- > 0)
                rightList.add(list.pollLast());

            //저장했던 카드들을 list에 순서에 맞게 담아주기.
            while (!leftList.isEmpty())
                list.add(leftList.poll());
            while (!rightList.isEmpty())
                list.add(rightList.pollLast());

            //변수값 갱신
            pre = cnt;
            i++;
            limit = k - i + 1;
        }
    }

}
