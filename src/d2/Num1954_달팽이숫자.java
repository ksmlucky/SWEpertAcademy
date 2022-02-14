// 1954 - 달팽이 숫자

package d2;

import java.util.Scanner;

public class Num1954_달팽이숫자 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();

            if (N == 1) {
                System.out.println("#" + t);
                System.out.println(1);
                continue;
            }

            int r = 0;
            int c = 0;
            int dir = 0;

            int[][] arr = new int[N][N];

            for (int i = 1; i <= N * N; i++) {
                arr[r][c] = i;
                r += dr[dir];
                c += dc[dir];

                // 앞으로 가다가 배열 밖으로 나가면
                if (r < 0 || r >= N || c < 0 || c >= N) {
                    // 원래 위치로 돌아옴
                    r -= dr[dir];
                    c -= dc[dir];

                    // 방향전환
                    dir = (dir + 1) % 4;

                    // 후 한칸앞으로 전진
                    r += dr[dir];
                    c += dc[dir];
                }

                // 한바퀴 돈 이후, 배열에 값이 있는 경우 배열바깥으로 나간거랑 똑같이
                if (arr[r][c] != 0) {

                    // 원래 위치로 돌아옴
                    r -= dr[dir];
                    c -= dc[dir];

                    // 방향전환
                    dir = (dir + 1) % 4;

                    // 후 한칸앞으로 전진
                    r += dr[dir];
                    c += dc[dir];
                }
            }

            System.out.println("#" + t);
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
