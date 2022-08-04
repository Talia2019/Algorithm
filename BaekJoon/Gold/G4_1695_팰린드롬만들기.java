package CJY.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class G4_1695 {
    //G4_1695_팰린드롬만들기
    //왼쪽에 넣어서도 만들 수 있음!

    public static long[][] dp;
    public static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        dp = new long[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(getNum(0, n - 1));

//        int i = 0;
//        int cnt = 0;
//        while(true){
//            int len = list.size();
//            if(len % 2 == 1){
//                if(i == len/2)
//                    break;
//            } else {
//                if(i > len/2)
//                    break;
//            }
//            if(!list.get(i).equals(list.get(len - i - 1))){
//                cnt++;
//                list.add(len - i, list.get(i));
//            }
//            i++;
//        }
//        System.out.println(cnt);
    }

    public static long getNum(int l, int r) {
        if (dp[l][r] != -1)
            return dp[l][r];

        if (l >= r) {
            dp[l][r] = 0;
        } else {
            if (numbers[l] == numbers[r])
                dp[l][r] = getNum(l + 1, r - 1);
            else
                dp[l][r] = Math.min(getNum(l + 1, r), getNum(l, r - 1)) + 1;
        }
        return dp[l][r];
    }
}
