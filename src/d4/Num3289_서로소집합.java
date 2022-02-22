// 3289 - 서로소 집합

package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num3289_서로소집합 {
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

            int M = Integer.parseInt(st.nextToken()); // 연산의 개수
            int[][] arr = new int[M][3];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken()); // 연산의 종류
                arr[i][1] = Integer.parseInt(st.nextToken()); // a
                arr[i][2] = Integer.parseInt(st.nextToken()); // b
            }


            sb.append("#").append(t).append(" ");
            for (int i = 0; i < M; i++) {
                if (arr[i][0] == 0) {
                    union(arr[i][1], arr[i][2]);
                } else {
                    if (isPossiblUnion(arr[i][1], arr[i][2])) {
                        sb.append(0);
                    } else {
                        sb.append(1);
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void makeSet() {
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) { // 자기자신의 부모가 자기자신이도록 초기화
            parents[i] = i;
        }
    }

    public static int findSet(int a){
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

        parents[bRoot] = aRoot;
    }

    // true면 다른 집합에 속해있으므로 합집합이 가능함
    public static boolean isPossiblUnion(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        // 부모가 같으면 같은 집합에 있는거임
        if (aRoot == bRoot) {
            return false;
        } else {
            return true;
        }
    }
}
