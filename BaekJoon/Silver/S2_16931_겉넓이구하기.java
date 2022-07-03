package CJY.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_16931 {
    //S2_16931_겉넓이구하기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        int area = 2 * n * m;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int curHeight = map[i][j];
                for (int k = 0; k < 4; k++) {
                    int ni = i + dir[k][0];
                    int nj = j + dir[k][1];
                    if (ni < 0 || ni >= n || nj < 0 || nj >= m)
                        area += curHeight;
                    else if (curHeight > map[ni][nj])
                        area += (curHeight - map[ni][nj]);
                }
            }
        }

        System.out.println(area);
    }
}
