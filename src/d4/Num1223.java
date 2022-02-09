// 1223 - [S/W 문제해결 기본] 6일차 - 계산기2

package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Num1223 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t <= 10; t++) {
            int N = Integer.parseInt(br.readLine());
            Stack<Character> characterStack = new Stack<>();
            String temp = "";
            String str = br.readLine();

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c != '+' && c != '*') {
                    temp += c;
                } else {
                    if (c == '*') {     // *면 스택에 바로 push
                        characterStack.push(c);
                    } else {
                        do {                        // +면 *을 빼고 push
                            if (characterStack.isEmpty()) {
                                break;
                            }

                            temp += characterStack.pop();
                        } while (!characterStack.isEmpty() && characterStack.peek() != '+');
                        characterStack.push(c);
                    }
                }
            }
            // 남은 연산자 추가
            while (!characterStack.isEmpty()) {
                temp += characterStack.pop();
            }

            Stack<Integer> stack = new Stack<Integer>();
            for (int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i) != '+' && temp.charAt(i) != '*') {    //피연산자인 경우 push
                    stack.push(temp.charAt(i) - '0');
                } else {
                    int a = stack.pop();
                    int b = stack.pop();
                    char c = temp.charAt(i);
                    switch (c) {
                        case '+':
                            int plus = a + b;
                            stack.push(plus);
                            break;
                        case '*':
                            int times = a * b;
                            stack.push(times);
                            break;
                    }
                }
            }

            System.out.println("#" + t + " " + stack.peek());
        }
    }
}
