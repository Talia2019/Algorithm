package CJY.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_16938 {
    // G5 16938 캠프준비

    static int n, l, r, x, ans;
    static int[] problems;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        problems = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            problems[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(problems);

//        for (int i = 0; i < n; i++) {
//            combination(problems[i], problems[i],problems[i], 1, i);
//        }
        combination(Integer.MAX_VALUE, 0, 0, 0, 0);
        System.out.println(ans);
    }

//    public static void combination(int start, int end, int sum, int selectedNum, int cnt) {
//        if(sum > r)
//            return;
//        if(selectedNum >= 2){
//            if(sum >= l && (end - start) >= x)
//                ans++;
//        }
//
//        for (int i = cnt + 1; i < n; i++) {
//            combination(start, problems[i], sum + problems[i], selectedNum + 1, cnt + 1);
//        }
//    }

    public static void combination(int min, int max, int sum, int cnt, int idx){
        if(sum > r)
            return;
        if(cnt >= 2){
            if(sum >= l && (max - min) >= x)
                ans++;
        }
        for (int i = idx; i < n; i++) {
            combination(Math.min(min, problems[i]), Math.max(max, problems[i]), sum + problems[i], cnt + 1, i + 1);
        }
    }
}
