// 1249 - [S/W 문제해결 응용] 4일차 - 보급로

package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Num1249_보급로 {
    static int N;
    static int[][] map;
    static int[][] answerMap;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    private static class Node implements Comparable<Node> {
        int r;
        int c;
        int weight;

        public Node(int r, int c, int weight) {
            this.r = r;
            this.c = c;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight = o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            map = new int[N][N];
            answerMap = new int[N][N];

            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = str.charAt(j) - '0';
                }
            }

            for (int i = 0; i < N; i++) {
                Arrays.fill(answerMap[i], Integer.MAX_VALUE);
            }
            answerMap[0][0] = 0;

            solution();

            System.out.println("#" + t + " " + answerMap[N - 1][N - 1]);
        }
    }

    private static void solution() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, 0));

        while (!pq.isEmpty()) {
//            // 테스트
//            for (int t = 0; t < N; t++) {
//                System.out.println(Arrays.toString(answerMap[t]));
//            }
//            System.out.println();
//
//            // 테스트
//            for (int t = 0; t < N; t++) {
//                System.out.println(Arrays.toString(map[t]));
//            }
//            System.out.println();

            Node temp = pq.poll();

            int r = temp.r;
            int c = temp.c;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                    continue;
                }

                if (answerMap[nr][nc] <= map[nr][nc] + answerMap[r][c]) {
                    continue;
                }

                answerMap[nr][nc] = map[nr][nc] + answerMap[r][c];
                pq.offer(new Node(nr, nc, map[nr][nc]));
            }
        }
    }
}
