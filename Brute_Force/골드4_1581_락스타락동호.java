package Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 골드4_1581_락스타락동호 {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[4];
        for (int i = 0; i < 4; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int ans = 0;

        if (arr[0] == 0 && arr[1] == 0 && arr[2] != 0 && arr[3] != 0) ans = arr[3] + 1; //빠른곡으로 시작하는거 없을때 경우 1.
        else if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0 && arr[3] != 0) ans = arr[3]; //빠른곡으로 시작하는거 없을때 경우 2.
        else if (arr[0] == 0 && arr[1] == 0 && arr[2] != 0 && arr[3] == 0) ans = 1; //빠른곡으로 시작하는거 없을때 경우 3.
        else {//빠른거로 시작하는거 있을때.
            if (arr[0] != 0 && arr[1] == 0) ans += arr[0]; //FS 곡이 없다.
            else if (arr[0] != 0 && arr[1] != 0) { //FF FS 가 존재할때.
                ans += arr[0] + 1;//FF개수 + FS 하나
                arr[1]--;
                ans += arr[3]; //현재까지 마지막곡은 FS -> SS곡을 모두 담는다.
                if (arr[1] >= arr[2]) ans += (arr[2] * 2); //FS가 SF보다 크거나 같다면 SF를 다쓸수 있음.
                else if (arr[1] < arr[2]) ans += (arr[1] * 2) + 1; //SF가 FS보다 크다면 FS를 다쓰고 마지막에 SF곡 을 담을수 있음.
            } else if (arr[0] == 0 && arr[1] != 0) { //FF가 없을때.
                ans = 1;//FS로 시작
                arr[1]--;
                ans += arr[3];
                if (arr[1] >= arr[2]) ans += (arr[2] * 2);
                else if (arr[1] < arr[2]) ans += (arr[1] * 2) + 1;
            }
        }
        System.out.println(ans);
    }

}
