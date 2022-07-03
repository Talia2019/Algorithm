package CJY.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S1_15565 {
    //S1_15565_귀여운라이언

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        // 얘가 LinkedList 일땐 시간초과였음
        List<Integer> lions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (st.nextToken().equals("1"))
                lions.add(i);
        }

        int min = Integer.MAX_VALUE;
        int size = lions.size() - k;
        for (int i = 0; i <= size; i++) {
            int end = i + k - 1;
            if (lions.size() < end)
                break;
            min = Math.min(min, lions.get(end) - lions.get(i));
        }

        if (min == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(min + 1);
    }
}
