// 1210 - [S/W 문제해결 기본] 2일차 - Ladder1

package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1210 {
    static int[][] map;
    // 우좌상 - 상이 맨 앞이면 안됨
    static int[] dr = {0, 0, -1};
    static int[] dc = {1, -1, 0};


    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t <= 10; t++) {
            int T = Integer.parseInt(br.readLine());
            map = new int[100][100];
            int r = 0;
            int c = 0;
            int answer = 0;
            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 2) {
                        r = i;
                        c = j;
                    }
                }
            }
            while (true) {
                for (int i = 0; i < 3; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if (nr >= 0 && nr < 100 && nc >= 0 && nc < 100 && map[nr][nc] == 1) {
                        map[nr][nc] = 0;
                        r = nr;
                        c = nc;
                        break;
                    }
                }
                if (r == 0) {
                    answer = c;
                    break;
                }
            }
            System.out.println("#" + t + " " + answer);
        }
    }

}
