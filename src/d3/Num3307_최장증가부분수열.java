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
            int N = Integer.parseInt(br.readLine()); // 수열의 크기

            int[] arr = new int[N]; // 수열의 원소를 저장
            int[] dp = new int[N]; // 자신을 끝으로 하는 LIS 길이

            Arrays.fill(dp, 1); // 자신 혼자 LIS 구성할 때의 길이 1로 초기화

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int max = 1; // 해당 수열의 LIS 최장 길이
            for (int i = 0; i < N; i++) { // 모든 원소에 대해 자신을 끝으로 하는 LIS 길이 계산
                for (int j = 0; j < i; j++) { // 첫 원소부터 i원소 직전까지 비교
                    if (arr[j] < arr[i] && dp[i] < dp[j] + 1) { // arr[j] < arr[i]: 증가 수열의 모습인지 확인
                        dp[i] = dp[j] + 1;
                    }
                }
                max = Math.max(max, dp[i]);
            }

            System.out.println("#" + t + " " + max);
        }
    }
}
