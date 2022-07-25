package CJY.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G4_15971 {
    // G4 15971 두로봇

    static class Edge implements Comparable<Edge>{
        int node;
        long distance;

        public Edge(int node, long distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(node, o.node);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if(n == 1 || a == b){
            System.out.println(0);
            System.exit(0);
        }

        List<Edge>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            graph[n1].add(new Edge(n2, d));
            graph[n2].add(new Edge(n1, d));
        }

        long[] distanceA = new long[n + 1];
        long[] distanceB = new long[n + 1];
        Arrays.fill(distanceA, Long.MAX_VALUE);
        Arrays.fill(distanceB, Long.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(a, 0));
        distanceA[a] = 0;

        while (pq.size() > 0) {
            Edge cur = pq.poll();
            if(distanceA[cur.node] < cur.distance) continue;
            for (Edge next : graph[cur.node]) {
                if(distanceA[next.node] > distanceA[cur.node] + next.distance){
                    distanceA[next.node] = distanceA[cur.node] + next.distance;
                    pq.add(new Edge(next.node, distanceA[next.node]));
                }
            }
        }

        pq.add(new Edge(b, 0));
        distanceB[b] = 0;

        while (pq.size() > 0) {
            Edge cur = pq.poll();
            if(distanceB[cur.node] < cur.distance) continue;
            for (Edge next : graph[cur.node]) {
                if(distanceB[next.node] > distanceB[cur.node] + next.distance){
                    distanceB[next.node] = distanceB[cur.node] + next.distance;
                    pq.add(new Edge(next.node, distanceB[next.node]));
                }
            }
        }

        long min = Long.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (Edge e : graph[i]) {
                long aToB = distanceA[i] + distanceB[e.node];
                if(aToB < min) min = aToB;
                long bToA = distanceA[e.node] + distanceB[i];
                if(bToA < min) min = bToA;
            }
        }
        System.out.println(min);
    }
}
