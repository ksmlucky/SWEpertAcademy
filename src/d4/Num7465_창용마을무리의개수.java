// 7465 - 창용 마을 무리의 개수

package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num7465_창용마을무리의개수 {
    static int N;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            makeSet();
            int M = Integer.parseInt(st.nextToken());
            int[][] arr = new int[M][2];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken()) - 1;
                arr[i][1] = Integer.parseInt(st.nextToken()) - 1;
            }

//            // 테스트
//            System.out.println("처음: " + Arrays.toString(parents));
            for (int i = 0; i < M; i++) {
                union(arr[i][0], arr[i][1]);
//                // 테스트
//                System.out.println(Arrays.toString(parents));
            }

            boolean[] check = new boolean[N];
            for (int i = 0; i < N; i++) {
                check[parents[i]] = true;
            }
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (check[i] == true) {
                    count++;
                }
            }
//            // 테스트
//            System.out.println(Arrays.toString(check));
//            System.out.println(Arrays.toString(parents));

            sb.append("#").append(t).append(" ").append(count).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);

    }

    public static void makeSet() {
        parents = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }
    }

    public static int findSet(int a) {
        if (a == parents[a]) {
            return a;
        }
        return parents[a] = findSet(parents[a]);
    }

    public static void union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if (aRoot == bRoot) {
            return;
        }
//        parents[bRoot] = aRoot; // b의 루트가 a의 루트를 가리키게 합친거임
        if (aRoot < bRoot) {
            parents[bRoot] = aRoot;
            for (int i = 0; i < N; i++) {
                if (parents[i] == bRoot) {
                    parents[i] = aRoot;
                }
            }
        } else {
            parents[aRoot] = bRoot;
            for (int i = 0; i < N; i++) {
                if (parents[i] == aRoot) {
                    parents[i] = bRoot;
                }
            }
        }
        return;
    }
}
