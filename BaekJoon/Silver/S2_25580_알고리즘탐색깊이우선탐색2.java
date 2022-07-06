package CJY.ect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S2_24480 {
    //S2_25580_알고리즘탐색깊이우선탐색2

    public static int n, m, r, order;
    public static int[] visited;
    public static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= n; i++)
            Collections.sort(graph[i], Collections.reverseOrder());

        order = 1;
        visited = new int[n + 1];
        dfs(r);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(visited[i]).append(" ");
        }
        System.out.println(sb);
    }

    public static void dfs(int r) {
        visited[r] = order++;
        for (int cur : graph[r]) {
            if(visited[cur] == 0){
                dfs(cur);
            }
        }
    }
}
