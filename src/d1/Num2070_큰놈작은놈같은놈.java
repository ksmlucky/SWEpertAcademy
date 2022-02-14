// 2070 - 큰 놈, 작은 놈, 같은 놈

package d1;

import java.util.Scanner;

public class Num2070_큰놈작은놈같은놈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (a > b) {
                System.out.println("#" + t + " " + ">");
            } else if (a < b) {
                System.out.println("#" + t + " " + "<");
            } else {
                System.out.println("#" + t + " " + "=");
            }
        }
    }
}
