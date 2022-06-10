package CJY.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class G5_10026 {
    static int n;
    static char[][] map;
    static boolean[][] visited;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

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

        int cntRGB, cntRB;
        cntRGB = cntRB = 0;

        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]){
                    cntRGB++;
                    bfsRGB(i, j);
                }
            }
        }

        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]){
                    cntRB++;
                    bfsRB(i, j);
                }
            }
        }

        System.out.println(cntRGB + " " + cntRB);
    }

    public static void bfsRGB(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        char color = map[x][y];
        queue.add(new int[]{x, y});
        while (queue.size() > 0) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dir[i][0];
                int ny = cur[1] + dir[i][1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                    continue;
                if (!visited[nx][ny] && map[nx][ny] == color) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }

    public static void bfsRB(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        char color = map[x][y];
        char color2 = color;
        if (color == 'R')
            color2 = 'G';
        if (color == 'G')
            color2 = 'R';

        queue.add(new int[]{x, y});
        while (queue.size() > 0) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dir[i][0];
                int ny = cur[1] + dir[i][1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                    continue;
                if (!visited[nx][ny] && (map[nx][ny] == color || map[nx][ny] == color2)) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }

}
