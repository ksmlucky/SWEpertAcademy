// 5515 - 2016년 요일 맞추기

package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num5515_2016년요일맞추기 {
    static int days[] = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static int date[] = {3, 4, 5, 6, 0, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int sum = d;
            for (int i = 0; i < m; i++) {
                sum += days[i];
            }

            System.out.printf("#%d %d\n", t, date[sum % 7]);
        }
    }
}
