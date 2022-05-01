// 1767 - [SW Test 샘플문제] 프로세서 연결하기

package 모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SW_Test_샘플문제_Num1767_프로세서연결하기2 {
    static int N, max, totalCnt, min, map[][];

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static ArrayList<int[]> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine().trim()); // 셀의 크기
            map = new int[N][N];
            list = new ArrayList<int[]>(); // 가장자리가 아닌 코어 리스트
            max = 0; // 최대 연결 코어 수
            min = Integer.MAX_VALUE; // 최소 전선 길이의 합
            totalCnt = 0; // 가장자리가 아닌 코어의 개수

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());


                    if ((i == 0 || i == N - 1 || j == 0 || j == N - 1) && map[i][j] == 1) {
                        continue; // 가장 자리 코어면 continue
                    }

                    if (map[i][j] == 1) { // 가장 자리가 아닌 코어면 list에 추가
                        list.add(new int[]{i, j});
                        totalCnt++;
                    }
                }
            }

            go(0, 0);

            System.out.println("#" + t + " " + min);
        }
    }

    private static void go(int index, int cCnt) { // 부분집합으로 코어 전선 놓기 시도, cCnt: 전원과 연결된 코어수

        if (index == totalCnt) {
            int res = getLength();
            if (max < cCnt) {
                max = cCnt;
                min = res;
            } else if (max == cCnt) {
                if (min > res) {
                    min = res;
                }
            }

            return;
        }

        int[] core = list.get(index);
        int r = core[0];
        int c = core[1];

        // 전선을 놓아보기(4방향으로)
        for (int d = 0; d < 4; d++) {
            if (isAvailable(r, c, d)) { // 현재 코어의 r, c 위치에서 d 방향으로 전선을 놓을 수 있다면
                setStatus(r, c, d, 2); // 전선 놓기 작업
                go(index + 1, cCnt + 1);
                setStatus(r, c, d, 0); // 전선 지우기
            }
        }

        // 전선 놓지 않기
        go(index + 1, cCnt);
    }

    private static boolean isAvailable(int r, int c, int d) { // r, c 위치에서 d 방향으로 전선을 놓을 수 있는지 체크
        int nr = r, nc = c;
        while (true) {
            nr += dr[d];
            nc += dc[d];

            if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                break;
            }

            // 다른 코어나 전선을 만나면 return false
            if (map[nr][nc] >= 1) {
                return false;
            }
        }

        return true;
    }

    private static void setStatus(int r, int c, int d, int s) { // r, c 위치에서 d 방향으로 전선을 놓거나(2) 지우거나(0)
        int nr = r, nc = c;
        while (true) {
            nr += dr[d];
            nc += dc[d];

            if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                break;
            }

            map[nr][nc] = s;
        }
    }

    private static int getLength() { // 놓아진 전선의 길이의 합 계산
        int lCnt = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c] == 2) {
                    lCnt++;
                }
            }
        }

        return lCnt;
    }
}
