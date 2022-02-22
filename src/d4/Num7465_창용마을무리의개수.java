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
        for (int i = 1; i <= N; i++) { // 자기자신의 부모가 자기자신이도록 초기화
            parents[i] = i;
        }
    }

    public static int findSet(int a) {
        // 부모가 자기 자신이면 끝(기저조건?)
        if (a == parents[a]) {
            return a;
        }
        // 부모가 자기 자신이 아니면 부모로 findSet()을 재귀호출
        return parents[a] = findSet(parents[a]);
    }

    public static void union(int a, int b) {
        // 최상위 부모(루트)를 다른 최상위 부모로 바꾸면(가리키게 하면)
        // 결과적으로 합집합이되는 것
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if (aRoot == bRoot) {
            return;
        }
//        parents[bRoot] = aRoot;

        // 원래는 서로 연결이 있으면 root를 바꾸어 줌으로써 연관관계를 나타내었는데
        // 예를 들어서 1-3, 2-3, 4-5, 5-6 에서 1-4로 추가해주면 모두 같은 집합이 된다.
        // 그러므로 모두 1로 바꿔줘야함.
        // 그러기 위해서 for문을 돌아서 원래 4의 자식이였던 5, 6을 다 1의 자식을 바꿔줌.
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
