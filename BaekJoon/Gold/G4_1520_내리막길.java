package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_1520 {
    private static int m, n;
    private static int[][] map, dp;
    private static int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}}; //상하좌우

    //G4 1520 내리막길
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken()); //세로
        n = Integer.parseInt(st.nextToken()); //가로

        map = new int[m][n];
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        findRouteNum(m - 1, n - 1);
        if (dp[m - 1][n - 1] < 0) System.out.println(0);
        else System.out.println(dp[m - 1][n - 1]);
    }

    public static int findRouteNum(int x, int y) {
        if (dp[x][y] == -1) {
            if(x==0 && y==0) return 1;
            dp[x][y] = 0;
            int nx, ny;
            for (int i = 0; i < 4; i++) {
                nx = dir[i][0] + x;
                ny = dir[i][1] + y;
                if (isValid(nx, ny) && map[nx][ny] > map[x][y]) {
                    dp[x][y] += findRouteNum(nx, ny);
                }
            }
        }
        return dp[x][y];
    }

    public static boolean isValid(int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n)
            return false;
        return true;
    }
}

// 각 위치에서 상/우/하/좌 중 나보다 큰경우에 저장된 값들을 저장함. 저장되지 않았으면 해당 칸에서 또 상우하좌 큰거
