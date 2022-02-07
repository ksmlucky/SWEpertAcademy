// 1209 - [S/W 문제해결 기본] 2일차 - Sum

package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1209 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t <= 10; t++) {
            int[][] arr = new int[100][100];
            int T = Integer.parseInt(br.readLine());

            for (int i = 0; i < arr.length; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < arr.length; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = Integer.MIN_VALUE;
            int sum = 0;

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    sum += arr[i][j];
                }
                max = Math.max(max, sum);
                sum = 0;
            }
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    sum += arr[j][i];
                }
                max = Math.max(max, sum);
                sum = 0;
            }
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if (i == j) {
                        sum += arr[i][j];
                    }
                }
            }
            max = Math.max(max, sum);
            sum = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if (((arr.length - 1) - i) == j) {
                        sum += arr[i][j];
                    }
                }
            }
            max = Math.max(max, sum);

            System.out.println("#" + t + " " + max);
        }
    }
}
