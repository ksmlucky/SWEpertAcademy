package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Num3124_최소스패닝트리 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            ArrayList<Node>[] arrayList = new ArrayList[v + 1];

            for (int i = 0; i <= v; i++) {
                arrayList[i] = new ArrayList<>();
            }

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                arrayList[x].add(new Node(y, w));
                arrayList[y].add(new Node(x, w));
            }

            boolean[] visit = new boolean[v + 1];
            PriorityQueue<Node> pq = new PriorityQueue<Node>();

            pq.add(new Node(1, 0));

            int cnt = 0;
            long res = 0;

            while (!pq.isEmpty()) {
                Node now = pq.poll();

                if (visit[now.x]) {
                    continue; //이미 방문했으면 컨티뉴}
                }

                res += now.w;
                visit[now.x] = true;
                if (++cnt == v) {
                    break;
                }

                for (int i = 0; i < arrayList[now.x].size(); i++) {
                    Node next = arrayList[now.x].get(i);

                    if (visit[next.x] == true) {
                        continue;
                    }

                    pq.add(next);
                }
            }

            sb.append("#").append(t).append(" ").append(res).append("\n");
        }

        System.out.println(sb);
    }
}

class Node implements Comparable<Node> {
    int x;
    long w;

    public Node(int x, long w) {
        super();
        this.x = x;
        this.w = w;
    }

    @Override
    public int compareTo(Node o) {
        return (this.w - o.w) > 0 ? 1 : -1;
    }
}

    