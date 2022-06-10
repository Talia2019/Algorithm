package CJY.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G4_1197 {

    static class Edge implements Comparable<Edge>{
        int node, distance;

        public Edge(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.distance, o.distance);
        }
    }

    static int v, e;
    static boolean[] visited;
    static List<List<Edge>> edgeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        visited = new boolean[v + 1];
        edgeList = new ArrayList<>();
        for (int i = 0; i <= v; i++)
            edgeList.add(new ArrayList<>());

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edgeList.get(a).add(new Edge(b, w));
            edgeList.get(b).add(new Edge(a, w));
        }

        System.out.println(prim(1, 0));
    }

    public static int prim(int startNode, int startDistance) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int cnt = 0;
        int sum = 0;
        pq.add(new Edge(startNode, startDistance));
        while (pq.size() > 0) {
            Edge cur = pq.poll();
            if (visited[cur.node]) continue;
            visited[cur.node] = true;
            sum += cur.distance;
            for (Edge next : edgeList.get(cur.node)) {
                if(!visited[next.node])
                    pq.add(next);
            }
            if(++cnt==v) break;
        }
        return sum;
    }
}

