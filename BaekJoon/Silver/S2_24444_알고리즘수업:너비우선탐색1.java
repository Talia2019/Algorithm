package CJY.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S2_24444 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[n + 1];
        int[] orders = new int[n + 1];

        List<Integer>[] graph = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++)
            graph[i] = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        for (int i = 1; i <= n; i++)
            Collections.sort(graph[i]);

        int order = 1;
        Queue<Integer> queue = new LinkedList<>();
        orders[r] = order++;
        visited[r] = true;
        queue.add(r);
        while (queue.size() > 0) {
            int cur = queue.poll();
            for (int next : graph[cur]) {
                if (!visited[next]) {
                    orders[next] = order++;
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(orders[i]).append("\n");
        }
        System.out.println(sb);
    }
}
