package CJY.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S1_2667 {
    static int n;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        visited = new boolean[n][n];
        List<Integer> houseNum = new ArrayList<>();

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] == '1') {
                    cnt++;
                    houseNum.add(bfs(i, j));
                }
            }
        }

        Collections.sort(houseNum);
        StringBuilder sb = new StringBuilder();

        sb.append(cnt).append("\n");
        for (int i = 0; i < houseNum.size(); i++)
            sb.append(houseNum.get(i)).append("\n");

        System.out.println(sb);
    }

    public static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int cnt = 1;

        while (queue.size() > 0) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dir[i][0];
                int ny = cur[1] + dir[i][1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                    continue;

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if (map[nx][ny] == '1') {
                        cnt++;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return cnt;
    }
}
