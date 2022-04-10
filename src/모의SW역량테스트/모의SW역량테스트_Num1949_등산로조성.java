// 1949 - [모의 SW 역량테스트] 등산로 조성

package 모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 모의SW역량테스트_Num1949_등산로조성 {
    static int[][] map;
    static boolean[][] visited; // 방문체크 배열
    static int N, K;
    static int max; // 등산로 시작점(map에서 제일 큰 값)
    static int answer = Integer.MIN_VALUE; // dfs한번 할때마다 나오는 등산로 최대 길이. 예비 정답
    static int realAnswer = Integer.MIN_VALUE; // dfs한 애들(등산로 시작점 개수 만큼 dfs 실행) 중 가장 큰 값. 진짜 정답

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static ArrayList<Point> arrayList; // 등산로 시작점을 담아둘 애들

    // 등산로 시작점 위치
    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            visited = new boolean[N][N];
            arrayList = new ArrayList<>();

            max = Integer.MIN_VALUE;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());

                    // 등산로 시작 위치가 가능한 높이 저장
                    if (max < map[i][j]) {
                        max = map[i][j];
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 등산로 시작 가능한 좌표면 저장
                    if (map[i][j] == max) {
                        arrayList.add(new Point(i, j));
                    }
                }
            }

            for (int i = 0; i < arrayList.size(); i++) {
                Point temp = arrayList.get(i);
                int r = temp.r;
                int c = temp.c;
                visited[r][c] = true;
                dfs(r, c, max, 1, 0);
                visited[r][c] = false;
                realAnswer = Math.max(realAnswer, answer); // dfs 한번 할 때마다 answer가 진짜 최대인지 검사
            }

            System.out.println("#"+ t+ " " + answer);
            answer = Integer.MIN_VALUE; // answer 초기화
            realAnswer = Integer.MIN_VALUE; // realAnswer 초기화
        }
    }

    // r, c, 현재의 높이, 현재등산로 길이, 몇번 깎았는지(깎을 수 있나 없나)
    private static void dfs(int r, int c, int height, int length, int count) {
        for (int d = 0; d < 4; d++) {
            if (answer < length) { // answer 갱신
                answer = length;
            }

            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) { // 범위 안이고, 방문 전이면
                if (height <= map[nr][nc]) { // 다음 칸이 더 높으면(깎아야 되면)
                    if (count == 0) { // 깎은 횟수가 0이면(깎을 수 있으면)
                        if (height > map[nr][nc] - K) {
                            visited[nr][nc] = true;
                            dfs(nr, nc, height - 1, length + 1, count + 1);
                            visited[nr][nc] = false;
                        }
                    }
                } else { // 다음 칸이 낮으면 (안깎고 그냥 진행할 수 있으면)
                    visited[nr][nc] = true;
                    dfs(nr, nc, map[nr][nc], length + 1, count);
                    visited[nr][nc] = false;
                }
            }
        }
    }
}
