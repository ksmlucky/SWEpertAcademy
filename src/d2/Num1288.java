// 1288 - 새로운 불면증 치료법

package d2;

import java.util.Scanner;

public class Num1288 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int temp = 0;
            boolean[] check = new boolean[10];


            while (!isChecked(check)) {
                temp += N;
                String str = Integer.toString(temp);

                for (int i = 0; i < str.length(); i++) {
                    if (!check[str.charAt(i) - '0']) {
                        check[str.charAt(i) - '0'] = true;
                    }
                }
            }

            System.out.println("#" + t + " " + temp);

        }
    }


    public static boolean isChecked(boolean[] check) {
        for (int i = 0; i < check.length; i++) {
            if (check[i] == false) {
                return false;
            }
        }
        return true;
    }
}
