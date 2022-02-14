// 1959 - 두 개의 숫자열

package d2;

import java.util.Scanner;

public class Num1959_두개의숫자열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] a = new int[N];
            int[] b = new int[M];

            for (int i = 0; i < N; i++) {
                a[i] = sc.nextInt();
            }
            for (int i = 0; i < M; i++) {
                b[i] = sc.nextInt();
            }

            int max = Integer.MIN_VALUE;

            if (N < M) {
                for (int i = 0; i < M - N + 1; i++) {
                    int sum = 0;
                    for (int j = 0; j < N; j++) {
                        sum += a[j] * b[j + i];
                    }
                    max = Math.max(max, sum);
                }
            } else {
                for (int i = 0; i < N - M + 1; i++) {
                    int sum = 0;
                    for (int j = 0; j < M; j++) {
                        sum += b[j] * a[j + i];
                    }
                    max = Math.max(max, sum);
                }
            }

            System.out.println("#" + t + " " + max);
        }
    }
}
