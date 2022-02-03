package d2;// 1285 - 아름이의 돌 던지기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1285 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            int min = Integer.MAX_VALUE;
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Math.abs(Integer.parseInt(st.nextToken()));
                min = Math.min(min, arr[i]);
            }
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == min) {
                    count++;
                }
            }
            System.out.println("#" + t + " " + min + " " + count);
        }
    }
}
