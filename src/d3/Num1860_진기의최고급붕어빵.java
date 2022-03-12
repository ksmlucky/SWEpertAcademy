// 1860 - 진기의 최고급 붕어빵

package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num1860_진기의최고급붕어빵 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int max = arr[arr.length - 1];
            int current = 0;
            for (int i = 0; i <= max; i++) {
                if (i != 0 && i % M == 0) {
                    current += K;
                }

                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] == i) {
                        current--;
                        if (current < 0) {
                            sb.append("#" + t + " ").append("Impossible").append("\n");
                            break;
                        }
                    }
                }
                if (current < 0) {
                    break;
                }
            }
            if (current >= 0) {
                sb.append("#" + t + " ").append("Possible").append("\n");
            }
        }

        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}
