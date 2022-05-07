// 1767 - [SW Test 샘플문제] 프로세서 연결하기

package 모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SW_Test_샘플문제_Num1767_프로세서연결하기 {
    static class Processor {
        int row, col;

        public Processor(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }


    static int N;
    static int[][] map;
    static int maxCore, minLength;
    static List<Processor> list;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine().trim());
            map = new int[N][N];
            list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) { //가장자리는 제외
                    if (i == 0 || j == 0 || i == N - 1 || j == N - 1) {
                        continue;
                    }
                    if (map[i][j] == 1) {
                        list.add(new Processor(i, j));
                    }
                }
            }
            maxCore = Integer.MIN_VALUE;
            minLength = Integer.MAX_VALUE;
            solution(0, 0, 0);
            System.out.println("#" + t + " " + minLength);

        }
    }

    private static void solution(int index, int coreCnt, int len) {
        if (index == list.size()) {
            if (maxCore < coreCnt) {
                maxCore = coreCnt;
                minLength = len;
            } else if (maxCore == coreCnt) {
                if (minLength > len) minLength = len;
            }
            return;
        }
        int row = list.get(index).row;
        int col = list.get(index).col;
        for (int dir = 0; dir < 4; dir++) {
            int count = 0;
            int nx = row;
            int ny = col;
            int Srow = row;
            int Scol = col;
            while (true) {
                ny += dr[dir];
                nx += dc[dir];

                if (check(nx, ny)) {
                    break;
                }

                if (map[nx][ny] == 1) {
                    count = 0;
                    break;
                }
                count++;
            }
            for (int i = 0; i < count; i++) {
                Srow += dc[dir];
                Scol += dr[dir];
                map[Srow][Scol] = 1;
            }
            if (count == 0)
                solution(index + 1, coreCnt, len);
            else {
                solution(index + 1, coreCnt + 1, len + count);
                Srow = row;
                Scol = col;
                for (int i = 0; i < count; i++) {
                    Srow += dc[dir];
                    Scol += dr[dir];
                    map[Srow][Scol] = 0;
                }
            }
        }
    }

    private static boolean check(int nx, int ny) {
        return nx < 0 || nx >= N || ny < 0 || ny >= N;
    }

}
