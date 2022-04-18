
/**
 * 돼지는 매우 뛰어난 후각을 지녔다. 프랑스 요리에서 최고의
 * 재료로 치는 송로버섯을 찾는 일에 돼지가 이용된다. 땅속의
 * 다이아몬드라는 별명에서도 알 수 있듯이 송로버섯은
 * 땅속에서만 자란다. 돼지는 뛰어난 후각으로 이 송로버섯을
 * 기가 막히게 찾아낸다.
 * 너무 살이 쪄서 굴러다니는 돼지는 평지 또는 오르막길을 올라갈 수는 없지만
 * 내리막길은 누구보다 빠르게 이동이 가능하다.
 * 송로버섯을 좋아하는 은서아빠는 이 귀여운 구르는 돼지를 이용해 송로버섯을
 * 찾고자 한다.
 * 산의 지형은 아래와 같이 표현되고,(입력 예시 참고)
 * 이 산에서 가장 왼쪽 위 칸에서 출발해 가장 오른쪽 아래 칸으로 도착하는 방법은
 * 예시에서는 세가지가 있음!
 * 더 많은 송로버섯을 채취하기 위해서는 더 많은 경로로 산을 탐색해야 한다.
 * 산의 지형이 주어질 때, 구르는 돼지가 제일 왼쪽 위 지점에서 출발하여 제일 오른쪽
 * 아래 지점까지 항상 내리막길로만 이동하는 경로의 개수를 구하는 프로그램을
 * 작성하시오.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 [입력] 테스트케이스는 파일로 주어진다.
 첫 번째 줄에는 테스트 케이스의 크기가 주어지고
 각 테스트 케이스의 첫번째 줄에는 산의 세로 크기 M과 가로의 크기 N이 주어진다.
 이어 다음 M줄에 걸쳐 한 줄에 N개씩 위에서부터 차례로 각 지점의 높이가 빈 칸을
 사이에 두고 주어진다. M과 N은 각각 500이하의 자연수이고, 각 지점의 높이는
 10000이하의 자연수이다.
 [출력]
 각 테스트케이스 별로 #T (T는 테스트케이스의 번호)를 출력한 후 한 칸 띄워 가능한
 경로의 수를 출력한다.

 [예제 입력]
 1
 4 5
 50 45 37 32 30
 35 50 40 20 25
 30 30 25 17 28
 27 24 22 15 10
 [출력 예시]
 #1 3

 */

public class Num2_구르는돼지의버섯찾기 {
    static int[][] map;
    static boolean[][] visited;
    // 우하좌상
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    static int M; // 세로
    static int N; // 가로
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            map = new int[M][N];
            visited = new boolean[M][N];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            visited[0][0] = true;
            dfs(0, 0);
            visited[0][0] = false;

            sb.append("#").append(t).append(" ").append(answer);
            sb.append("\n");
            answer = 0;
        }

        sb.setLength(sb.length() - 1);
        System.out.println(sb.toString());
    }

    private static void dfs(int r, int c) {
        // 도착지에 도착하면 answer 1증가 후 return
        if (r == M - 1 && c == N - 1) {
            answer++;
            return;
        }

        // 사방탐색
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            // map 밖이거나 다음 칸이 이미 방문했거나 평지나 오르막이면 넘어감
            if (nr < 0 || nr >= M || nc < 0 || nc >= N || visited[nr][nc] ||map[r][c] <= map[nr][nc]) {
                continue;
            }

            visited[nr][nc] = true;
            dfs(nr, nc);
            visited[nr][nc] = false;
        }
    }
}
