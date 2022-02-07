// 1218 - [S/W 문제해결 기본] 4일차 - 괄호 짝짓기

package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Num1218 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t <= 10; t++) {
            int N = Integer.parseInt(br.readLine());
            String str = br.readLine();
            int answer = -1;

            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < N; i++) {
                char c = str.charAt(i);
                if (c == '(' || c == '[' || c == '{' || c == '<') {
                    stack.push(c);
                } else {
                    if (stack.size() <= 0) {
                        answer = 0;
                        break;
                    } else if (c == ')') {
                        if (stack.peek() == '(') {
                            stack.pop();
                        } else {
                            answer = 0;
                            break;
                        }
                    } else if (c == ']') {
                        if (stack.peek() == '[') {
                            stack.pop();
                        } else {
                            answer = 0;
                            break;
                        }
                    } else if (c == '}') {
                        if (stack.peek() == '{') {
                            stack.pop();
                        } else {
                            answer = 0;
                            break;
                        }
                    } else if (c == '>') {
                        if (stack.peek() == '<') {
                            stack.pop();
                        } else {
                            answer = 0;
                            break;
                        }

                    }
                }
            }
            if (stack.size() == 0 && answer == -1) {
                answer = 1;
            } else {
                answer = 0;
            }

            System.out.println("#" + t + " " + answer);
        }
    }
}
