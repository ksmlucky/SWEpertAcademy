// 1233 - [S/W 문제해결 기본] 9일차 - 사칙연산 유효성 검사

package d4;

import java.io.*;
import java.util.StringTokenizer;

public class Num1233_사칙연산유효성검사 {
    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        for(int t = 1; t <= 10; t++) {
            int N = Integer.parseInt(br.readLine());

            int answer = 1;

            for(int i = 1; i <= N; i++) {
                StringTokenizer st =  new StringTokenizer(br.readLine());

                // 걍 필요없는 값
                String temp = st.nextToken();

                char node = st.nextToken().charAt(0);

                // 리프노드인 경우
                if(!st.hasMoreTokens()) {
                    if(node < '0' || node > '9') { // 숫자가 아니면 0
                        answer = 0;
                    }

                } else { // 리프노드가 아닌 경우
                    if(node >= '0' && node <= '9') { // 숫자면 0
                        answer = 0;
                    }
                }
            }
            sb.append("#" + t + " " + answer + "\n");
        }
        System.out.println(sb);
    }
}
