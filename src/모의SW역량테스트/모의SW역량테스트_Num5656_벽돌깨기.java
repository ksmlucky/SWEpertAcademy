// 5656 - [모의 SW 역량테스트] 벽돌 깨기

package 모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 중복 순열 + 시뮬레이션

 - 중복순열
 go함수(실행함수)

 - 시뮬
 벽돌 부시기 함수
 부서진 벽돌 아래로 내리기 함수
 남은 벽돌수 세기 함수
 map 백업해놓기 함수(copy 함수)
 */

//BFS
public class 모의SW역량테스트_Num5656_벽돌깨기 {
    static class Point {
        int r, c, cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N, W, H, min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            int[][] map = new int[H][W];

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            min = Integer.MAX_VALUE;
            go(0, map);
            System.out.println("#" + t + " " + min);
        }
    }

    // 중복순열을 이용하여 구슬을 던지기, 벽돌이 다 부서졌다면 true, 아니면 false 리턴
    static boolean go(int count, int[][] map) {
        int result = getRemain(map);

        // 모든 벽돌이 다 부서졌다면
        if (result == 0) {
            min = 0;
            return true;
        }

        // 모든 구슬을 다 던졌으면
        if (count == N) {
            min = Math.min(min, result);
            return false;
        }

        int[][] newMap = new int[H][W];

        // 0열부터 W-1까지 구슬 던져보기
        for (int c = 0; c < W; c++) {
            // 구슬에 맞는 벽돌 찾기
            int r = 0;
            while (r < H && map[r][c] == 0) {
                ++r; // 빈 공간이면 계쏙해서 아래로
            }

            // 해당 열은 벽돌이 없음
            if (r == H) {
                continue;
            }

            // 배열의 상태를 백업
            copy(map, newMap);

            boom(newMap, r, c); // 현재 벽돌 기준으로 주변의 가능한 모든 벽돌 함께 연쇄 파괴

            down(newMap); // 부서진 벽돌 정리

            if (go(count + 1, newMap)) {
                return true;
            } // 다음 구슬 던지러 go
        }

        return false;
    }

    // r, c 위치에서 주변의 가능한 모든 벽돌도 함께 부수는 처리
    static void boom(int[][] map, int r, int c) {
        Queue<Point> queue = new LinkedList<>();

        if (map[r][c] > 1) { // 벽돌 크기가 2 이상이면 큐에 추가
            queue.offer(new Point(r, c, map[r][c]));
        }
        map[r][c] = 0;

        while (!queue.isEmpty()) {
            Point temp = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = temp.r;
                int nc = temp.c;

                for (int k = 1; k < temp.cnt; k++) {
                    nr += dr[d];
                    nc += dc[d];

                    if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] > 0) {
                        if (map[nr][nc] > 1) { // 주변 벽돌에 영향을 주는 벽돌이면
                            queue.offer(new Point(nr, nc, map[nr][nc]));
                        }
                        map[nr][nc] = 0; // 제거 처리
                    }
                }
            }
        }
    }

    // 부서진 벽돌 정리, 남은 벽돌 정리!!(공중에 떠있는 벽돌도 아래로 내리기)
    static void down(int[][] map) {
        for (int c = 0; c < W; c++) {
            int r = H - 1; // 아래행 시작
            while (r > 0) {
                if (map[r][c] == 0) { // 빈칸이면 내릴 벽돌 찾기
                    int nr = r - 1;
                    while (nr > 0 && map[nr][c] == 0) {
                        nr--;
                    }
                    map[r][c] = map[nr][c];
                    map[nr][c] = 0;
                }
                r--;
            }
        }
    }

    // 남은 벽돌 수 리턴
    static int getRemain(int[][] map) {
        int count = 0;
        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                if (map[r][c] > 0) {
                    ++count;
                }
            }
        }

        return count;
    }

    static void copy(int[][] map, int[][] newMap) {
        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                newMap[r][c] = map[r][c];
            }
        }
    }
}
