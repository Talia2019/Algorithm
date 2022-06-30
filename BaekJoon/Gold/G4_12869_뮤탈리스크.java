package CJY.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_12869 {
    public static int n, min = Integer.MAX_VALUE;
    public static int[][] attack = {{9, 3, 1}, {9, 1, 3}, {3, 9, 1}, {3, 1, 9}, {1, 3, 9}, {1, 9, 3}};
    public static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        int[] scv = new int[3];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            scv[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[61][61][61];
        dfs(scv, 0);
        System.out.println(min);
    }

    public static void dfs(int[] scv, int num) {
        if (num >= min)
            return;

        if (dp[scv[0]][scv[1]][scv[2]] > 0 && dp[scv[0]][scv[1]][scv[2]] <= num)
            return;

        dp[scv[0]][scv[1]][scv[2]] = num;

        if (scv[0] == 0 && scv[1] == 0 && scv[2] == 0) {
            min = Math.min(min, num);
        }

        for (int i = 0; i < 6; i++) {
            int[] attackedHp = new int[3];
            for (int j = 0; j < 3; j++)
                attackedHp[j] = Math.max(scv[j] - attack[i][j], 0);
            dfs(attackedHp, num + 1);
        }
    }
}
