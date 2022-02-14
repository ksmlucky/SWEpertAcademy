// 3431 - 준환이의 운동관리

package d3;

import java.util.Scanner;

public class Num3431_준환이의운동관리 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int L = sc.nextInt();
            int U = sc.nextInt();
            int X = sc.nextInt();
            int answer = 0;

            if (X < L) {
                answer = L - X;
            } else if (X >= L && X <= U) {
                answer = 0;
            } else {
                answer = -1;
            }

            System.out.println("#" + t + " " + answer);
        }
    }
}
