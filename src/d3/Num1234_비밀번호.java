// 1234 - 비밀번호

package d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Num1234_비밀번호 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            Stack<Integer> stack = new Stack<>();
//            ArrayList<Integer> list = new ArrayList<>();
//            list.add(str.charAt(0) - '0');
//            for (int i = 1; i < str.length(); i++) {
//                int temp = str.charAt(i) - '0';
//                if (t)
//            }
            for (int i = 0; i < str.length(); i++) {
                int temp = str.charAt(i) - '0';
                if (stack.isEmpty()) {
                    stack.push(temp);
                } else {
                    if (stack.peek() == temp) {
                        stack.pop();
                    } else {
                        stack.push(temp);
                    }
                }
            }
//            System.out.println(stack);

            StringBuilder sb = new StringBuilder();
//            System.out.println("stack.size() = " + stack.size());
//            while (!stack.isEmpty()) {
//                sb.append(stack.pop());
////                System.out.println(sb);
//            }

            // 스택의 사이즈가 pop()할 때마다 계속 변해서 출력되다 마는거였음;;;
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                int pop = stack.pop();
                sb.append(pop);
//                System.out.println(sb);
            }
            sb.reverse();

            System.out.println("#" + t + " " + sb);
        }
    }
}
