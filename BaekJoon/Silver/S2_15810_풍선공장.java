package CJY.week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_15810 {
    //S2_15810_풍선공장
    //time++로 하다가 시간초과
    //이분탐색
    
    //주의 -> 타입 다른거 주의(int, long)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] times = new int[n];
        int min = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            times[i] = Integer.parseInt(st.nextToken());
            min = Math.min(min, times[i]);
        }

        long start = 0, end = (long)min * (long)m;
        long mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            long balloon = 0;
            for (int i = 0; i < n; i++) {
                balloon += (mid / times[i]);
            }
            if (balloon >= m)
                end = mid - 1;
            else
                start = mid + 1;
        }

        System.out.println(start);
    }
}
