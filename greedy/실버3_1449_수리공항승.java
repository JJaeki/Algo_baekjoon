package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 실버3_1449_수리공항승 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());   //배열크기
        int L = Integer.parseInt(st.nextToken());

        int arr[] = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i= 0;i<M;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int range = (int)(arr[0]- 0.5 + L); //최소 0.5이므로 0.5전부터 테이브 길이 이 값을 다음 값이 벗어난다면 하나 붙이는 식으로
        int count = 1;  //가장 첫번째는 담았기에 카운트
        //다음거랑 L범위 안에 있다면 카운트 1 아니면 2

        for(int i=1;i<arr.length;i++){
            if(range <(int)(arr[i]+0.5)){
                range = (int)(arr[i]-0.5 + L);
                count++;
            }
        }

        System.out.println(count);
    }

}
