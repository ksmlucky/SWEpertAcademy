// 1984 - 중간 평균값 구하기

package d2;

import java.util.Arrays;
import java.util.Scanner;

public class Num1984_중간평균값구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int[] arr = new int[10];
            int sum = 0;
            long avg = 0;

            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);

            for (int i = 1; i < 9; i++) {
                sum += arr[i];
            }

            avg = Math.round((double) sum / 8);

            System.out.println("#" + t + " " + avg);
        }
    }
}
