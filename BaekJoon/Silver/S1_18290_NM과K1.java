package CJY.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_18290 {
    //S1_18290_NM과K1
    //음수도 가능

    public static int n, m, k, max = Integer.MIN_VALUE;
    public static int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public static boolean[][] visited;
    public static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0, 0);
        System.out.println(max);
    }

    public static void dfs(int cnt, int sum, int x, int y) {
        if (cnt == k) {
            if (sum > max)
                max = sum;
            return;
        }

        for (int i = 0; i < n; i++) {
            indexM:
            for (int j = 0; j < m; j++) {
                if (visited[i][j])
                    continue;
                for (int d = 0; d < 4; d++) {
                    int nx = i + dir[d][0];
                    int ny = j + dir[d][1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                        continue;
                    if (visited[nx][ny])
                        continue indexM;
                }
                visited[i][j] = true;
                dfs(cnt + 1, sum + map[i][j], i, j);
                visited[i][j] = false;
            }
        }
    }
}
