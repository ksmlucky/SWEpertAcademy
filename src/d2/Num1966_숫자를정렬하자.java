// 1966 - 숫자를 정렬하자

package d2;

import java.util.Arrays;
import java.util.Scanner;

public class Num1966_숫자를정렬하자 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {

            int N = sc.nextInt();

            int[] arr = new int[N];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);

            System.out.print("#" + t + " ");

            for (int i = 0; i < arr.length; i++) {
                if (i != arr.length - 1) {
                    System.out.print(arr[i] + " ");
                } else {
                    System.out.print(arr[i] + "\n");
                }
            }
        }
    }
}
