// 1861 - 정사각형 방

package d4;

import java.io.*;
import java.util.StringTokenizer;

public class Num1861 {
    static int N;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int answerCount = 1; // 최대 이동 횟수
    static int[][] answerMap;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            answerMap = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    solution(map, i, j);
                    answerMap[i][j] = answerCount;
                    answerCount = 1;
                }
            }

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (max < answerMap[i][j]) {
                        max = answerMap[i][j];

                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (max == answerMap[i][j]) {
                        if (min > map[i][j]) {
                            min = map[i][j];
                        }
                    }
                }
            }

            System.out.println("#" + t + " " + min + " " + max);
        }
    }

    public static void solution(int[][] map, int r, int c) {
        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            // 다음거가 map 안에 들어와있고 현재꺼보다 +1이면
            if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                if (map[nr][nc] == map[r][c] + 1) {
                    answerCount++;
                    solution(map, nr, nc);
                    break;
                }
            }
        }
    }
}
