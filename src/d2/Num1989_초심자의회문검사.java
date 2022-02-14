// 1989 - 초심자의 회문 검사

package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num1989_초심자의회문검사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            String str = br.readLine().trim();
            char[] charArr = str.toCharArray();
            int count = 0;
            for (int i = 0; i < charArr.length / 2; i++) {
                if (charArr[i] == charArr[charArr.length - 1 - i]) {
                    count++;
                }
            }

            if (count == charArr.length / 2) {
                System.out.println("#" + t + " " + 1);
            } else {
                System.out.println("#" + t + " " + 0);
            }

        }
    }
}
