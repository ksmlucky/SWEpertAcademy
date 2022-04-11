// 5607 - [Professional] 조합

package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num5607_조합 {
    static int T, N, R;
    static final long NUMBER = 1234567891;
    static long[] factorial;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        factorial = new long[1000001];
        factorial[0] = 1;
        for (int i = 1; i < 1000001; i++) {
            factorial[i] = factorial[i - 1] * i;
            factorial[i] %= NUMBER;
        }

        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());

            long n1 = factorial[N];
            long n2 = (factorial[N - R] * factorial[R]) % NUMBER;
            long n3 = solution(n2, NUMBER - 2);

            System.out.printf("#%d %d\n", t, (n1 * n3) % NUMBER);
        }
    }

    private static long solution(long a, long N) {
        if (N == 0) return 1;
        if (N == 1) return a;
        if (N % 2 == 0) {
            long temp = solution(a, N / 2);
            return (temp * temp) % NUMBER;
        }

        long temp = solution(a, N - 1) % NUMBER;

        return (temp * a) % NUMBER;
    }
}
