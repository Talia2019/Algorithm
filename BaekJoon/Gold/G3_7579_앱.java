package CJY.ect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G3_7579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] mem = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++)
            mem[i] = Integer.parseInt(st.nextToken());

        int[] cost = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++)
            cost[i] = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n][10001]; //mem cost
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 10000; j++) {
                if (i == 0) {
                    if (j >= cost[i]) dp[i][j] = mem[i];
                } else {
                    if (j >= cost[i])
                        dp[i][j] = Math.max(dp[i - 1][j - cost[i]] + mem[i], dp[i - 1][j]);
                    else
                        dp[i][j] = dp[i - 1][j];
                }
                if (dp[i][j] >= m) answer = Math.min(answer, j);
            }
        }

        System.out.println(answer);
    }
}
