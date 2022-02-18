// 1247 - [S/W 문제해결 응용] 3일차 - 최적 경로

package d5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1247_최적경로 {
    static int N;
    static int min = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine()); // 고객의 수

            // 회사 -> 고객의 집(N) -> 본인의 집
            int[][] arr = new int[N + 2][N];
            boolean[] check = new boolean[N + 2];
            int[] result = new int[N + 2];

            StringTokenizer st = new StringTokenizer(br.readLine());
            // 집
            arr[0][0] = Integer.parseInt(st.nextToken());
            arr[0][1] = Integer.parseInt(st.nextToken());

            // 회사
            arr[N + 1][0] = Integer.parseInt(st.nextToken());
            arr[N + 1][1] = Integer.parseInt(st.nextToken());

            // 고객들
            for (int i = 1; i <= N; i++) {
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            solution(1, arr, check, result);
            System.out.println("#" + t + " " + min);
            min = Integer.MAX_VALUE;

        }
    }

    public static void solution(int count, int[][] arr, boolean[] check, int[] result) {
        if (count == N + 1) {
            int sum = 0;
            for (int i = 0; i < N + 1; i++) {
                sum += Math.abs(arr[result[i]][0] - arr[result[i + 1]][0]) + Math.abs(arr[result[i]][1] - arr[result[i + 1]][1]);
            }

            min = Math.min(min, sum);
            return;

        }

        result[0] = 0;
        check[0] = true;

        result[N + 1] = N + 1;
        check[N + 1] = true;

        for (int i = 0; i < N + 1; i++) {
            if (check[i]) {
                continue;
            }
            result[count] = i;
            check[i] = true;
            solution(count + 1, arr, check, result);
            check[i] = false;
        }
    }
}
