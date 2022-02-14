// 2805 - 농작물 수확하기

package d3;

import java.util.Scanner;

public class Num2805_농작물수확하기 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
            int result = 0;
            for (int i = 0; i < arr.length; i++) {
                String str = sc.next();
                for (int j = 0; j < arr[i].length; j++) {
                    arr[i][j] = str.charAt(j) - '0';
                }
            }

            for (int i = 0; i < arr.length / 2; i++) {
                for (int j = arr.length / 2 - i; j <= (arr.length / 2 + i); j++) {
                    result += arr[i][j];
                }
            }
            for (int i = arr.length / 2; i >= 0; i--) {
                for (int j = arr.length / 2 - i; j <= arr.length / 2 + i; j++) {
                    result += arr[arr.length - i - 1][j];
                }
            }
            System.out.println("#" + t + " " + result);
        }
    }
}
