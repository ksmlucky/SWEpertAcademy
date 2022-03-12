// 7272 - 안경이 없어!

package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num7272_안경이없어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());

            String str1 = st.nextToken();
            String str2 = st.nextToken();

            if (str1.length() != str2.length()) {
                sb.append("DIFF").append("\n");
                break;
            }

            char[] charArr1 = str1.toCharArray();
            char[] charArr2 = str2.toCharArray();

            for (int i = 0; i < charArr1.length; i++) {
                if (charArr1[i] == 'A' || charArr1[i] == 'D' || charArr1[i] == 'O' || charArr1[i] == 'P' || charArr1[i] == 'Q' || charArr1[i] == 'R') {
                    charArr1[i] = 'A';
                } else if (charArr1[i] == 'B') {
                    charArr1[i] = 'B';
                } else if (charArr1[i] >= 'A' && charArr1[i] <= 'Z') {
                    charArr1[i] = 'C';
                }

                if (charArr2[i] == 'A' || charArr2[i] == 'D' || charArr2[i] == 'O' || charArr2[i] == 'P' || charArr2[i] == 'Q' || charArr2[i] == 'R') {
                    charArr2[i] = 'A';
                } else if (charArr2[i] == 'B') {
                    charArr2[i] = 'B';
                } else if (charArr2[i] >= 'A' && charArr2[i] <= 'Z') {
                    charArr2[i] = 'C';
                }
            }

            String tempStr1 = new String(charArr1);
            String tempStr2 = new String(charArr2);

            if (tempStr1.equals(tempStr2)) {
                sb.append("SAME").append("\n");
            } else {
                sb.append("DIFF").append("\n");
            }
        }

        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}
