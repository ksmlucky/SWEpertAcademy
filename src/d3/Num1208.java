// 1208 - [S/W 문제해결 기본] 1일자 - Flatten

package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num1208 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t <= 10; t++) {
            int dump = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[100];
            int answer = 0;
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < dump; i++) {
                Arrays.sort(arr);

                arr[99]--;
                arr[0]++;
            }
            Arrays.sort(arr);
            answer = arr[99] - arr[0];
            System.out.println("#" + t + " " + answer);
        }
    }
}
