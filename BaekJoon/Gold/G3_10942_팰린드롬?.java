package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G3_10942 {
    //G3_10942_팰린드롬?

    public static int n, m;
    public static int[] numbers;
    //    public static int[][] questions;
    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        dp = new int[n][n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(isPelindrom(s - 1, e - 1)).append("\n");
        }
        System.out.println(sb);
    }

    public static int isPelindrom(int s, int e) {
        if (s == e)
            return 1;
        if (e - s == 1) {
            if (numbers[s] == numbers[e])
                return 1;
            return 0;
        }
        if (dp[s][e] == -1) {
            if (isPelindrom(s + 1, e - 1) == 1 && numbers[s] == numbers[e])
                dp[s][e] = 1;
            else
                dp[s][e] = 0;
        }
        return dp[s][e];
    }
}
