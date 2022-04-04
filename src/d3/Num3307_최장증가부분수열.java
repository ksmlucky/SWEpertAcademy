// 3307 - 최장 증가 부분 수열

package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num3307_최장증가부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];
            int[] dp = new int[N];
            Arrays.fill(dp, 1);

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int max = 1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < i; j++) {
                    if (arr[j] < arr[i] && dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                    }
                }
                max = Math.max(max, dp[i]);
            }

            System.out.println("#" + t + " " + max);
        }
    }
}
