// 1228 - [S/W 문제해결 기본] 8일차 - 암호문1

package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Num1228 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t <= 10; t++) {
            // 원본 암호문의 길이
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> list = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();

            // 원본 암호문
            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            // 명령어의 개수
            int M = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            // 명령어
            for (int i = 0; i < M; i++) {
                String str = st.nextToken(); // 구분자
                int x = Integer.parseInt(st.nextToken()); // 위치x
                int y = Integer.parseInt(st.nextToken()); // 삽입할 숫자의 개수 y

                // stack에 저장
                for (int j = 0; j < y; j++) {
                    stack.push(Integer.parseInt(st.nextToken()));
                }

                // stack에 저장했던거 list에 x다음에 추가
                for (int j = 0; j < y; j++) {
                    list.add(x, stack.pop());
                }
            }

            System.out.print("#" + t + " ");
            for (int i = 0; i < 10; i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }
}
