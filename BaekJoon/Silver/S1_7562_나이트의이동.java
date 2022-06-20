package CJY.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_7562 {
    static int[][] dir = {{-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        int[] from = new int[3];
        int[] to = new int[3];
        test: for (int test = 0; test < t; test++) {
            int l = Integer.parseInt(br.readLine());
            boolean[][] visited = new boolean[l][l];
            st = new StringTokenizer(br.readLine(), " ");
            from[0] = Integer.parseInt(st.nextToken());
            from[1] = Integer.parseInt(st.nextToken());
            from[2] = 1;
            st = new StringTokenizer(br.readLine(), " ");
            to[0] = Integer.parseInt(st.nextToken());
            to[1] = Integer.parseInt(st.nextToken());
            to[2] = 1;

            if(from[0] == to[0] && from[1] == to[1]) {
                sb.append(0).append("\n");
                continue;
            }
            Queue<int[]> queue = new LinkedList<>();
            queue.add(from);
            visited[from[0]][from[1]] = true;
            while (queue.size() > 0) {
                int[] cur = queue.poll();
                for (int i = 0; i < 8; i++) {
                    int nx = cur[0] + dir[i][0];
                    int ny = cur[1] + dir[i][1];
                    if (nx < 0 || nx >= l || ny < 0 || ny >= l)
                        continue;
                    if(!visited[nx][ny]){
                        if(nx == to[0] && ny == to[1]){
                            sb.append(cur[2]).append("\n");
                            continue test;
                        }
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny, cur[2] + 1});
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
