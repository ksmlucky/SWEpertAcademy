// 6730 - 장애물 경주 난이도

package d3;

import java.util.Scanner;

public class Num6730 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }


            int first = 0, second = 0;
            int down = 0, up = 0;
            for (int i = 0; i < N - 1; i++) {
                first = arr[i];
                second = arr[i + 1];
                if (first > second) {
                    down = Math.max(down, first - second);
                } else {
                    up = Math.max(up, second - first);
                }
            }

            System.out.println("#" + t + " " + up + " " + down);
        }
    }
}
