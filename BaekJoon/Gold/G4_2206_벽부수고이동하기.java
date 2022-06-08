package StudyAlgorithmJava.src.CJY.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_2206 {
    static int n, m;
    static char[][] map;
    static boolean[][][] visited;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static class Block {
        int x, y, distance, isBreak;

        public Block(int x, int y, int distance, int isBreak) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.isBreak = isBreak;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m][2];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++)
                map[i][j] = str.charAt(j);
        }

        System.out.println(bfs(0, 0));
    }

    public static int bfs(int x, int y) {
        Queue<Block> q = new LinkedList<>();
        q.add(new Block(x, y, 1, 0));
        visited[x][y][0] = visited[x][y][1] = true;

        while (q.size() > 0) {
            Block cur = q.poll();
            if (cur.x == n - 1 && cur.y == m - 1)
                return cur.distance;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dir[i][0];
                int ny = cur.y + dir[i][1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;

                if (map[nx][ny] == '0') {
                    if (!visited[nx][ny][cur.isBreak]) {
                        q.add(new Block(nx, ny, cur.distance + 1, cur.isBreak));
                        visited[nx][ny][cur.isBreak] = true;
                    }
                } else if (map[nx][ny] == '1') {
                    if (cur.isBreak == 0 && !visited[nx][ny][1]) {
                        q.add(new Block(nx, ny, cur.distance + 1, 1));
                        visited[nx][ny][1] = true;
                    }
                }
            }
        }

        return -1;
    }
}
