package CJY.week6;

import java.util.Arrays;
import java.util.Scanner;

public class G4_1563 {
    //G4_1563_개근상

    public static int n;
    public static int[][][] dp;
    public static int DIV = 1000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new int[n + 1][2][3];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        System.out.println(attendance(0, 0, 0));
    }

    public static int attendance(int cnt, int late, int absent) {
        if (cnt >= n)
            return 1;

        if (dp[cnt][late][absent] == -1) {
            dp[cnt][late][absent] = attendance(cnt + 1, late, 0); //O
            if (late < 1)
                dp[cnt][late][absent] = (dp[cnt][late][absent] + attendance(cnt + 1, late + 1, 0)) % DIV; //L
            if (absent < 2)
                dp[cnt][late][absent] = (dp[cnt][late][absent] + attendance(cnt + 1, late, absent + 1)) % DIV; //A
        }
        return dp[cnt][late][absent];
    }
}
