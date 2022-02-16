// 5664 - [모의 SW 역량테스트] 무선 충전

package 모의SW역량테스트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 모의SW역량테스트_Num5644_무선충전 {
    static int M;
    static int A;
    // 이동X + 4방향
    static int dx[] = {0, -1, 0, 1, 0};
    static int dy[] = {0, 0, 1, 0, -1};
    static int[] aInfo;
    static int[] bInfo;
    static ArrayList<AP> apList; // AP 객체들을 담을 리스트

    static class AP {
        // AP의 위치
        int x;
        int y;

        int c; // 충전 범위
        int p; // 성능

        public AP(int x, int y, int c, int p) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.p = p;
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 이동 시간
            A = Integer.parseInt(st.nextToken()); // BC의 개수
            aInfo = new int[M];
            bInfo = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < aInfo.length; i++) {
                aInfo[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < bInfo.length; i++) {
                bInfo[i] = Integer.parseInt(st.nextToken());
            }

            apList = new ArrayList();
            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());

                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());

                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());

                apList.add(new AP(x, y, c, p));
            }

            int answer = solution();

            System.out.println("#" + t + " " + answer);
        }
    }

    public static int solution() {
        int x1 = 1;
        int y1 = 1;
        int x2 = 10;
        int y2 = 10;

        // 0초일 때 일단 실행
        int sum = sum(x1, y1, x2, y2);

        //시간별로 이동하면서 그때마다의 최대값을 합해준다.
        for (int i = 0; i < M; i++) {
            x1 += dx[aInfo[i]];
            y1 += dy[aInfo[i]];
            x2 += dx[bInfo[i]];
            y2 += dy[bInfo[i]];
            sum += sum(x1, y1, x2, y2);
        }

        return sum;
    }

    public static int sum(int x1, int y1, int x2, int y2) {
        int[][] charge = new int[A][2];

        for (int i = 0; i < A; i++) {
            charge[i][0] = check(x1, y1, i);
            charge[i][1] = check(x2, y2, i);
        }

        int max = 0;
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < A; j++) {
                int sum = charge[i][0] + charge[j][1];

                // 같은 BC를 이용하는 경우 값을 반으로 나누어줌
                // 한 쪽은 아예 값이 0(해당 BC를 이용할 수 없는 위치)일 수도 있으므로
                // 정확히 둘다 같이 이용하고 있는 경우에만 나누어줌
                if (i == j && charge[i][0] == charge[j][1]) {
                    sum /= 2;
                }
                max = Math.max(max, sum);
            }
        }

        return max;
    }

    public static int check(int x, int y, int index) {
        // 문제에 나와있는데로 거리 구하기
        int distance = Math.abs(x - apList.get(index).x) + Math.abs(y - apList.get(index).y);

        // 범위내에 있으면 충전량을 리턴
        if (distance <= apList.get(index).c) {
            return apList.get(index).p;
        } else {
            return 0;
        }
    }
}
