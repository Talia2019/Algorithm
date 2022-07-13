package CJY.ect.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G5_7569 {
    // G5_7569_토마토

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][] box = new int[m][n][h];
        boolean[][][] visited = new boolean[m][n][h];
        int[][] dir = {{-1, 0, 0}, {1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}};
        int yetNum = 0;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < m; k++) {
                    box[k][j][i] = Integer.parseInt(st.nextToken());
                    if (box[k][j][i] == 1) {
                        visited[k][j][i] = true;
                        q.add(new int[]{k, j, i});
                    }
                    if (box[k][j][i] == 0)
                        yetNum++;
                }
            }
        }

        int day = -1;
        while (q.size() > 0) {
            day++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int d = 0; d < 6; d++) {
                    int nx = cur[0] + dir[d][0];
                    int ny = cur[1] + dir[d][1];
                    int nz = cur[2] + dir[d][2];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || nz < 0 || nz >= h)
                        continue;
                    if (visited[nx][ny][nz] || box[nx][ny][nz] != 0)
                        continue;
                    visited[nx][ny][nz] = true;
                    yetNum--;
                    q.add(new int[]{nx, ny, nz});
                }
            }
        }
        if (yetNum > 0)
            System.out.println(-1);
        else
            System.out.println(day);
    }
}
