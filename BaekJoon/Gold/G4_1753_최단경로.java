package StudyAlgorithmJava.src.CJY.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge implements Comparable<Edge> {
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

public class G4_1753 {
    public static int v, e, start;
    public static List<List<Edge>> edgeList;
    public static PriorityQueue<Edge> pq;
    public static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        edgeList = new ArrayList<>();
        pq = new PriorityQueue<>();
        distance = new int[v + 1];

        for (int i = 0; i <= v; i++)
            edgeList.add(new ArrayList<>());

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            edgeList.get(Integer.parseInt(st.nextToken())).add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        pq.add(new Edge(start, distance[start]));

        while (pq.size() > 0) {
            Edge cur = pq.poll();
            if (distance[cur.node] < cur.distance)
                continue;
            for (Edge next : edgeList.get(cur.node)) {
                if (distance[next.node] > distance[cur.node] + next.distance) {
                    distance[next.node] = distance[cur.node] + next.distance;
                    pq.add(new Edge(next.node, distance[next.node]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            if (distance[i] == Integer.MAX_VALUE) sb.append("INF");
            else sb.append(distance[i]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
