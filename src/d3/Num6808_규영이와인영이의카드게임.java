// 6808 - 규영이와 인영이의 카드게임

package d3;

import java.io.*;
import java.util.StringTokenizer;

public class Num6808_규영이와인영이의카드게임 {
    static final int TOTAL = 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1;
    static boolean[] numbers;
    static int[] arr = new int[9];
    static int winCount = 0;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            numbers = new boolean[19];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                numbers[arr[i]] = true;
            }

            solution(0, 0, 0);

            System.out.println("#" + t + " " + winCount + " " + (TOTAL - winCount));
            winCount = 0;
        }
    }

    public static void solution(int index, int aSum, int bSum) {
        if (index >= 9) {
            if (aSum > bSum) {
                winCount++;
            }

            return;
        }

        for (int i = 1; i <= 18; ++i) {
            if (!numbers[i]) {
                numbers[i] = true;

                int score = arr[index] + i;

                if (arr[index] >= i) {
                    solution(index + 1, aSum + score, bSum);
                }
                else {
                    solution(index + 1, aSum, bSum + score);
                }

                numbers[i] = false;
            }
        }
    }
}
