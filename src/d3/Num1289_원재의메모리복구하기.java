// 1289 - 원재의 메모리 복구하기

package d3;

import java.util.Scanner;

public class Num1289_원재의메모리복구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            String str = sc.next();
            int[] arr = new int[str.length()];
            int count = 0;

            for (int i = 0; i < str.length(); i++) {
                arr[i] = str.charAt(i) - '0';
            }

            if (arr[0] == 1) {
                count++;
            }

            for (int i = 1; i < arr.length; i++) {
                if (arr[i] != arr[i - 1]) {
                    count++;
                }
            }

            System.out.println("#" + t + " " + count);
        }
    }
}
