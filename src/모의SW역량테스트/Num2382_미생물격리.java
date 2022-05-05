// 2382 - [모의 SW 역량테스트] 미생물 격리

package 모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Num2382_미생물격리 {
    public static class Microbe {
        int r;
        int c;
        int numberOfMicrobe;
        int dir;

        public Microbe(int r, int c, int numberOfMicrobe, int dir) {
            this.r = r;
            this.c = c;
            this.numberOfMicrobe = numberOfMicrobe;
            this.dir = dir;
        }
    }

    static ArrayList<Microbe> arrayList;
    static int N, M, K;

    // 상우하좌(0123)
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arrayList = new ArrayList<>();

            for (int i = 0; i < K; i++) {
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int mNum = Integer.parseInt(st.nextToken());
                int direction = Integer.parseInt(st.nextToken());
                if (direction == 1) {
                    direction = 0;
                } else if (direction == 4) {
                    direction = 1;
                }

                arrayList.add(new Microbe(r, c, mNum, direction));
            } // 입력

            int time = 0;
            while (true) {
                if (time == M) {
                    break;
                }

                


                time++;
            }
        }
    }
}
