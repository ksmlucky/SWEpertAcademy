// 1224 - [S/W 문제해결 기본] 6일차 - 계산기3

package d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Num1224_계산기3 {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {

            Stack<Character> characterStack = new Stack<>();
            Stack<Character> postStack = new Stack<>();

            Stack<Integer> stack = new Stack<>();

            int N = Integer.parseInt(br.readLine());


            String str = br.readLine();


            for (int i = 0; i < N; i++) {
                char c = str.charAt(i);

                if (c == '(') {
                    characterStack.push(c);
                } else if (c == ')') {
                    while (characterStack.peek() != '(') {
                        postStack.push(characterStack.pop());
                    }
                    characterStack.pop(); // (을 없앰
                } else if (c >= '0' && c <= '9') {
                    postStack.push(c);
                } else {
                    while (priority(characterStack.peek()) <= priority(c) && !characterStack.isEmpty()) {
                        postStack.push(characterStack.pop());
                        if (characterStack.isEmpty()) {
                            break;
                        }
                    }

                    characterStack.push(c); // 최근 연산자는 스택에 저장
                }
            }

            // 남은 연산자 추가
            while (!characterStack.isEmpty()) {
                postStack.push(characterStack.pop());
            }


            // 계산
            int size = postStack.size();
            Character[] postArr = new Character[size];
            postStack.toArray(postArr);

            for (int i = 0; i < size; i++) {
                char c = postArr[i];

                if (c >= '0' && c <= '9') {
                    stack.push(c - '0');
                } else {
                    int a = stack.pop();
                    int b = stack.pop();
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

            System.out.println(String.format("#%d %d", t, stack.pop()));
        }

    }


    private static int priority(char c) {
        switch (c) {
            case '(':
                return 5;
            case '*':
                return 1;
            case '-':
                return 2;
            case '+':
                return 2;
            default:
                return -1;
        }
    }
}
