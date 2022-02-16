// 4012 - [모의 SW 역량테스트] 요리사

package 모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 모의SW역량테스트_Num4012_요리사 {
    static int N;
    static int[][] arr;
    static boolean[] check;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            check = new boolean[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            combination(0, 0);

            sb.append("#").append(t).append(" ");
            sb.append(min).append("\n");

            min = Integer.MAX_VALUE;
        }

        System.out.println(sb);
    }

    public static void combination(int count, int index) {
        if (count == N / 2) {
            solution();
            return;
        }

        for (int i = index; i < N; i++) {
            check[i] = true;
            combination(count + 1, i + 1);
            check[i] = false;
        }
    }

    public static void solution() {
        int A = 0;
        int B = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (check[i] && check[j]) {
                    A += arr[i][j] + arr[j][i];
                } else if (!check[i] && !check[j]) {
                    B += arr[i][j] + arr[j][i];
                }
            }
        }

        int isMin = Math.abs(A - B);
        min = Math.min(min, isMin);
    }
}
