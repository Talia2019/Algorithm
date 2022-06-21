package CJY.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Add_G3_2629 {
    //처음 dp를 1차원배열로 했으나 그렇게하면 중복처리됨
    static int weightNum, marbleNum;
    static int[] weights;
    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        weightNum = Integer.parseInt(br.readLine());
        weights = new int[weightNum];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < weightNum; i++)
            weights[i] = Integer.parseInt(st.nextToken());

        dp = new boolean[weightNum + 1][40001];
        getNum(0, 0);

        marbleNum = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < marbleNum; i++) {
            if (dp[weightNum][Integer.parseInt(st.nextToken())])
                sb.append("Y ");
            else
                sb.append("N ");
        }
        System.out.println(sb);
    }

    static void getNum(int cnt, int weight) {
        if (dp[cnt][weight]) return;
        dp[cnt][weight] = true;

        if (cnt == weightNum) return;
        getNum(cnt + 1, weight + weights[cnt]);
        getNum(cnt + 1, weight);
        getNum(cnt + 1, Math.abs(weight - weights[cnt]));
    }
}
