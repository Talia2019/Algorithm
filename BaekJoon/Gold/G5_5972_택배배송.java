package CJY.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G5_5972 {
    //G5_5972_택배배송

    //최단경로, 다익스트라

    static class Edge implements Comparable<Edge> {
        int node;
        int distance;

        public Edge(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.distance, o.distance);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] distance = new int[n + 1];
        List<Edge>[] edgeList = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            distance[i] = Integer.MAX_VALUE;
            edgeList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edgeList[a].add(new Edge(b,c));
            edgeList[b].add(new Edge(a,c));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        distance[1] = 0;
        pq.add(new Edge(1, 0));

        while (pq.size() > 0){
            Edge cur = pq.poll();

            if(distance[cur.node] < cur.distance) continue;
            for (Edge next : edgeList[cur.node]) {
                if(distance[next.node] > distance[cur.node] + next.distance){
                    distance[next.node] = distance[cur.node] + next.distance;
                    pq.add(new Edge(next.node, distance[next.node]));
                }
            }
        }

        System.out.println(distance[n]);
    }
}
