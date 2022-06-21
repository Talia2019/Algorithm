package CJY.ect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_2293 {
    static int n, k;
    static int[] coins;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        coins = new int[n];
        dp = new int[n][10001];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
            Arrays.fill(dp[i], -1);
        }

        Arrays.sort(coins);
        System.out.println(getNum(0, k));
    }

    public static int getNum(int depth, int charge) {
        if (charge == 0)
            return 1;
        if (dp[depth][charge] == -1) {
            dp[depth][charge] = 0;
            for (int i = depth; i < n; i++) {
                int c = coins[i];
                if (c <= charge) {
                    dp[depth][charge] += getNum(i, charge - c);
                } else break;
            }
        }
        return dp[depth][charge];
    }
}
