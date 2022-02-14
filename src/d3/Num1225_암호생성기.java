// 1225 - [S/W 문제해결 기본] 7일차 - 암호생성기

package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num1225_암호생성기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t <= 10; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < 8; i++) {
                queue.offer(Integer.parseInt(st.nextToken()));
            }
            int count = 1;
            int temp = 0;

            while (true) {
                if (queue.peek() <= 0) {
                    queue.poll();
                    queue.offer(0);
                    break;
                } else {
                    if (count > 5) {
                        count = 1;
                    }
                    temp = queue.poll() - count;
                    if (temp <= 0) {
                        temp = 0;
                        queue.offer(temp);
                        break;
                    }
                    queue.offer(temp);
                    count++;
                }
            }
            System.out.print("#" + t + " ");
            for (int i = 0; i < 8; i++) {
                System.out.print(queue.poll() + " ");
            }
            System.out.println();
        }
    }
}
