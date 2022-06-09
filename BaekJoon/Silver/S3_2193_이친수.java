package CJY.week2;

import java.util.Scanner;

public class S3_2193 {
    static long[] dp0, dp1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp0 = new long[n + 1];
        dp1 = new long[n + 1];
        System.out.println(getCnt1(n));
    }

    public static long getCnt0(int n) {
        if (n == 1 || n == 2)
            return 2;
        if (dp0[n] == 0)
            dp0[n] = getCnt1(n - 1) + getCnt0(n - 1);
        return dp0[n];
    }

    public static long getCnt1(int n) {
        if (n == 1 || n == 2)
            return 1;
        if (dp1[n] == 0)
            dp1[n] = getCnt0(n - 1);
        return dp1[n];
    }
}
