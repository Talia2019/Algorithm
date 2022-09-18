package CJY.week14;

import java.util.Scanner;

public class G5_2410 {
    //G5_2410_2의멱수의합
    //dp 안 쓰니 시간초과

    //dp[k] 는 k를 2의 멱급수로 나타내는 경우의수
    //for(0~n) dp[k] += dp[k-2^i]
    //이때 n은 입력된수 이하의 최대2의제곱수

    public static long MOD = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dp = new long[n + 1];

        dp[0] = 1;

        int mul = 1;
        while(mul <= n){
            for (int i = 0; i <= n; i++) {
                if(i >= mul){
                    dp[i] = (dp[i] + dp[i-mul]) % MOD;
                }
            }
            mul *= 2;
        }

        System.out.println(dp[n]);
    }
}
 
