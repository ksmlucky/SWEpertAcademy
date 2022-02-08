// 9229 - 한빈이와 Spot Mart

package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num9229_2 {
    static int N, M, max;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            max = -1;

            solution(0, 0, 0);

            System.out.println("#" + t + " " + max);

        }
    }

    public static void solution(int index, int count, int weight) {
        if (weight > M) {
            return;
        }
        if (count == 2) {
            max = Math.max(max, weight);
            return;
        }
        if (index == N) {
            return;
        }

        solution(index + 1, count + 1, weight + arr[index]);
        solution(index + 1, count, weight);
    }
}
