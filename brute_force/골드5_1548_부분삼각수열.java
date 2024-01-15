package brute_force;

import java.util.Arrays;
import java.util.Scanner;

public class 골드5_1548_부분삼각수열 {

    static int n;
    static int[] arr;
    static int min = 1;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        Arrays.sort(arr);
        if (n > 2) {
            for (int i = 0; i < n - 1; i++) {
                for (int j = n - 1; j >= 0; j--) {
                    if (i + 1 == j)
                        break;
                    if (arr[i] + arr[i + 1] > arr[j]) {
                        min = Math.max(min, j - i + 1);
                        break;
                    }
                }
            }
        }
        // 1 2 3 4 5
        if (min == 1 && n >= 2)
            min = 2;
        System.out.println(min);
    }
}
