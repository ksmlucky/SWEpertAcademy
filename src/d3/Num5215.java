// 5215 - 햄버거 다이어트

package d3;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Num5215 {
    static int N, L, max;
    static int[][] arr;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            N = sc.nextInt(); // 재료 수
            L = sc.nextInt(); // 제한 칼로리

            // arr[][0]은 맛 점수, arr[][1]은 칼로리
            arr = new int[N][2];

            max = 0;

            for (int i = 0; i < arr.length; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }

            solution(0, 0, 0);

            System.out.println("#" + t + " " + max);
        }
    }

    public static void solution(int index, int score, int cal) {
        if (cal > L) {
            return;
        }
        if (cal <= L) {
            max = Math.max(max, score);
        }
        if (index == N) {
            return;
        }

        solution(index+1, score + arr[index][0], cal + arr[index][1]);
        solution(index+1, score, cal);
    }

}

