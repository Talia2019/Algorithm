package StudyAlgorithmJava.src.CJY.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S3_2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++)
            graph[i] = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        int answer = 0;

        while (queue.size() != 0) {
            int cur = queue.poll();
            visited[cur] = true;
            answer++;

            for (int i = 0; i < graph[cur].size(); i++) {
                int next = graph[cur].get(i);
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

        System.out.println(answer - 1);
    }
}
