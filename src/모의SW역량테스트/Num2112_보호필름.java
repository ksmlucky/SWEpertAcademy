// 2112 - [모의 SW 역량테스트] 보호 필름

package 모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num2112_보호필름 {
    static int D, W, K, film[][], min;
    static final int A = 0, B = 1;
    static int[] drugA, drugB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = null;

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine().trim());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            film = new int[D][W];
            drugA = new int[W];
            drugB = new int[W];
            min = Integer.MAX_VALUE;

            for (int i = 0; i < D; ++i) {
                st = new StringTokenizer(br.readLine().trim());
                for (int j = 0; j < W; j++) {
                    film[i][j] = Integer.parseInt(st.nextToken());
                }
            } // 입력처리

            Arrays.fill(drugA, A);
            Arrays.fill(drugB, B);

            process(0, 0);
            System.out.println("#" + t + " " + min);
        }
    }

    private static boolean check() { // 보호 필름 성능 검사
        // 열 고정 행탐색하면서 연속된 셀의 같은 특성이 K개 이상인지 검사
        for (int c = 0; c < W; c++) { // 열고정
            int count = 1;
            int before = film[0][c];
            for (int r = 0; r < D; r++) {
                int current = film[r][c];
                if (before == current) {
                    if (++count == K) {
                        break;
                    } else {
                        before = current;
                        count = 1;
                    }
                }
            } // 하나의 열을 고정해서 수직 검사

            if (count < K) {
                return false;
            }
        }

        return true;
    }

    private static boolean process(int row, int useCnt) {
        if (row == D) {
            if (check()) {
                min = Math.min(min, useCnt);
                return min == 0; // 약품을 하나도 사용하지 않았으면 true, 사용했으면 false
            }

            return false;
        }

        // 기존 임시 최적해의 최소  약품수보다 현재까지 사용한 약품수가 같거나 크면 의미 없으므로 리턴
        if (useCnt >= min) {
            return false;
        }

        int[] backup = film[row]; // 현재 막의 상태 배열 기억

        // 약품 비투여
        if (process(row + 1, useCnt)) {
            return true;
        }

        // 약품 A 투여
        film[row] = drugA;
//        if (process(row + 1, useCnt + 1)) {
//            return true;
//        }
        process(row + 1, useCnt + 1);

        // 약품 B 투여
        film[row] = drugB;
//        if (process(row + 1, useCnt + 1)) {
//            return true;
//        }
        process(row + 1, useCnt + 1);

        film[row] = backup; // 기존막의 상태로 되돌려 놓기
        return false;
    }
}
