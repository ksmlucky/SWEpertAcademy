package d2;// 1926 - 간단한 369게임

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num1926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            String str = "" + i;
            if (str.length() == 1) {
                if (str.charAt(0) == '3' || str.charAt(0) == '6' || str.charAt(0) == '9') {
                    sb.append("-");
                } else {
                    sb.append(str.charAt(0));
                }
            } else {
                int count = 0;
                if (str.contains("3") || str.contains("6") || str.contains("9")) {
                    for (int j = 0; j < str.length(); j++) {
                        if (str.charAt(j) == '3' || str.charAt(j) == '6' || str.charAt(j) == '9') {
                            count++;
                        }
                    }
                    for (int k = 0; k < count; k++) {
                        sb.append("-");
                    }
                } else {
                    sb.append(str);
                }
            }

            sb.append(" ");
        }

        System.out.println(sb);
    }
}
