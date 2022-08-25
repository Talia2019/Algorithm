package CJY.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G4_16398 {
    //G4_16398_행성연결

    static class Edge implements Comparable<Edge>{
        private int node, distance;

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
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());

        List<Edge>[] edgeList = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            edgeList[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < i; j++) {
                int d =  Integer.parseInt(st.nextToken());
                edgeList[i].add(new Edge(j, d));
                edgeList[j].add(new Edge(i, d));
            }
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n + 1];
        long answer = 0;
        //자료형주의! int아니고 long
        int cnt = 0;

        pq.add(new Edge(1, 0));
        while(pq.size() > 0){
            Edge edge = pq.poll();
            if(visited[edge.node]) continue;
            visited[edge.node] = true;
            answer += edge.distance;
            for (Edge next : edgeList[edge.node]) {
                if(!visited[next.node])
                    pq.add(next);
            }
            if(++cnt == n) break;
        }
        System.out.println(answer);
    }
}
