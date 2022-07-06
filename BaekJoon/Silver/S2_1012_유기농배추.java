package CJY.ect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S2_1012 {
    //S2_1012_유기농배추
    //bfs 항상 큐에 넣기 전에 방문처리할것

    public static int t, m, n, k;
    public static boolean[][] field, visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int test = 0; test < t; test++) {
            st = new StringTokenizer(br.readLine(), " ");
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            field = new boolean[m][n];
            visited = new boolean[m][n];
            List<int[]> cabbages = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[x][y] = true;
                cabbages.add(new int[]{x, y});
            }

            int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            int bug = 0;
            for (int[] cbg : cabbages) {
                Queue<int[]> queue = new LinkedList<>();
                if (!visited[cbg[0]][cbg[1]]) {
                    visited[cbg[0]][cbg[1]] = true;
                    queue.add(cbg);
                    bug++;
                }
                while (queue.size() > 0) {
                    int[] cur = queue.poll();
                    for (int i = 0; i < 4; i++) {
                        int nx = cur[0] + dir[i][0];
                        int ny = cur[1] + dir[i][1];
                        if (nx < 0 || nx >= m || ny < 0 || ny >= n)
                            continue;
                        if(visited[nx][ny] || !field[nx][ny])
                            continue;
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
            sb.append(bug).append("\n");
        }
        System.out.println(sb);
    }
}
