// 1873 - 상호의 배틀필드

package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1873 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            char[][] map = new char[H][W];

            int r = 0;  // 행
            int c = 0;  // 열
            // 상하좌우(0123)
            int[] dr = {-1, 1, 0, 0};
            int[] dc = {0, 0, -1, 1};
            int dir = 0;

            // map에 구성 요소 입력
            for (int i = 0; i < H; i++) {
                String str = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = str.charAt(j);
                    if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
                        r = i;
                        c = j;
                    }
                    if (map[i][j] == '^') {
                        dir = 0;
                    } else if (map[i][j] == 'v') {
                        dir = 1;
                    } else if (map[i][j] == '<') {
                        dir = 2;
                    } else if (map[i][j] == '>') {
                        dir = 3;
                    }
                }
            }

            int N = Integer.parseInt(br.readLine());
            String user = br.readLine();

            for (int i = 0; i < user.length(); i++) {
                // S인 경우
                if (user.charAt(i) == 'S') {
                    // 현재 보고 있는 방향의 한칸 앞의 칸을 저장
                    int nr = r + dr[dir];
                    int nc = c + dc[dir];
                    // map 밖이면 다음으로 넘어감
                    if (nr < 0 || nr >= H || nc < 0 || nc >= W) {
                        continue;
                    }
                    // 위아래방향이면
                    if (dir == 0 || dir == 1) {
                        while (nr >= 0 && nr < H) {
                            if (map[nr][nc] == '*') {
                                map[nr][nc] = '.';
                                break;
                            } else if (map[nr][nc] == '#') {
                                break;
                            }
                            nr += dr[dir];
                        }
                    } else if (dir == 2 || dir == 3) {  // 좌우방향이면
                        while (nc >= 0 && nc < W) {
                            if (map[nr][nc] == '*') {
                                map[nr][nc] = '.';
                                break;
                            } else if (map[nr][nc] == '#') {
                                break;
                            }
                            nc += dc[dir];
                        }
                    }
                } else {    // S가 아닌 경우
                    if (user.charAt(i) == 'U') {
                        dir = 0;
                        map[r][c] = '^';
                    } else if (user.charAt(i) == 'D') {
                        dir = 1;
                        map[r][c] = 'v';
                    } else if (user.charAt(i) == 'L') {
                        dir = 2;
                        map[r][c] = '<';
                    } else {
                        dir = 3;
                        map[r][c] = '>';
                    }
                    int nr = r + dr[dir];
                    int nc = c + dc[dir];
                    if (nr < 0 || nr >= H || nc < 0 || nc >= W) {
                        continue;
                    }
                    if (map[nr][nc] == '.') {
                        map[nr][nc] = map[r][c];
                        map[r][c] = '.';
                        r = nr;
                        c = nc;
                    }
                }
            }

            System.out.print("#" + t + " ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
    }
}
