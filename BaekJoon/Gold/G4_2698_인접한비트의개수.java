package CJY.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_2698 {
    //G4_2698_인접한비트의개수
    //이런 dp문제는 시작점이나 종료점을 기준으로 잡으면 편함
    //답 = n자리_k인접_0끝 + n자리_k인접_1끝
    //nk0 = n-1자리_k인접_0끝(0) + n-1자리_k인접+1끝(0)
    //nk1 = n-1자리_k-1인접_1끝(1) + n-1자리_k인접+0끝(1)

    public static int[][][] dp;
    public static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        dp = new int[101][101][4];
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++)
                Arrays.fill(dp[i][j], -1);
        }
        dp[1][0][0] = dp[1][0][1] = dp[2][0][1] = dp[2][1][1] = 1;
        dp[2][0][0] = 2;

        for (int test = 0; test < t; test++) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            System.out.println(getNum(n, k, 0) + getNum(n, k, 1));
        }
    }

    static int getNum(int curN, int curK, int end) {
        if (curN <= 0 || curK < 0 || curK >= curN)
            return 0;
        if(end == 0 && curK >= curN + 1)
            return 0;
        if (dp[curN][curK][end] < 0) {
            if (end == 0)
                dp[curN][curK][0] = getNum(curN - 1, curK, 0) + getNum(curN - 1, curK, 1);
            else
                dp[curN][curK][1] = getNum(curN - 1, curK - 1, 1) + getNum(curN - 1, curK, 0);
        }
        return dp[curN][curK][end];
    }
}
